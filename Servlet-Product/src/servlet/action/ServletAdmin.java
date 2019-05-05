package servlet.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.domain.ProductVO;

import database.connect.AdminDAO;
import html.js.HTMLSource;

@WebServlet("/admin")
public class ServletAdmin extends HttpServlet {

	private PrintWriter out;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		out = response.getWriter();
		
		String command = request.getParameter("command");
		
		if(command != null && command.equals("addProduct")) {
			doAddHandle(request, response);
		}
		else if(command != null && command.equals("delProduct")) {
			doDelHandle(request, response);
		}
		else if(command != null && command.equals("upProduct")) {
			doUpHandle(request, response);
		}
		
		adminInfo(request, response);
		
	}
	
	private void adminInfo(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		AdminDAO admin = new AdminDAO();
		
		try {
			
			out.println("<html>");
			out.println("<body>");
			
			out.println("<table border=1><tr align='center' bgcoor='lightgreen'>");
			out.println("<td>상품명</td><td>수량</td><td>단가</td><td>규격</td><td>제조날짜</td><td>입고일</td>");
			
			List<ProductVO> pAry = admin.getProductList();
			
			for(int itr=0; itr<pAry.size(); itr++) {
				
				ProductVO pVO = (ProductVO) pAry.get(itr);
				
				String name = pVO.getpName();
				int count = pVO.getpCount();
				int money = pVO.getpMoney();
				double standard = pVO.getpStandard();
				String firstDate = pVO.getFirstDate();
				String inDate = pVO.getinDate();
				
				out.println("<tr><td>" + name + "</td><td>" + count + "</td><td>" +
								money + "</td><td>" + standard + "</td><td>" + 
								firstDate + "</td><td>" + inDate + "</td><td>" +
								"<a href='/Servlet-Product/admin?command=delProduct&name=" + name + "'><input type='button' value='삭제' /></a>" + "</td><td>" + 
								"<a href='/Servlet-Product/update?command=upProduct&name=" + name + 
								"&count=" + count + 
								"&money=" + money +
								"&standard=" + standard +
								"&firstDate=" + firstDate +
								"&inDate=" + inDate +
								"'><input type='button' value='수정' /></a>"
								+"</td></tr>");
				
			}
			
			out.println("</table>");
			
			out.println("<input type='button' value='상품등록' onClick=window.location.href='addProduct.html' />");
			
			out.println("</body>");
			out.println("</html>");
			
		} catch(Exception e) {}
			
	}


	private void doAddHandle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		AdminDAO admin = new AdminDAO();
		HTMLSource hs = new HTMLSource();

		ProductVO pVO = new ProductVO();
		
		pVO.setpName(request.getParameter("pName"));
		pVO.setpCount(Integer.parseInt(request.getParameter("pCount")));
		pVO.setpMoney(Integer.parseInt(request.getParameter("pMoney")));
		pVO.setpStandard(Double.parseDouble(request.getParameter("pStandard")));
		pVO.setFirstDate(request.getParameter("firstDate"));
		pVO.setinDate(request.getParameter("inDate"));
		
		int rs = admin.addProduct(pVO);
		
		if(rs == 1) { out.println(hs.script_Alert("등록 완료")); }
		else {
			out.println(hs.script_Alert("등록 취소") + 
							hs.script_Path("addProduct.html"));
		}
		
	}

	private void doUpHandle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		AdminDAO admin = new AdminDAO();
		HTMLSource hs = new HTMLSource();

		ProductVO pVO = new ProductVO();
		
		pVO.setpName(request.getParameter("uName"));
		pVO.setpCount(Integer.parseInt(request.getParameter("uCount")));
		pVO.setpMoney(Integer.parseInt(request.getParameter("uMoney")));
		pVO.setpStandard(Double.parseDouble(request.getParameter("uStandard")));
		pVO.setFirstDate(request.getParameter("uFirst"));
		pVO.setinDate(request.getParameter("uIn"));
		
		admin.upProduct(pVO); out.println(hs.script_Alert("수정 완료"));
		
	}
	
	private void doDelHandle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		AdminDAO admin = new AdminDAO();
		HTMLSource hs = new HTMLSource();
		
		String name = request.getParameter("name");
		admin.delProduct(name);
		
		out.println(hs.script_Alert("[" + name + "] 삭제 완료"));
		
	}
	
}
