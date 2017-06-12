package br.com.mecanicadoisirmaos.controle.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
	
	/*LINKS*/
	@RequestMapping("/cadastrar")
	public ModelAndView cadastrarServico(){
		ModelAndView mv = getRetorno("servico/servico-cadastrar");
		mv.addObject("listaGrupoServico", listarGrupoServico());
		mv.addObject("servicoVo", new ServicoVo());
		mv.addObject("funcao", "Cadastrar");
		return mv;
	}
	
	@RequestMapping("/inserirGrupoServico")
	public ModelAndView inserirGrupoServico(GrupoServicoVo grupoServicoVo){
		grupoServicoBusiness.cadastrarGrupoServico(grupoServicoVo);
		return cadastrarServico();
	}
	
	@RequestMapping("/alterarServico")
	public ModelAndView alterarServico(ServicoVo servico, final RedirectAttributes redirectAtributes){
		if(servicoBusiness.alterarServico(servico)){
			redirectAtributes.addFlashAttribute("sucesso", "Serviço alterado com sucesso!");
		}
		return new ModelAndView("redirect:consultar");
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
		mv.addObject("listaServicos", carregarServicos(null));
		return mv;
	}
	
	@RequestMapping("/filtrar")
	public ModelAndView listarServicos(ServicoVo servico){
		List<ServicoVo> listaServicos = null;
		ModelAndView mv = getRetorno("servico/servico-consultar");
		if(servico.getNome()!= null){
			listaServicos = carregarServicos(servico);
		}else{
			listaServicos = carregarServicos(null);
		}
		mv.addObject("listaServicos", listaServicos);
		mv.addObject("servicoVo", servico);
		return mv;
	}
	
	@ResponseBody
	@RequestMapping("/carregarServicos")
	public List<ServicoVo> carregarServicos(ServicoVo servico){
		return servicoBusiness.listarServicos(servico);
	}
	
	/*AÇÕES*/
	@RequestMapping("/inserirServico")
	public ModelAndView inserirServico(@Valid ServicoVo servico, final BindingResult result, final RedirectAttributes redirectAtributes){
		/*if(result.hasErrors()){
			redirectAtributes.addFlashAttribute("org.springframework.validation.BindingResult.register", result);
			redirectAtributes.addFlashAttribute("errors", result);
			redirectAtributes.addFlashAttribute("servico", servico);
			return new ModelAndView("redirect:cadastrar");
		}*/
		if(servicoBusiness.inserirServico(servico)){
			redirectAtributes.addFlashAttribute("sucesso", "O Serviço "+ servico.getNome() +" foi cadastrado com sucesso!");
		}
		return new ModelAndView("redirect:consultar");
	}
	
	@RequestMapping("/excluirServico")
	public ModelAndView excluirServico(Integer id, HttpServletResponse response, RedirectAttributes redirectAtributes){
		ServicoVo servico = new ServicoVo();
		servico.setIdServico(id);
		servicoBusiness.deletarServico(servico);
		redirectAtributes.addFlashAttribute("sucesso", "Serviço removido com sucesso!");
		return new ModelAndView("redirect:consultar");
	}
	
	@RequestMapping("/ativarDesativarServico")
	public ModelAndView ativarDesativarServico(Integer id, String funcao, RedirectAttributes redirectAtributes){
		try{
			ServicoVo servico = new ServicoVo();
			servico.setIdServico(id);
			if(servicoBusiness.ativarDesativarServico(servico, funcao)){
				redirectAtributes.addFlashAttribute("sucesso", "Sucesso ao " + funcao + " o Serviço" );				
			}else{
				redirectAtributes.addFlashAttribute("error", "Falha ao tentar " + funcao + " o Serviço");
			}
		}catch(Exception e){
			LOGGER.error("Erro ao ativar desativar o Servico: " + e);
		}
		return new ModelAndView("redirect:consultar");
	}

	@ResponseBody
	@RequestMapping("/carregarListaGrupoServico")
	public List<GrupoServicoVo> carregarListaGrupoServico(){
		return listarGrupoServico();
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