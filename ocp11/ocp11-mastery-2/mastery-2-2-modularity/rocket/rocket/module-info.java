import org.jesperancinha.ocp11.lunar.module.LunarInterface;
import org.jesperancinha.ocp11.service.module.ServiceInterface;

module rocket {
    uses LunarInterface;
    uses ServiceInterface;
//    requires consolerizer;
    requires service.module;
    requires lunar.module;
}