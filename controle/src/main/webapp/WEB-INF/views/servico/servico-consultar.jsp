<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

        <div id="page-wrapper">

            <div class="container-fluid">

                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
						<div class="col-lg-11">
							<h1 class="page-header">
								Serviço
							</h1>
						</div>
						<div class="col-lg-1" style="top: 50px; right: 25px;">
							<a href="cadastrar" class="btn btn-primary">Cadastrar</a>
						</div>
						
                    </div>
                </div>
                <!-- /.row -->

                <div class="row">
                    <div class="col-lg-12">
						<div class="col-lg-6">
							<h2 style="margin-top: 0">Lista de Serviços</h2>
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
                                        <th style="text-align: center;">Nome</th>
                                        <th style="text-align: center;">Grupo</th>
										<th style="text-align: center;">Alterar</th>
										<th style="text-align: center;">Ações</th>
                                    </tr>
                                </thead>
                                <tbody>
                                	<c:forEach items="${listaServicos}" var="servico">
	                                    <tr>
	                                        <td style="text-align: center;"><a href="#">${servico.nome }</a></td>
	                                        <td style="text-align: center;">${servico.grupoServico.nome }</td>
											<td style="text-align: center;"><a href="#" class="btn btn-primary"><i class="fa fa-refresh"></i></a></td>
											<td style="text-align: center;">
												<a href="" onclick="deletarServico(${servico.idServico})" class="btn btn-danger">
													<i class="fa">
														<c:if test="${servico.ativo eq true}">Excluir</c:if>
													</i>
												</a>
											</td>
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
        <!-- /#page-wrapper -->

        <script src="<c:url value="/static/js/servico/servico-consultar.js" />" type="text/javascript"></script>