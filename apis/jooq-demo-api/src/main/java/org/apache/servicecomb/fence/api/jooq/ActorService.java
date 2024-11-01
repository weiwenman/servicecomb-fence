package org.apache.servicecomb.fence.api.jooq;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RequestMapping(path = "/v1/handler/actor")
public interface ActorService {

    @ResponseBody
    @GetMapping(path = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    Object listActors();

    @GetMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    Object getActor(@RequestParam(name = "actorId") Long actorId);

    @DeleteMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    boolean deleteActor(@RequestParam(name = "actorId") Long actorId);

    @PostMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    boolean addActor(@RequestParam(name = "firstName") String firstName, @RequestParam(name = "lastName") String lastName);
}
