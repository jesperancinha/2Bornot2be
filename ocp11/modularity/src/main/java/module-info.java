import org.jesperancinha.ocp11.modularity.ModuleImpl;
import org.jesperancinha.ocp11.modularity.ModuleInterface;

/**
 * Provides always has two parameters:
 * provides ${interface} with ${implements}
 * <p>
 * NOTE: Provides has no effect if the uses directive is not implemented.
 */
module org.jesperancinha.ocp.modularity {
    requires java.compiler;
    // provides ModuleRunner;
    uses ModuleInterface;
    provides ModuleInterface with ModuleImpl;
}