<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
        <div id="page-wrapper">

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
						<h2 style="margin-top: 0">Cadastro de Profissional</h2>
					</div>
					<div class="col-lg-12">
						<div class="form-group row">
							<label for="example-text-input" class="col-xs-1 col-form-label">Nome</label>
							<div class="col-xs-7">
								<input class="form-control" type="text" name="nome" placeholder="Nome"/>
							</div>
							<label for="example-text-input" class="col-xs-1 col-form-label">Data de Nascimento</label>
							<div class="col-xs-3">
								<input class="form-control" type="date" name="nascimento" placeholder="nascimento"/>
							</div>
						</div>
						<div class="form-group row">
							<label for="example-text-input" class="col-xs-1 col-form-label">Email</label>
							<div class="col-xs-7">
								<input class="form-control" name="email" type="email" placeholder="Email"/>
							</div>
							<label for="example-text-input" class="col-xs-1 col-form-label">CPF</label>
							<div class="col-xs-3">
								<input class="form-control" type="text" name="cpf" placeholder="CPF"/>
							</div>
						</div>
						<div class="form-group row">
							<label for="example-text-input" class="col-xs-1 col-form-label">Telefone Fixo</label>
							<div class="col-xs-3">
								<input class="form-control" type="tel" name="fixo" placeholder="Telefone Fixo"/>
							</div>
							<label for="example-text-input" class="col-xs-1 col-form-label">Telefone Celular</label>
							<div class="col-xs-3">
								<input class="form-control" type="tel" name="celular" placeholder="Telefone Celular"/>
							</div>
							<label for="example-text-input" class="col-xs-1 col-form-label">Telefone Contato</label>
							<div class="col-xs-3">
								<input class="form-control" type="tel" name="contato" placeholder="Telefone Contato"/>
							</div>
						</div>
						<div class="form-group row">
							<label for="example-text-input" class="col-xs-1 col-form-label">CEP</label>
							<div class="col-xs-3">
								<input class="form-control" type="text" name="cep" placeholder="CEP"/>
							</div>
							<label for="example-text-input" class="col-xs-1 col-form-label">Rua</label>
							<div class="col-xs-7">
								<input class="form-control" name="rua" type="text" placeholder="Rua"/>
							</div>
						</div>
						<div class="form-group row">
							<label for="example-text-input" class="col-xs-1 col-form-label">NÃºmero</label>
							<div class="col-xs-3">
								<input class="form-control" type="number" name="numero" placeholder="NÃºmero"/>
							</div>
							<label for="example-text-input" class="col-xs-1 col-form-label">Comple.</label>
							<div class="col-xs-7">
								<input class="form-control" type="text" name="complemento" placeholder="Complemento"/>
							</div>
						</div>
						<div class="form-group row">
							<label for="example-text-input" class="col-xs-1 col-form-label">Bairro</label>
							<div class="col-xs-3">
								<input class="form-control" type="text" name="bairro" placeholder="Bairro"/>
							</div>
							<label for="example-text-input" class="col-xs-1 col-form-label">Cidade</label>
							<div class="col-xs-3">
								<input class="form-control" type="text" name="cidade" placeholder="Cidade"/>
							</div>
							<label for="example-text-input" class="col-xs-1 col-form-label">UF</label>
							<div class="col-xs-3">
								<input class="form-control" type="text" name="uf" placeholder="UF"/>
							</div>
						</div>
						<div class="form-group row">
							<label for="example-text-input" class="col-xs-1 col-form-label">SalÃ¡rio</label>
							<div class="col-xs-3">
								<input class="form-control" type="number" name="salario" placeholder="1.500,00"/>
							</div>
						</div>
						<div class="form-group text-right">
							<a href="profissional-consultar.html" class="btn btn-default" name="cancelar" type="button">Cancelar</a>
							<input class="btn btn-default" name="limpar" type="button" value="Limpar"/>
							<input class="btn btn-primary" name="cadastrar" type="button" value="Cadastrar"/>
						</div>
                    </div>
                </div>
                <!-- /.row -->
            </div>
            <!-- /.container-fluid -->

        </div>
