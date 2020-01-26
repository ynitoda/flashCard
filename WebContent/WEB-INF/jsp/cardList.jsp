<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>単語表</title>
</head>
<body>
<h1>単語表</h1>
<form action="ShowCardServlet" method="post">
<table border="1">
	<tr>
		<th>No</th>
		<th>削除チェック</th>
		<th>チェック</th>
		<th>単語</th>
		<th>意味</th>
		<th>ユニット</th>
		<th>日</th>
	</tr>
		<c:forEach var="i" begin="0" end="${cardList.size() - 1}" step="1">
			<tr>
				<td>${i + 1}</td>
				<td><input type="checkbox" name="deleteCardIds" value="${cardList[i].id }"> </td>
				<td><c:choose>
					<c:when test="${cardList[i].checkflag}">
						〇
					</c:when>
					<c:otherwise>
						×
					</c:otherwise>
					</c:choose>
				</td>
				<td>${cardList[i].word}</td>
				<td>${cardList[i].meaning}</td>
				<td>${cardList[i].unit}</td>
				<td>${cardList[i].day}</td>
			</tr>
		</c:forEach>
</table>
<p>カードの登録</p>
	<p>単語 <input type="text" name="word"></p>
	<p>意味 <input type="text" name="meaning"></p>
	<p>ユニット<input type="text" name="unit"></p>
	<p>日 <input type="text" name="day"></p>
	<p>
	<input type="submit" name="action" value="登録">
	<input type="submit" name="action" value="削除">
	</p>
	<a href="ShowCardServlet">更新</a>
</form>
</body>
</html>