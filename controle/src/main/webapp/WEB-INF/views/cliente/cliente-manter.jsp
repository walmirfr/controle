<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

        <div id="page-wrapper">

            <div class="container-fluid">

                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
						<h1 class="page-header">
							Cadastro de Cliente
						</h1>
                    </div>
                </div>
                <!-- /.row -->

                <div class="row">
					<div class="col-lg-12">
						<div class="form-group row">
							<label for="example-text-input" class="col-xs-1 col-form-label">Nome</label>
							<div class="col-xs-7">
								<input class="form-control" type="text" name="nome" placeholder="Nome"/>
							</div>
							<label for="example-text-input" class="col-xs-1 col-form-label">Data de Nascimento</label>
							<div class="col-xs-3">
								<input class="form-control" type="date" name="nascimento" placeholder="Data de Nascimento"/>
							</div>
						</div>
						<div class="form-group row">
							<label for="example-text-input" class="col-xs-1 col-form-label">Email</label>
							<div class="col-xs-7">
								<input class="form-control" name="email" type="email" placeholder="Email"/>
							</div>
							<label for="example-text-input" class="col-xs-1 col-form-label">Login</label>
							<div class="col-xs-3">
								<input class="form-control" type="text" name="cpf" placeholder="Login"/>
							</div>
						</div>
						<div class="form-group row">
							<label for="example-text-input" class="col-xs-1 col-form-label">CPF</label>
							<div class="col-xs-3">
								<input class="form-control" type="tel" name="fixo" placeholder="CPF"/>
							</div>
							<label for="example-text-input" class="col-xs-1 col-form-label">RG</label>
							<div class="col-xs-3">
								<input class="form-control" type="tel" name="celular" placeholder="RG"/>
							</div>
							<label for="example-text-input" class="col-xs-1 col-form-label">Senha</label>
							<div class="col-xs-3">
								<input class="form-control" type="tel" name="contato" placeholder="Senha"/>
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
							<label for="example-text-input" class="col-xs-1 col-form-label">Telefone</label>
							<div class="col-xs-1">
								<input class="form-control" type="tel" name="celular" placeholder="DD"/>
							</div>
							<div class="col-xs-3">
								<input class="form-control" type="tel" name="celular" placeholder="Telefone"/>
							</div>
							<div class="col-xs-3">
								<input class="btn btn-primary" name="cadastrar" type="button" value="Adicionar Telefone"/>
							</div>
						</div>
						<div class="form-group row">
							<div class="col-xs-6">
								<table class="table table-bordered table-hover table-striped">
									<tr>
										<th>Telefone</th>
										<th style="text-align:center;">Remover</th>
									</tr>
									<tr>
										<td>(21) 2222-3333</td>
										<td style="text-align:center;"><input class="btn btn-danger" type="button" value="Remover"/></td>
									</tr>
								</table>
							</div>
						</div>
						<div class="form-group text-right">
							<a href="../cliente/consultar" class="btn btn-default" name="cancelar" type="button">Cancelar</a>
							<input class="btn btn-default" name="limpar" type="button" value="Limpar"/>
							<input class="btn btn-primary" name="cadastrar" type="button" value="Cadastrar"/>
						</div>
                    </div>
                </div>
                <!-- /.row -->
            </div>
            <!-- /.container-fluid -->

        </div>
