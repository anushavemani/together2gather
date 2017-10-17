package com.us.g2g.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.us.g2g.hbm.Payment;
import com.us.g2g.hbm.User;

/**
 * Servlet implementation class UserPaymentsData
 */
@WebServlet("/UserPaymentsData")
public class UserPaymentsData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserPaymentsData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("application/json");
		
		User user = (User) request.getSession().getAttribute("user");
		
		JsonArray jsonPayments = new JsonArray();
		
		for (Payment payment: user.getPayments()) {
			JsonObject jPayment = new JsonObject();
			jPayment.addProperty("eventTitle", payment.getEvent().getTitle());
			jPayment.addProperty("amount", payment.getAmount());
			jPayment.addProperty("note", payment.getNote());
			jPayment.addProperty("status", payment.getStatus());
			jPayment.addProperty("paidOn", payment.getPaidOn().getTime());
			jPayment.addProperty("gatewayId", payment.getGatewayId());
			jsonPayments.add(jPayment);
			
		}
		
		response.getWriter().println(jsonPayments.toString());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
