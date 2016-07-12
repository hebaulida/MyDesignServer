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

/**
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update() {
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
		String stuNum = request.getParameter("stuNum");
		String flag = request.getParameter("flag");
		System.out.println(flag);
		User user = new User();
		user.setStuNum(stuNum);
		UserDaoImp userDao = new UserDaoImp();
		userDao.setUser(user);
		userDao.selectByStuNum();
		User newuser = new User();
		newuser = userDao.getUser();
		if (flag.equals("upSex")) {
			String sex = request.getParameter("sex");
			newuser.setSex(sex);
			userDao.setUser(newuser);
			userDao.update();
			System.out.println(sex);
		}else if (flag.equals("upUserName")) {
			String userName = request.getParameter("userName");
			newuser.setUserName(userName);
			userDao.setUser(newuser);
			userDao.update();
			System.out.println(userName);
		}else if (flag.equals("upClass")) {
			String class_ = request.getParameter("class_");
			newuser.setClass_(class_);
			userDao.setUser(newuser);
			userDao.update();
			System.out.println(class_);
		}else if (flag.equals("upRole")) {
			String role = request.getParameter("role");
			newuser.setRole(role);
			userDao.setUser(newuser);
			userDao.update();
			System.out.println(role);
		}else if (flag.equals("upPass")) {
			String pass = request.getParameter("pass");
			String newpass = request.getParameter("newpass");
			System.out.println(pass+"+"+newpass);
			newuser.setStuNum(stuNum);
			newuser.setPass(pass);
			userDao.setUser(newuser);
			userDao.selectLogin();
			User check = userDao.getUser();
			if(check==null){
				//ÃÜÂë´íÎó£¬ÐÞ¸ÄÊ§°Ü
				PrintWriter out = response.getWriter();
				out.print(0);
				out.flush();
				out.close();
			}else {
				check.setPass(newpass);
				userDao.setUser(check);
				userDao.update();
				PrintWriter out = response.getWriter();
				out.print(1);
				out.flush();
				out.close();
			}
			
		}
		doGet(request, response);
	}

}
