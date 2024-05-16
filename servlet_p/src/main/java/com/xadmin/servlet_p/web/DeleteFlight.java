package com.xadmin.servlet_p.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xadmin.servlet_p.dao.FlightDAO;

/**
 * Servlet implementation class DeleteFlight
 */
@WebServlet("/DeleteFlight")
public class DeleteFlight extends HttpServlet {
	private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idParam = request.getParameter("flightcode");
        if(idParam != null && !idParam.isEmpty()) {
            try {
                String flightcode = idParam;
                FlightDAO flightDAO = new FlightDAO();
                flightDAO.deleteFlight(flightcode);
            } catch (NumberFormatException e) {
                // Gérer le cas où l'ID n'est pas un entier valide
                e.printStackTrace();
            } catch (SQLException e) {
                // Gérer les erreurs de la base de données lors de la suppression du passager
                e.printStackTrace();
            }
        } else {
            // Gérer le cas où aucun ID n'est fourni dans la requête
        }
        response.sendRedirect("flights"); // Redirection vers la liste des passagers
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
