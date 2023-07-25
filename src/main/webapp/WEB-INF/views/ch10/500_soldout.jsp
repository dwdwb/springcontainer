<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="/WEB-INF/views/common/header.jsp" %>

<div class="card m-2">
	<div class="card-header">
		예외 처리(Ch10SoldoutException)
	</div>
	<div class="card-body">
		사유: [${message}] 의 이유로 주문할 수 없습니다.
		<a href="content" class="btn btn-outline-danger btn-sm">돌아가기</a>
	</div>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>