package com.lee.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lee.bean.Answer;
import com.lee.dao.AnswerDao;
import com.lee.daoimp.AnswerDaoImp;

/**
 * Servlet implementation class AddAnswer
 */
@WebServlet("/AddAnswer")
public class AddAnswer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAnswer() {
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
		String answer = request.getParameter("answer");
		String questid = request.getParameter("questid");
		String answerTime = request.getParameter("sendTime");
		System.out.println(answer);
		Answer mAnswer = new Answer();
		mAnswer.setStuNum(stuNum);
		mAnswer.setUserName(userName);
		mAnswer.setAnswer(answer);
		mAnswer.setQuestid(questid);
		mAnswer.setAnswerTime(answerTime);
		AnswerDaoImp answerDao = new AnswerDaoImp();
		answerDao.setAnswer(mAnswer);
		answerDao.save();
		PrintWriter out = response.getWriter();
		out.print(1);
		out.flush();
		out.close();
		
		doGet(request, response);
	}

}
