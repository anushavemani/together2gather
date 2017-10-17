package com.us.g2g.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.us.g2g.hbm.Event;
import com.us.g2g.hbm.EventHome;
import com.us.g2g.hbm.Payment;
import com.us.g2g.hbm.PaymentHome;
import com.us.g2g.hbm.User;
import com.us.g2g.hbm.UserHome;

/**
 * Servlet implementation class PostPaymentController
 */
@WebServlet("/paymentReport.do")
public class PostPaymentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostPaymentController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Success
		// http://localhost:8080/admin/paymentReport.do?id=0a420c17e0774d24a91ad98b70a3e5ac&transaction_id=fmc4qr2gj2bdrh2hs6jncsg5qd&payment_id=MOJO7418005J69014042
		User user = (User)request.getSession().getAttribute("user");
		Payment payment = (Payment)request.getSession().getAttribute("paymentobj");
		String paymentId = request.getParameter("payment_id");
		payment.setPaidOn(new Date());
		payment.setGatewayId(paymentId);
		payment.setStatus("SUCCESS");
		PaymentHome pHome = new PaymentHome();
		pHome.merge(payment);
		
		
		Event event = payment.getEvent();
		int receivedFund =0;
		try{
			receivedFund = Integer.parseInt(event.getReceivedFund());
		}catch(Exception e){
			
		}
		event.setReceivedFund((receivedFund+payment.getAmount())+"");
		EventHome eHome = new EventHome();
		eHome.merge(event);
		
		request.getSession().setAttribute("user", (new UserHome()).findById(user.getId()));
		response.sendRedirect("index.jsp");
			
	}

	

}
