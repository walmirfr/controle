package br.com.mecanicadoisirmaos.controle.controller;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.mecanicadoisirmaos.controle.business.ServicoBusiness;
import br.com.mecanicadoisirmaos.controle.dao.ServicoDao;
import br.com.mecanicadoisirmaos.controle.vo.GrupoServicoVo;
import br.com.mecanicadoisirmaos.controle.vo.ServicoVo;

@Controller
public class ServicoController {

	//private ServicoDaoImpl servicoDao = new ServicoDaoImpl();
	
	@Autowired
	private ServicoBusiness servicoDao;
	
	private ServicoVo servicoVo = new ServicoVo();

	@RequestMapping("/servicoCadastrar")
	public String cadastrarServico(){
		return "servico/servico-cadastro";
	}
	
	@RequestMapping("/inserirServico")
	public String inserirServico(ServicoVo servico){
		servicoDao.inserirServico(servico);
		return "infra-ok";
	}
	
	@RequestMapping("/cadastrarInfra")
	public String cadastrarInfra(ServicoVo servico){
		System.out.println(servico.getNome());
		return "infra-ok";
	}
	
	public void popularServico(){
		servicoVo.setAtivo(true);
		servicoVo.setNome("Bucha");
		servicoVo.setDescricao("Balança");
		servicoVo.setTempoEstivamo(3);
		GrupoServicoVo grupo = new GrupoServicoVo();
		grupo.setIdGrupoServico(1);
		servicoVo.setGrupoServico(grupo);
	}
	
	@RequestMapping("/infra")
	public String infraok() throws NamingException{
		return "infra-ok";
	}	
}