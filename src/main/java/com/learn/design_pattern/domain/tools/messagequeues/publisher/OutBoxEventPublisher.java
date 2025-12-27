package com.learn.design_pattern.domain.tools.messagequeues.publisher;

import com.learn.design_pattern.application.EventService;
import com.learn.design_pattern.domain.model.OutBoxEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class OutBoxEventPublisher {
    private final KafkaPaymentEventPublisher kafkaPaymentEventPublisher;
    private final EventService eventService;

    @Scheduled(fixedDelay = 2000)
    public void publish() {
        List<OutBoxEvent> eventList = eventService.getListOfEvents();

        for (OutBoxEvent event : eventList) {
            try {
                kafkaPaymentEventPublisher.publish(event.getPaymentEvent());
                event.setStatus("success");
            } catch (Exception e) {
                event.setStatus("Failed");
            }
        }
    }

}
