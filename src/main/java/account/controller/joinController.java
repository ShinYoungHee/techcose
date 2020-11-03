package account.controller;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;

import account.entity.AccountDao;
import account.entity.Account;

public class joinController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/account/select.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		
		AccountDao mDao = new AccountDao();
		Account mDto = new Account();
		mDto.setId(id);
		mDto.setPassword(pw);
		mDto.setName(name);
		mDto.setEmail(email);
		int joinResult = mDao.join(mDto);
		
		if (joinResult == 1) {
			req.setAttribute("joinResult", joinResult);
			HttpSession session = req.getSession();
			session.setAttribute("sessionID", id);
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/account/introPageDesign.jsp");
			rd.forward(req, resp);
		} else {
			req.setAttribute("joinResult", 0);
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/account/select.jsp");
			rd.forward(req, resp);
		}
	}
	
}