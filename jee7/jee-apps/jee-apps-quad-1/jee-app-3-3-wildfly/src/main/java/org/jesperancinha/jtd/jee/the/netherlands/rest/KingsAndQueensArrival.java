package org.jesperancinha.jtd.jee.the.netherlands.rest;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/arrival")
public class KingsAndQueensArrival {

    @Inject
    private Event<ArrivalEvent> arrivalEventEmitter;

    @GET
    @Path("{monarch}")
    @Produces(MediaType.APPLICATION_JSON)
    public String processArrival(@PathParam("monarch") String monarch){
        final ArrivalEvent arrivalEvent = new ArrivalEvent();
        final String message = String.format("Your Majesty King/Queen %s is arriving to the Palace", monarch);
        arrivalEvent.setMessage(message);
        arrivalEventEmitter.fire(arrivalEvent);
        return message;
    }
}
