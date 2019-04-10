package com.gap;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.twilio.twiml.messaging.Message;
import com.twilio.Twilio;
import com.twilio.type.PhoneNumber;
import com.twilio.twiml.messaging.Body;
import com.twilio.twiml.MessagingResponse;
import com.twilio.twiml.TwiMLException;

import com.gap.DatabasePostGreSql;


/**
 * Servlet implementation class SimpleServlet
 */

@WebServlet("/welcome")
public class SimpleServlet extends HttpServlet {
	public static final String ACCOUNT_SID = "ACe78c053da34e18b6ffc9fc427ded4973";
	public static final String AUTH_TOKEN = "c1b0964a43cf411171d5399ccf46b339";
	
	private DatabasePostGreSql db= new DatabasePostGreSql();
	
	private String mymsg;
	public void init() throws ServletException{
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
		mymsg = "Hello World";
		
		
	}
       
	 public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
		 String body = request.getParameter("Body");
		 String ph = request.getParameter("phone");
		    String message = "Message";
		    String keyword = db.getRegisteredKeyword();
		    if (body.equals(keyword)) {
		      message = db.getRegisteredValidResponse();
		    } else {
		    	message = db.getRegisteredInvalidResponse();
		    }

		    // Create a TwiML response and add our friendly message.
		    Body messageBody = new Body.Builder(message).build();
		    Message sms = new Message.Builder().body(messageBody).build();
		    MessagingResponse twiml = new MessagingResponse.Builder().message(sms).build();

		    response.setContentType("application/xml");

		    try {
		      response.getWriter().print(twiml.toXml());
		    } catch (TwiMLException e) {
		      e.printStackTrace();
		    }
		  }
	 
	 

	   public void destroy() {
	     
	   }
}


