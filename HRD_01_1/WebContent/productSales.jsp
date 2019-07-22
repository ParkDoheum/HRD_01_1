<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int totalSalesCnt = (int)request.getAttribute("totalSalesCnt");
	int totalSalesPrice = (int)request.getAttribute("totalSalesPrice");
	String strTotalSalesPrice = String.format("%,d", totalSalesPrice);
%>
<div>    
	총 판매갯수 : <%=totalSalesCnt %>개
</div>

<div>
	총 판매 매출액 : <%=strTotalSalesPrice %>원
</div> 


