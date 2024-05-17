package com.xadmin.servlet_p.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xadmin.servlet_p.bean.Flight;
import com.xadmin.servlet_p.dao.FlightDAO;

/**
 * Servlet implementation class flightServlet
 */
@WebServlet("/flights")
public class flightServlet extends HttpServlet {
	  private static final long serialVersionUID = 1L;
	    private FlightDAO flightDAO;

	    public flightServlet() {
	        super();
	    }

	    public void init() throws ServletException {
	        flightDAO = new FlightDAO();
	    }

	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        doGet(request, response);
	    }

	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        String action = request.getServletPath();
	        try {
	            switch (action) {
	                case "/new":
	                    showNewForm(request, response);
	                    break;
	                case "/insert":
	                    insertFlight(request, response);
	                    break;
	                case "/delete":
	                    deleteFlight(request, response);
	                    break;
	                case "/edit":
	                    showEditForm(request, response);
	                    break;
	                case "/update":
	                    updateFlight(request, response);
	                    break;
	                case "/list":
	                default:
	                    listFlights(request, response);
	                    break;
	            }
	        } catch (SQLException ex) {
	            throw new ServletException(ex);
	        }
	    }


	    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        RequestDispatcher dispatcher = request.getRequestDispatcher("flight-form.jsp");
	        dispatcher.forward(request, response);
	    }

	    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, ServletException, IOException {
	        String flightcode = request.getParameter("flightcode"); 
	        Flight existingFlight = flightDAO.getFlight(flightcode);

	        // Envoyer le passager récupéré à la page JSP pour affichage dans le formulaire d'édition
	        RequestDispatcher dispatcher = request.getRequestDispatcher("flight-form.jsp");
	        request.setAttribute("flight", existingFlight);
	        dispatcher.forward(request, response);
	    }


	    public void insertFlight(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, IOException {
	        String flightcode = request.getParameter("flightcode");
	        String source_l = request.getParameter("source_l");
	        String detination_l = request.getParameter("detination_l");
	        String takeoffd = request.getParameter("takeoffd");
	        int nbseats = Integer.parseInt(request.getParameter("nbseats"));
	        double amount = Double.parseDouble(request.getParameter("amount"));
	        
	        Flight newFlight = new Flight(flightcode ,source_l,detination_l,takeoffd,nbseats,amount);
            flightDAO.insertFlight(newFlight);
	        response.sendRedirect("list");
	    }


	    private void updateFlight(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, IOException {
	        String flightcode = null;
	        if (request.getParameter("flightcode") != null && !request.getParameter("flightcode").isEmpty()) {
	            flightcode = request.getParameter("flightcode");
	        }
	      
	        String source_l = request.getParameter("source_l");
	        String detination_l = request.getParameter("detination_l");
	        String takeoffd = request.getParameter("takeoffd");
	        int nbseats = Integer.parseInt(request.getParameter("nbseats"));
	        double amount = Double.parseDouble(request.getParameter("amount"));
	        
	        Flight flight = new Flight(flightcode ,source_l,detination_l,takeoffd,nbseats,amount);
	        flight.setFlightcode(flightcode);
            flightDAO.updateFlight(flight);

	        response.sendRedirect("flights");
	}

	    private void deleteFlight(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, IOException {
	    String flightcode = request.getParameter("flightcode");
	    flightDAO.deleteFlight(flightcode);
	    response.sendRedirect("list");
	}

	    

	    private void listFlights(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, IOException, ServletException {
	        List<Flight> listFlights = flightDAO.getAllFlights();
	        request.setAttribute("listFlights", listFlights);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("flight-list.jsp");
	        dispatcher.forward(request, response);
	    }

}
