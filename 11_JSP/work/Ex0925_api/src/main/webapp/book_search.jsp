<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="js/httpRequest.js"></script>
<script>
	function m_send(f) {
		let url = "list.do";
		let param = "search_txt=" + f.search_txt.value;
		sendRequest(url, param, resultFn, "get");

	}

	function resultFn() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			// 콜백으로 돌아와서
			let data = xhr.responseText;
			let json = eval(data); // data -> json
			
			//alert(json[0].items[0].title);
			let resTable = document.getElementById("resTable");
			resTable.innerHTML = ""; // 검색어가 바뀔 때마다 조회정보 초기화
			
			// 가져온 도서 수 만큼 반복
			json[0].items.forEach(item => {
				let row = document.createElement("tr");
				
				row.innerHTML = "<td><img src='" + item.image + "' width='100'></td>" 
				              + "<td><span>" + item.title + "</span>"
				              + "<br>저자 : " + item.author
				              + "<br>" + item.discount + "</td>";
				 resTable.appendChild(row);
			});

		}
	}
</script>
</head>
<body>
	<form>
		<input name="search_txt" /> <input type="button" value="검색"
			onclick="m_send(this.form)">

		<table id="resTable" border="1"></table>

	</form>
</body>
</html>