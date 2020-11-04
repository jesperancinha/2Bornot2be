import org.jesperancinha.ocp11.mastery2dot2.animals.BetterFluteServiceImpl;
import org.jesperancinha.ocp11.mastery2dot2.animals.FluteService;
import org.jesperancinha.ocp11.mastery2dot2.animals.FluteServiceImpl;
import org.jesperancinha.ocp11.mastery2dot2.animals.OboeService;
import org.jesperancinha.ocp11.mastery2dot2.animals.OboeServiceImpl;

module $mastery$ {
    requires consolerizer;
    uses FluteService;
    uses OboeService;
    provides FluteService with FluteServiceImpl, BetterFluteServiceImpl;
    provides OboeService with OboeServiceImpl;
}