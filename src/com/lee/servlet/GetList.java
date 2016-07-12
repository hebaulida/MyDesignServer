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
 * Servlet implementation class GetList
 */
@WebServlet("/GetList")
public class GetList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetList() {
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
		String stuNum = request.getParameter("stuNum");
		String type = request.getParameter("type");
		AnswerDaoImp answerDaoImp = new AnswerDaoImp();
		QuestDaoImp questDaoImp = new QuestDaoImp();
		
		if (type.equals("1")) {
			JSONArray js = new JSONArray();
			List<Quest> ls	=	questDaoImp.selectbyid(stuNum);
			for (int i = 0; i < ls.size(); i++) {
//				System.out.println("循环内"+ls.get(i).toString());
				js.add(ls.get(i).toString());
			}
			System.out.println("type1"+js.toString());
			out.print(js);
			out.flush();
			out.close();
			
		}else if (type.equals("2")) {
			System.out.println("type2");
			JSONArray js = new JSONArray();
			List<Answer> ansls = answerDaoImp.selectbyStuNum(stuNum);
			for (int i = 0; i < ansls.size(); i++) {
				String questid = ansls.get(i).getQuestid();
				System.out.println("外层循环"+ansls.get(i).getQuestid());
				List<Quest> ls	=	questDaoImp.selectbyQuestId(questid);
				for (int j = 0; j < ls.size(); j++) {
					System.out.println("内层循环"+ls.get(j).toString());
					js.add(ls.get(j).toString());
				}
			}
			out.print(js);
			out.flush();
			out.close();
		}
		
		
		doGet(request, response);
	}

}
