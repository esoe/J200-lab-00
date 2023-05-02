package com.example.webapp230428;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String button = request.getParameter("button");
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(-1);
        getServletContext().setAttribute("contextAtr", "same data");
        request.setAttribute("nameAtr", "same data");
        session.setAttribute("sessionId", session.getId());

        if(login.equals("servlet"))
        getServletContext().getRequestDispatcher("/ServletNew").forward(request, response);
        else
            response.sendRedirect("https://dzen.ru/?yredirect=true");

    }

    public void destroy() {
    }
}