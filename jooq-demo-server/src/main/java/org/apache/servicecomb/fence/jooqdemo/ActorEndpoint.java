package org.apache.servicecomb.fence.jooqdemo;

import org.apache.servicecomb.fence.api.jooq.ActorService;
import org.apache.servicecomb.fence.jooqdemo.server.IActorService;
import org.apache.servicecomb.provider.rest.common.RestSchema;
import org.springframework.beans.factory.annotation.Autowired;

@RestSchema(schemaId = "ActorEndpoint", schemaInterface = ActorService.class)
public class ActorEndpoint implements ActorService {
    @Autowired
    private IActorService actorService;

    @Override
    public Object listActors() {
        return actorService.listActors();
    }

    @Override
    public Object getActor(Long actorId) {
        return actorService.getActor(actorId);
    }

    @Override
    public boolean deleteActor(Long actorId) {
        return actorService.deleteActor(actorId);
    }

    @Override
    public boolean addActor(String firstName, String lastName) {
        return actorService.addActor(firstName, lastName);
    }
}
