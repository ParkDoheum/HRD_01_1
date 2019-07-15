<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
	function check() {		
		if(frm.p_name.value === '') {
			alert('물품이름을 입력하세요.');
			return false;
		}
		
		return true;
	} 
</script>    

<form id="frm" action="preg" method="post" onsubmit="return check();">
	물품이름 : <input type="text" name="p_name">
	<input type="submit" value="등록">
</form>