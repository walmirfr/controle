package br.com.mecanicadoisirmaos.controle.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.mecanicadoisirmaos.controle.business.GrupoServicoBusiness;
import br.com.mecanicadoisirmaos.controle.business.ServicoBusiness;
import br.com.mecanicadoisirmaos.controle.vo.GrupoServicoVo;
import br.com.mecanicadoisirmaos.controle.vo.ServicoVo;

@Controller
@RequestMapping("/servico")
public class ServicoController {

	private final static Logger LOGGER = Logger.getLogger(ServicoController.class);
	
	@Autowired
	private ServicoBusiness servicoBusiness;

	@Autowired
	private GrupoServicoBusiness grupoServicoBusiness;
	/*
	@InitBinder
	public void InitBinder(WebDataBinder binder){
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	    binder.addValidators(new ServicoValidation());
	}*/
	
	/*LINKS*/
	@RequestMapping("/cadastrar")
	public ModelAndView cadastrarServico(){
		ModelAndView mv = getRetorno("servico/servico-cadastrar");
		mv.addObject("listaGrupoServico", listarGrupoServico());
		mv.addObject("funcao", "Cadastrar");
		return mv;
	}
	
	@RequestMapping("/inserirGrupoServico")
	public ModelAndView inserirGrupoServico(GrupoServicoVo grupoServicoVo){
		grupoServicoBusiness.cadastrarGrupoServico(grupoServicoVo);
		return cadastrarServico();
	}
	
	@RequestMapping("/alterarServico")
	public ModelAndView alterarServico(ServicoVo servico){
		System.out.println("");
		if(servicoBusiness.alterarServico(servico)){
			return listarServicos();			
		}
		return cadastrarServico();
	}
	
	@RequestMapping("/visualizar")
	public ModelAndView visualizarServico(ServicoVo servicoVo){
		ModelAndView mv = getRetorno("servico/servico-alterar");
		ServicoVo servico = servicoBusiness.consultarServicoPorId(servicoVo.getIdServico());
		mv.addObject("servicoVo", servico);
		mv.addObject("listaGrupoServico", listarGrupoServico());
		mv.addObject("funcao", "Alterar");
		return mv;
	}
	
	@RequestMapping("/consultar")
	public ModelAndView listarServicos(){
		ModelAndView mv = getRetorno("servico/servico-consultar");
		mv.addObject("listaServicos", servicoBusiness.listarServicos());
		return mv;
	}
	
	/*AÇÕES*/
	@RequestMapping("/inserirServico")
	public ModelAndView inserirServico(@Valid ServicoVo servico, BindingResult result, RedirectAttributes redirectAtributes){
		if(result.hasErrors()){
			return cadastrarServico();
		}
		redirectAtributes.addFlashAttribute("sucesso", "Serviço "+ servico.getNome() +" foi cadastrado com sucesso!");
		servicoBusiness.inserirServico(servico);
		return new ModelAndView("redirect:consultar");
	}
	
	@RequestMapping("/deletarServico")
	public void deletarServico(ServicoVo servico, HttpServletResponse response, RedirectAttributes redirectAtributes){
		servicoBusiness.deletarServico(servico);
		redirectAtributes.addFlashAttribute("sucesso", "Serviço removido com sucesso!");
		response.setStatus(200);
	}
	
	private ModelAndView getRetorno(String pagRetorno){
		ModelAndView mv = new ModelAndView(pagRetorno);
		mv.addObject("pagina", "servico");
		return mv;
	}
	private List<GrupoServicoVo> listarGrupoServico(){
		return grupoServicoBusiness.listarGrupoServico();
	}
}