package com.bank.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bank.repository.AccountRepository;
import com.bank.repository.JdbcAccountRepository;
import com.bank.service.TxrService;
import com.bank.service.TxrServiceImpl;

@WebServlet(urlPatterns = { "/txr" })
public class TxrController extends HttpServlet {

	private TxrService txrService = null;

	@Override
	public void init(ServletConfig config) throws ServletException {
		AccountRepository accountRepository = new JdbcAccountRepository();
		txrService = new TxrServiceImpl(accountRepository);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String reqURI = req.getRequestURI(); // /MVC-app/txr
		String path = reqURI.substring(reqURI.lastIndexOf('/'));

		if (path.equals("/txr")) {

			String amount = req.getParameter("amount");
			String fromAcc = req.getParameter("fromAcc");
			String toAcc = req.getParameter("toAcc");

			
			
			boolean b = txrService.doTxr(Double.parseDouble(amount), fromAcc, toAcc);

			PrintWriter out = resp.getWriter();
			out.println(b);
			out.close();

		}

	}

	@Override
	public void destroy() {

	}
}
