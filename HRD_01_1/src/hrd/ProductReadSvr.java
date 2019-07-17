package hrd;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/readpd")
public class ProductReadSvr extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("list", DAO.selProductList("p_no desc"));
		request.setAttribute("title", "물품 조회");
		request.setAttribute("view", "productRead.jsp");
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
