<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro</title>
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
					<h3 style="color: purple;">Novo Brinquedo</h3>
					<hr />
					<form action="BrinquedoServlet" method="POST" class="form-group">
						<input type="hidden" name="acao" value="salvar"> <input
							type="hidden" id="cd_brinquedo" name="cd_brinquedo"
							value="${ brinquedo.codigo }" />

						<div class="form-group row">
							<div class="col-xs-4">
								<label>CÓDIGO</label> <input type="text"
									value="${ brinquedo.codigo }" disabled="disabled"
									class="form-control" />
							</div>
						</div>

						<div class="form-group row">
							<div class="col-xs-4">
								<label>DESCRIÇÃO</label> <input type="text" name="descricao"
									value="${brinquedo.descricao }" class="form-control"
									required="required" />
							</div>
						</div>

						<div class="form-group row">
							<div class="col-xs-4">
								<label>CATEGORIA</label> <select name="categoria"
									class="form-control">
									<option id="option-0" value="0">Selecione</option>
									<c:forEach items="${categoria}" var="c">
										<c:if test="${c.cod == brinquedo.categoria.cod }">
											<option selected="selected" value="${c.cod }">${c.descricao}</option>
										</c:if>
										<c:if
											test="${c.cod != brinquedo.categoria.cod && c.cod != 0 }">
											<option value="${c.cod }">${c.descricao}</option>
										</c:if>
									</c:forEach>
								</select>
							</div>
						</div>

						<div class="form-group row">
							<div class="col-xs-4">
								<label>MARCA</label> <input type="text" name="marca"
									value="${brinquedo.marca }" class="form-control" />
							</div>
						</div>

						<div class="form-group row">
							<div class="col-xs-4">
								<label>IMAGEM</label> <input id="id-img" type="file" name="img" />
								<!-- onchange="previewFile()" -->

								<img id="id-imagem" name="imagem" src="${brinquedo.imagem }"
									height="200" alt="${brinquedo.imagem }">
							</div>
						</div>

						<div class="form-group row">
							<div class="col-xs-4">
								<label>VALOR</label> <input type="text" name="valor"
									value="${brinquedo.valor }" class="form-control" />
							</div>
						</div>


						<div class="form-group row">
							<div class="col-xs-6 ">
								<label for="id-detalhes">DETALHES</label>
								<textarea id="id-detalhes" name="detalhes" rows="10" cols="10"
									class="form-control">${brinquedo.detalhes }</textarea>
							</div>
						</div>
						<div class="form-group">
							<input type="submit" value="Salvar Dados" class="btn btn-primary" />
							<input type="reset" value="Limpar" class="btn btn-primary" />
						</div>
					</form>
				</div>

				<!-- Fim conteúdo página -->

			</div>
		</div>
	</div>



	<script type="text/javascript">
		$(document).ready(function() {
			//if($("#cd_brinquedo").val() != ""){
			$('#option-0').attr('disabled', 'disabled');
			//}
		})

		function readURL(input) {

			if (input.files && input.files[0]) {
				var reader = new FileReader();

				reader.onload = function(e) {
					$('#id-imagem').attr('src', e.target.result);
				}

				reader.readAsDataURL(input.files[0]);
			}
		}

		$("#id-img").change(function() {
			readURL(this);
		});
	</script>



</body>
</html>