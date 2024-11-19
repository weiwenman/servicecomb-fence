package org.apache.servicecomb.fence.resource.endpoint;

import org.apache.servicecomb.fence.resource.dao.EventsDao;
import org.apache.servicecomb.fence.resource.entity.Events;
import org.apache.servicecomb.provider.rest.common.RestSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;

@RestSchema(schemaId = "AccessingDataHibernateEndpoint")
@RequestMapping(path = "/v1/hibernate")
public class AccessingDataHibernateEndpoint {
    @Autowired
    private EventsDao eventsDao;

    @GetMapping("/findById")
    public Events getEventsById(@RequestParam(name = "id") Long id) {
        return eventsDao.findById(id);
    }

    @PutMapping("/save")
    public Events saveEvents(@RequestParam("event") String event) {
        Events events = new Events();
        events.setEvent(event);
        events.setEventTime(LocalDateTime.now());
        return eventsDao.save(events);
    }

    @GetMapping("/list")
    public List<Events> listEvents() {
        return eventsDao.findAll();
    }
}
