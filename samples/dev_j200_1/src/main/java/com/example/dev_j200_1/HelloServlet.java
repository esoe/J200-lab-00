package com.example.dev_j200_1;

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
        response.setContentType("text/html; charset=UTF-8");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        boolean resCheckUser = new UserStore().checkUser(login, password);
        if(resCheckUser){
            getServletContext().getRequestDispatcher("/ServletViewList").forward(request, response);
        } else {
            request.setAttribute("message", "Логин или пароль не найдены!");
            getServletContext().getRequestDispatcher("/ErrorServlet").forward(request, response);
        }

    }

    public void destroy() {
    }
}