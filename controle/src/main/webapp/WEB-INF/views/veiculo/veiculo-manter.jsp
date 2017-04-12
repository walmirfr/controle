<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
        <div id="page-wrapper">

            <div class="container-fluid">

                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
						<h1 class="page-header">
							Cadastrar VeÃ­culo
						</h1>
                    </div>
                </div>
                <!-- /.row -->

                <div class="row">
					<div class="col-lg-12">
						<div class="form-group row">
							<label for="example-text-input" class="col-xs-1 col-form-label">Marca</label>
							<div class="col-xs-3">
								<select class="form-control" name="marca" placeholder="nascimento">
									<option value="#">Selecione uma Marca</option>
									<option value="0">Fiat</option>
									<option value="1">Ford</option>
									<option value="2">Chevrolet</option>
								</select>
							</div>
							<div class="col-xs-2">
								<input class="btn btn-primary" name="cadastrar" type="button" value="Adicionar Marca"/>
							</div>
							<label for="example-text-input" class="col-xs-1 col-form-label">Modelo</label>
							<div class="col-xs-3">
								<select class="form-control" name="marca" placeholder="nascimento">
									<option value="#">Selecione um Modelo</option>
									<option value="0">Uno</option>
									<option value="1">Punto</option>
									<option value="2">Ducato</option>
								</select>
							</div>
							<div class="col-xs-2">
								<input class="btn btn-primary" name="cadastrar" type="button" value="Adicionar Modelo"/>
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
							<label for="example-text-input" class="col-xs-1 col-form-label">NÃºmero Chassi</label>
							<div class="col-xs-3">
								<input class="form-control" type="text" name="chassi" placeholder="NÃºmero do Chassi"/>
							</div>
						</div>
						<div class="form-group row">
							<label for="example-text-input" class="col-xs-1 col-form-label">ObservaÃ§Ã£o</label>
							<div class="col-xs-11">
								<textarea class="form-control" type="text" name="chassi" placeholder="ObservaÃ§Ã£o"></textarea>
							</div>
						</div>
						<div class="form-group row">
							<label class="col-xs-2 col-form-label">Tipo de ProprietÃ¡rio:</label>
							<label class="radio-inline col-xs-1">
								<input type="radio" name="optionsRadiosInline" id="optionsRadiosInline1" value="option1" checked>Cliente
							</label>
							<label class="radio-inline col-xs-1">
								<input type="radio" name="optionsRadiosInline" id="optionsRadiosInline2" value="option2">Empresa
							</label>
							<label for="example-text-input" class="col-xs-2 col-form-label">Filtro ProprietÃ¡rio</label>
							<div class="col-xs-3">
								<input class="form-control" type="text" name="filtro" placeholder="Filtro por Nome"/>
							</div>
						</div>
						<div class="form-group row">
							<label for="example-text-input" class="col-xs-1 col-form-label">ProprietÃ¡rio</label>
							<div class="col-xs-3">
								<select class="form-control" name="proprietario" placeholder="nascimento">
									<option value="#">Selecione um ProprietÃ¡rio</option>
									<option value="0">Fulano</option>
									<option value="1">Fulano 2</option>
									<option value="2">Fulano 3</option>
								</select>
							</div>
						</div>
						
						<div class="form-group text-right">
							<a href="veiculo-consultar.html" class="btn btn-default" name="cancelar" type="button">Cancelar</a>
							<input class="btn btn-default" name="limpar" type="button" value="Limpar"/>
							<input class="btn btn-primary" name="cadastrar" type="button" value="Cadastrar"/>
						</div>
                    </div>
                </div>
                <!-- /.row -->
            </div>
            <!-- /.container-fluid -->

        </div>
