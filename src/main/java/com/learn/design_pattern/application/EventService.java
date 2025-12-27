package com.learn.design_pattern.application;

import com.learn.design_pattern.domain.model.OutBoxEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService {
    private final OutBoxEvent event;

    public List<OutBoxEvent> getListOfEvents() {
        if (event.getEventList().isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        return event.getEventList();
    }

}
