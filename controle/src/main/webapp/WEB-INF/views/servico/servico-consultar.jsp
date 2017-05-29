<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

        <div id="page-wrapper">

            <div class="container-fluid">
				<c:if test="${sucesso != null}">
					<div class="alert alert-info center" role="alert">
						<button type="button" class="close" data-dismiss="alert" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<span> ${sucesso}</span>
					</div>
				</c:if>
                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
						<div class="col-lg-11">
							<h1 class="page-header">
								Serviço
							</h1>
						</div>
						<div class="col-lg-1" style="top: 50px; right: 25px;">
							<a href="cadastrar" class="btn btn-lg btn-primary">Cadastrar</a>
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
							<form method="post" action="filtrar">
								<div class="input-group">
									<input name="nome" value="${servicoVo.nome}" id="filtro" placeholder="Filtro pelo Nome" class="form-control input-lg">
									<span class="input-group-btn"> 
										<button class="btn btn-lg btn-primary" type="submit">Filtrar</button> 
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
	                                    <tr align="center">
	                                        <td><a href="#">${servico.nome }</a></td>
	                                        <td>${servico.grupoServico.nome }</td>
											<td>
												<a href="visualizar?idServico=${servico.idServico}" class="btn btn-lg btn-primary">
													<i class="fa fa-refresh"></i>
												</a>
											</td>
											<td>
												<c:if test="${servico.ativo eq true && servico.vinculo eq false}">
													<a href="#" onclick="modalAcao(${servico.idServico},'Excluir')" data-target="#modalAcoes" data-toggle="modal" class="btn btn-lg btn-danger">
														<i class="fa">
															Excluir
														</i>
													</a>
												</c:if>
												<c:if test="${servico.ativo eq true && servico.vinculo eq true}">
													<a href="" onclick="modalAtivarDesativar(${servico.idServico})" data-target="#modalDesativar" data-toggle="modal" class="btn btn-lg btn-warning">
														<i class="fa">
															Desativar
														</i>
													</a>
												</c:if>
												<c:if test="${servico.ativo eq false}">
													<a href="" onclick="modalAcao(${servico.idServico},'Ativar')" data-target="#modalAcoes" data-toggle="modal" class="btn btn-lg btn-success">
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

<div class="modal fade" id="modalExcluir" tabindex="-1" role="dialog" data-backdrop="static" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
	<div class="modal-content">
	  <div class="modal-header header-danger">
		<h2 class="modal-title">Excluir
			<button type="button" class="close" data-dismiss="modal" aria-label="Close">
			  <span aria-hidden="true">&times;</span>
			</button>
		</h2>
	  </div>
		<form action="deletarServico" method="post">
			<input type="hidden" name="idServico" id="excluirServico"/>
			<div class="modal-body center">
				<h3>
			        <p>O Serviço será excluido!</p>
			        <p>Tem certeza que deseja excluir?</p>
				</h3>
		    </div>
		  <div class="modal-footer">
			<button type="submit" class="btn btn-lg btn-danger">Sim</button>
			<button type="button" class="btn btn-lg btn-default" data-dismiss="modal">Não</button>
		  </div>
		</form>
	</div>
  </div>
</div>

<div class="modal fade" id="modalDesativar" tabindex="-1" role="dialog" data-backdrop="static" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
	<div class="modal-content">
	  <div class="modal-header header-warning">
		<h2 class="modal-title">Desativar
			<button type="button" class="close" data-dismiss="modal" aria-label="Close">
			  <span aria-hidden="true">&times;</span>
			</button>
		</h2>
	  </div>
			<div class="modal-body center">
				<h3>
			        <p>O Serviço será desativado!</p>
			        <p>Tem certeza que deseja desativar?</p>
				</h3>
		    </div>
		  <div class="modal-footer">
			<button type="button" onclick="ativarDesativarServico('desativar')" data-dismiss="modal" class="btn btn-lg btn-warning">Sim</button>
			<button type="button" class="btn btn-lg btn-default" data-dismiss="modal">Não</button>
		  </div>
	</div>
  </div>
</div>

<div class="modal fade" id="modalAtivar" tabindex="-1" role="dialog" data-backdrop="static" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
	<div class="modal-content">
	  <div class="modal-header header-success">
		<h2 class="modal-title">Ativar
			<button type="button" class="close" data-dismiss="modal" aria-label="Close">
			  <span aria-hidden="true">&times;</span>
			</button>
		</h2>
	  </div>
			<div class="modal-body center">
				<h3>
			        <p>O Serviço <b>Ponteira</b> será ativado!</p>
			        <p>Tem certeza que deseja ativar?</p>
				</h3>
		    </div>
		  <div class="modal-footer">
			<button type="button" onclick="ativarDesativarServico('ativar')" data-dismiss="modal" class="btn btn-lg btn-success">Sim</button>
			<button type="button" class="btn btn-lg btn-default" data-dismiss="modal">Não</button>
		  </div>
	</div>
  </div>
</div>


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
			<input type="hidden" name="idServico" id="idServicoAcao"/>
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

        <script src="<c:url value="/static/js/servico/servico-consultar.js" />" type="text/javascript"></script>