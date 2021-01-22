# spring-cloud-stream-kafka-consumer
Sample Spring Cloud Stream Kafka Consumer

## How to start

Run following commands & Run Consumer without group id

```
mvn clean install
mvn spring-boot:run -Dspring.cloud.stream.kafka.binder.brokers=<KAFKA_BROKER_URL> -Dspring.cloud.stream.bindings.input.destination=<TOPIC_NAME>
```

## Steps to reproduce:

1. Once the application starts, send some messages on the kafka topic you provided. 
2. Stop the application & run it again by providing consumer group id, consumer startOffset (value latest) & resetOffset.
3. Notice that it listens to the previously consumed messages.

## Docker Setup

1. Run the below command to build the docker image

```
mvn clean install
docker build . -t consumer
```

2. Run the src/main/docker/docker-compose-consumer.yml file with the following command

 ```
 docker-compose -f docker-compose-consumer.yml up
 ```
 
 3. Send some messages on the kafka topic you provided.
 4. Stop the application & run it again by uncommenting last 3 lines of the docker-compose file's environment section. (group, startOffset & resetOffset).
 5. Not that it listens to the previously consumed messages.
