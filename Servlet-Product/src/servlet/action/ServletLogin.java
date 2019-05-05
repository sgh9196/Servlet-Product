package servlet.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.domain.AdminVO;
import org.domain.ProductVO;

import database.connect.AdminDAO;
import html.js.HTMLSource;
 
@WebServlet("/login")
public class ServletLogin extends HttpServlet implements AdminVO {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		doHandle(request, response);
		
	}

	private void doHandle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		
		AdminDAO admin = new AdminDAO();
		HTMLSource hs = new HTMLSource();
		
		String id = request.getParameter("login_id");
		String pw = request.getParameter("login_pw");
		
		String name = admin.chkUserLogin(id, pw); 
		String html = "";
		
		if(id.equals(ID) && pw.equals(PW)) {
			out.print(hs.script_Alert("** [관리자] 로그인 **"));
			//adminInfo(out, admin);
			RequestDispatcher dispatch = request.getRequestDispatcher("admin");
			dispatch.forward(request, response);
			
		}
		else if(name != null) {
			html = hs.script_Alert("** [" + name + "]님 로그인 **");
		}
		else {
			html = hs.script_Alert("등록되지 않은 아이디입니다.");
			html += hs.script_Path("login.html");
		}
		
		out.print(html);
		
	}

	
}

