// Source code is decompiled from a .class file using FernFlower decompiler.
package com.xadmin.servlet_p.web;

import com.xadmin.servlet_p.bean.Flight;
import com.xadmin.servlet_p.dao.FlightDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({"/UpdateFlight"})
public class UpdateFlight extends HttpServlet {
   private static final long serialVersionUID = 1L;
   private FlightDAO flightDAO = new FlightDAO();

   public UpdateFlight() {
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      response.sendRedirect("flights");
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String flightcode = request.getParameter("flightcode");
      String source_l = request.getParameter("source_l");
      String destination_l = request.getParameter("destination_l");
      String takeoffd = request.getParameter("takeoffd");
      int nbseats = Integer.parseInt(request.getParameter("nbseats"));
      double amount = Double.parseDouble(request.getParameter("amount"));
      Flight flight = new Flight(flightcode, source_l, destination_l, takeoffd, nbseats, amount);
      flight.setFlightcode(flightcode);

      try {
         this.flightDAO.updateFlight(flight);
      } catch (SQLException var12) {
         var12.printStackTrace();
      }

      response.sendRedirect("flights");
   }
}
