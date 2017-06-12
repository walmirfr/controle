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
								Empresa
							</h1>
						</div>
						<div class="col-lg-1" style="top: 50px; right: 25px;">
							<a href="../empresa/cadastrar" class="btn btn-primary">Cadastrar</a>
						</div>
						
                    </div>
                </div>
                <!-- /.row -->

                <div class="row">
                    <div class="col-lg-12">
						<div class="col-lg-6">
							<h2 style="margin-top: 0">Lista de Empresas</h2>
						</div>
						<div class="col-lg-6">
							<form method="post" action="filtrar">
								<div class="input-group">
									<input name="nomeFantasia" value="${empresaVo.nomeFantasia}" id="filtro"  placeholder="Filtro pelo Nome" class="form-control">
									<span class="input-group-btn"> 
										<button class="btn btn-primary" type="submit">Filtrar</button> 
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
                                        <th style="text-align: center;">E-mail</th>
                                        <th style="text-align: center;">Telefone</th>
										<th style="text-align: center;">Alterar</th>
										<th style="text-align: center;">Excluir</th>
                                    </tr>
                                </thead>
                                <tbody>
                                	<c:if test="${listaEmpresas.size() == 0 && empresaVo.nomeFantasia == null}">
                                		<tr align="center">
                                			<td colspan="5">
                                				<h3>Nenhuma Empresa Cadastrada</h3>
                                			</td>
                                		</tr>
                                	</c:if>
                                	<c:if test="${listaEmpresas.size() == 0 && empresaVo.nomeFantasia != null}">
                                		<tr align="center">
                                			<td colspan="5">
                                				<h3>Nenhuma Empresa encontrada com o Filtro informado!</h3>
                                			</td>
                                		</tr>
                                	</c:if>
									<c:forEach items="${listaEmpresas}" var="empresa">
	                                    <tr>
	                                        <td class="meio">
	                                        	<a href="visualizar?idPessoa=${empresa.idPessoa}"> ${empresa.nomeFantasia }</a>
                                        	</td>
	                                        <td class="meio">${empresa.email }</td>
	                                        <td class="meio">
	                                        	<c:forEach items="${empresa.listaTelefones}" end="1" var="telefone">
													(${telefone.dd}) ${telefone.numero} <br>
												</c:forEach>
                                        	</td>
											<td class="meio">
												<a href="visualizarAlterar?idPessoa=${empresa.idPessoa}" class="btn btn-lg btn-primary">
													<i class="fa fa-refresh"></i>
												</a>
											</td>
											<td class="meio">
												<c:if test="${empresa.ativo eq true && empresa.vinculo eq false}">
													<a href="#" onclick="modalAcao(${empresa.idPessoa},'Excluir', 'Empresa')" data-target="#modalAcoes" data-toggle="modal" class="btn btn-lg btn-danger">
														<i class="fa">
															Excluir
														</i>
													</a>
												</c:if>
												<c:if test="${empresa.ativo eq true && empresa.vinculo eq true}">
													<a href="" onclick="modalAcao(${empresa.idPessoa},'Desativar', 'Empresa')" data-target="#modalAcoes" data-toggle="modal" class="btn btn-lg btn-warning">
														<i class="fa">
															Desativar
														</i>
													</a>
												</c:if>
												<c:if test="${empresa.ativo eq false}">
													<a href="" onclick="modalAcao(${empresa.idPessoa},'Ativar', 'Empresa')" data-target="#modalAcoes" data-toggle="modal" class="btn btn-lg btn-success">
														<i class="fa">
															Ativar
														</i>
													</a>
											</c:if>
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
<script src="<c:url value="/static/js/empresa/empresa-consultar.js" />" type="text/javascript"></script>