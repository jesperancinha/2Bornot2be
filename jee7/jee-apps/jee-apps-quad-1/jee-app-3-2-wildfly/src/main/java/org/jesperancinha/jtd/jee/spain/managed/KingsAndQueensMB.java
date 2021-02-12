package org.jesperancinha.jtd.jee.spain.managed;

import javax.inject.Named;
import java.util.List;

@Named("kingsAndQueensMB")
public class KingsAndQueensMB {

    private String filterString;

    public List<String> allKingsAndQueensHabsburg() {
        return List.of("Carlos I", "Felipe II", "Felipe III", "Felipe IV", "Carlos II");
    }

    public String getFilterString() {
        return filterString;
    }

    public void setFilterString(String filterString) {
        this.filterString = filterString;
    }

    public String searchFrom() {
        return allKingsAndQueensHabsburg().stream().filter(kq -> kq.contains(filterString)).findAny().orElse(null);
    }
}
