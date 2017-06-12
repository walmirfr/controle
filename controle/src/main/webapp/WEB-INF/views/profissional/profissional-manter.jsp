<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

     <div id="page-wrapper">
		
			<c:if test="${funcao == 'Cadastrar'}">
				<form action="inserirProfissional" method="post">
			</c:if>
			<c:if test="${funcao == 'Alterar'}">
				<form action="alterarProfissional" method="post" >
			   	<form:hidden path="profissionalVo.idPessoa" />
			</c:if>
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
							<h2 style="margin-top: 0">
								${funcao} Profissional
							</h2>
						</div>
						<div class="col-lg-12">
							<div class="form-group row">
								<label for="example-text-input" class="col-xs-1 col-form-label">Nome</label>
								<div class="col-xs-7">
									<input class="form-control" value="${profissionalVo.nome }" maxlength="50" type="text" name="nome" placeholder="Nome"/>
								</div>
								 
								<label for="example-text-input" class="col-xs-1 col-form-label">Data de Nascimento</label>
								<div class="col-xs-3">
									<div class="input-group date">
									    <input type="text" name="dtNascimento" value="${profissionalVo.nascimento}" maxlength="10" class="form-control datepicker">
									    <div class="input-group-addon">
									        <span class="glyphicon glyphicon-th"></span>
									    </div>
									</div>
								</div>
								 
							</div>
							<div class="form-group row">
								<label for="example-text-input" class="col-xs-1 col-form-label">Email</label>
								<div class="col-xs-7">
									<input class="form-control" name="email" value="${profissionalVo.email}" type="email" maxlength="80" placeholder="Email"/>
								</div>
								<label for="example-text-input" class="col-xs-1 col-form-label">Login</label>
								<div class="col-xs-3">
									<input class="form-control" disabled="disabled" type="text" maxlength="50" name="login" placeholder="Login"/>
								</div>
							</div>
							<div class="form-group row">
								<label for="example-text-input" class="col-xs-1 col-form-label">CPF</label>
								<div class="col-xs-3">
									<input class="form-control" type="text" maxlength="11" value="${profissionalVo.cpf}" name="cpf" placeholder="CPF"/>
								</div>
								<label for="example-text-input" class="col-xs-1 col-form-label">Sexo</label>
								<div class="col-xs-3">
									<select class="form-control" name="sexo">
										<option value="#">Selecione um Sexo</option>
										<c:if test="${profissionalVo.sexo == 'M'}">
											<option selected="selected" value="M">Masculino</option>
											<option value="F">Feminino</option>
										</c:if>
										<c:if test="${profissionalVo.sexo == 'F'}">
											<option value="M">Masculino</option>
											<option selected="selected" value="F">Feminino</option>
										</c:if>
										<c:if test="${profissionalVo.sexo == null}">
											<option value="M">Masculino</option>
											<option value="F">Feminino</option>
										</c:if>
									</select>
								</div>
								<label for="example-text-input" class="col-xs-1 col-form-label">Senha</label>
								<div class="col-xs-3">
									<input class="form-control" disabled="disabled" type="password" maxlength="50" name="contato" placeholder="Senha"/>
								</div>
							</div>
							<div class="form-group row">
								<label for="example-text-input" class="col-xs-1 col-form-label">CEP</label>
								<div class="col-xs-3">
									<input class="form-control" type="text" maxlength="8" value="${profissionalVo.endereco.cep}" name="endereco.cep" placeholder="CEP"/>
								</div>
								<label for="example-text-input" class="col-xs-1 col-form-label">Rua</label>
								<div class="col-xs-7">
									<input class="form-control" value="${profissionalVo.endereco.rua}" name="endereco.rua" maxlength="60" type="text" placeholder="Rua"/>
								</div>
							</div>
							<div class="form-group row">
								<label for="example-text-input" class="col-xs-1 col-form-label">Número</label>
								<div class="col-xs-3">
									<input class="form-control" type="number" maxlength="10" value="${profissionalVo.endereco.numero}" name="endereco.numero" placeholder="Número"/>
								</div>
								<label for="example-text-input" class="col-xs-1 col-form-label">Comple.</label>
								<div class="col-xs-7">
									<input class="form-control" type="text" maxlength="200" value="${profissionalVo.endereco.complemento}" name="endereco.complemento" placeholder="Complemento"/>
								</div>
							</div>
							<div class="form-group row">
								<label for="example-text-input" class="col-xs-1 col-form-label">Bairro</label>
								<div class="col-xs-3">
									<input class="form-control" type="text" maxlength="60" value="${profissionalVo.endereco.bairro}" name="endereco.bairro" placeholder="Bairro"/>
								</div>
								<label for="example-text-input" class="col-xs-1 col-form-label">Cidade</label>
								<div class="col-xs-3">
									<input class="form-control" type="text" maxlength="60" value="${profissionalVo.endereco.cidade}" name="endereco.cidade" placeholder="Cidade"/>
								</div>
								<label for="example-text-input" class="col-xs-1 col-form-label">UF</label>
								<div class="col-xs-3">
									<input class="form-control" type="text" maxlength="2" value="${profissionalVo.endereco.uf}" name="endereco.uf" placeholder="UF"/>
								</div>
							</div>
							<div class="form-group row">
								<label for="example-text-input" class="col-xs-1 col-form-label visu">Telefone</label>
								<div class="col-xs-1 visu">
									<input class="form-control" id="ddTelefone" maxlength="2" type="tel" placeholder="DD"/>
								</div>
								<div class="col-xs-3 visu">
									<input class="form-control" id="numeroTelefone" maxlength="9" type="tel" placeholder="Telefone"/>
								</div>
								<div class="col-xs-3 visu">
									<input class="btn btn-primary" id="adicionarTelefone" type="button" value="Adicionar Telefone"/>
								</div>
								<label for="example-text-input" class="col-xs-1 col-form-label">Salário</label>
								<div class="col-xs-3">
									<input class="form-control" type="number" maxlength="10" value="${profissionalVo.salario}" name="salario" placeholder="Ex: 1.500,00"/>
								</div>
							</div>
							<div class="form-group row">
								<div class="col-xs-6">
									<table id="tabelaTelefone" class="table table-bordered table-hover table-striped">
										<input type="hidden" id="controleTelefone" value="${profissionalVo.listaTelefones.size() + 1}" />
										<tr>
											<th class="center">Telefone</th>
											<th class="center visu">Remover</th>
										</tr>
										<c:if test="${profissionalVo.listaTelefones == null || profissionalVo.listaTelefones.size() == 0}">
											<tr id="msgTelefone" align="center">
												<td colspan="2">
													<h4>Nenhum Telefone Cadastrado</h4>
												</td>
											</tr>
										</c:if>
										<c:if test="${profissionalVo.listaTelefones != null && profissionalVo.listaTelefones.size() > 0}">
											<c:forEach items="${profissionalVo.listaTelefones}" var="telefone" varStatus="loop">
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
								<a href="../profissional/consultar" class="btn btn-default"  type="button">
								<c:if test="${funcao == 'Visualizar'}">
									Voltar
								</c:if>
								<c:if test="${funcao != 'Visualizar'}">
									Cancelar
								</c:if>
								</a>
								<input class="btn btn-default visu" name="limpar" type="button" value="Limpar"/>
								<input class="btn btn-primary visu" name="${funcao}" type="submit" value="${funcao}"/>
							</div>
	                    </div>
	                </div>
                <!-- /.row -->
            </div>
            <!-- /.container-fluid -->
		</form>
      </div>
<script src="<c:url value="/static/js/profissional/profissional-master.js" />" type="text/javascript"></script>