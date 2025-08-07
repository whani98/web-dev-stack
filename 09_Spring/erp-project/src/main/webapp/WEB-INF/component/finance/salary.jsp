<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<section>
	<div class="section-title">급여 관리</div>
	<form class="filter-bar" method="get" action="">
		<label>직원명 <input type="text" name="username" /></label> <label>기간
			<select name="year">
				<option>----</option>
				<option>2025</option>
				<option>2024</option>
		</select> 년 <select name="month">
				<option>--</option>
				<option>1</option>
				<option>2</option>
				<option>3</option>
				<!-- ... -->
		</select> 월
		</label>
		<button type="submit">검색</button>
	</form>

	<div class="table-wrapper">
		<table class="data-table">
			<thead>
				<tr>
					<th>이름</th>
					<th>부서</th>
					<th>직급</th>
					<th>기본급</th>
					<th>보너스</th>
					<th>OT 수당</th>
					<th>세금</th>
					<th>총지급액</th>
					<th>지급일</th>
				</tr>
			</thead>
			<tbody>
				
			</tbody>
		</table>
	</div>
</section>