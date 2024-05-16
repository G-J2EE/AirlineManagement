package com.xadmin.servlet_p.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xadmin.servlet_p.bean.passengers;
import com.xadmin.servlet_p.dao.passengersDAO;

@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private passengersDAO passengersDAO;

    public EditServlet() {
        super();
        passengersDAO = new passengersDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idParam = request.getParameter("PI");
        if (idParam != null && !idParam.isEmpty()) {
            try {
                int id = Integer.parseInt(idParam); 
                passengers existingPassenger = passengersDAO.selectPassenger(id);
                RequestDispatcher dispatcher = request.getRequestDispatcher("passengers-form.jsp");
                request.setAttribute("passenger", existingPassenger);
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
