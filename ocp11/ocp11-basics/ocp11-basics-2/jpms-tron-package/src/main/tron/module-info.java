import org.jesperancinha.ocp11.tron.TronService;
import org.jesperancinha.ocp11.tron.TronServiceImpl;

module tron {
    uses TronService;
    exports org.jesperancinha.ocp11.tron;
    provides TronService with TronServiceImpl;
}