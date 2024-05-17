package com.xadmin.servlet_p.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xadmin.servlet_p.dao.FlightDAO;
import com.xadmin.servlet_p.dao.ticketsDAO;

@WebServlet("/DeleteTicketServlet")
public class DeleteTicketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public DeleteTicketServlet() {
	   }

       

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idParam = request.getParameter("ticketId");
        if (idParam != null && !idParam.isEmpty()) {
            try {
                int id = Integer.parseInt(idParam); // Convert the string to an integer
                ticketsDAO ticketsDAO = new ticketsDAO();
                ticketsDAO.deleteTicket(id); // Pass the integer id to deleteTicket method
            } catch (NumberFormatException e) {
                e.printStackTrace();
                // Handle the case where the ID is not a valid integer
            } catch (SQLException e) {
                e.printStackTrace();
                // Handle database errors during ticket deletion
            }
        } else {
            // Handle the case where no ID is provided in the request
        }
        response.sendRedirect("Tickets"); // Redirect to the tickets list page
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    doGet(request, response);
	}

}
