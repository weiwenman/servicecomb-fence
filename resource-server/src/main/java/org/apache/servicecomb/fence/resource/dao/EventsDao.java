package org.apache.servicecomb.fence.resource.dao;

import org.apache.servicecomb.fence.resource.entity.Events;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EventsDao {
    @Autowired
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory;


    public Events save(Events events) {

        sessionFactory.inTransaction(session -> {
            session.persist(events);
        });
        System.out.println("保存成功,id=" + events.getId());
        return events;
    }

    public List<Events> findAll() {
        List<Events> events = new ArrayList<>();
        sessionFactory.inTransaction(session -> {
            session.createSelectionQuery("from Events ", Events.class)
                    .getResultList()
                    .forEach(event -> {
                        events.add(event);
                        System.out.println(event);
                    });
        });
        return events;
    }

    public Events findById(Long id) {
        List<Events> events = new ArrayList<>();
        sessionFactory.inTransaction(session -> {
            events.add(session.get(Events.class, id));
        });
        return events.get(0);
    }
}
