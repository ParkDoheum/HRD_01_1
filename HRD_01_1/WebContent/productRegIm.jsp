<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="hrd.*" %>    
<%
	List<ProductVo> list = (List<ProductVo>)request.getAttribute("list");
%>    
<h2>물품 입고</h2>
<form method="post">
	물품 목록 : 
	<select name="p_no">
		<% for(ProductVo vo : list) { %>
			<option value="<%=vo.getP_no() %>"><%=vo.getP_name() %></option>
		<% } %>		
	</select><br>
	입고 수량 : <input type="number" name="i_cnt" value="1"><br>
	<input type="submit" value="입고">	
</form>
	<a href=""><button>조회</button></a>