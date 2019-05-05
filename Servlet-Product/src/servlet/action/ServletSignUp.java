package servlet.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.domain.AdminVO;
import org.domain.MemberVO;

import database.connect.AdminDAO;
import html.js.HTMLSource;
 
@WebServlet("/signup")
public class ServletSignUp extends HttpServlet implements AdminVO {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		doHandle(request, response);
		
	}

	private void doHandle(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		AdminDAO admin = new AdminDAO();
		HTMLSource hs = new HTMLSource();
		
		PrintWriter out = response.getWriter();
		String html = "";
		
		String id = request.getParameter("su_id");
		
		if(id.equals(ID)) {
			html = hs.script_Alert("사용할 수 없는 아이디입니다.") + hs.script_Path("signup.html");
		}
		else {
			
			MemberVO vo = new MemberVO();
			vo.setId(id);
			vo.setPw(request.getParameter("su_pw"));
			vo.setName(request.getParameter("su_name"));
			vo.setPhone(request.getParameter("su_tel"));
			
			if(admin.chkUserID(vo.getId())) {
				
				int rlst = admin.addUser(vo); 
				
				html = (rlst == 1) ? hs.script_Alert("회원가입 완료") + 
											hs.script_Path("login.html") : "";
				
			}
			else {
				html = hs.script_Alert("아이디 중복 확인") + hs.script_Path("signup.html");
			}
		}
		
		out.print(html);
		
	}
	
}
