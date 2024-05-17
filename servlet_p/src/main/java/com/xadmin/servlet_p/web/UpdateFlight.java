package com.xadmin.servlet_p.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xadmin.servlet_p.bean.Flight;
import com.xadmin.servlet_p.dao.FlightDAO;

/**
 * Servlet implementation class UpdateFlight
 */
@WebServlet("/UpdateFlight")
public class UpdateFlight extends HttpServlet {
	   private static final long serialVersionUID = 1L;
	    private FlightDAO flightDAO;

	    public UpdateFlight() {
	        super();
	        flightDAO = new FlightDAO();
	    }

	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        // Si quelqu'un tente d'accéder à cette servlet via la méthode GET, redirigez-le vers la page d'accueil ou une autre page appropriée
	        response.sendRedirect("flights");
	    }

	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	    	
	        String flightcode = request.getParameter("flightcode");
	        String source_l = request.getParameter("source_l");
	        String destination_l = request.getParameter("destination_l");
	        String takeoffd = request.getParameter("takeoffd");
	        int nbseats = Integer.parseInt(request.getParameter("nbseats"));
	        double amount = Double.parseDouble(request.getParameter("amount"));
	        
	        Flight flight = new Flight(flightcode,source_l,destination_l,takeoffd,nbseats,amount);

	      
	        flight.setFlightcode(flightcode);
	        try {
				flightDAO.updateFlight(flight);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        response.sendRedirect("flights");
	    }

}
