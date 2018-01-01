 
 <div class="col-sm-3">
    <div class="sidebar-nav">
      <div class="navbar " role="navigation">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <span class="visible-xs navbar-brand">Sidebar menu</span>
        </div>
        <div id="menu" class="navbar-collapse collapse sidebar-navbar-collapse">
          <ul class="nav navbar-nav">
          <li ><a href="#"><img alt="logo" src="imagens/logo.jpg" style="width: 100%;"></a></li>
            <li style="background-color: Plum; text-align: center;"><a href="#"><span style="color: black;">MENU PRINCIPAL</span></a></li>
            <li id="li-home"><a href="BrinquedoServlet?acao=listarDestaque"><span style="color: black;">Home</span></a></li>
			<li id="li-cat"><a href="BrinquedoServlet?acao=listaCategorias"><span style="color: black;">Catálogo de Brinquedos</span></a></li>
			<li id="li-adm"><a href="BrinquedoServlet?acao=listarBrinquedo"><span style="color: black;">Administração</span></a></li>
            <li id="li-caCat"><a href="cadastroCategoria.jsp"><span style="color: black;">Cadastro de Categoria</span></a></li>
			<li id="li-equi"><a href=BrinquedoServlet?acao=equipe><span style="color: black;">Sobre a equipe</span></a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </div>
  </div>
  


<script type="text/javascript">
	$('#menu > div ul.nav li a').click(
			function(e) {
				var $this = $(this);
				$this.parent().siblings().removeClass('active').end().addClass('active');
				//e.preventDefault();
			});
</script>
