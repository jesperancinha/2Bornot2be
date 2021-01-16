package org.jesperancinha.jtd.jee.united.kingdom.servlet;

import javax.batch.operations.JobOperator;
import javax.batch.runtime.BatchRuntime;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import static org.jesperancinha.console.consolerizer.Consolerizer.printRainbowFlag;

@WebServlet("/history/victoria/cooking/stop")
public class QueenVictoriaEggRecipeStopServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        printRainbowFlag("Stopping Queen Victoria's egg recipe!");
        final PrintWriter writer = resp.getWriter();
        writer.println("<html><head></head><body>");

        JobOperator jobOperator = BatchRuntime.getJobOperator();
        final List<Long> boilEggsJobs = jobOperator.getRunningExecutions("BoilEggsJob");

        boilEggsJobs.forEach(jobId->{
            jobOperator.stop(jobId);
            writer.println(String.format("<p>Stopped BoilEggsJobs %s</p>", jobId));
        });

        writer.println("<p><a href=\"../../../index.xhtml\">Back</a></p>");
        writer.println("</body></html>");
    }

}
