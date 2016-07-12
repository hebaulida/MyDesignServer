package com.lee.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lee.bean.User;
import com.lee.daoimp.UserDaoImp;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		String stuNum = request.getParameter("stuNum");
		String pass = request.getParameter("pass");
		System.out.println(stuNum+"---"+pass);
		User user = new User();
		user.setStuNum(stuNum);
		user.setPass(pass);
		UserDaoImp userDao = new UserDaoImp();
		userDao.setUser(user);
		userDao.selectLogin();
		User newuser = userDao.getUser();
		if (newuser==null) {
			System.out.println("’À∫≈√‹¬Î¥ÌŒÛ");
			//–¬”√ªß£¨∑µªÿ0
			PrintWriter out = response.getWriter();
			JSONObject json=new JSONObject();  
	        json.accumulate("flag", "0");  
	        json.accumulate("user","");
	        out.print(json.toString());  
//			out.print(0);
			out.flush();
			out.close();
		}else{
			//◊¢≤·π˝£¨∑µªÿ1
			JSONObject json=new JSONObject();  
	        json.accumulate("flag", "1");  
	        json.accumulate("user", newuser);  
			System.out.println("’À∫≈√‹¬Î’˝»∑");
			PrintWriter out = response.getWriter();
			out.print(json.toString());  
//			out.print(newuser);
			out.flush();
			out.close();
		}
		doGet(request, response);
	}

}
