// Source code is decompiled from a .class file using FernFlower decompiler.
package com.xadmin.servlet_p.web;

import com.xadmin.servlet_p.bean.Flight;
import com.xadmin.servlet_p.dao.FlightDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({"/EditFlight"})
public class EditFlight extends HttpServlet {
   private static final long serialVersionUID = 1L;
   private FlightDAO flightDAO = new FlightDAO();

   public EditFlight() {
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String idParam = request.getParameter("flightcode");
      if (idParam != null && !idParam.isEmpty()) {
         try {
            Flight existingFlight = this.flightDAO.getFlight(idParam);
            RequestDispatcher dispatcher = request.getRequestDispatcher("flight-form.jsp");
            request.setAttribute("flight", existingFlight);
            dispatcher.forward(request, response);
         } catch (NumberFormatException var7) {
            var7.printStackTrace();
            response.sendRedirect("Error.jsp");
         }
      } else {
         response.sendRedirect("Error.jsp");
      }

   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      this.doGet(request, response);
   }
}
