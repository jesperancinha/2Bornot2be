package org.jesperancinha.ocp11.computeif.present;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class SpaceFlyingBody extends FlyingBody {
    private long operationalPayloads;

    public SpaceFlyingBody(String id, long operationalPayloads) {
        super(id);
        this.operationalPayloads = operationalPayloads;
    }

    @Override
    public String toString() {
        return "SpaceFlyingBody{" +
                "operationalPayloads=" + operationalPayloads +
                ", id='" + id + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Map<String, FlyingBody> flyingBodyHashMap = new HashMap<>();
        flyingBodyHashMap.put("Sputnik-PS", new FlyingBody("Sputnik 1"));
        flyingBodyHashMap.put("Juno I", new SpaceFlyingBody("Explorer 1", 1914));
        BiFunction<String, FlyingBody, FlyingBody> bif = (id, fb) ->
                fb instanceof SpaceFlyingBody ? new SpaceFlyingBody(id, 1524) : new FlyingBody(id);
        FlyingBody sputnik =  flyingBodyHashMap.get("Sputnik-PS");
        SpaceFlyingBody juno = (SpaceFlyingBody) flyingBodyHashMap.get("Juno I");
        System.out.println("Before:");
        System.out.println(sputnik);
        System.out.println(juno);
        flyingBodyHashMap.computeIfPresent("Sputnik-PS", bif);
        sputnik =  flyingBodyHashMap.get("Sputnik-PS");
        juno = (SpaceFlyingBody) flyingBodyHashMap.get("Juno I");
        System.out.println("After:");
        System.out.println(sputnik);
        System.out.println(juno);
        flyingBodyHashMap.computeIfPresent("Juno I", bif);
        sputnik =  flyingBodyHashMap.get("Sputnik-PS");
        juno = (SpaceFlyingBody) flyingBodyHashMap.get("Juno I");
        System.out.println("After:");
        System.out.println(sputnik);
        System.out.println(juno);
    }
}
