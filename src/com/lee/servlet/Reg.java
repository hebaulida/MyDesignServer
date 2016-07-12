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
 * Servlet implementation class Reg
 */
@WebServlet("/Reg")
public class Reg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Reg() {
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
		String userName = request.getParameter("userName");
		String class_ = request.getParameter("class_");
		String role = request.getParameter("role");
		String sex = request.getParameter("sex");
		System.out.println(stuNum+"---"+pass);
		User user = new User();
		user.setStuNum(stuNum);
		user.setPass(pass);
		user.setUserName(userName);
		user.setClass_(class_);
		user.setRole(role);
		user.setSex(sex);
		
		UserDaoImp userDao = new UserDaoImp();
		userDao.setUser(user);
		userDao.selectByStuNum();
		User newuser = userDao.getUser();
		if (newuser==null) {
			System.out.println("注册用户");
			//新用户，返回0
			userDao.setUser(user);
			userDao.save();
			
			PrintWriter out = response.getWriter();
			out.print(0);
			out.flush();
			out.close();
		}else{
			//注册过，返回1
			System.out.println("注册失败");
			PrintWriter out = response.getWriter();
			out.print(1);
			out.flush();
			out.close();
		}
		
		
		doGet(request, response);
	}

}
