<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Catalogo de Brinquedos</title>
<jsp:include page="header.jsp" />
</head>
<body>
	<div class="container">
		<div class="row">
			<jsp:include page="menu.jsp" />
			<div class="col-sm-9">

				<!-- Início conteúdo página -->
	
	<div class="col-sm-12">
	<h2 style="color: purple;" align="center">GCBrinquedos</h2><hr/>
	<h3 style="color: purple;">Catálogo de Brinquedos :: ${categoria.descricao}</h3>
	<hr>
	<div class="row">
		<c:forEach var="b" items="${ brinquedos }">
			<div class="col-md-3">
			
			<div class="form-group">
				<div class="thumbnail"  style="width: 250px;height: 200px;">
				
					<a href="BrinquedoServlet?acao=buscar&codigo=${b.codigo }"> 
					<img style="width: 50%"  alt="" src="<c:url value="${ b.imagem }" />"><br>
					<div style="text-align: center;">
					<label><c:out value="${ b.descricao }" /></label><br>  
					<label><c:out value="${b.valor }"></c:out></label>
					</div>
					</a>
					</div>
				</div>
				
			</div>
		</c:forEach>
			</div>
	</div>
	<!-- Fim conteúdo página -->

			</div>
		</div>
	</div>
</body>
</html>