package org.jesperancinha.jtd.jee.mastery1.servlet.show;

import org.jesperancinha.console.consolerizer.Consolerizer;

import javax.enterprise.context.SessionScoped;
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
import java.io.IOException;
import java.io.PrintWriter;

import static org.jesperancinha.console.consolerizer.ConsolerizerColor.BLUE;
import static org.jesperancinha.console.consolerizer.ConsolerizerColor.MAGENTA;

@WebServlet("/concert/show")
@SessionScoped
public class ConcertServlet extends HttpServlet {

    @Inject
    private ConcertManager concertManager;

    @Inject
    private ConcertManagerFail concertManagerFail;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final PrintWriter writer = resp.getWriter();

        Consolerizer.setupFastDefault();
        final ConcertEntity concertEntity = concertManager.goToConcert();
        ConcertEntity concertEntityFail = null;
        try {
            concertEntityFail = concertManagerFail.goToConcert();
        } catch (SystemException e) {
            e.printStackTrace();
        } catch (NotSupportedException e) {
            e.printStackTrace();
        } catch (HeuristicRollbackException e) {
            e.printStackTrace();
        } catch (HeuristicMixedException e) {
            e.printStackTrace();
        } catch (RollbackException e) {
            e.printStackTrace();
        }

        writer.println(BLUE.getPBText("Via a CONTAINER managed bean we were able to rollback. We didn't went to see P!nk. 😢 -> %s", concertManager.getStatement(concertEntity.getUuid())));
        try {
            writer.println(BLUE.getPBText("Via a BEAN managed bean we were not able to rollback. We are going to see P!nk live! 🎉🎸 -> %s", concertManagerFail.getStatement(concertEntityFail.getUuid())));
        } catch (SystemException e) {
            e.printStackTrace();
        } catch (NotSupportedException e) {
            e.printStackTrace();
        } catch (HeuristicRollbackException e) {
            e.printStackTrace();
        } catch (HeuristicMixedException e) {
            e.printStackTrace();
        } catch (RollbackException e) {
            e.printStackTrace();
        }
        writer.println(MAGENTA.getPText("<p><a href=\"../index.xhtml\">Back</a></p>"));
    }
}
