package com.lee.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lee.bean.Quest;
import com.lee.dao.QuestDao;
import com.lee.daoimp.QuestDaoImp;

/**
 * Servlet implementation class AddQuest
 */
@WebServlet("/AddQuest")
public class AddQuest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddQuest() {
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
		String userName = request.getParameter("userName");
		String quest_title = request.getParameter("quest_title");
		String quest = request.getParameter("quest");
		String sendTime = request.getParameter("sendTime");
		System.out.println(stuNum+"---"+quest_title);
		Quest mQuest = new Quest();
		mQuest.setStuNum(stuNum);
		mQuest.setUserName(userName);
		mQuest.setQuest_title(quest_title);
		mQuest.setQuest(quest);
		mQuest.setSendTime(sendTime);
		QuestDaoImp questDao = new QuestDaoImp();
		questDao.setQuest(mQuest);
		questDao.save();
		PrintWriter out = response.getWriter();
		out.print(1);
		out.flush();
		out.close();
		doGet(request, response);
	}

}
