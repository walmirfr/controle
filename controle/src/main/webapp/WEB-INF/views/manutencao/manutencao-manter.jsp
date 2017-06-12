<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
        <div id="page-wrapper">
			<form action="inserirManutencao" method="post">
            <div class="container-fluid">

                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
						<h1 class="page-header">
							Cadastro de Manutenção
						</h1>
                    </div>
                </div>
                <!-- /.row -->
                <div class="row">
					<div class="col-lg-12">					
						<div class="form-group row">
							<label class="col-xs-2 col-form-label">Tipo de Proprietário:</label>
							<label class="radio-inline col-xs-1">
								<input type="radio" id="optionsRadiosInline1" value="option1" checked>Cliente
							</label>
							<label class="radio-inline col-xs-1">
								<input type="radio" id="optionsRadiosInline2" value="option2">Empresa
							</label>
							<label for="example-text-input" class="col-xs-1 col-form-label">Proprietário</label>
							<div class="col-xs-3">
								<select class="form-control" id="proprietario" name="proprietario.idPessoa" >
									<option value="#">Selecione um Proprietário</option>
									<c:forEach items="${listaProprietarios}" var="proprietario">
										<option value="${proprietario.idPessoa }">${proprietario.nome }</option>									
									</c:forEach>							
								</select>
							</div>
						</div>
						<div class="form-group row">
							<label for="example-text-input" class="col-xs-1 col-form-label">Veículo</label>
							<div class="col-xs-3">
								<select id="selectVeiculo" name="veiculo.idVeiculo" class="form-control bloq">
									<option value="#">Selecione um Veículo</option>
									<c:if test="${listaVeiculos != null && listaVeiculos.size() > 0 }">
										<c:forEach items="${listaVeiculos}" var="veiculo">
											<option value="${marca.idVeiculo }">${veiculo.placa}</option>
										</c:forEach>
									</c:if>
								</select>
							</div>
							<label for="example-text-input" class="col-xs-1 col-form-label">Marca</label>
							<div class="col-xs-3">
								<input type="text" class="form-control" id="marca" disabled="disabled">
							</div>
							<label for="example-text-input" class="col-xs-1 col-form-label" >Modelo</label>
							<div class="col-xs-3">
								<input type="text" class="form-control" id="modelo" disabled="disabled">
							</div>
						</div>
						<div class="form-group row">
							<label for="example-text-input" class="col-xs-1 col-form-label">KM</label>
							<div class="col-xs-3">
								<input class="form-control" type="text" name="km" placeholder="KM"/>
							</div>
							<label for="example-text-input" class="col-xs-1 col-form-label">Data Entrada</label>
							<div class="col-xs-3">
								<div class="input-group date">
								    <input type="text" name="dtEntrada" class="form-control datepicker">
								    <div class="input-group-addon">
								        <span class="glyphicon glyphicon-th"></span>
								    </div>
								</div>
							</div>
							<label for="example-text-input" class="col-xs-1 col-form-label">Data Saída</label>
							<div class="col-xs-3">
								<div class="input-group date">
								    <input type="text" name="dtSaida" class="form-control datepicker">
								    <div class="input-group-addon">
								        <span class="glyphicon glyphicon-th"></span>
								    </div>
								</div>
							</div>
						</div>
						<div class="form-group row">
							<label for="example-text-input" class="col-xs-1 col-form-label">Observação</label>
							<div class="col-xs-11">
								<textarea class="form-control" name="observacao" placeholder="Observação"></textarea>
							</div>
						</div>
						<h4>Serviços</h4>
						<div class="form-group row">
							<label for="example-text-input" class="col-xs-1 col-form-label">Grupo Serviço</label>
							<div class="col-xs-3">
								<select id="selectGrupoServico" class="form-control">
									<option value="#">Selecione um Grupo</option>
									<c:forEach items="${listaGrupos}" var="grupoServico">
										<c:if test="${grupoServico.idGrupoServico == servicoVo.grupoServico.idGrupoServico}">
											<option selected value="${grupoServico.idGrupoServico}">${grupoServico.nome}</option>									
										</c:if>
										<c:if test="${grupoServico.idGrupoServico != servicoVo.grupoServico.idGrupoServico}">
											<option value="${grupoServico.idGrupoServico}">${grupoServico.nome}</option>									
										</c:if>
									</c:forEach>
								</select>
							</div>
							<label for="example-text-input" class="col-xs-1 col-form-label">Serviço</label>
							<div class="col-xs-3">
								<select id="selectServico" class="form-control">
									<option value="#">Selecione um Serviço</option>
									<c:forEach items="${listaServicos}" var="servico">
										<option value="${servico.idServico}">${servico.nome }</option>
									</c:forEach>
								</select>
							</div>
							<div class="col-xs-2">
								<input class="btn btn-primary" onclick="adicionarServico()" type="button" value="Adicionar Serviço"/>
							</div>
						</div>
						<h4>Lista de Serviços</h4>
						<div class="form-group">
							<table id="tabelaServicos" class="table table-bordered table-hover table-striped">
								<input type="hidden" id="controleServico" value="${manutencaoVo.listaServicos.size() + 1}" />
								<tr>
									<th class="center">Nome do Serviço</th>
									<th class="center">Grupo de Serviço</th>
									<th class="center">Preço</th>
									<th class="center">Remover</th>
								</tr>
								<c:if test="${manutencaoVo.listaServicos == null || manutencaoVo.listaServicos.size() == 0}">
									<tr align="center" id="msgServicos">
										<td colspan="4">
											<h4>Nenhum Serviço Adicionado!</h4>
										</td>
									</tr>
								</c:if>
							</table>
						</div>
						<h4>Profissionais</h4>
						<div class="form-group row">
							<label for="example-text-input" class="col-xs-1 col-form-label">Profissional</label>
							<div class="col-xs-3">
								<select class="form-control" id="selectProfissional">
									<option value="#">Selecione um Profissional</option>
									<c:forEach items="${listaProfissionais}" var="profissional">
										<option value="${profissional.idPessoa}">${profissional.nome}</option>
									</c:forEach>
								</select>
							</div>
							<div class="col-xs-2">
								<input class="btn btn-primary" onclick="adicionarProfissional()" type="button" value="Adicionar Profissional"/>
							</div>
						</div>
						<h4>Lista de Profissionais</h4>
						<div class="form-group">
							<table id="tabelaProfissional" class="table table-bordered table-hover table-striped">
								<input type="hidden" id="controleProfissional" value="${manutencaoVo.listaProfissionais.size() + 1}" />
								<tr>
									<th class="center">Nome</th>
									<th class="center">Remover</th>
								</tr>
								<c:if test="${manutencaoVo.listaProfissionais == null || manutencaoVo.listaProfissionais.size() == 0}">
									<tr align="center" id="msgProfissional">
										<td colspan="2">
											<h4>Nenhum Profissional Adicionado!</h4>
										</td>
									</tr>
								</c:if>
							</table>
						</div>
						<div class="form-group text-right">
							<a href="../manutencao/consultar" class="btn btn-default" type="button">Cancelar</a>
							<input class="btn btn-default" type="button" value="Limpar"/>
							<input class="btn btn-primary" type="submit" value="Cadastrar"/>
						</div>
                    </div>
                </div>
                <!-- /.row -->
            </div>
            <!-- /.container-fluid -->
			</form>
        </div>

        <script src="<c:url value="/static/js/manutencao/manutencao-manter.js" />" type="text/javascript"></script>