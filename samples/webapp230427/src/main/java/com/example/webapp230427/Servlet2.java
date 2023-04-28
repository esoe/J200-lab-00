package com.example.webapp230427;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Servlet2", value = "/Servlet2")
public class Servlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String var = (String)request.getAttribute("Var");

        request.getSession().setMaxInactiveInterval(-1);
        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + "Получены параметры:" + "</h1>");
        out.println("<h3>" + "login: " + login + "</h3>");
        out.println("<h3>" + "password: " + password + "</h3>");
        out.println("<h3>" + "var: " + var + "</h3>");
        out.println("<h3>" + "Session: " + request.getSession().getId() + "</h3>");
        out.println("<h3>" + "Session: " + request.getSession().getMaxInactiveInterval() + "</h3>");
        out.println("</body></html>");
    }
}
