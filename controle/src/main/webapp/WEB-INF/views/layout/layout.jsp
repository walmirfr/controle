<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<html>
<head>
<title><tiles:getAsString name="title" /></title>

<!-- Bootstrap Core CSS -->
<link href="<c:url value="/static/css/comum/bootstrap.min.css" />"
	rel="stylesheet">

<!-- Bootstrap Core CSS -->
<link href="<c:url value="/static/css/comum/bootstrap-theme.css" />"
	rel="stylesheet">

<!-- Custom CSS -->
<link href="<c:url value="/static/css/comum/sb-admin.css" />"
	rel="stylesheet">

<!-- Custom Fonts -->
<link
	href="<c:url value="/static/font-awesome/css/font-awesome.min.css" />"
	rel="stylesheet">

<!-- Bootstrap Datepicker-->
<link href="<c:url value="/static/css/comum/bootstrap-datepicker.css" />" rel="stylesheet">

<!-- Custom Master-->
<link href="<c:url value="/static/css/comum/master.css" />" rel="stylesheet">


<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

	<!-- jQuery -->
	<script src="<c:url value="/static/js/comum/jquery.js" />"
		type="text/javascript"></script>
</head>
<body>
	<div id="wrapper">
		<tiles:insertAttribute name="menu" />
		<tiles:insertAttribute name="main" />
		
		<div class="modal fade" id="modalAcoes" tabindex="-1" role="dialog" data-backdrop="static" aria-labelledby="exampleModalLabel" aria-hidden="true">
		  <div class="modal-dialog" role="document">
			<div class="modal-content">
			  <div class="modal-header header-danger">
				<h2 class="modal-title" id="tituloModalAcoes"><span></span>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					  <span aria-hidden="true">&times;</span>
					</button>
				</h2>
			  </div>
				<form action="#" method="post" id="formAcoes">
					<input type="hidden" name="id" id="idAcao"/>
					<input type="hidden" name="funcao" id="idFuncaoAcao"/>
					<div class="modal-body center">
						<h3>
					        <p id="textoAcao"></p>
					        <p id="textoAcao2"></p>
						</h3>
				    </div>
				  <div class="modal-footer">
					<button id="btAcao" type="submit" class="btn">Sim</button>
					<button type="button" class="btn btn-lg btn-default" data-dismiss="modal">Não</button>
				  </div>
				</form>
			</div>
		  </div>
		</div>
	</div>
	<!-- /#wrapper -->
	
	<c:if test="${funcao == 'Visualizar'}">
		<script type="text/javascript">
			$('input, select').prop('disabled', 'disabled');
			$('.visu').hide();
		</script>
	</c:if>

	<!-- Bootstrap Core JavaScript -->
	<script src="<c:url value="/static/js/comum/bootstrap.min.js" />"
		type="text/javascript"></script>
	
	<!-- Bootstrap Datepicker-->
	<script src="<c:url value="/static/js/comum/bootstrap-datepicker.js" />"
		type="text/javascript"></script>		
	<script src="<c:url value="/static/js/comum/bootstrap-datepicker.pt-BR.min.js" />"
		type="text/javascript"></script>
		
		
	<!-- Master JavaScript -->
	<script src="<c:url value="/static/js/comum/master.js" />"
		type="text/javascript"></script>
</body>
</html>