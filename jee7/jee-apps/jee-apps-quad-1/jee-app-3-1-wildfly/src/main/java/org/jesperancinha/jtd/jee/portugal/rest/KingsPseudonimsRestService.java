package org.jesperancinha.jtd.jee.portugal.rest;

import org.jesperancinha.console.consolerizer.Consolerizer;
import org.jesperancinha.jtd.jee.portugal.beans.HistoryContentCreator;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

import static org.jesperancinha.console.consolerizer.Consolerizer.printBlueGenericTitleLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printGreenGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printMagentaGenericLn;

@Path("history/pseudonyms")
public class KingsPseudonimsRestService {

    @GET
    @Path("burgundy/{name}")
    public String getPseudonymByName(
        @PathParam("name")
            String name) {
        printBlueGenericTitleLn("Generic REST endpoint");
        printMagentaGenericLn("You've reached the most generic endpoint.");
        printGreenGenericLn("The reason is that there is no other more specific endpoint.");
        return String.join(",", HistoryContentCreator.getKingsMap()
            .get(name));
    }

    @GET
    @Path("/burgundy/Sancho I")
    public String getPseudonymById() {
        printBlueGenericTitleLn("Specific REST endpoint");
        printMagentaGenericLn("If you've reached this, then you have reached Sancho I fixed enpoint.");
        printGreenGenericLn("This means that although the other endpoint could also account for Sancho I, since this is more specific, it gets called first.");
        return String.join(",", HistoryContentCreator.getKingsMap()
            .get("Sancho I"));
    }
    @GET
    @Path("/burgundy")
        public String getPseudonymById(@QueryParam("id") Integer id) {
        printBlueGenericTitleLn("Query param REST endpoint");
        printMagentaGenericLn("If you've reached this, then you have reached QueryParam enpoint.");
        printGreenGenericLn("This is how we get query params to enter our REST endpoint.");
        return String.join(",", HistoryContentCreator.getKingsMap()
            .values().toArray()[id].toString());
    }

}
