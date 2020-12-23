package org.jesperancinha.java11.crums.crum34;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Boats {
   Boat[] value();
}
