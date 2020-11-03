package account.controller;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;

import account.entity.AccountDao;

@SuppressWarnings("serial")
public class loginController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/account/login.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String id = req.getParameter("id");
		String password = req.getParameter("password");
		
		AccountDao mDao = new AccountDao();
		int loginResult = mDao.login(id, password);
		
		if (loginResult == 1) {
			req.setAttribute("loginResult", loginResult);
			HttpSession session = req.getSession();
			session.setAttribute("sessionID", id);
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/account/introPageDesign.jsp");
			rd.forward(req, resp);
			System.out.print(id);
			System.out.print(password);
		} else {
			req.setAttribute("loginResult", loginResult);
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/account/login.jsp");
			rd.forward(req, resp);

		}
		
	}
	
}