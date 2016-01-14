# divolte-collector-confluent

to be completed

## Building
Build divolte-collector first: checkout https://github.com/divolte/divolte-collector and build it. 

To make dependencies work, install divolte-collector in local maven repository:

- in divolte-collector project, edit build.gradle and add:

apply plugin: 'maven'

- and afterwards execute 

./gradlew install

Now build divolte-collector-confluent, checkout and run 

mvn install

## Installation

You'll need to add the freshly built divolte-confluent-serializer-1.0-SNAPSHOT.jar and it's dependencies (e.g. kafka-avro-serializer-2.0.0.jar) to the divolte classpath.
