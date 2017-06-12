<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

        <div id="page-wrapper">
		<c:if test="${funcao == 'Cadastrar'}">
			<form action="inserirVeiculo" method="post">
		</c:if>
            <div class="container-fluid">

                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
						<h1 class="page-header">
							Cadastrar Veículo
						</h1>
                    </div>
                </div>
                <!-- /.row -->

                <div class="row">
					<div class="col-lg-12">
						<div class="form-group row">
							<label for="example-text-input" class="col-xs-1 col-form-label">Marca</label>
							<div class="col-xs-3">
								<select id="selectMarca" class="form-control" name="marca.idMarca" placeholder="nascimento">
									<option value="#">Selecione uma Marca</option>
									<c:if test="${listaMarcas != null && listaMarcas.size() > 0 }">
										<c:forEach items="${listaMarcas}" var="marca">
											<option value="${marca.idMarca }">${marca.nome}</option>
										</c:forEach>
									</c:if>
								</select>
							</div>
							<div class="col-xs-2">
								<button class="btn btn-primary" type="button" id="btMarca" data-toggle="modal" data-target="#modalMarca">
									Adicionar Marca
								</button>
							</div>
							<label for="example-text-input" class="col-xs-1 col-form-label">Modelo</label>
							<div class="col-xs-3">
								<select class="form-control" id="selectModelo" name="modelo.idModelo" placeholder="nascimento">
									<option value="#">Selecione um Modelo</option>
									<c:if test="${listaModelos != null && listaModelos.size() > 0 }">
										<c:forEach items="${listaModelos}" var="modelo">
											<option value="${modelo.idModelo }">${modelo.nome}</option>
										</c:forEach>
									</c:if>
								</select>
							</div>
							<div class="col-xs-2">
								<button class="btn btn-primary" type="button" id="btModelo" data-toggle="modal" data-target="#modalModelo">
									Adicionar Modelo
								</button>
							</div>
						</div>
						<div class="form-group row">
							<label for="example-text-input" class="col-xs-1 col-form-label">Placa</label>
							<div class="col-xs-3">
								<input class="form-control" name="placa" type="text" placeholder="Placa"/>
							</div>
							<label for="example-text-input" class="col-xs-1 col-form-label">Ano</label>
							<div class="col-xs-3">
								<input class="form-control" type="text" name="ano" placeholder="Ano"/>
							</div>
							<label for="example-text-input" class="col-xs-1 col-form-label">Cor</label>
							<div class="col-xs-3">
								<input class="form-control" type="text" name="cor" placeholder="Cor"/>
							</div>
						</div>
						<div class="form-group row">
							<label for="example-text-input" class="col-xs-1 col-form-label">Observação</label>
							<div class="col-xs-11">
								<textarea class="form-control" name="observacao" placeholder="Observação"></textarea>
							</div>
						</div>
						<div class="form-group row">
							<label class="col-xs-2 col-form-label">Tipo de Proprietário</label>
							<label class="radio-inline col-xs-1">
								<input type="radio" name="tipo" id="optionsRadiosInline1" value="C" checked>Cliente
							</label>
							<label class="radio-inline col-xs-1">
								<input type="radio" name="tipo" id="optionsRadiosInline2" value="E">Empresa
							</label>
							
							<label for="example-text-input" class="col-xs-1 col-form-label">Proprietário</label>
							<div class="col-xs-3">
								<select class="form-control" name="proprietario.idPessoa" >
									<option value="#">Selecione um Proprietário</option>
									<c:forEach items="${listaClientes}" var="cliente">
										<option value="${cliente.idPessoa }">${cliente.nome }</option>									
									</c:forEach>							
								</select>
							</div>
						</div>
						<div class="form-group text-right">
							<a href="../veiculo/consultar" class="btn btn-default" type="button">Cancelar</a>
							<input class="btn btn-default" name="limpar" type="button" value="Limpar"/>
							<input class="btn btn-primary" name="cadastrar" type="submit" value="Cadastrar"/>
						</div>
                    </div>
                </div>
                <!-- /.row -->
            </div>
            </form>
            <!-- /.container-fluid -->

        </div>


<!--Modal Adicionar Marca-->
<div class="modal fade" id="modalMarca" tabindex="-1" role="dialog" data-backdrop="static" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
	<div class="modal-content">
	  <div class="modal-header">
		<h4 class="modal-title" id="ModalMarca">Adicionar Marca
			<button type="button" class="close" data-dismiss="modal" aria-label="Close">
			  <span aria-hidden="true">&times;</span>
			</button>
		</h4>
	  </div>
		<form action="inserirMarca" method="post">
		  <div class="modal-body">
			<div class="form-group">
				<label for="recipient-name" class="control-label">Nome da Marca</label>
				<input class="form-control" id="nomeMarca" type="text" name="nome" placeholder="Nome da Marca"/>
			</div>
		  </div>
		  <div class="modal-footer">
			<button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
			<button type="button" data-dismiss="modal" onclick="inserirMarca()" class="btn btn-primary">Salvar Marca</button>
		  </div>
		</form>
	</div>
  </div>
</div>


<!--Modal Adicionar Marca-->
<div class="modal fade" id="modalModelo" tabindex="-1" role="dialog" data-backdrop="static" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
	<div class="modal-content">
	  <div class="modal-header">
		<h4 class="modal-title" id="ModalMarca">Adicionar Modelo
			<button type="button" class="close" data-dismiss="modal" aria-label="Close">
			  <span aria-hidden="true">&times;</span>
			</button>
		</h4>
	  </div>
		<form action="inserirModelo" id="formModelo" method="post">
			<input type="hidden" name="marca.idMarca" id="marcaDoModelo">
		  <div class="modal-body">
			<div class="form-group">
				<label for="recipient-name" class="control-label">Nome do Modelo</label>
				<input class="form-control" id="nomeModelo" type="text" name="nome" placeholder="Nome do Modelo"/>
			</div>
		  </div>
		  <div class="modal-footer">
			<button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
			<button type="button" onclick="inserirModelo()" data-dismiss="modal" class="btn btn-primary">Salvar Modelo</button>
		  </div>
		</form>
	</div>
  </div>
</div>

<!-- Veiculo-Master JavaScript -->
	<script src="<c:url value="/static/js/veiculo/veiculo-master.js" />"
		type="text/javascript"></script>