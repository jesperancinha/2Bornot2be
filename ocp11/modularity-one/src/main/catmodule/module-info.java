import org.jesperancinha.oc11.modularity.one.Cat;
import org.jesperancinha.oc11.modularity.one.Feline;

/**
 * Note that:
 * 1. The uses clause is here to say that we are using {@link Feline} in our module (own module running is never a good idea btw).
 * 2. Exports will export and make available all classes to whatever module that uses this module.
 * 3. Provides will provide an implementation of {@link Feline} for the {@link java.util.ServiceLoader}.
 * 4. We using Cat as the implementation for our service {@link Cat}
 */
module catmodule {
    uses Feline;
    exports org.jesperancinha.oc11.modularity.one;
    provides Feline with Cat;
}
