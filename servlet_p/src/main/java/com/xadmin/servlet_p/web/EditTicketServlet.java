package com.xadmin.servlet_p.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xadmin.servlet_p.bean.Flight;
import com.xadmin.servlet_p.bean.tickets;
import com.xadmin.servlet_p.dao.ticketsDAO;


@WebServlet("/EditTicketServlet")
public class EditTicketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ticketsDAO ticketsDAO = new ticketsDAO();

       
    
    public EditTicketServlet() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idParam = request.getParameter("ticketId");
        if (idParam != null && !idParam.isEmpty()) {
            try {
                int id = Integer.parseInt(idParam);
//                Flight existingFlight = this.flightDAO.getFlight(idParam);
                tickets existingTicket = this.ticketsDAO.selectBooking(id);
                RequestDispatcher dispatcher = request.getRequestDispatcher("tickets-form.jsp");
                request.setAttribute("ticket", existingTicket);
                dispatcher.forward(request, response);
                
            } catch (NumberFormatException var7) {
                var7.printStackTrace();
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
