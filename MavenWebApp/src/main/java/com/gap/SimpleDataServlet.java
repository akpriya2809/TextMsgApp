package com.gap;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gap.DatabasePostGreSql;


/**
 * Servlet implementation class SimpleDataServlet
 */

public class SimpleDataServlet extends HttpServlet {
	private String mymsg;
	private DatabasePostGreSql db = new DatabasePostGreSql() ;
       
	public void init() throws ServletException{
		mymsg = "Hello World";
		
	}
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String keyword = request.getParameter("key");
		String optInMsg = request.getParameter("valid");
		String invalidMsg = request.getParameter("invalid");
		db.insertkeywordsettings(keyword,optInMsg,invalidMsg);
	}

}
