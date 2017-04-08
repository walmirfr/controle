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
<form:errors path="servico.descricao" />
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
		<input class="btn btn-primary" name="cadastrar" type="button" value="Adicionar Grupo"/>
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
