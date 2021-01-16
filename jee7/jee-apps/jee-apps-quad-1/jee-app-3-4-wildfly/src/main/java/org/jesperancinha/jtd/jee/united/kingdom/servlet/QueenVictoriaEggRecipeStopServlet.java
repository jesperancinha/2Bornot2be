package org.jesperancinha.jtd.jee.united.kingdom.servlet;

import javax.batch.operations.JobOperator;
import javax.batch.runtime.BatchRuntime;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static org.jesperancinha.console.consolerizer.Consolerizer.printRainbowFlag;

@WebServlet("/history/victoria/cooking/stop")
public class QueenVictoriaEggRecipeStopServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        printRainbowFlag("Stopping Queen Victoria's egg recipe!");
        stopAllJobs();
    }

    private void stopAllJobs() {
        JobOperator jobOperator = BatchRuntime.getJobOperator();
        final List<Long> boilEggsJobs = jobOperator.getRunningExecutions("BoilEggsJob");
        boilEggsJobs.forEach(jobOperator::stop);
    }
}
