package com.xadmin.servlet_p.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xadmin.servlet_p.bean.Flight;
import com.xadmin.servlet_p.bean.passengers;
import com.xadmin.servlet_p.dao.FlightDAO;
import com.xadmin.servlet_p.dao.passengersDAO;

/**
 * Servlet implementation class EditFlight
 */
@WebServlet("/EditFlight")
public class EditFlight extends HttpServlet {
	  private static final long serialVersionUID = 1L;
	    private FlightDAO flightDAO;

	    public EditFlight() {
	        super();
	        flightDAO = new FlightDAO();
	    }

	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String idParam = request.getParameter("flightcode");
	        if (idParam != null && !idParam.isEmpty()) {
	            try {
	                String flightcode = idParam; 
	                Flight existingFlight = flightDAO.getFlight(flightcode);
	                RequestDispatcher dispatcher = request.getRequestDispatcher("flight-form.jsp");
	                request.setAttribute("flight", existingFlight);
	                dispatcher.forward(request, response);
	            } catch (NumberFormatException e) {
	                e.printStackTrace();
	           
	                response.sendRedirect("Error.jsp");
	            }
	        } else {
	           
	            response.sendRedirect("Error.jsp");
	        }
	    }

	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        doGet(request, response);
	    }
}
