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
								Profissional
							</h1>
						</div>
						<div class="col-lg-1" style="top: 50px; right: 25px;">
							<a href="../profissional/cadastrar" class="btn btn-primary">Cadastrar</a>
						</div>
						
                    </div>
                </div>
                <!-- /.row -->

                <div class="row">
                    <div class="col-lg-12">
						<div class="col-lg-6">
							<h2 style="margin-top: 0">Lista de Profissionais</h2>
						</div>
						<div class="col-lg-6">
							<form method="post" action="filtrar">
								<div class="input-group">
									<input name="nome" value="${profissionalVo.nome}" id="filtro"  placeholder="Filtro pelo Nome" class="form-control">
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
                                        <th class="center">Nome</th>
                                        <th class="center">E-mail</th>
                                        <th class="center">Telefone</th>
										<th class="center">Alterar</th>
										<th class="center">Ações</th>
                                    </tr>
                                </thead>
                                <tbody>
                                	<c:if test="${listaProfissionais.size() == 0 && profissionalVo.nome == null}">
                                		<tr align="center">
                                			<td colspan="5">
                                				<h3>Nenhum Profissional Cadastrado!</h3>
                                			</td>
                                		</tr>
                                	</c:if>
                                	<c:if test="${listaProfissionais.size() == 0 && profissionalVo.nome != null}">
                                		<tr align="center">
                                			<td colspan="5">
                                				<h3>Nenhum Profissional encontrado com o Filtro informado!</h3>
                                			</td>
                                		</tr>
                                	</c:if>
                                	<c:forEach items="${listaProfissionais}" var="profissional">
	                                    <tr>
	                                        <td class="meio">
	                                        	<a href="visualizar?idPessoa=${profissional.idPessoa}"> ${profissional.nome }</a>
                                        	</td>
	                                        <td class="meio">${profissional.email }</td>
	                                        <td class="meio">
	                                        	<c:forEach items="${profissional.listaTelefones}" end="1" var="telefone">
													(${telefone.dd}) ${telefone.numero} <br>
												</c:forEach>
                                        	</td>
											<td class="meio">
												<a href="visualizarAlterar?idPessoa=${profissional.idPessoa}" class="btn btn-lg btn-primary">
													<i class="fa fa-refresh"></i>
												</a>
											</td>
											<td class="meio">
												<c:if test="${profissional.ativo eq true && profissional.vinculo eq false}">
													<a href="#" onclick="modalAcao(${profissional.idPessoa},'Excluir', 'Profissional')" data-target="#modalAcoes" data-toggle="modal" class="btn btn-lg btn-danger">
														<i class="fa">
															Excluir
														</i>
													</a>
												</c:if>
												<c:if test="${profissional.ativo eq true && profissional.vinculo eq true}">
													<a href="" onclick="modalAcao(${profissional.idPessoa},'Desativar', 'Profissional')" data-target="#modalAcoes" data-toggle="modal" class="btn btn-lg btn-warning">
														<i class="fa">
															Desativar
														</i>
													</a>
												</c:if>
												<c:if test="${profissional.ativo eq false}">
													<a href="" onclick="modalAcao(${profissional.idPessoa},'Ativar', 'Profissional')" data-target="#modalAcoes" data-toggle="modal" class="btn btn-lg btn-success">
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
        <!-- /#page-wrapper -->
        <script src="<c:url value="/static/js/profissional/profissional-consultar.js" />" type="text/javascript"></script>