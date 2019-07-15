package hrd;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/readpim")
public class ProductReadImportSvr extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sql = " SELECT a.i_no, B.P_name, a.i_cnt, a.i_date "
				+ " FROM i_import A "
				+ " INNER JOIN i_product B "
				+ " ON A.p_no = B.p_no ";
		
		
		
		
		//request.setAttribute("list", list);
		request.setAttribute("title", "입고 조회");
		request.setAttribute("view", "productIm.jsp");
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
}
