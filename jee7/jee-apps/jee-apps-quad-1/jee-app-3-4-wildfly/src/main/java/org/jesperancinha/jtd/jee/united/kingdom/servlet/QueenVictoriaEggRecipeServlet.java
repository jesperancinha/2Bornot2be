package org.jesperancinha.jtd.jee.united.kingdom.servlet;

import org.jesperancinha.console.consolerizer.Consolerizer;

import javax.batch.operations.JobOperator;
import javax.batch.runtime.BatchRuntime;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Properties;

import static org.jesperancinha.console.consolerizer.Consolerizer.printMagentaGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printRainbowFlag;

@WebServlet("/history/victoria/cooking")
public class QueenVictoriaEggRecipeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        printRainbowFlag("Starting Queen Victoria's egg recipe!");
        final long processId = startNewBatchJob();

        printMagentaGenericLn("Running job with id %s", processId);
    }

    private long startNewBatchJob() {
        JobOperator jobOperator = BatchRuntime.getJobOperator();
        Properties props = new Properties();
        return jobOperator.start("BoilEggsJob", props);
    }
}
