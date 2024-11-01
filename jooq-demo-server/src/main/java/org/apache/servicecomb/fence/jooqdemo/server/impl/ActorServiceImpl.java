package org.apache.servicecomb.fence.jooqdemo.server.impl;

import org.apache.servicecomb.fence.jooqdemo.db.tables.pojos.Actor;
import org.apache.servicecomb.fence.jooqdemo.db.tables.records.ActorRecord;
import org.apache.servicecomb.fence.jooqdemo.server.IActorService;
import org.jooq.DSLContext;
import org.jooq.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static org.apache.servicecomb.fence.jooqdemo.db.Tables.ACTOR;

@Component
public class ActorServiceImpl implements IActorService {

    @Autowired
    private DSLContext ctx;

    @Override
    public List<Actor> listActors() {
        List<Actor> list  = new ArrayList<>();
        Result<ActorRecord> fetch = ctx.selectFrom(ACTOR).fetch();
        fetch.forEach(record -> {
            Actor actor = new Actor(record.getActorId(), record.getFirstName(), record.getLastName(), record.getLastUpdate());
            list.add(actor);
        });
        return list;
    }

    @Override
    public Object getActor(Long actorId) {
        ActorRecord record = ctx.selectFrom(ACTOR)
                .where(ACTOR.ACTOR_ID.eq(actorId))
                .fetchOne();
        if (record != null) {
            return record.formatJSON();
        }
        return null;
    }

    @Override
    public boolean deleteActor(Long actorId) {
        return ctx.selectFrom(ACTOR).where(ACTOR.ACTOR_ID.eq(actorId)).execute() > 0;
    }

    @Override
    public boolean addActor(String firstName, String lastName) {
        return ctx.insertInto(ACTOR).columns(ACTOR.FIRST_NAME, ACTOR.LAST_NAME).values(firstName, lastName).execute() > 0;
    }
}
