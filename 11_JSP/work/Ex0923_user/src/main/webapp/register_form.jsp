<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Ajax 사용을 위한 js파일을 참조 -->
<script src="js/httpRequest.js"></script>
<script>
	// 아이디 중복여부 체크
	let b_idCheck = false;

	function send(f) {
		// 유효성 체크
		let name = f.name.value;
		if (name == "") {
			alert("이름을 입력하세요.");
			return;
		}
		let id = f.id.value;
		if (id == "") {
			alert("아이디를 입력하세요.");
			return;
		}
		let pwd = f.pwd.value;
		if (pwd == "") {
			alert("비밀번호를 입력하세요.");
			return;
		}
		let email = f.email.value;
		if (email == "") {
			alert("이메일을 입력하세요.");
			return;
		}
		let addr = f.addr.value;
		if (addr == "") {
			alert("주소를 입력하세요.");
			return;
		}

		// 아이디 중복 체크 여부 확인
		if (!b_idCheck) {
			alert("아이디 중복체크를 하세요.");
			return; // 뒤로 넘어가지 않는 상태로 만듦
		}
		f.action = 'member_register.do';
		f.method = "post"; // 비밀번호와 같이 민감한 정보가 보이지 않도록 post로 전송
		f.submit();
	}

	// 중복 체크 버튼 클릭
	function check_id() {
		let id = document.getElementById("id").value.trim();
		if (id == "") {
			alert("아이디를 입력하세요.");
			return;
		}
		let url = "check_id.do";
		let param = "id=" + id;
		sendRequest(url, param, resFn, "post");
	}
	function resFn() {
		// 콜백 메서드
		// alert("콜백 메서드");
		// xhr.readyState
		// 0 : 초기화
		// 1 ~ 3 : 로딩중
		// 4 : 로드완료
		
		// xhr.status
		// 200 : 이상없음
		// 404, 500 : 이상있음
		if(xhr.readyState == 4 && xhr.status == 200){
			
			// xhr.responseText => data  = '[{result: yes, id: whani98}]'
			 let data = xhr.responseText;
			
			let json = eval(data);
			
			if(json[0].result == "no"){
				alert(json[0].id + "은(는) 이미 사용중입니다.");
				return;
			} else{
				alert(json[0].id + "은(는) 사용가능합니다.");
				b_idCheck = true;
			}
		}
		
	}
	
	function che(){
		b_idCheck = false;
	}
</script>
</head>
<body>
	<form>
		<table border="1">

			<tr>
				<th>이름</th>
				<td><input name="name" /></td>
			</tr>
			<tr>
				<th>아이디</th>
				<td><input name="id" size="9" id="id" onInput="che()" /> <input
					type="button" value="중복체크" onClick="check_id()"></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input name="pwd" type="password" /></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input name="email" /></td>
			</tr>
			<tr>
				<th>주소</th>
				<td><input name="addr" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="button" value="확인"
					onClick="send(this.form);"> <input type="button" value="취소"
					onClick="location.href='list.do'"></td>
			</tr>
		</table>

	</form>

</body>
</html>