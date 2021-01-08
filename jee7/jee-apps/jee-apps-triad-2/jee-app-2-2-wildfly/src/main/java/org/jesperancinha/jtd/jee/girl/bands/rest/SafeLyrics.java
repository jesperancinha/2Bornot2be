package org.jesperancinha.jtd.jee.girl.bands.rest;

import org.jesperancinha.console.consolerizer.Consolerizer;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/secure/lyrics/spice")
@RequestScoped
public class SafeLyrics {

    private static final String FROM = "https://genius.com/Spice-girls-spice-up-your-life-lyrics";

    private static final String LYRIC =
        "Flamenco, lambada\n" + "But hip hop is harder\n" + "(We moonwalk the foxtrot)\n" + "(Then polka, the salsa)\n"
            + "Shake it shake it shake it, haka\n" + "Shake it shake it shake it, haka\n" + "Arriba! Aha";

    @GET
    @Produces(APPLICATION_JSON)
    public String getLyrics() {
        Consolerizer.printBrightMagentaGenericLn(FROM);
        Consolerizer.printBrightMagentaGenericLn(LYRIC);
        return FROM.concat("\n")
            .concat(LYRIC);
    }
}
