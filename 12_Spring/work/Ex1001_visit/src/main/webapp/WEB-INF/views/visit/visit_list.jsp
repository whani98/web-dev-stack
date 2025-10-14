<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록 리스트</title>
<link rel="stylesheet" href="/visit/resources/css/visit_style.css"></link>
<script src="/visit/resources/js/httpRequest.js"></script>
<script>
	function del(f) {

		let pwd = f.pwd.value; // 원래 비번
		let c_pwd = f.c_pwd.value; // 입력받은 비번

		if(pwd != c_pwd){
			alert("비밀번호 불일치!");
			return;
		}
		
		if(!confirm("정말 삭제하시겠습니까?")){
			return;
		}
		
		let url = "visit_delete.do";
		let param = "idx=" + f.idx.value;
		sendRequest(url, param, resultFn, "post");
	}
	
	function resultFn(){
		if(xhr.readyState == 4 && xhr.status == 200){
			let data = xhr.responseText;
			
			if(data == "yes"){
				alert("삭제 성공!");
				location.href='list.do';
			} else {
				alert("삭제 실패..");
				return;
			}
		}
	}

	function update(f) {
	
		let pwd = f.pwd.value;
		let c_pwd = f.c_pwd.value;
		
		if(pwd != c_pwd){
			alert("비밀번호 불일치!");
			return;
		}
		f.method = "post";
		f.action = "visit_updateform.do";
		f.submit();
		
	}
</script>
</head>
<body>
	<div align="center">
		<h1>~방명록 리스트~</h1>
		<input type="button" value="글쓰기" onClick="location.href='visit_insertform.do'">
		<c:forEach var="vo" items="${list}">
			<table>
				<tr>
					<td id="content">
					<pre>${vo.content}</pre>
					<!-- | < : lt | > : gt | == : eq | >= : ge | <= : le | != : ne | -->
					<c:if test="${vo.filename ne 'no_file'}">
					<img src="resources/upload/${vo.filename}" width="200"/>
					</c:if>
					</td>
				</tr>
				<tr>
					<td id="name">작성자 : ${vo.name}(${vo.ip})</td>
				</tr>
				<tr>
					<td id="regdate">작성일자 : ${vo.regdate}</td>

				</tr>
				<tr>
					<td id="password">
					<form>
						<input type="hidden" name="idx" value="${vo.idx}"> 
						<input type="hidden" name="pwd" value="${vo.pwd}"> 
						비밀번호 : <input type="password" name="c_pwd" class="pwd"> 
						<input type="button" value="수정" onClick="update(this.form)"> 
						<input type="button" value="삭제" onClick="del(this.form)">
					</form>
					</td>
				</tr>
			</table>
		</c:forEach>
	</div>
</body>
</html>