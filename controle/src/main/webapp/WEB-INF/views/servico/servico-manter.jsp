<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div id="page-wrapper">
	<form action="inserirServico" method="post">
	   <div class="container-fluid">
	
	       <!-- Page Heading -->
			<div class="row">
			    <div class="col-lg-12">
					<h1 class="page-header">
						Serviço
					</h1>
				</div>
			</div>
	          <!-- /.row -->
	
			<div class="row">
				<div class="col-lg-12">
					<h2 style="margin-top: 0">Cadastro de Serviço</h2>
				</div>
				<div class="col-lg-12">
					<div class="form-group row">
						<form:errors path="servico.nome" />
						<label for="example-text-input" class="col-xs-1 col-form-label">Nome</label>
						<div class="col-xs-7">
							<input class="form-control" type="text" name="nome" placeholder="Nome"/>
						</div>
					</div>
					<div class="form-group row">
						<label for="example-text-input" class="col-xs-1 col-form-label">Descrição</label>
						<div class="col-xs-7">
							<textarea class="form-control" name="descricao"  placeholder="Descrição"></textarea>
						</div>
					</div>
					<div class="form-group row">
						<label for="example-text-input" class="col-xs-1 col-form-label">Grupo Serviço</label>
						<div class="col-xs-3">
							<select class="form-control" name="grupoServico.idGrupoServico" placeholder="Grupo Serviço">
								<option value="#">Selecione um Grupo</option>
								<option value="1">Suspenção</option>
							</select>
						</div>
						<div class="col-xs-2">
							<div class="col-xs-2">
								<button class="btn btn-primary" id="btGrupoServico" name="cadastrar" data-toggle="modal" data-target="#modalGrupoServico" type="button" >
									Adicionar Grupo
								</button>
							</div>
						</div>
					</div>
					<div class="form-group row">
						<label for="example-text-input" class="col-xs-1 col-form-label">Tempo Estimado</label>
						<div class="col-xs-3">
							<input class="form-control" type="number" name="tempoEstivamo" placeholder="Tempo estimado em horas"/>
						</div>
					</div>
					<div class="form-group text-right">
						<a href="consultar" class="btn btn-default" name="cancelar" type="button">Cancelar</a>
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
<!-- /#page-wrapper -->

<!--Modal Adicionar grupo-->
<div class="modal fade" id="modalGrupoServico" tabindex="-1" role="dialog" data-backdrop="static" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
	<div class="modal-content">
	  <div class="modal-header">
		<h4 class="modal-title" id="exampleModalLabel">Adicionar Grupo de Serviço
			<button type="button" class="close" data-dismiss="modal" aria-label="Close">
			  <span aria-hidden="true">&times;</span>
			</button>
		</h4>
	  </div>
	  <div class="modal-body">
		<form>
			<div class="form-group">
				<label for="recipient-name" class="control-label">Nome do Grupo</label>
				<input class="form-control" type="text" name="nome" placeholder="Nome do Grupo Serviço"/>
			</div>
		</form>
	  </div>
	  <div class="modal-footer">
		<button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
		<button type="button" class="btn btn-primary">Salvar Grupo</button>
	  </div>
	</div>
  </div>
</div>