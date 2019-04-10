package com.gap;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.twilio.Twilio;
import com.twilio.twiml.MessagingResponse;
import com.twilio.twiml.TwiMLException;
import com.twilio.twiml.messaging.Body;
//import com.twilio.twiml.messaging.Message;
import com.twilio.type.PhoneNumber;
import com.twilio.rest.api.v2010.account.Message;
import com.gap.DatabasePostGreSql;

/**
 * Servlet implementation class SendMessages
 */
public class SendMessages extends HttpServlet {
	public static final String ACCOUNT_SID = "ACe78c053da34e18b6ffc9fc427ded4973";
	public static final String AUTH_TOKEN = "c1b0964a43cf411171d5399ccf46b339";
	String mymsg;
	DatabasePostGreSql db;
	
	
	
	public void init() throws ServletException{
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
		mymsg = "Hello World";
		
		
	}
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
		String phone = request.getParameter("phone");
		if(phone!="") {
			mymsg = request.getParameter("txtmessage_bulk");
			Message msg = Message.creator(new PhoneNumber(request.getParameter("phone")), 
					new PhoneNumber("+12133196605"), mymsg).create();
			System.out.println(msg.getSid());
		}else {
			mymsg = request.getParameter("txtmessage");
			List<String> list = db.getAllPhoneNumbers();
			for(String s:list) {
				Message msg = Message.creator(new PhoneNumber(request.getParameter("phone")), 
						new PhoneNumber("+12133196605"), mymsg).create();
				System.out.println(msg.getSid());
			}
			
		}
		
		
		
		  }
    

}
