package com.kingcontext.divolte.kafka.serializer;

import java.util.Map;

import io.divolte.server.DivolteIdentifier;

import org.apache.kafka.common.serialization.Serializer;
import org.apache.kafka.common.serialization.StringSerializer;

public class DivolteStringSerializer implements Serializer<DivolteIdentifier> {

    private StringSerializer ser;

    public DivolteStringSerializer() {
        super();
        ser = new StringSerializer();
    }

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        ser.configure(configs, isKey);
    }

    @Override
    public byte[] serialize(String topic, DivolteIdentifier data) {
        return ser.serialize(topic, data.value);
    }

    @Override
    public void close() {
        ser.close();
    }
}