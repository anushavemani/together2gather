package com.us.g2g.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.instamojo.wrapper.model.PaymentOrder;
import com.instamojo.wrapper.response.CreatePaymentOrderResponse;
import com.us.g2g.hbm.Event;
import com.us.g2g.hbm.EventHome;
import com.us.g2g.hbm.Payment;
import com.us.g2g.hbm.PaymentHome;
import com.us.g2g.hbm.User;
import com.us.g2g.util.PaymentDelegate;
import com.us.g2g.util.RandomStringUtil;

/**
 * Servlet implementation class DonationController
 */
@WebServlet("/donationController")
public class DonationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DonationController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String path =  request.getRequestURL().toString();
		String contextPath = request.getRequestURL().delete(path.lastIndexOf("/"), path.length()).toString();
		User user = (User) request.getSession().getAttribute("user");
		Integer eventid = Integer.parseInt(request.getParameter("id"));
		EventHome ehome = new EventHome();
		Event event = ehome.findById(eventid);
		String transactionId = RandomStringUtil.next();
		
		Payment payment = new Payment();
		payment.setAmount(Integer.parseInt(request.getParameter("donation_amount")));
		payment.setEvent(event);
		payment.setNote(request.getParameter("note"));
		payment.setPaidOn(new Date());
		payment.setStatus("PENDING");
		payment.setTransactionId(transactionId);
		payment.setUser(user);
		
		PaymentHome pHome = new PaymentHome();
		pHome.persist(payment);
		request.getSession().setAttribute("paymentobj", payment);
		String reply = createPaymentLink(user, payment.getAmount().doubleValue(), contextPath,	request.getParameter("donator_email"), request.getParameter("mobile_number"),transactionId);
		if(reply.startsWith("http")){
			response.sendRedirect(reply);
		}else{
			payment.setStatus("FAILED");
			payment.setNote(reply + "***" + payment.getNote() +"***");
			pHome.merge(payment);
			response.sendRedirect("index.jsp");
		}
		
	}

	private String createPaymentLink(User user,Double amount,String contextPath, String email_id,String mobile_no, String transactionId){
    	
		PaymentOrder order = new PaymentOrder();
		order.setName(user.getName());
		order.setEmail(email_id);
		order.setPhone(mobile_no);
		order.setCurrency("USD");
		order.setAmount(amount);
		order.setDescription("User("+user.getEmail() +") is donatned $" +amount+"");
		order.setRedirectUrl(contextPath + "/paymentReport.do");
		order.setTransactionId(transactionId);

		if (order.validate()) {
			System.out.println(order.toString());
			CreatePaymentOrderResponse createPaymentOrderResponse = PaymentDelegate.createPaymentOrderResponse(order);
			if(createPaymentOrderResponse != null)
				return createPaymentOrderResponse.getPaymentOptions().getPaymentUrl();
		}else{
			if (order.isTransactionIdInvalid()) {
				return ("Transaction id is invalid.");
			}
			if (order.isAmountInvalid()) {
				return ("Amount can not be less than 9.00.");
			}
			if (order.isCurrencyInvalid()) {
				return ("Please provide the currency.");
			}
			if (order.isDescriptionInvalid()) {
				return ("Description can not be greater than 255 characters.");
			}
			if (order.isEmailInvalid()) {
				return ("Please provide valid Email Address.");
			}
			if (order.isNameInvalid()) {
				return ("Name can not be greater than 100 characters.");
			}
			if (order.isPhoneInvalid()) {
				return ("Phone is invalid.");
			}
			if (order.isRedirectUrlInvalid()) {
				return ("Please provide valid Redirect url.");
			}
			if (order.isWebhookInvalid()) {
                return ("Provide a valid webhook url");
            }
		}
		return ("No payment gateway connectivity");
}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
