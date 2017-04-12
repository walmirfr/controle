<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Navigation -->
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="index.html">Mecânica Dois Irmãos</a>
    </div>
    <!-- Top Menu Items -->
    <ul class="nav navbar-right top-nav">
        <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> Walmir Ferreira <b class="caret"></b></a>
            <ul class="dropdown-menu">
                <li>
                    <a href="#"><i class="fa fa-fw fa-user"></i> Perfil</a>
                </li>
                <li>
                    <a href="#"><i class="fa fa-fw fa-power-off"></i> Sair</a>
                </li>
            </ul>
        </li>
    </ul>
    <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
       <div class="collapse navbar-collapse navbar-ex1-collapse">
           <ul class="nav navbar-nav side-nav">
          
               <c:if test="${pagina == 'principal'}">
               		<li class="active">
               </c:if>
               <c:if test="${pagina != 'principal'}">
               		<li>
               </c:if>
                   <a href="home/index"><i class="fa fa-fw fa-home"></i> Principal</a>
               </li>
				<c:if test="${pagina == 'cliente'}">
               		<li class="active">
               </c:if>
               <c:if test="${pagina != 'cliente'}">
               		<li>
               </c:if>
                   <a href="cliente/cliente-consultar"><i class="fa fa-fw fa-user"></i> Cliente <span class="icon-tipo-down"></span></a>
               </li>
				<c:if test="${pagina == 'empresa'}">
               		<li class="active">
               </c:if>
               <c:if test="${pagina != 'empresa'}">
               		<li>
               </c:if>
                   <a href="empresa/empresa-consultar"><i class="fa fa-fw fa-users" aria-hidden="true"></i> Empresa</a>
               </li>
				<c:if test="${pagina == 'veiculo'}">
               		<li class="active">
               </c:if>
               <c:if test="${pagina != 'veiculo'}">
               		<li>
               </c:if>
                   <a href="veiculo/veiculo-consultar"><i class="fa fa-fw fa-car"></i> Veículos</a>
               </li>
               <c:if test="${pagina == 'manutencao'}">
               		<li class="active">
               </c:if>
               <c:if test="${pagina != 'manutencao'}">
               		<li>
               </c:if>
                   <a href="manutencao/manutencao-consultar"><i class="fa fa-fw fa-wrench"></i> Manutenção</a>
               </li>
               <c:if test="${pagina == 'servico'}">
               		<li class="active">
               </c:if>
               <c:if test="${pagina != 'servico'}">
               		<li>
               </c:if>
                   <a href="servico/servico-consultar"><i class="fa fa-fw fa-gears"></i> Serviço</a>
               </li>
				<c:if test="${pagina == 'profissional'}">
               		<li class="active">
               </c:if>
               <c:if test="${pagina != 'profissional'}">
               		<li>
               </c:if>
                   <a href="profissional/profissional-consultar"><i class="fa fa-fw fa-desktop"></i> Profissional</a>
               </li>
           </ul>
       </div>
       <!-- /.navbar-collapse -->
</nav>