<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sobre a equipe</title>
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
		<h3 style="color:purple; ">Sobre a equipe</h3>
		<hr>
		<div class="row">
			<c:forEach var="e" items="${ equipe }">
				<div class="col-md-4">
					<div class="thumbnail" style="width: 70%; height: 20%">
						<div class="form-group">
							<img src="${ e.imagem }" style="width: 100%" />
							<div style="text-align: center;">
								<div class="caption">
									<label><c:out value="${ e.nome}" /></label> <br> <label><c:out
											value="${ e.rgm}" /></label>
								</div>
							</div>
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
			$("#li-equi").addClass('active');
		})
	</script>

</body>
</html>