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
					<li class="active">
                        <a href="veiculo-consultar.html"><i class="fa fa-fw fa-car"></i> VeÃ­culos</a>
                    </li>
                    <li>
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
						<div class="col-lg-11">
							<h1 class="page-header">
								VeÃ­culo
							</h1>
						</div>
						<div class="col-lg-1" style="top: 50px; right: 25px;">
							<a href="veiculo-cadastrar.html" class="btn btn-primary">Cadastrar</a>
						</div>
						
                    </div>
                </div>
                <!-- /.row -->

                <div class="row">
                    <div class="col-lg-12">
						<div class="col-lg-6">
							<h2 style="margin-top: 0">Lista de VeÃ­culos</h2>
						</div>
						<div class="col-lg-6">
							<form method="post" action="#">
								<div class="input-group">
									<input name="filtro" placeholder="Filtro pelo Nome" class="form-control">
									<span class="input-group-btn"> 
										<button class="btn btn-primary" type="button">Filtrar</button> 
									</span>
								</div>
							</form>
						</div>
					</div>
					<div class="col-lg-12">
                        <div class="table-responsive">
                            <table class="table table-bordered table-hover table-striped">
                                <thead>
                                    <tr>
                                        <th style="text-align: center;">Placa</th>
                                        <th style="text-align: center;">Marca/Modelo</th>
                                        <th style="text-align: center;">ProprietÃ¡rio</th>
										<th style="text-align: center;">Alterar</th>
										<th style="text-align: center;">Excluir</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td style="text-align: center;"><a href="#"> AAA-1234</a></td>
                                        <td style="text-align: center;">Fiat/Uno</td>
                                        <td style="text-align: center;">Fulano</td>
										<td style="text-align: center;"><a href="#" class="btn btn-primary"><i class="fa fa-refresh"></i></a></td>
										<td style="text-align: center;"><a href="#" class="btn btn-danger"><i class="fa fa-remove"></i></a></td>
                                    </tr>
                                    <tr>
                                        <td style="text-align: center;"><a href="#"> AAA-1234</a></td>
                                        <td style="text-align: center;">Fiat/Uno</td>
                                        <td style="text-align: center;">Fulano</td>
										<td style="text-align: center;"><a href="#" class="btn btn-primary"><i class="fa fa-refresh"></i></a></td>
										<td style="text-align: center;"><a href="#" class="btn btn-danger"><i class="fa fa-remove"></i></a></td>
                                    </tr>
									<tr>
                                        <td style="text-align: center;"><a href="#"> AAA-1234</a></td>
                                        <td style="text-align: center;">Fiat/Uno</td>
                                        <td style="text-align: center;">Fulano</td>
										<td style="text-align: center;"><a href="#" class="btn btn-primary"><i class="fa fa-refresh"></i></a></td>
										<td style="text-align: center;"><a href="#" class="btn btn-danger"><i class="fa fa-remove"></i></a></td>
                                    </tr>
									<tr>
                                        <td style="text-align: center;"><a href="#"> AAA-1234</a></td>
                                        <td style="text-align: center;">Fiat/Uno</td>
                                        <td style="text-align: center;">Fulano</td>
										<td style="text-align: center;"><a href="#" class="btn btn-primary"><i class="fa fa-refresh"></i></a></td>
										<td style="text-align: center;"><a href="#" class="btn btn-danger"><i class="fa fa-remove"></i></a></td>
                                    </tr>
									<tr>
                                        <td style="text-align: center;"><a href="#"> AAA-1234</a></td>
                                        <td style="text-align: center;">Fiat/Uno</td>
                                        <td style="text-align: center;">Fulano</td>
										<td style="text-align: center;"><a href="#" class="btn btn-primary"><i class="fa fa-refresh"></i></a></td>
										<td style="text-align: center;"><a href="#" class="btn btn-danger"><i class="fa fa-remove"></i></a></td>
                                    </tr>
                                </tbody>
                            </table>
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
