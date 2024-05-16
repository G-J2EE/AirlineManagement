package com.xadmin.servlet_p.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xadmin.servlet_p.bean.passengers;
import com.xadmin.servlet_p.dao.passengersDAO;

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private passengersDAO passengersDAO;

    public UpdateServlet() {
        super();
        passengersDAO = new passengersDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Si quelqu'un tente d'accéder à cette servlet via la méthode GET, redirigez-le vers la page d'accueil ou une autre page appropriée
        response.sendRedirect("passengers");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	int id = 0;
        if (request.getParameter("PI") != null && !request.getParameter("PI").isEmpty()) {
            id = Integer.parseInt(request.getParameter("PI"));
        }
        
        String PName = request.getParameter("PName");
        String PNat = request.getParameter("PNat");
        String PGen = request.getParameter("PGen");
        
        int PPass = 0;
        if (request.getParameter("PPass") != null && !request.getParameter("PPass").isEmpty()) {
            PPass = Integer.parseInt(request.getParameter("PPass"));
        }
        
        String PAdd = request.getParameter("PAdd");
        
        int Pphone = 0;
        if (request.getParameter("Pphone") != null && !request.getParameter("Pphone").isEmpty()) {
            Pphone = Integer.parseInt(request.getParameter("Pphone"));
        }

        passengers passenger = new passengers(PName, PNat, PGen, PPass, PAdd, Pphone);
        passenger.setPI(id);
        try {
			passengersDAO.updatePassenger(passenger);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        response.sendRedirect("passengers");
    }

}