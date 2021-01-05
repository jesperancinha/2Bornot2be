package org.jesperancinha.jtd.jee.teeth.servlets;

import org.jesperancinha.console.consolerizer.Consolerizer;
import org.jesperancinha.jtd.jee.teeth.domain.Jaw;
import org.jesperancinha.jtd.jee.teeth.domain.Tooth;
import org.jesperancinha.jtd.jee.teeth.service.JawService;
import org.jesperancinha.jtd.jee.teeth.service.transaction.ToothServiceTx;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

import static org.jesperancinha.console.consolerizer.Consolerizer.printOrangeGenericLn;

@WebServlet("/tooth/servlet/tx/all")
public class ToothTransactionAttributeServlet extends HttpServlet {

    @EJB
    private ToothServiceTx toothService;

    @Inject
    private JawService jawService;

    @Resource
    private UserTransaction userTransaction;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final PrintWriter writer = resp.getWriter();

        final Tooth tooth = createTestTooth();

        final var jaw = new Jaw();
        jaw.setUuid(UUID.randomUUID());
        final Jaw jaw1 = jawService.updateItRight(jaw);

        tooth.setJaw(jaw);

        var tooth1 = (Tooth) null;

        try {
            Consolerizer.printBrightMagentaGenericLn("No Transaction");
            tooth1 = toothService.addToothNone(tooth);
            Consolerizer.printBrightMagentaGenericLn("REQUIRES_NEW");
            userTransaction.begin();
            toothService.addTootRequiresNew(createTestTooth());
            toothService.addTootRequiresNew(createTestTooth());
            userTransaction.commit();
            Consolerizer.printBrightMagentaGenericLn("MANDATORY");
            userTransaction.begin();
            toothService.addToothMandatory(createTestTooth());
            toothService.addToothMandatory(createTestTooth());
            userTransaction.commit();

        } catch (NotSupportedException e) {
            e.printStackTrace();
        } catch (SystemException e) {
            e.printStackTrace();
        } catch (HeuristicMixedException e) {
            e.printStackTrace();
        } catch (HeuristicRollbackException e) {
            e.printStackTrace();
        } catch (RollbackException e) {
            e.printStackTrace();
        }
        Consolerizer.printBlueGenericLn(tooth1);

        printOrangeGenericLn(tooth1);
        printOrangeGenericLn(jaw1);

        writer.println(tooth1);
    }

    private Tooth createTestTooth() {
        final var tooth = new Tooth();
        final var uuid = UUID.randomUUID();
        tooth.setUuid(uuid);
        return tooth;
    }
}
