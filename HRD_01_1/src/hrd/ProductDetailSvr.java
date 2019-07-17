package hrd;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/detailpd")
public class ProductDetailSvr extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String p_no = request.getParameter("p_no");
		System.out.println("p_no : " + p_no);
		request.setAttribute("vo", null);
		request.setAttribute("title", "");
		request.setAttribute("view", "productDetail.jsp");
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
