package com.lee.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lee.bean.Answer;
import com.lee.bean.Quest;
import com.lee.daoimp.AnswerDaoImp;
import com.lee.daoimp.QuestDaoImp;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class GetAList
 */
@WebServlet("/GetAList")
public class GetAList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAList() {
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
		PrintWriter out = response.getWriter();
		String questid = request.getParameter("questid");
		JSONArray js	=	new JSONArray();
		
		AnswerDaoImp answerDaoImp	=	new AnswerDaoImp();
		List<Answer> ls	=	answerDaoImp.selectbyid(questid);
		for (int i = 0; i < ls.size(); i++) {
//			System.out.println("Ñ­»·ÄÚ"+ls.get(i).toString());
			js.add(ls.get(i).toString());
		}
//		System.out.println(js.toString());
		
		
		out.print(js);
		out.flush();
		out.close();
		
		doGet(request, response);
	}

}
