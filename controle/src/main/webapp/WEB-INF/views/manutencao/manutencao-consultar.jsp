<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
        <div id="page-wrapper">

            <div class="container-fluid">

                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
						<div class="col-lg-11">
							<h1 class="page-header">
								Manutenção
							</h1>
						</div>
						<div class="col-lg-1" style="top: 50px; right: 25px;">
							<a href="../manutencao/cadastrar" class="btn btn-primary">Cadastrar</a>
						</div>
						
                    </div>
                </div>
                <!-- /.row -->

                <div class="row">
                    <div class="col-lg-12">
						<div class="col-lg-6">
							<h2 style="margin-top: 0">Lista de Manutenções</h2>
						</div>
						<div class="col-lg-6">
							<form method="post" action="#">
								<div class="input-group">
									<input name="filtro" placeholder="Filtro pela Placa" class="form-control">
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
                                        <th style="text-align: center;">Modelo</th>
                                        <th style="text-align: center;">Placa</th>
                                        <th style="text-align: center;">Proprietário</th>
										<th style="text-align: center;">Data Entrada</th>
										<th style="text-align: center;">Data Saída</th>
										<th style="text-align: center;">Alterar</th>
										<th style="text-align: center;">Excluir</th>
                                    </tr>
                                </thead>
                                <tbody>
                                	<c:forEach items="${listaManutencoes}" var="manutencao">
	                                    <tr>
	                                        <td style="text-align: center;"><a href="#">${manutencao.veiculo.modelo.nome}</a></td>
	                                        <td style="text-align: center;">${manutencao.veiculo.placa}</td>
	                                        <td style="text-align: center;">${manutencao.proprietario.nome}</td>
											<td style="text-align: center;">
												<fmt:formatDate pattern="dd/MM/yyyy" value="${manutencao.dtEntrada}" />
											</td>
											<td style="text-align: center;">
												<fmt:formatDate pattern="dd/MM/yyyy" value="${manutencao.dtSaida}" />
											</td>
											<td style="text-align: center;"><a href="#" class="btn btn-primary"><i class="fa fa-refresh"></i></a></td>
											<td style="text-align: center;"><a href="#" class="btn btn-danger"><i class="fa fa-remove"></i></a></td>
	                                    </tr>
                                	</c:forEach>
                                </tbody>
                            </table>	
                        </div>
                    </div>
                </div>
                <!-- /.row -->
            </div>
            <!-- /.container-fluid -->

        </div>
