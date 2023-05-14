/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpack;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mainpack.entities.Domains;
import mainpack.entities.Person;
import mainpack.repo.AppRepositoryLocal;

/**
 *
 * @author denis
 */
@WebServlet(name = "CreateServlet", urlPatterns = {"/CreateServlet"})
public class CreateServlet extends HttpServlet {
    @EJB
    private AppRepositoryLocal repository;

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CreateServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Создание персоны и домена</h1>");
            out.println("<form action=\"CreateServlet\" method=\"post\" align=\"center\">");
            out.println("<label>jobtitle</label><br>");
            out.println("<input type=\"text\" name=\"jobtitle\" required><br><br>");
            out.println("<label>name</label><br>");
            out.println("<input type=\"text\" name=\"name\" required><br><br>");
            out.println("<label>phone</label><br>");
            out.println("<input type=\"tel\" name=\"phone\" required><br><br>");
            out.println("<label>email</label><br>");
            out.println("<input type=\"email\" name=\"email\" required><br><br>");
            out.println("<label>webname</label><br>");
            out.println("<input type=\"text\" name=\"webname\" required><br><br>");
            out.println("<label>domainname</label><br>");
            out.println("<input type=\"text\" name=\"domainname\" required><br><br>");
            out.println("<label>ip</label><br>");
            out.println("<input type=\"text\" name=\"ip\" required><br><br>");
            out.println("<label>country</label><br>");
            out.println("<input type=\"text\" name=\"country\" required><br><br>");
            out.println("<input type=\"submit\" value=\"Create\">");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String jobtitle = request.getParameter("jobtitle");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String webname = request.getParameter("webname");
        String domainname = request.getParameter("domainname");
        String ip = request.getParameter("ip");
        String country = request.getParameter("country");
        
        Domains newDomain = new Domains();
        newDomain.setWebname(webname);
        newDomain.setDomainname(domainname);
        newDomain.setIp(ip);
        newDomain.setCountryreg(country);
        newDomain = repository.createDomains(newDomain);
        
        Person newPerson = new Person();
        newPerson.setJobtitle(jobtitle);
        newPerson.setFirstnamelastname(name);
        newPerson.setPhone(phone);
        newPerson.setEmail(email);
        newPerson.getDomainsCollection().add(newDomain);
        newPerson = repository.createPerson(newPerson);
        newDomain.setPersonid(newPerson);
        repository.updateDomains(newDomain);
        response.sendRedirect("ViewList");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
