package com.dogukanku.kafka.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(
            topicPartitions = @TopicPartition(topic = "comsumer.events",
                    partitionOffsets = {
                            @PartitionOffset(partition = "0", initialOffset = "0")
                    }))
    public void listenToParition(
            @Payload String message,
            @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
        System.out.println(
                "Received Messasge: " + message + " from partition: " + partition);
    }
}
