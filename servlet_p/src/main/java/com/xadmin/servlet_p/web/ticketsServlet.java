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
//import com.xadmin.servlet_p.bean.passengers;
import com.xadmin.servlet_p.bean.tickets;
import com.xadmin.servlet_p.dao.ticketsDAO;


@WebServlet("/Tickets")
public class ticketsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ticketsDAO ticketsDAO;
    
    
    public ticketsServlet() {
    	super();
    }
    public void init() throws ServletException {
        ticketsDAO = new ticketsDAO();
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
                        insertBooking(request, response);
                        break;
                    case "/delete":
                        deleteTicket(request, response);
                        break;
                    case "/edit":
                        showEditForm(request, response);
                        break;
                    case "/update":
                        updateTicket(request, response);
                        break;
                    default:
                        listTickets(request, response);
                        break;
                }
            
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("tickets-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("ticketId"));
        tickets existingTicket = ticketsDAO.selectBooking(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("tickets-form.jsp");
        request.setAttribute("ticket", existingTicket);
        dispatcher.forward(request, response);
    }

    public void insertBooking(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int ticketId = Integer.parseInt(request.getParameter("ticketId"));
        String pName = request.getParameter("pName");
        String flCode = request.getParameter("flCode");
        String pGen = request.getParameter("pGen");
        String pPass = request.getParameter("pPass");
        int amount = Integer.parseInt(request.getParameter("amount"));
        String nationality = request.getParameter("nationality");

        Flight flight = new Flight(flCode);
        tickets newTicket = new tickets(ticketId, pName, flight, pGen, pPass, amount, nationality);
        ticketsDAO.insertBooking(newTicket);
        response.sendRedirect("Tickets?action=list");
    }

    private void updateTicket(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int ticketId = Integer.parseInt(request.getParameter("ticketId"));
        String pName = request.getParameter("pName");
        String flCode = request.getParameter("flCode");
        String pGen = request.getParameter("pGen");
        String pPass = request.getParameter("pPass");
        int amount = Integer.parseInt(request.getParameter("amount"));
        String nationality = request.getParameter("nationality");

        Flight flight = new Flight(flCode);
        tickets ticket = new tickets(ticketId, pName, flight, pGen, pPass, amount, nationality);
        ticketsDAO.updateTicket(ticket);
        response.sendRedirect("list");
    }

    private void deleteTicket(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("ticketId"));
        ticketsDAO.deleteTicket(id);
        response.sendRedirect("list");
    }

    private void listTickets(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<tickets> listTickets = ticketsDAO.selectAllTickets();
        request.setAttribute("listTickets", listTickets);
        RequestDispatcher dispatcher = request.getRequestDispatcher("tickets-list.jsp");
        dispatcher.forward(request, response);
    }
}
