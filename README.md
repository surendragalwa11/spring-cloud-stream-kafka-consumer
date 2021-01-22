# spring-cloud-stream-kafka-consumer
Sample Spring Cloud Stream Kafka Consumer

## How to start

Run following commands & Run Consumer without group id

```
mvn clean install
mvn spring-boot:run -Dspring.cloud.stream.kafka.binder.brokers=<KAFKA_BROKER_URL> -Dspring.cloud.stream.bindings.input.destination=<TOPIC_NAME>
```

## Steps to reproduce [kafka-binder-issue](https://github.com/spring-cloud/spring-cloud-stream-binder-kafka/issues/1016):

1. Once the application starts, send some messages on the kafka topic you provided. 
2. Stop the application & send some more messages on the kafka topic. 
3. Run the application again by providing a fresh consumer group id and consumer startOffset (value latest).
4. Notice that it does not listens to the messages which were sent between the stop (consumer without group id) & start (consumer with new group id) phase.

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
 4. Stop the application & send some more messages on the kafka topic.
 5. Run the application again by uncommenting last 2 lines of the docker-compose file's environment section. (group id & startOffset).
 6. Notice that it does not listens to the messages which were sent between the stop (consumer without group id) & start (consumer with new group id) phase.
