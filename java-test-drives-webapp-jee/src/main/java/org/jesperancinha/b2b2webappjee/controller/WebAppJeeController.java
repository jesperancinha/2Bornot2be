package org.jesperancinha.b2b2webappjee.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Arrays;

/**
 * Created by joao on 29-5-16.
 */
@Path("/test")
public class WebAppJeeController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMyGroups() {

        return Response.ok(Arrays.asList("Group1", "Group2"),
                MediaType.APPLICATION_JSON)
                .build();

    }

}
