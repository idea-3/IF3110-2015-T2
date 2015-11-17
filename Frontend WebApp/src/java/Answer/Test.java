/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Answer;

import AnswerWS.AnswerWS_Service;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author Irene Wiliudarsan - 13513002
 * @author Angela Lynn - 13513032
 * @author Devina Ekawati - 13513088
 */
public class Test extends HttpServlet {
  @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8082/Stackexchange_WS/AnswerWS.wsdl")
  private AnswerWS_Service service;

  /**
   * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
   * methods.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    try (PrintWriter out = response.getWriter()) {
      /* TODO output your page here. You may use following sample code. */
      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("<title>Servlet Test</title>");      
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>Servlet Test at " + request.getContextPath() + "</h1>");
      try { 
        int i = 1; 
        java.util.List<AnswerWS.Answer> result = getAnswerByQId(i); 
        out.println("Result: " + result); 
        for (AnswerWS.Answer answer : result) { 
          out.println(answer.getContent()); 
        } 
      } catch (Exception ex) { 
        out.println("Exception: " + ex); 
      }
      out.println("</body>");
      out.println("</html>");
    }
  }

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
    processRequest(request, response);
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
    processRequest(request, response);
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

  private java.util.List<AnswerWS.Answer> getAnswerByQId(int qid) {
    // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
    // If the calling of port operations may lead to race condition some synchronization is required.
    AnswerWS.AnswerWS port = service.getAnswerWSPort();
    return port.getAnswerByQId(qid);
  }

}
