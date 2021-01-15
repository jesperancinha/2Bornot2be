package org.jesperancinha.jtd.jee.the.netherlands.servlet;

import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import java.util.Arrays;
import java.util.List;

@Stateless
public class ListOfKingsAndQueensBean {

    @RolesAllowed({ "Manager", "Civilian" })
    public List<String> getOrangeNassau() {
        return Arrays.asList("Willem I", "Maurice", "Frederik Hendrik", "Willem II", "Willem III", "Willem IV",
            "Willem V");
    }

    @RolesAllowed({ "Manager" })
    public List<String> getNassau() {
        return Arrays.asList("Jan VI", "Willem Lodewijk", "Ernst Casimir I", "Hendrik Casimir I", "Willem Frederik",
            "Hendrik Casimir II", "Johan Willem Friso");
    }
}
