package account.controller;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

import account.entity.Account;
import account.entity.AccountDao;

@SuppressWarnings("serial")
public class id_foundController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("./account/id_found.jsp");
		rd.forward(req, resp);
	}

	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String Name = req.getParameter("name");
		String Phone = req.getParameter("phone");
		String Email=req.getParameter("email");
		
		AccountDao mDao = new AccountDao();
		
		Account mDto = new Account();
		mDto.setName(Name);
		mDto.setPhone(Phone);
		mDto.setEmail(Email);
		
		if(Email != null) {
			System.out.println("id_search2함수 사용");
			//id_search2함수
			int id_foundResult2 = mDao.id_search2(mDto,Name,Email);
					
			if (id_foundResult2 ==1 ) {
				req.setAttribute("id_foundResult2", id_foundResult2);
				HttpSession session = req.getSession();
				session.setAttribute("sessionID", Name);
				RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/account/introPageDesign.jsp");
				rd.forward(req, resp);
			
						

			} else {
				req.setAttribute("id_foundResult2", id_foundResult2);
				RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/account/id_found.jsp");
				rd.forward(req, resp);
				System.out.println("id_foundResult2 is null ㅠㅠ");
		
					}
		
		}else {
			System.out.println("id_search1함수 사용");
			//id_search1함수
			int id_foundResult1 = mDao.id_search1(mDto,Name,Phone);
			
			if (id_foundResult1 ==1 ) {
				req.setAttribute("id_foundResult", id_foundResult1);
				HttpSession session = req.getSession();
				session.setAttribute("sessionID", Name);
				RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/account/introPageDesign.jsp");
				rd.forward(req, resp);
		
				

			} else {
				req.setAttribute("id_foundResult1", id_foundResult1);
				RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/account/id_found.jsp");
				rd.forward(req, resp);
				System.out.println("id_foundResult1 is null ㅠㅠ");

			}
		}}}

		


	

