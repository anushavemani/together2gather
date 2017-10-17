package com.us.g2g.util;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.instamojo.wrapper.api.Instamojo;
import com.instamojo.wrapper.api.InstamojoImpl;
import com.instamojo.wrapper.exception.ConnectionException;
import com.instamojo.wrapper.exception.InvalidPaymentOrderException;
import com.instamojo.wrapper.model.PaymentOrder;
import com.instamojo.wrapper.response.CreatePaymentOrderResponse;
import com.instamojo.wrapper.response.PaymentOrderDetailsResponse;

public class PaymentDelegate {
	

	private static final Logger LOGGER = Logger.getLogger(PaymentDelegate.class.getName());
	
	public static Instamojo getAPI(){
		Instamojo api = null;

		try {
			// gets the reference to the instamojo api
			api = InstamojoImpl.getApi(PaymentConstants.CLIENT_ID, PaymentConstants.CLIENT_SECRET, PaymentConstants.API_ENDPOINT, PaymentConstants.AUTH_ENDPOINT);
		} catch (ConnectionException e) {
			LOGGER.log(Level.SEVERE, e.toString(), e);
		}
		
		return api;
	}

	public static CreatePaymentOrderResponse createPaymentOrderResponse(PaymentOrder order) {
		try {
			CreatePaymentOrderResponse createPaymentOrderResponse = getAPI().createNewPaymentOrder(order);
			return createPaymentOrderResponse;
		} catch (InvalidPaymentOrderException e) {
			LOGGER.log(Level.SEVERE, e.toString(), e);

			if (order.isTransactionIdInvalid()) {
				System.out.println("Transaction id is invalid. This is mostly due to duplicate transaction id.");
			}
			if (order.isCurrencyInvalid()) {
				System.out.println("Currency is invalid.");
			}
		} catch (ConnectionException e) {
			LOGGER.log(Level.SEVERE, e.toString(), e);
		}
		return null;
	}

	/**
	 * Get details of payment order when order id is given.
	 * @param orderId
	 * @return
	 */
	public static PaymentOrderDetailsResponse getPaymentOrder(String orderId) {
		try {
		    Instamojo api = getAPI();

		    PaymentOrderDetailsResponse paymentOrderDetailsResponse = api.getPaymentOrderDetails(orderId);

		    return paymentOrderDetailsResponse;
		    
		} catch (ConnectionException e) {
		    LOGGER.log(Level.SEVERE, e.toString(), e);
		}
		return null;
	}

}
