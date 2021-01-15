package org.jesperancinha.jtd.jee.the.netherlands.servlet;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/history")
public class ListOfKingsAndQueensServlet extends HttpServlet {

    @Inject
    private ListOfKingsAndQueensBean listOfKingsAndQueensBean;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        final List<String> orangeNassau = listOfKingsAndQueensBean.getOrangeNassau();

        final PrintWriter writer = resp.getWriter();

        orangeNassau.forEach(writer::println);

    }
}
