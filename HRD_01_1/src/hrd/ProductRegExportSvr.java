package hrd;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//출고 처리

@WebServlet("/regpex")
public class ProductRegExportSvr extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		request.setAttribute("list", DAO.selProductList());
		request.setAttribute("title", "출고");
		request.setAttribute("view", "productRegEx.jsp");		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String p_no = request.getParameter("p_no");
		String i_cnt = request.getParameter("i_cnt");
		
		System.out.println("p_no : " + p_no);
		System.out.println("i_cnt : " + i_cnt);
		
		ProductVo vo = new ProductVo();
		vo.setP_no(Integer.parseInt(p_no));
		vo.setI_cnt(Integer.parseInt(i_cnt));
		
		DAO.regIm(vo);
		DAO.productUpdCnt(vo);
		
		response.sendRedirect("readpim");
		
	}

}









