<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
        <div id="page-wrapper">

			<c:if test="${funcao == 'Cadastrar'}">
				<form action="inserirEmpresa" method="post">
			</c:if>
			<c:if test="${funcao == 'Alterar'}">
				<form action="alterarEmpresa" method="post" >
			   	<form:hidden path="empresaVo.idPessoa" />
			</c:if>
            <div class="container-fluid">

                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
						<h1 class="page-header">
							Cadastrar Empresa
						</h1>
                    </div>
                </div>
                <!-- /.row -->

                  <div class="row">
					<div class="col-lg-12">
						<div class="form-group row">
							<label for="example-text-input" class="col-xs-1 col-form-label">Nome Fantasia</label>
							<div class="col-xs-7">
								<input class="form-control" maxlength="50" type="text" name="nomeFantasia" placeholder="Nome Fantasia"/>
							</div>
							<label for="example-text-input" class="col-xs-1 col-form-label">CNPJ</label>
							<div class="col-xs-3">
								<input class="form-control" maxlength="14" type="tel" name="cnpj" placeholder="CNPJ"/>
							</div>
						</div>
						<div class="form-group row">
							<label for="example-text-input" class="col-xs-1 col-form-label">Razão Social</label>
							<div class="col-xs-7">
								<input class="form-control" maxlength="50" name="razaoSocial" type="text" placeholder="Razão Social"/>
							</div>
							<label for="example-text-input" class="col-xs-1 col-form-label">Login</label>
							<div class="col-xs-3">
								<input class="form-control" disabled="disabled" type="text" placeholder="Login"/>
							</div>
						</div>
						<div class="form-group row">
							<label for="example-text-input" class="col-xs-1 col-form-label">Email</label>
							<div class="col-xs-7">
								<input class="form-control" maxlength="80" name="email" type="email" placeholder="Email"/>
							</div>
							<label for="example-text-input" class="col-xs-1 col-form-label">Senha</label>
							<div class="col-xs-3">
								<input class="form-control" disabled="disabled" type="tel" placeholder="Senha"/>
							</div>
						</div>
						<div class="form-group row">
							<label for="example-text-input" class="col-xs-1 col-form-label">CEP</label>
							<div class="col-xs-3">
								<input class="form-control" maxlength="8" type="text" name="endereco.cep" placeholder="CEP"/>
							</div>
							<label for="example-text-input" class="col-xs-1 col-form-label">Rua</label>
							<div class="col-xs-7">
								<input class="form-control" maxlength="60" name="endereco.rua" type="text" placeholder="Rua"/>
							</div>
						</div>
						<div class="form-group row">
							<label for="example-text-input" class="col-xs-1 col-form-label">Número</label>
							<div class="col-xs-3">
								<input class="form-control" maxlength="10" type="number" name="endereco.numero" placeholder="Número"/>
							</div>
							<label for="example-text-input" class="col-xs-1 col-form-label">Comple.</label>
							<div class="col-xs-7">
								<input class="form-control" maxlength="200" type="text" name="endereco.complemento" placeholder="Complemento"/>
							</div>
						</div>
						<div class="form-group row">
							<label for="example-text-input" class="col-xs-1 col-form-label">Bairro</label>
							<div class="col-xs-3">
								<input class="form-control" type="text" maxlength="50" name="endereco.bairro" placeholder="Bairro"/>
							</div>
							<label for="example-text-input" class="col-xs-1 col-form-label">Cidade</label>
							<div class="col-xs-3">
								<input class="form-control" type="text" maxlength="50" name="endereco.cidade" placeholder="Cidade"/>
							</div>
							<label for="example-text-input" class="col-xs-1 col-form-label">UF</label>
							<div class="col-xs-3">
								<input class="form-control" type="text" maxlength="2" name="endereco.uf" placeholder="UF"/>
							</div>
						</div>
						
						<h3>Cadastrar Funcionários</h3>
						<div class="form-group row">
							<label for="example-text-input" class="col-xs-1 col-form-label">Nome</label>
							<div class="col-xs-7">
								<input class="form-control" maxlength="50" id="nomeFunc" type="text" placeholder="Nome"/>
							</div>
							<label for="example-text-input" class="col-xs-1 col-form-label">Data de Nascimento</label>
							<div class="col-xs-3">
								<div class="input-group date">
								    <input type="text" id="nascimentoFunc" value="${clienteVo.nascimento}" maxlength="10" class="form-control datepicker">
								    <div class="input-group-addon">
								        <span class="glyphicon glyphicon-th"></span>
								    </div>
								</div>
							</div>
						</div>
						<div class="form-group row">
							<label for="example-text-input" class="col-xs-1 col-form-label">CPF</label>
							<div class="col-xs-3">
								<input class="form-control" id="cpfFunc" maxlength="11" type="text" placeholder="CPF"/>
							</div>
							<label for="example-text-input" class="col-xs-1 col-form-label">Telefone</label>
							<div class="col-xs-1">
								<input class="form-control" id="ddFunc" maxlength="2" type="tel" placeholder="DD"/>
							</div>
							<div class="col-xs-3">
								<input class="form-control" id="numeroFunc" maxlength="9" type="tel" placeholder="Telefone"/>
							</div>
						</div>
						<div class="form-group row">
							<label for="example-text-input" class="col-xs-1 col-form-label">Sexo</label>
							<div class="col-xs-3">
								<select class="form-control" id="sexoFunc">
									<option value="#">Selecione um Sexo</option>
									<c:if test="${clienteVo.sexo == 'M'}">
										<option selected="selected" value="M">Masculino</option>
										<option value="F">Feminino</option>
									</c:if>
									<c:if test="${clienteVo.sexo == 'F'}">
										<option value="M">Masculino</option>
										<option selected="selected" value="F">Feminino</option>
									</c:if>
									<c:if test="${clienteVo.sexo == null}">
										<option value="M">Masculino</option>
										<option value="F">Feminino</option>
									</c:if>
								</select>
							</div>
							<div class="col-xs-3">
								<input class="btn btn-primary" id="adicionarFuncionario" type="button" value="Adicionar Funcionário"/>
							</div>
						</div>
						<h4>Lista de Funcionários</h4>
						<div class="form-group">
							<div class="col-xs-12">
								<table id="tabelaFunc" class="table table-bordered table-hover table-striped">
								<input type="hidden" id="controleFunc" value="${empresaVo.listaFuncionarios.size() + 1}" />
									<tr>
										<th class="center" style="width: 28%">Nome</th>
										<th class="center" style="width: 16%">Dt Nascimento</th>
										<th class="center" style="width: 15%">CPF</th>
										<th class="center" style="width: 6%">Sexo</th>
										<th class="center" style="width: 16%">Telefone</th>
										<th class="center" style="width: 9%">Alterar</th>
										<th class="center" style="width: 10%">Remover</th>
									</tr>
									<c:if test="${empresaVo.listaFuncionarios == null || empresaVo.listaFuncionarios.size() == 0}">
										<tr align="center" id="msgFunc">
											<td class="center" colspan="7">
												<h3>Nenhum Funcionario Cadastrado!</h3>
											</td>
										</tr>
									</c:if>
									<c:if test="${empresaVo.listaFuncionarios != null && empresaVo.listaFuncionarios.size() > 0}">
										<c:forEach items="${empresaVo.listaFuncionarios}" var="funcionario" varStatus="loop">
											<tr align="center">
												<td>
													<input type="hidden" name="listaFuncionarios[${loop.index}].nome" value="${funcionario.nome}">
													${funcionario.nome}
												</td>
												<td>
													<input type="hidden" name="listaFuncionarios[${loop.index}].dtNascimento" value="${funcionario.nascimento}">
													${funcionario.nascimento}
												</td>
												<td>
													<input type="hidden" name="listaFuncionarios[${loop.index}].cpf" value="${funcionario.cpf}">
													${funcionario.cpf}
												</td>
												<td>
													<input type="hidden" name="listaFuncionarios[${loop.index}].sexo" value="${funcionario.sexo}">
													${funcionario.sexo}
												</td>
												<td>
													<input type="hidden" name="listaFuncionarios[${loop.index}].telefone.dd" value="${funcionario.telefone.dd}">
													<input type="hidden" name="listaFuncionarios[${loop.index}].telefone.numero" value="${funcionario.telefone.numero}">
													(${funcionario.telefone.dd}) funcionario.telefone.numero
												</td>
												<td>
													<input class="btn btn-primary" onclick="alterarFuncionario(this)" type="button" value="Alterar"/>
												</td>
												<td>
													<input class="btn btn-danger" onclick="removerLinha(this)" type="button" value="Remover"/>
												</td>
											</tr>
										</c:forEach>
									</c:if>
								</table>
							</div>
						</div>
						<h3>Cadastrar Telefones da Empresa</h3>
						<div class="form-group row">
							<label for="example-text-input" class="col-xs-1 col-form-label">Telefone</label>
							<div class="col-xs-1">
								<input class="form-control" id="ddTelefone" maxlength="2" type="tel" placeholder="DD"/>
							</div>
							<div class="col-xs-3">
								<input class="form-control" id="numeroTelefone" maxlength="9" type="tel" placeholder="Telefone"/>
							</div>
							<div class="col-xs-3">
								<input class="btn btn-primary" id="adicionarTelefone" type="button" value="Adicionar Telefone"/>
							</div>
						</div>
						<h4>Lista de Telefones da Empresa</h4>
						<div class="form-group row">
							<div class="col-xs-6">
								<table id="tabelaTelefone" class="table table-bordered table-hover table-striped">
									<input type="hidden" id="controleTelefone" value="${empresaVo.listaTelefones.size() + 1}" />
									<tr>
										<th class="center">Telefone</th>
										<th class=	"center visu">Remover</th>
									</tr>
									<c:if test="${empresaVo.listaTelefones == null || empresaVo.listaTelefones.size() == 0}">
										<tr id="msgTelefone" align="center">
											<td colspan="2">
												<h4>Nenhum Telefone Cadastrado</h4>
											</td>
										</tr>
									</c:if>
									<c:if test="${empresaVo.listaTelefones != null && empresaVo.listaTelefones.size() > 0}">
										<c:forEach items="${empresaVo.listaTelefones}" var="telefone" varStatus="loop">
											<tr align="center">
												<td>
													<input type="hidden" value="${telefone.dd}" name="listaTelefones[${loop.index}].dd">
													(${telefone.dd}) ${telefone.numero}
													<input type="hidden" value="${telefone.numero}" name="listaTelefones[${loop.index}].numero">
												</td>
												<td class="visu">
													<input class="btn btn-danger" onclick="removerTelefone(this)" type="button" value="Remover"/>
												</td>
											</tr>
										</c:forEach>
									</c:if>
								</table>
							</div>
						</div>
						<div class="form-group text-right">
							<a href="empresa-consultar.html" class="btn btn-default" name="cancelar" type="button">Cancelar</a>
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
<script src="<c:url value="/static/js/empresa/empresa-master.js" />" type="text/javascript"></script>