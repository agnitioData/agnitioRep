package com.agni.hrms.servletControllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.util.BirthdayMailSend;

/**
 * Servlet implementation class EmailSendServlet
 */
@WebServlet("/EmailSendServlet")
public class EmailSendServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private String host;
    private String port;
    private String user;
    private String pass;    
   
    public EmailSendServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String recipient = request.getParameter("recipient");
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        
        System.out.println("recipient -->" + recipient + "userName -->" + userName + "password -->" + password);
        
 
        String resultMessage = "";
 
        try {
        	//BirthdayMailSend.sendEmail(host, port, user, pass, recipient, subject, content);
            resultMessage = "The e-mail was sent successfully";
        } catch (Exception ex) {
            ex.printStackTrace();
            resultMessage = "There were an error: " + ex.getMessage();
        } finally {
            request.setAttribute("Message", resultMessage);
            getServletContext().getRequestDispatcher("/Result.jsp").forward(
                    request, response);
        }
	}

}