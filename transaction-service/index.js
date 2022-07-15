const express = require('express')
const bodyParser = require('body-parser')
const amqplib = require('amqplib/callback_api')
const { MongoClient } = require('mongodb')
const os = require("os")

const app = express()
const port = 3000
const host = 'host.minikube.internal'
const queue = 'transactions'
const amqp = `amqp://${host}:5672`
const mongoUrl = `mongodb://${host}:27017`
const mongoClient = new MongoClient(mongoUrl)
const dbName = 'transactionsdb'
const hostname = os.hostname()


let channel = null
let transactionsCollection = null

app.use(bodyParser.json())

app.listen(port, () => {
  
  amqplib.connect(amqp, (err, conn) => {
    if (err) throw err
    conn.createChannel((err, ch1) => {
      if (err) throw err
      ch1.assertQueue(queue)
      channel = ch1
      console.log(`transaction-service connected to AMQP running at ${amqp}`)
    });
  });
  
  mongoClient.connect().then(() => {
    console.log(`transaction-service connected to MongoDB running at ${mongoUrl}`)
    const db = mongoClient.db(dbName)
    transactionsCollection = db.collection('transactions')
  }).catch(err => console.err(err))

  console.log(`transaction-service ready at the port ${port}`)

})

app.post('/transaction-service/transactions', (req, res) => {
    const { body } = req
    console.log('sending message', body)
    transactionsCollection.insertOne(body).then(result => {
      const id = result.insertedId.toString()
      console.log(`inserted id is ${id}`)
      channel.sendToQueue(queue, Buffer.from(JSON.stringify({id, ...body})))      
    })
    res.status(200).send({'os.name': hostname})
})
