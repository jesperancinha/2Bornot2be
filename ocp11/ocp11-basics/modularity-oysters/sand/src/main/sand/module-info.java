import org.jesperancinha.ocp11.sand.Sand;
import org.jesperancinha.ocp11.sand.SandImpl;

module sand {
    exports org.jesperancinha.ocp11.sand;
    provides Sand with SandImpl;
    requires oyster;
}