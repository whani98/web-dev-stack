<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
function update(f){
	let deptno = f.deptno.value;
	if(deptno == "" || deptno == 0){
		alert("부서번호를 1 이상으로 입력해주세요.");
	}
	
	let dname = f.dname.value;
	if(dname == ""){
		alert("부서명을 입력해주세요.");
	}
	
	let loc = f.loc.value;
	if(loc == ""){
		alert("위치를 입력해주세요.");
	}
	f.action = "dept_insert.do";
	f.submit();
}
</script>
</head>
<body>
<h3>부서 정보 수정</h3>
	<form>
		<table border="1">
			<tr>
				<th>부서번호</th>
				<td><input name="deptno" value="${deptno}"></td>
			</tr>
			<tr>
				<th>부서명</th>
				<td><input name="dname" value="${dname}"></td>
			</tr>
			<tr>
				<th>위치</th>
				<td><input name="loc" value="${loc}"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="button" value="수정" onClick="update(this.form)"/>
					<input type="button" value="취소" onClick="location.href='list.do'"/>
				</td>	
			</tr>
		</table>
	</form>
</body>
</html>