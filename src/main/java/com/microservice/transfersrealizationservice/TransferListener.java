package com.microservice.transfersrealizationservice;

import com.microservice.commons.TransferMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Slf4j
@Service
@RequiredArgsConstructor
public class TransferListener {

    @Autowired
    private final TransferRealizationProducer producer;

    @KafkaListener(topics = "transfers")
    public void consume(@Payload TransferMessage transferMessage) throws IOException {
        log.info("Consumed transferMessage: {}", transferMessage);
        producer.sendTransferRequest(transferMessage);
    }

}