// Source code is decompiled from a .class file using FernFlower decompiler.
package com.xadmin.servlet_p.web;

import com.xadmin.servlet_p.dao.FlightDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({"/DeleteFlight"})
public class DeleteFlight extends HttpServlet {
   private static final long serialVersionUID = 1L;

   public DeleteFlight() {
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String idParam = request.getParameter("flightcode");
      if (idParam != null && !idParam.isEmpty()) {
         try {
            FlightDAO flightDAO = new FlightDAO();
            flightDAO.deleteFlight(idParam);
         } catch (NumberFormatException var6) {
            var6.printStackTrace();
         } catch (SQLException var7) {
            var7.printStackTrace();
         }
      }

      response.sendRedirect("flights");
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      this.doGet(request, response);
   }
}
