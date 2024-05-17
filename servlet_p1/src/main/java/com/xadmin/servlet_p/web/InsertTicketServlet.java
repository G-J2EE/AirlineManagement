package com.xadmin.servlet_p.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xadmin.servlet_p.bean.Flight;
import com.xadmin.servlet_p.bean.tickets;
import com.xadmin.servlet_p.dao.ticketsDAO;

@WebServlet("/InsertTicketServlet")
public class InsertTicketServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public InsertTicketServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ticketIdParam = request.getParameter("ticketId");
        String pName = request.getParameter("pName");
        String flCode = request.getParameter("flCode");
        String pGen = request.getParameter("pGen");
        String pPass = request.getParameter("pPass");
        String amountParam = request.getParameter("amount");
        String nationality = request.getParameter("nationality");

        int ticketId = 0;
        int amount = 0;

        // Check and parse ticketId
        if (ticketIdParam != null && !ticketIdParam.isEmpty()) {
            try {
                ticketId = Integer.parseInt(ticketIdParam);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                response.sendRedirect("Error.jsp");
                return;
            }
        }

        // Check and parse amount
        if (amountParam != null && !amountParam.isEmpty()) {
            try {
                amount = Integer.parseInt(amountParam);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                response.sendRedirect("Error.jsp");
                return;
            }
        }

        Flight flight = new Flight(flCode);
        tickets newTicket = new tickets(ticketId, pName, flight, pGen, pPass, amount, nationality);
        ticketsDAO ticketsDAO = new ticketsDAO();

        try {
            ticketsDAO.insertBooking(newTicket);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.sendRedirect("Tickets");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
