package com.kingcontext.divolte.kafka.serializer;


import java.util.Map;

import org.apache.kafka.common.serialization.Serializer;

import io.confluent.kafka.serializers.KafkaAvroSerializer;
import io.divolte.server.AvroRecordBuffer;

public class DivolteConfluentAvroSerializer implements Serializer<AvroRecordBuffer> {

    private KafkaAvroSerializer ser;

    public DivolteConfluentAvroSerializer() {
        super();
        ser = new KafkaAvroSerializer();
    }

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        ser.configure(configs, isKey);
    }

    @Override
    public byte[] serialize(String topic, AvroRecordBuffer data) {
        return ser.serialize(topic, data.getRecord());
    }

    @Override
    public void close() {
        ser.close();
    }
}
