package org.jesperancinha.jtd.jee.the.netherlands.rest;

import org.jesperancinha.console.consolerizer.Consolerizer;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.Serializable;

import static org.jesperancinha.console.consolerizer.Consolerizer.printOrangeGenericLn;

@Path("/arrival")
@SessionScoped
public class KingsAndQueensArrival implements Serializable {

    @Inject
    private Event<ArrivalEvent> arrivalEventEmitter;

    @Inject
    private EventProcessor eventProcessor;

    @GET
    @Path("{monarch}")
    @Produces(MediaType.APPLICATION_JSON)
    public String processArrival(
        @PathParam("monarch")
            String monarch) {
        Consolerizer.setupFastDefault();
        printOrangeGenericLn("We will now see what will happen with our %s with hash %s", eventProcessor.getClass()
            .getCanonicalName(), eventProcessor.hashCode());
        final ArrivalEvent arrivalEvent = new ArrivalEvent();
        final String message = String.format("Your Majesty King/Queen %s is arriving to the Palace", monarch);
        arrivalEvent.setMessage(message);
        arrivalEventEmitter.fire(arrivalEvent);
        return message;
    }
}
