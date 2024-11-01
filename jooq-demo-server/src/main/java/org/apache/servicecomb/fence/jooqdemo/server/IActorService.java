package org.apache.servicecomb.fence.jooqdemo.server;

import org.apache.servicecomb.fence.jooqdemo.db.tables.pojos.Actor;

import java.util.List;

public interface IActorService {
    List<Actor> listActors();

    Object getActor(Long actorId);

    boolean deleteActor(Long actorId);

    boolean addActor(String firstName, String lastName);
}
