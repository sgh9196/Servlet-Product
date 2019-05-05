package servlet.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.domain.AdminVO;

import database.connect.AdminDAO;
 
@WebServlet("/popup")
public class ServletPopup extends HttpServlet implements AdminVO{

	private PrintWriter out;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		out = response.getWriter();
		
		String id = request.getParameter("chk-id");
		String html = "";
		
		if(id.equals(ID)) {
			html = "<h2>[" + id + "]는 사용 불가능한 아이디입니다..</h2>";
		}
		else {
			if(new AdminDAO().chkUserID(id)) { 
				html = "<h2>[" + id + "]는 사용가능한 아이디 입니다.</h2>"; 
			}
			else { html = "<h2>[" + id + "]는 이미 등록 된 아이디입니다..</h2>"; }
		}
		
		out.println(html);
	}

}
