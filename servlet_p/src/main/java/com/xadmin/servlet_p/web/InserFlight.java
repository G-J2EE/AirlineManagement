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
 * Servlet implementation class InserFlight
 */
@WebServlet("/InserFlight")
public class InserFlight extends HttpServlet {
	 private static final long serialVersionUID = 1L;
     
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        // Récupérer les données du formulaire
	        String flightcode = request.getParameter("flightcode");
	        String source_l = request.getParameter("source_l");
	        String destination_l = request.getParameter("destination_l");
	        String takeoffd = request.getParameter("takeoffd");
	        int nbseats = Integer.parseInt(request.getParameter("nbseats"));
	        double amount = Double.parseDouble(request.getParameter("amount"));
	       

	        // Créer un nouvel objet passager
	        Flight newFlight = new Flight(flightcode, source_l, destination_l, takeoffd, nbseats, amount);
	        
	        // Insérer le passager dans la base de données
	        FlightDAO flightDAO = new FlightDAO();
	        try {
	            flightDAO.insertFlight(newFlight);
	        } catch (SQLException e) {
	            // Gérer les erreurs de la base de données lors de l'insertion du passager
	            e.printStackTrace();
	            // Vous pouvez rediriger vers une page d'erreur appropriée ici
	        }
	        
	        // Redirection vers la page des passagers après l'insertion
	        response.sendRedirect("flights");
	    }

	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        // Appeler doGet pour traiter les requêtes POST
	        doGet(request, response);
	    }

}
