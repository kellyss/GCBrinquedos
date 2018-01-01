<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Catálogo de Brinquedos : categorias</title>
<jsp:include page="header.jsp" />
</head>
<body>

	<div class="container">
		<div class="row">
			<jsp:include page="menu.jsp" />
			<div class="col-sm-9">

				<!-- Início conteúdo página -->

				<div class="col-md-12">
				<h2 style="color: purple;" align="center">GCBrinquedos</h2><hr/>
					<h3 style="color: purple;">Catálogo de Brinquedos : : categorias</h3>
					<hr>
					<div class="row">
						<c:forEach var="c" items="${ categoria }">

							<div class="col-md-4">
								<div class="form-group">
									<div class="thumbnail"  style="width: 250px; height: 220px;">
										<a
											href="BrinquedoServlet?acao=listaBrinquedoPorCategoria&categoria=${c.cod}">
											<img style="width: 80%" alt=""
											src="<c:url value="${ c.imagem }"/>"> <br>
											<div style="text-align: center; margin-top: 5px;">
												<label><c:out value="${ c.descricao }" /></label>
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


	<script type="text/javascript">
		$(document).ready(function() {
			$("#li-cat").addClass('active');
		})
	</script>
</body>
</html>