package com.sapiens.wyrwalm.ridemon.mq.activemq;

import com.iditnext.cmc.model.EventMessage;
import com.sapiens.wyrwalm.ridemon.service.Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ActiveMqMessageConsumer {
    private final Service service;

    public ActiveMqMessageConsumer(Service service) {
        this.service = service;
    }

    @JmsListener(destination ="party-outbox")
    public void messageListener(EventMessage message){
        service.toLog(message);
    }
}
