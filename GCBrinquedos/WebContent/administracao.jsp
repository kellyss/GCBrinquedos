<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Administração</title>
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
					<h3 style="color: purple;">Administração</h3>
					<hr>
					<div class="form-group">

						<a href="BrinquedoServlet?acao=cadastro"><button
								class="btn btn-primary">NOVO</button></a>
					</div>

					<table id="tabela" class="table">
						<tr>
							<th>Descrição</th>
							<th>Categoria</th>
							<th>Valor</th>
							<th>Controles</th>


						</tr>
						<c:forEach var="b" items="${ brinquedos }">
							<tr>
								<td><c:out value="${ b.descricao }" /></td>
								<td><c:out value="${ b.categoria.descricao }" /></td>
								<td><c:out value="${ b.valor }" /></td>
								<td><a
									href="BrinquedoServlet?acao=editar&codigo=${b.codigo }"><button
											class="btn btn-info">Editar</button></a>
									<button onclick="excluir()" value="${ b.codigo }" type="button"
										class="btn btn-danger" data-toggle="modal"
										data-target="#myModal">Excluir</button></td>
							</tr>
						</c:forEach>
					</table>

					<!-- Fim conteúdo página -->

				</div>
			</div>
		</div>


		<div id="myModal" class="modal fade" role="dialog">
			<div class="modal-dialog">

				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Exclusão de Brinquedo</h4>
					</div>
					<div class="modal-body">
						<p>Deseja realmente excluir o brinquedo?</p>
					</div>
					<div class="modal-footer">
						<form method="post" action="BrinquedoServlet?acao=excluir">
							<input type="hidden" name="codigo" /> <input type="submit"
								class="btn btn-danger" value="Excluir" />
							<button type="button" class="btn btn-default"
								data-dismiss="modal">Cancelar</button>
						</form>
					</div>
				</div>

				<!-- Fim conteúdo página -->

			</div>
		</div>
	</div>

	<script type="text/javascript">
		$(document).ready(function() {
			$("#li-adm").addClass('active');
		})

		function excluir() {
			$("#tabela").on("click", ".btn-danger", function(event) {
				$("[name='codigo']").val($(this).val());
			});
		}
	</script>

</body>
</html>




