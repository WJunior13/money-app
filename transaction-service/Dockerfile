FROM node

ENV  RUN_TIME=host.minikube.internal

ADD ./transaction-service/package.json package.json
ADD ./transaction-service/package-lock.json package-lock.json
ADD ./transaction-service/index.js index.js

EXPOSE 3000

RUN npm install

CMD ["npm", "start"]