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
                    <li class="active">
                        <a href="manutencao-consultar.html"><i class="fa fa-fw fa-wrench"></i> ManutenÃ§Ã£o</a>
                    </li>
                    <li>
                        <a href="servico-consultar.html"><i class="fa fa-fw fa-gears"></i> ServiÃ§o</a>
                    </li>
                    <li>
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
							Cadastro de ManutenÃ§Ã£o
						</h1>
                    </div>
                </div>
                <!-- /.row -->
                <div class="row">
					<div class="col-lg-12">					
						<div class="form-group row">
							<label class="col-xs-2 col-form-label">Tipo de ProprietÃ¡rio:</label>
							<label class="radio-inline col-xs-1">
								<input type="radio" name="optionsRadiosInline" id="optionsRadiosInline1" value="option1" checked>Cliente
							</label>
							<label class="radio-inline col-xs-1">
								<input type="radio" name="optionsRadiosInline" id="optionsRadiosInline2" value="option2">Empresa
							</label>
							<label for="example-text-input" class="col-xs-2 col-form-label">Filtro ProprietÃ¡rio</label>
							<div class="col-xs-3">
								<input class="form-control" type="text" name="filtro" placeholder="Filtro por Nome"/>
							</div>
						</div>
						<div class="form-group row">
							<label for="example-text-input" class="col-xs-1 col-form-label">ProprietÃ¡rio</label>
							<div class="col-xs-3">
								<select class="form-control" name="proprietario" placeholder="nascimento">
									<option value="#">Selecione um ProprietÃ¡rio</option>
									<option value="0">Fulano</option>
									<option value="1">Fulano 2</option>
									<option value="2">Fulano 3</option>
								</select>
							</div>
						</div>
						<div class="form-group row">
							<label for="example-text-input" class="col-xs-1 col-form-label">Placa</label>
							<div class="col-xs-3">
								<input class="form-control" name="placa" type="text" placeholder="Placa"/>
							</div>
							<label for="example-text-input" class="col-xs-1 col-form-label">Marca</label>
							<div class="col-xs-3">
								<select class="form-control" name="marca" placeholder="nascimento">
									<option value="#">Selecione uma Marca</option>
									<option value="0">Fiat</option>
									<option value="1">Ford</option>
									<option value="2">Chevrolet</option>
								</select>
							</div>
							<label for="example-text-input" class="col-xs-1 col-form-label">Modelo</label>
							<div class="col-xs-3">
								<select class="form-control" name="marca" placeholder="nascimento">
									<option value="#">Selecione um Modelo</option>
									<option value="0">Uno</option>
									<option value="1">Punto</option>
									<option value="2">Ducato</option>
								</select>
							</div>
						</div>
						<div class="form-group row">
							<label for="example-text-input" class="col-xs-1 col-form-label">Lista de VeÃ­culos</label>
							<div class="col-xs-3">
								<select class="form-control" name="marca" placeholder="nascimento">
									<option value="#">Selecione uma Marca</option>
									<option value="0">AAA-1111</option>
									<option value="1">BBB-1111</option>
									<option value="2">CCC-1111</option>
								</select>
							</div>
							<label for="example-text-input" class="col-xs-1 col-form-label">KM</label>
							<div class="col-xs-3">
								<input class="form-control" type="text" name="km" placeholder="KM"/>
							</div>
						</div>
						<div class="form-group row">
							<label for="example-text-input" class="col-xs-1 col-form-label">Data Entrada</label>
							<div class="col-xs-3">
								<input class="form-control" type="text" name="dt_entrada" placeholder="Data Entrada"/>
							</div>
							<label for="example-text-input" class="col-xs-1 col-form-label">Data SaÃ­da</label>
							<div class="col-xs-3">
								<input class="form-control" type="text" name="dt_saida" placeholder="Data SaÃ­da"/>
							</div>
						</div>
						<div class="form-group row">
							<label for="example-text-input" class="col-xs-1 col-form-label">ObservaÃ§Ã£o</label>
							<div class="col-xs-11">
								<textarea class="form-control" name="observacao" placeholder="ObservaÃ§Ã£o"></textarea>
							</div>
						</div>
						<h4>ServiÃ§os</h4>
						<div class="form-group row">
							<label for="example-text-input" class="col-xs-1 col-form-label">Grupo ServiÃ§o</label>
							<div class="col-xs-3">
								<select class="form-control" name="marca" placeholder="nascimento">
									<option value="#">Todos os Grupos</option>
									<option value="0">SuspenÃ§Ã£o</option>
									<option value="1">Motor</option>
								</select>
							</div>
							<label for="example-text-input" class="col-xs-1 col-form-label">ServiÃ§o</label>
							<div class="col-xs-3">
								<select class="form-control" name="marca" placeholder="nascimento">
									<option value="#">Selecione um ServiÃ§o</option>
									<option value="0">Pastilia Dianteira</option>
									<option value="1">Amortecedor</option>
								</select>
							</div>
							<div class="col-xs-2">
								<input class="btn btn-primary" name="cadastrar" type="button" value="Adicionar ServiÃ§o"/>
							</div>
						</div>
						<h4>Lista de ServiÃ§os</h4>
						<div class="form-group">
							<table class="table table-bordered table-hover table-striped">
								<tr>
									<th style="text-align:center;">Nome do ServiÃ§o</th>
									<th style="text-align:center;">Grupo de ServiÃ§o</th>
									<th style="text-align:center;">PreÃ§o</th>
									<th style="text-align:center;">Remover</th>
								</tr>
								<tr>
									<td style="text-align:center;">Amortecedor</td>
									<td style="text-align:center;">SuspenÃ§Ã£o</td>
									<td style="text-align:center;"><input value="50,00" name="preco" placeholder="PreÃ§o"/></td>
									<td style="text-align:center;"><input class="btn btn-danger" type="button" value="Remover"/></td>
								</tr>
							</table>
						</div>
						<h4>Profissionais</h4>
						<div class="form-group row">
							<label for="example-text-input" class="col-xs-1 col-form-label">Profissional</label>
							<div class="col-xs-3">
								<select class="form-control" name="marca" placeholder="nascimento">
									<option value="#">Selecione um Profissional</option>
									<option value="0">Fulano</option>
									<option value="1">Jose</option>
									<option value="2">JoÃ£o</option>
								</select>
							</div>
							<div class="col-xs-2">
								<input class="btn btn-primary" name="cadastrar" type="button" value="Adicionar Profissional"/>
							</div>
						</div>
						<h4>Lista de Profissionais</h4>
						<div class="form-group">
							<table class="table table-bordered table-hover table-striped">
								<tr>
									<th style="text-align:center;">Nome</th>
									<th style="text-align:center;">Remover</th>
								</tr>
								<tr>
									<td style="text-align:center;">Fulano</td>
									<td style="text-align:center;"><input class="btn btn-danger" type="button" value="Remover"/></td>
								</tr>
							</table>
						</div>
						<div class="form-group text-right">
							<a href="manutencao-consultar.html" class="btn btn-default" name="cancelar" type="button">Cancelar</a>
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
