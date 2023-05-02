package com.example.webapp230428;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletNew", value = "/ServletNew")
public class ServletNew extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String button = request.getParameter("button");
        String contextAtr = (String)getServletContext().getAttribute("contextAtr");
        String nameAtr = (String)request.getAttribute("nameAtr");
        String sessionId = (String)request.getSession().getAttribute("sessionId");
        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + "Hello world" + "</h1>");
        out.println("<h3>" + "login=" + login + "</h3>");
        out.println("<h3>" + "password=" + password + "</h3>");
        out.println("<h3>" + "button=" + button + "</h3>");
        out.println("<h3>" + "contextAtr=" + contextAtr + "</h3>");
        out.println("<h3>" + "nameAtr=" + nameAtr + "</h3>");
        out.println("<h3>" + "sessionId=" + sessionId + "</h3>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
