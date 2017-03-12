<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Controle de manutenções</title>

    <!-- Bootstrap Core CSS -->
	<link href="<c:url value="/static/css/comum/bootstrap.min.css" />" rel="stylesheet">

    <!-- Custom CSS -->
	<link href="<c:url value="/static/css/comum/sb-admin.css" />" rel="stylesheet">
	
    <!-- Custom Fonts -->
	<link href="<c:url value="/static/font-awesome/css/font-awesome.min.css" />" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>

    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.html">Mecânica Dois Irmãos</a>
            </div>
            <!-- Top Menu Items -->
            <ul class="nav navbar-right top-nav">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> Walmir Ferreira <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li>
                            <a href="#"><i class="fa fa-fw fa-user"></i> Perfil</a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-fw fa-power-off"></i> Sair</a>
                        </li>
                    </ul>
                </li>
            </ul>
            <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav side-nav">
                    <li>
                        <a href="index.html"><i class="fa fa-fw fa-home"></i> Principal</a>
                    </li>
                    <li  data-toggle="collapse" data-target="#products" class="collapsed">
                        <a href="cliente-consultar.html"><i class="fa fa-fw fa-user"></i> Cliente <span class="icon-tipo-down"></span></a>
                    </li>
					<li>
                        <a href="empresa-consultar.html"><i class="fa fa-fw fa-users" aria-hidden="true"></i> Empresa</a>
                    </li>
					<li>
                        <a href="veiculo-consultar.html"><i class="fa fa-fw fa-car"></i> Veículos</a>
                    </li>
                    <li>
                        <a href="manutencao-consultar.html"><i class="fa fa-fw fa-wrench"></i> Manutenção</a>
                    </li>
                    <li class="active">
                        <a href="servico-consultar.html"><i class="fa fa-fw fa-gears"></i> Serviço</a>
                    </li>
                    <li>
                        <a href="profissional-consultar.html"><i class="fa fa-fw fa-desktop"></i> Profissional</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </nav>

        <div id="page-wrapper">
			<form action="inserirServico" method="post">
            <div class="container-fluid">

                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
						<h1 class="page-header">
							Serviço
						</h1>
                    </div>
                </div>
                <!-- /.row -->

                <div class="row">
                    <div class="col-lg-12">
						<h2 style="margin-top: 0">Cadastro de Serviço</h2>
					</div>
					<div class="col-lg-12">
						<div class="form-group row">
							<label for="example-text-input" class="col-xs-1 col-form-label">Nome</label>
							<div class="col-xs-7">
								<input class="form-control" type="text" name="nome" placeholder="Nome"/>
							</div>
						</div>
						<div class="form-group row">
							<label for="example-text-input" class="col-xs-1 col-form-label">Descrição</label>
							<div class="col-xs-7">
								<textarea class="form-control" name="descricao"  placeholder="Descrição"></textarea>
							</div>
						</div>
						<div class="form-group row">
							<label for="example-text-input" class="col-xs-1 col-form-label">Grupo Serviço</label>
							<div class="col-xs-3">
								<select class="form-control" name="grupoServico.idGrupoServico" placeholder="Grupo Serviço">
									<option value="#">Selecione um Grupo</option>
									<option value="1">Suspenção</option>
								</select>
							</div>
							<div class="col-xs-2">
								<input class="btn btn-primary" name="cadastrar" type="button" value="Adicionar Grupo"/>
							</div>
						</div>
						<div class="form-group row">
							<label for="example-text-input" class="col-xs-1 col-form-label">Tempo Estimado</label>
							<div class="col-xs-3">
								<input class="form-control" type="number" name="tempoEstivamo" placeholder="Tempo estimado em horas"/>
							</div>
						</div>
						<div class="form-group text-right">
							<a href="servico-consultar.html" class="btn btn-default" name="cancelar" type="button">Cancelar</a>
							<input class="btn btn-default" name="limpar" type="button" value="Limpar"/>
							<input class="btn btn-primary" name="cadastrar" type="submit" value="Cadastrar"/>
						</div>
                    </div>
                </div>
                <!-- /.row -->
            </div>
            <!-- /.container-fluid -->
			</form>
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
	<script src="<c:url value="/static/js/comum/jquery.js" />" type="text/javascript"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="<c:url value="/static/js/comum/bootstrap.min.js" />" type="text/javascript"></script>

</body>
</html>