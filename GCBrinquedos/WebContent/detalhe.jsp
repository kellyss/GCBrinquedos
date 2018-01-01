<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DETALHES</title>
<jsp:include page="header.jsp" />
</head>
<body>
	<div class="container">
		<div class="row">
			<jsp:include page="menu.jsp" />
			<div class="col-sm-9">

				<!-- Início conteúdo página -->


				<div class="row">
					<div class="col-sm-12">
						<h2 style="color: purple;" align="center">GCBrinquedos</h2>
						<hr />
						<h3 style="color: purple;">Detalhes</h3>
						<hr>

						<div class="col-sm-5 inner_div">
							<table>
								<tr>
									<td></td>
									<td></td>
								</tr>
								<tr>
									<td><img src="${brinquedo.imagem}" style="width: 100%" /></td>
									<td><br /> <br />
										<h4>CÓDIGO ${brinquedo.codigo}</h4>
										<h3>${brinquedo.descricao}</h3>
										<h4>R$ ${brinquedo.valor}</h4></td>
								</tr>
							</table>

							<textarea  disabled="disabled" rows="7" cols="90">${brinquedo.detalhes}</textarea>

						</div>
					</div>
				</div>
				<!-- Fim conteúdo página -->

			</div>
		</div>
	</div>
</body>
</html>