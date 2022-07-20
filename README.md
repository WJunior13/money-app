# MONEY-APP 
###Projeto de microserviços para movimentações bancárias

## Gerando imagens docker
executar o arquivo **docker-compose.yml** no diretorio raiz do projeto para criar as imagens gerais do projeto.

#### Rodar comandos no diretorio money-app/transaction-service para gerar as imagens :
* docker build -t wjcarrer/transaction-service:green .
* docker build -t wjcarrer/transaction-service:blue .
* docker push wjcarrer/transaction-service:green
* docker push wjcarrer/transaction-service:blue:

#### Rodar comandos no diretorio money-app/clientes-service para gerar as imagens :
* mvn clean install package -DskipTests

* docker build -t wjcarrer/clientes-service:blue .
* docker build -t wjcarrer/clientes-service:green .
* docker push wjcarrer/clientes-service:blue
* docker push wjcarrer/clientes-service:green

#### Rodar comandos no diretorio money-app/migration-money-app para gerar as imagens :
* mvn clean install package -DskipTests

* docker build -t wjcarrer/migration-app:v1 .
* docker push wjcarrer/migration-app:v1

## Executando arquivos kubernetes

#### No diretório money-app/kubefiles executar os comandos:
* kubectl apply -f namespace.yml
* kubectl apply -f gateway.yml


#### No diretório money-app/transaction-service/kubefiles executar os comandos:
* kubectl apply -f destination-rule.yml
* kubectl apply -f service.yml
* kubectl apply -f deployment-blue.yml
* kubectl apply -f deployment-green.yml
* kubectl apply -f blue-virtual-service.yml

#### No diretório money-app/balance-service/kubefiles executar os comandos:
* kubectl apply -f destination-rule.yml
* kubectl apply -f service.yml
* kubectl apply -f deployment-blue.yml
* kubectl apply -f deployment-green.yml
* kubectl apply -f blue-virtual-service.yml

#### No diretório money-app/clientes-service/kubefiles executar os comandos:
* kubectl apply -f destination-rule.yml
* kubectl apply -f service.yml
* kubectl apply -f deployment-blue.yml
* kubectl apply -f deployment-green.yml
* kubectl apply -f blue-virtual-service.yml

#### No diretório money-app/migration-money-app/kubefiles executar os comandos:
* kubectl apply -f deployment.yml

