package org.jesperancinha.jtd.jee.mastery1.servlet.ticket;

import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import static org.jesperancinha.console.consolerizer.ConsolerizerColor.GREEN;
import static org.jesperancinha.console.consolerizer.ConsolerizerColor.ORANGE;

@WebServlet(value = "/ticket/sender/blocking1",
        asyncSupported = true)
public class TicketSenderBlockingServlet extends HttpServlet {


    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        super.service(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        final AsyncContext asyncContext = req.getAsyncContext();
        asyncContext.start(() -> {
            GREEN.printSyncGenericTitleLn("From AsyncContext");
            ORANGE.printSyncGenericLn(req.getParameter("name"));
            asyncContext.complete();
        });


        asyncContext.addListener(new AsyncListener() {
            @Override
            public void onComplete(AsyncEvent event) throws IOException {
                GREEN.printSyncGenericTitleLn("From onComplete Listener");
                ORANGE.printSyncGenericLn(event.getAsyncContext().getRequest().getParameter("name"));

            }

            @Override
            public void onTimeout(AsyncEvent event) throws IOException {
                GREEN.printSyncGenericTitleLn("From onTimeout Listener");
                ORANGE.printSyncGenericLn(event.getAsyncContext().getRequest().getParameter("name"));
            }

            @Override
            public void onError(AsyncEvent event) throws IOException {
                GREEN.printSyncGenericTitleLn("From onError Listener");
                ORANGE.printSyncGenericLn(event.getAsyncContext().getRequest().getParameter("name"));
            }

            @Override
            public void onStartAsync(AsyncEvent event) throws IOException {
                GREEN.printSyncGenericTitleLn("From onStartAsync Listener");
                ORANGE.printSyncGenericLn(event.getAsyncContext().getRequest().getParameter("name"));
            }
        });
        asyncContext.complete();
        final ExecutorService executorService = Executors.newSingleThreadExecutor();
        final Future<Object> text = executorService.submit(() -> {
            GREEN.printSyncGenericTitleLn("From Callable");
            ORANGE.printSyncGenericLn(req.getParameter("name"));
            return null;
        });
        try {
            final Object o = text.get();
            executorService.awaitTermination(1, TimeUnit.SECONDS);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

    }
}
