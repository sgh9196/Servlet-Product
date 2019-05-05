package servlet.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/update")
public class ServletUpdate extends HttpServlet {

	private PrintWriter out;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		out = response.getWriter();
		
		out.println("<html>"); 
		
		out.println("<head>");
		
		out.println("<script type='text/javascript'>");
		out.println("function fn_sender() {");
		out.println("document.frmUpdate.method='get';");
		out.println("document.frmUpdate.action='admin';");
		out.println("document.frmUpdate.submit();");
		out.println("}");
		out.println("</script>");
		
		out.println("</head>");
		
		out.println("<body>"); 
		
		out.println("<form name='frmUpdate' encType='utf-8'>"); 
		out.println("<table>");
		out.println("<tr>");
		out.println("<td>상품명</td><td><input type='text' name='uName' value= '" + request.getParameter("name") + "' /></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>수량</td><td><input type='number' name='uCount' value= '" + request.getParameter("count") + "' /></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>단가</td><td><input type='text' name='uMoney' value= '" + request.getParameter("money") + "' /></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>규격</td><td><input type='text' name='uStandard' value= '" + request.getParameter("standard") + "' /></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>제조일</td><td><input type='date' name='uFirst' value= '" + request.getParameter("firstDate") + "' /></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>입고일</td><td><input type='date' name='uIn' value= '" + request.getParameter("inDate") + "' /></td>");
		out.println("</tr>");
		out.println("</table>"); 
		
		out.println("<input type='button' value='수정하기' onClick='fn_sender()' />");
		out.println("<input type='reset' value='새로고침' />");
		out.println("<input type='hidden' name='command' value='upProduct' />");
		
		out.println("</form>");
		
		out.println("</body>"); out.println("</html>");
		
	}

}