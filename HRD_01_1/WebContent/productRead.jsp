<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import= "hrd.*" %>
<%
	List<ProductVo> list = (List<ProductVo>)request.getAttribute("list");
%>
<style>
	tr.pointer {
		cursor:pointer;
	}	
	tr:hover {
		background-color:#bdc3c7;
	}
</style>

<script>
	function moveToDetail(p_no) {		
		location.href='detailpd?p_no=' + p_no;
	}
</script>
<table>
	<tr>
		<th>물품번호</th>
		<th>물품이름</th>
		<th>수량</th>
		<th>등록일자</th>
	</tr>
	<% for(ProductVo vo : list) { %>	
		<tr class="pointer" onclick="moveToDetail(<%=vo.getP_no()%>);">
			<td><%=vo.getP_no() %></td>
			<td><%=vo.getP_name() %></td>
			<td><%=vo.getP_cnt() %></td>
			<td><%=vo.getI_date() %></td>
		</tr>	
	<% } %>
</table>







