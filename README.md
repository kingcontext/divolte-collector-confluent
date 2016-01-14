# divolte-collector-confluent

It's Confluent serializers to be used in Divolte collector. It's built for the upcoming Divolte-collector 0.4.0, which is now only available as a snapshot release. 

It requires some patches to be applied in divolte-collecor & the Confluent kafka-avro-serializer (part of their schemaregistry) to make it work. Until these are applied, you'll find them in the forked repo's:
- https://github.com/kingcontext/schema-registry
- https://github.com/kingcontext/divolte-collector

FYI, these are the pull requests:
- https://github.com/confluentinc/schema-registry/pull/276
- https://github.com/divolte/divolte-collector/pull/117

## Building it
Build divolte-collector first: checkout https://github.com/divolte/divolte-collector and build it. 

To make dependencies work, install divolte-collector in local maven repository:

- in divolte-collector project, edit build.gradle and add:

`apply plugin: 'maven' `

- and afterwards execute 

`./gradlew install `

Now build divolte-collector-confluent, checkout and run 

`mvn package `

## Installation

You'll need to add the freshly built divolte-confluent-serializer-1.0-SNAPSHOT.jar and it's dependencies (e.g. kafka-avro-serializer-2.0.0.jar) to the divolte classpath. 

For your convenience, they've packaged as a binary archive containing the jar and just the additional dependencies needed (since divolte-collector already offers e.g. Kafka, Avro etc.). So un-(tar)-(g/b)-zip in the divolte lib folder and your good to go.

## Usage

You need to configure the Kafka serializers in your divolte-collector.conf. To do so, add under the `kafka_flusher` -> `producer` section:
```
key.serializer=com.kingcontext.divolte.kafka.serializer.DivolteStringSerializer
value.serializer=com.kingcontext.divolte.kafka.serializer.DivolteConfluentAvroSerializer
```
The result is a String message key (instead of a byte[]), and a GenericRecord message value (instead of a byte[]). Only the value is will have a schema registered in the Confluent SchemaRegistry. To have the key also registered in the SchemaRegistry, instead use 
```
key.serializer=com.kingcontext.divolte.kafka.serializer.DivolteStringSerializer
```






