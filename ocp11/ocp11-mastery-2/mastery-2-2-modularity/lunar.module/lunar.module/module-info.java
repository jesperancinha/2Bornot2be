import org.jesperancinha.ocp11.lunar.module.LunarInterface;
import org.jesperancinha.ocp11.lunar.module.LunarModule;

module lunar.module {
    requires consolerizer;
    exports org.jesperancinha.ocp11.lunar.module;
//    exports org.jesperancinha.ocp11.lunar.extra;
    provides LunarInterface with LunarModule;

}