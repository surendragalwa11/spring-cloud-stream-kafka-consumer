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
3. Notice that it listened to the previously consumed messages.
