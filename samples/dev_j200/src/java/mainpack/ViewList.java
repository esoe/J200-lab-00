/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpack;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.List;
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
@WebServlet(name = "ViewList", urlPatterns = {"/ViewList"})
public class ViewList extends HttpServlet {
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
        List<Person> persons = repository.getAllPerson();
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ViewList</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>View list</h1>");
            
            out.println("<form action=\"CreateServlet\" method=\"get\" align=\"center\">");
            out.println("<input type=\"submit\" value=\"Create\">");
            out.println("</form>");
            
            out.println("<table align=\"center\" cellpadding=\"5\" border=\"1\" cellspacing=\"0\">");
            out.println("<tr>");
            out.println("<th>id</th>");
            out.println("<th>jobtitle</th>");
            out.println("<th>name</th>");
            out.println("<th>phone</th>");
            out.println("<th>email</th>");
            out.println("<th>id</th>");
            out.println("<th>webname</th>");
            out.println("<th>domainname</th>");
            out.println("<th>ip</th>");
            out.println("<th>country</th>");
            out.println("</tr>");
            for(Person person : persons){
                Collection<Domains> domains = person.getDomainsCollection();
                if(domains.size()>0){
                    for(Domains domain : person.getDomainsCollection()){
                        out.println("<tr>");
                        out.println("<td>" + person.getId() + "</td>");
                        out.println("<td>" + person.getJobtitle() + "</td>");
                        out.println("<td>" + person.getFirstnamelastname() + "</td>");
                        out.println("<td>" + person.getPhone() + "</td>");
                        out.println("<td>" + person.getEmail() + "</td>");
                        out.println("<td>" + domain.getId() + "</td>");
                        out.println("<td>" + domain.getWebname()+ "</td>");
                        out.println("<td>" + domain.getDomainname()+ "</td>");
                        out.println("<td>" + domain.getIp() + "</td>");
                        out.println("<td>" + domain.getCountryreg() + "</td>");
                        out.println("</tr>");
                    }
                }else {
                    out.println("<tr>");
                        out.println("<td>" + person.getId() + "</td>");
                        out.println("<td>" + person.getJobtitle() + "</td>");
                        out.println("<td>" + person.getFirstnamelastname() + "</td>");
                        out.println("<td>" + person.getPhone() + "</td>");
                        out.println("<td>" + person.getEmail() + "</td>");
                        out.println("<td></td><td></td><td></td><td></td><td></td>");
                        out.println("</tr>");
                }
            }
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
