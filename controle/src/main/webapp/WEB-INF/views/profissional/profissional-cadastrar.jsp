<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Controle de manutenÃ§Ãµes</title>

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
                <a class="navbar-brand" href="index.html">MecÃ¢nica Dois IrmÃ£os</a>
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
                        <a href="veiculo-consultar.html"><i class="fa fa-fw fa-car"></i> VeÃ­culos</a>
                    </li>
                    <li>
                        <a href="manutencao-consultar.html"><i class="fa fa-fw fa-wrench"></i> ManutenÃ§Ã£o</a>
                    </li>
                    <li>
                        <a href="servico-consultar.html"><i class="fa fa-fw fa-gears"></i> ServiÃ§o</a>
                    </li>
                    <li class="active">
                        <a href="profissional-consultar.html"><i class="fa fa-fw fa-desktop"></i> Profissional</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </nav>

        <div id="page-wrapper">

            <div class="container-fluid">

                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
						<h1 class="page-header">
							Profissional
						</h1>
                    </div>
                </div>
                <!-- /.row -->

                <div class="row">
                    <div class="col-lg-12">
						<h2 style="margin-top: 0">Cadastro de Profissional</h2>
					</div>
					<div class="col-lg-12">
						<div class="form-group row">
							<label for="example-text-input" class="col-xs-1 col-form-label">Nome</label>
							<div class="col-xs-7">
								<input class="form-control" type="text" name="nome" placeholder="Nome"/>
							</div>
							<label for="example-text-input" class="col-xs-1 col-form-label">Data de Nascimento</label>
							<div class="col-xs-3">
								<input class="form-control" type="date" name="nascimento" placeholder="nascimento"/>
							</div>
						</div>
						<div class="form-group row">
							<label for="example-text-input" class="col-xs-1 col-form-label">Email</label>
							<div class="col-xs-7">
								<input class="form-control" name="email" type="email" placeholder="Email"/>
							</div>
							<label for="example-text-input" class="col-xs-1 col-form-label">CPF</label>
							<div class="col-xs-3">
								<input class="form-control" type="text" name="cpf" placeholder="CPF"/>
							</div>
						</div>
						<div class="form-group row">
							<label for="example-text-input" class="col-xs-1 col-form-label">Telefone Fixo</label>
							<div class="col-xs-3">
								<input class="form-control" type="tel" name="fixo" placeholder="Telefone Fixo"/>
							</div>
							<label for="example-text-input" class="col-xs-1 col-form-label">Telefone Celular</label>
							<div class="col-xs-3">
								<input class="form-control" type="tel" name="celular" placeholder="Telefone Celular"/>
							</div>
							<label for="example-text-input" class="col-xs-1 col-form-label">Telefone Contato</label>
							<div class="col-xs-3">
								<input class="form-control" type="tel" name="contato" placeholder="Telefone Contato"/>
							</div>
						</div>
						<div class="form-group row">
							<label for="example-text-input" class="col-xs-1 col-form-label">CEP</label>
							<div class="col-xs-3">
								<input class="form-control" type="text" name="cep" placeholder="CEP"/>
							</div>
							<label for="example-text-input" class="col-xs-1 col-form-label">Rua</label>
							<div class="col-xs-7">
								<input class="form-control" name="rua" type="text" placeholder="Rua"/>
							</div>
						</div>
						<div class="form-group row">
							<label for="example-text-input" class="col-xs-1 col-form-label">NÃºmero</label>
							<div class="col-xs-3">
								<input class="form-control" type="number" name="numero" placeholder="NÃºmero"/>
							</div>
							<label for="example-text-input" class="col-xs-1 col-form-label">Comple.</label>
							<div class="col-xs-7">
								<input class="form-control" type="text" name="complemento" placeholder="Complemento"/>
							</div>
						</div>
						<div class="form-group row">
							<label for="example-text-input" class="col-xs-1 col-form-label">Bairro</label>
							<div class="col-xs-3">
								<input class="form-control" type="text" name="bairro" placeholder="Bairro"/>
							</div>
							<label for="example-text-input" class="col-xs-1 col-form-label">Cidade</label>
							<div class="col-xs-3">
								<input class="form-control" type="text" name="cidade" placeholder="Cidade"/>
							</div>
							<label for="example-text-input" class="col-xs-1 col-form-label">UF</label>
							<div class="col-xs-3">
								<input class="form-control" type="text" name="uf" placeholder="UF"/>
							</div>
						</div>
						<div class="form-group row">
							<label for="example-text-input" class="col-xs-1 col-form-label">SalÃ¡rio</label>
							<div class="col-xs-3">
								<input class="form-control" type="number" name="salario" placeholder="1.500,00"/>
							</div>
						</div>
						<div class="form-group text-right">
							<a href="profissional-consultar.html" class="btn btn-default" name="cancelar" type="button">Cancelar</a>
							<input class="btn btn-default" name="limpar" type="button" value="Limpar"/>
							<input class="btn btn-primary" name="cadastrar" type="button" value="Cadastrar"/>
						</div>
                    </div>
                </div>
                <!-- /.row -->
            </div>
            <!-- /.container-fluid -->

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
