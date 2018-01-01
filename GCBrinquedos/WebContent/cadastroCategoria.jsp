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
				<h2 style="color: purple;" align="center">GCBrinquedos</h2><hr/>
				<h3 style="color: purple;">Nova categoria</h3>
				<hr />
				<form action="CategoriaServlet" method="POST" class="form-group">
					<input type="hidden" name="acao" value="salvar"> <input
						type="hidden" name="cd_categoria" value="${ categoria.codigo }" />

					<div class="form-group row">
						<div class="col-xs-4">
							<label>CÓDIGO</label> <input type="text"
								value="${ categoria.codigo }" disabled="disabled"
								class="form-control" />
						</div>
					</div>

					<div class="form-group row">
						<div class="col-xs-4">
							<label>DESCRIÇÃO</label> <input type="text" name="descricao"
								value="${categoria.descricao }" class="form-control" />
						</div>
					</div>

					<div class="form-group row">
						<div class="col-xs-4">
							<label>IMAGEM</label> <input id="id-imagem" type="file"
								name="img" onchange="previewFile()" /> <img
								src="${categoria.imagem }" height="200" alt="">
						</div>
					</div>


					<div class="form-group">
						<input type="submit" value="Salvar Dados" class="btn btn-primary" />
						<input type="reset" value="Limpar" class="btn btn-primary" />
					</div>

				</form>
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







