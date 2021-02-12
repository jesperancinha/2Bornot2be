package org.jesperancinha.jtd.jee.app2.mdb;

import org.jesperancinha.console.consolerizer.Consolerizer;

import javax.annotation.Resource;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static org.jesperancinha.console.consolerizer.Consolerizer.printMagentaGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printOrangeGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printRedGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printUnicornsLn;

@WebServlet("/jms")
public class KitchenHerbsJMSServlet extends HttpServlet {

    @Resource(lookup = "java:/ConnectionFactoryLove")
    ConnectionFactory cf;

    @Resource(lookup = "java:jboss/activemq/queue/TestQueue")
    private Queue queue;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            example();
            PrintWriter out = response.getWriter();
            out.println("Message sent!");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void example() throws Exception {
        Consolerizer.setupFastDefault();
        printUnicornsLn(100);
        printOrangeGenericLn("The type of the connection factory is %s", cf);
        printOrangeGenericLn("The type of the queue is %s", queue);
        printUnicornsLn(100);
        Connection connection = null;
        try {
            connection = cf.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer publisher = session.createProducer(queue);

            connection.start();

            TextMessage message = session.createTextMessage("Hello!");
            publisher.send(message);
        } finally {
            closeConnection(connection);
        }

    }

    private void closeConnection(Connection con) {
        printMagentaGenericLn("Closing connection %s", con);
        try {
            if (con != null) {
                con.close();
            }

        } catch (JMSException jmse) {
            printRedGenericLn("Could not close connection " + con + " exception was " + jmse);
        }

    }

}