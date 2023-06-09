package com.example.dev_j200_2;

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

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        boolean check = new UserStore().checkUser(username, password);
        if(check) getServletContext().getRequestDispatcher("/ServletViewList").forward(request, response);
        else {
            String message = "Логин или пароль не найдены";
            request.setAttribute("message", message);
            getServletContext().getRequestDispatcher("/ServletInfo").forward(request, response);
        }
    }

    public void destroy() {
    }
}