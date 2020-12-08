package com.microservice.transfersrealizationservice;

import com.microservice.commons.TransferMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TransferRealizationProducer {

    private static final String TRANSFERS_REALIZATION_TOPIC = "transfers-realization";
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void sendTransferRequest(TransferMessage transferMessage) {
        log.info("Sending transfer realization request to Kafka, transferMessage: {}", transferMessage);
        kafkaTemplate.send(TRANSFERS_REALIZATION_TOPIC, transferMessage);
        log.info("Message was sent");
    }
}