import org.jesperancinha.ocp11.service.module.ServiceInterface;
import org.jesperancinha.ocp11.service.module.ServiceModule;

module service.module {
    requires consolerizer;
    exports org.jesperancinha.ocp11.service.module;
    provides ServiceInterface with ServiceModule;

}