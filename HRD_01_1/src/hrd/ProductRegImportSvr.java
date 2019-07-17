package hrd;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//입고 처리

@WebServlet("/regpim")
public class ProductRegImportSvr extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		List<ProductVo> list = DAO.selProductList();
		
		request.setAttribute("list", list);		
		request.setAttribute("title", "입고");
		request.setAttribute("view", "productRegIm.jsp");
		
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
		
		vo.setTableNm("i_import");
		DAO.regImEx(vo);
		DAO.productUpdCnt(vo);
		
		response.sendRedirect("readpim");
		
	}

}









