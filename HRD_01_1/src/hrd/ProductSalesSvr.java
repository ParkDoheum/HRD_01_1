package hrd;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/psales")
public class ProductSalesSvr extends HttpServlet {
	private static final long serialVersionUID = 1L;
           
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		request.setAttribute("totalSalesCnt", DAO.totalSalesCnt()); //총 판매 갯수
		request.setAttribute("totalSalesPrice", DAO.totalSalesPrice());
		
		request.setAttribute("title", "매출액");
		request.setAttribute("view", "productSales.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	
}
