package br.com.mecanicadoisirmaos.controle.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.mecanicadoisirmaos.controle.business.ProfissionalBusiness;
import br.com.mecanicadoisirmaos.controle.util.Util;
import br.com.mecanicadoisirmaos.controle.vo.PessoaFisicaVo;
import br.com.mecanicadoisirmaos.controle.vo.PessoaVo;
import br.com.mecanicadoisirmaos.controle.vo.ProfissionalVo;

@Controller
@RequestMapping("/profissional")
public class ProfissionalController {

	private Logger LOGGER = Logger.getLogger(ProfissionalController.class);
	
	@Autowired
	private ProfissionalBusiness profissionalBusiness;
	
	private PessoaFisicaVo profissionalOriginal;
	
	/*LINKS*/
	@RequestMapping("/cadastrar")
	public ModelAndView cadastraProfissional(){
		ModelAndView mv = getRetorno("profissional/profissional-cadastrar");
		mv.addObject("funcao", "Cadastrar");
		mv.addObject("profissionalVo", new ProfissionalVo());
		return mv;
	}
	
	@RequestMapping("/consultar")
	public ModelAndView listarProfissionais(){
		ModelAndView mv = getRetorno("profissional/profissional-consultar");
		try{
			mv.addObject("listaProfissionais", profissionalBusiness.listarProfissionais(null));
		}catch (Exception e){
			LOGGER.error("Erro ao listar os profissionais: " + e);
		}
		return mv;
	}

	@RequestMapping("/filtrar")
	public ModelAndView filtrar(PessoaFisicaVo pf){
		List<PessoaFisicaVo> listaProfissionais = null;
		ModelAndView mv = getRetorno("profissional/profissional-consultar");
		if(pf.getNome()!= null){
			listaProfissionais = carregarProfissionais(pf);
		}else{
			listaProfissionais = carregarProfissionais(null);
		}
		mv.addObject("listaProfissionais", listaProfissionais);
		mv.addObject("profissionalVo", pf);
		return mv;
	}
	
	@RequestMapping("/visualizarAlterar")
	public ModelAndView visualizarAlterar(ProfissionalVo profissional){
		ModelAndView mv = getRetorno("profissional/profissional-alterar");
		profissionalOriginal = consultarProfissionalPorId(profissional.getIdPessoa());
		mv.addObject("profissionalVo", profissionalOriginal);
		mv.addObject("funcao", "Alterar");
		return mv;
	}
	
	@RequestMapping("/visualizar")
	public ModelAndView visualizar(ProfissionalVo profissional){
		ModelAndView mv = getRetorno("profissional/profissional-visualizar");
		mv.addObject("profissionalVo", consultarProfissionalPorId(profissional.getIdPessoa()));
		mv.addObject("funcao", "Visualizar");
		return mv;
	}

	/*Ações*/
	@RequestMapping("/inserirProfissional")
	public ModelAndView inserirProfissional(ProfissionalVo profissional, final RedirectAttributes redirectAtributes){
		ModelAndView mv = null;
		try{
			if(profissionalBusiness.inserirProfissional(profissional)){
				mv = new ModelAndView("redirect:consultar");
				redirectAtributes.addFlashAttribute("sucesso", "O Profissional "+ profissional.getNome() +" foi cadastrado com sucesso!");
			}else{
				mv = getRetorno("profissional/profissional-cadastrar");
				mv.addObject("funcao", "Cadastrar");
				mv.addObject("erro", "Já existe um profissional cadastrado com o nome "+ profissional.getNome());
				profissional.setNascimento(Util.formatarData(profissional.getDtNascimento()));
				Util.limparListaNullListTelefone(profissional.getListaTelefones());
				mv.addObject("profissionalVo", profissional);
			}
		}catch (Exception e){
			LOGGER.error("Erro na inclusão do profissional: " + e);
		}
	
		return mv;
	}
	
	@RequestMapping("/alterarProfissional")
	public ModelAndView alterarProfissional(ProfissionalVo profissional, final RedirectAttributes redirectAtributes){
		ModelAndView mv = null;
		try{
			if(profissionalBusiness.alterarProfissional(profissional, profissionalOriginal)){
				mv = new ModelAndView("redirect:consultar");
				redirectAtributes.addFlashAttribute("sucesso", "Serviço alterado com sucesso!");
			}else{
				mv = getRetorno("profissional/profissional-alterar");
				mv.addObject("funcao", "Alterar");
				mv.addObject("erro", "Já existe um profissional cadastrado com o nome "+ profissional.getNome());
				profissional.setNascimento(Util.formatarData(profissional.getDtNascimento()));
				Util.limparListaNullListTelefone(profissional.getListaTelefones());
				mv.addObject("profissionalVo", profissional);
			}
		}catch(Exception e){
			LOGGER.error("Erro na alteração do Profissional: " + e);
		}
		return mv;
	}
	
	@RequestMapping("/excluirProfissional")
	public ModelAndView excluirProfissional(Integer id, HttpServletResponse response, RedirectAttributes redirectAtributes){
		try{
			ProfissionalVo profissional = new ProfissionalVo();
			profissional.setIdPessoa(id);
			if(profissionalBusiness.excluirProfissional(profissional)){
				redirectAtributes.addAttribute("sucesso", "Profissional foi excluído com sucesso!");
			}
		}catch(Exception e){
			LOGGER.error("Erro na exclusão do Profissional: " + e);
		}
		redirectAtributes.addFlashAttribute("sucesso", "Profissional removido com sucesso!");
		return new ModelAndView("redirect:consultar");
	}
	
	@RequestMapping("/ativarDesativarProfissional")
	public ModelAndView ativarDesativarProfissional(Integer id, String funcao, RedirectAttributes redirectAtributes){
		try{
			PessoaVo pessoa = new PessoaVo();
			pessoa.setIdPessoa(id);
			if(profissionalBusiness.ativarDesativarProfissional(pessoa, funcao)){
				redirectAtributes.addFlashAttribute("sucesso", "Sucesso ao " + funcao + " o Profissional" );				
			}else{
				redirectAtributes.addFlashAttribute("error", "Falha ao tentar " + funcao + " o Profissional");
			}
		}catch(Exception e){
			LOGGER.error("Erro ao ativar desativar o Profissional: " + e);
		}
		return new ModelAndView("redirect:consultar");
	}
	
	public List<PessoaFisicaVo> carregarProfissionais(PessoaFisicaVo pf){
		List<PessoaFisicaVo> lista = null;
		try{
			lista = profissionalBusiness.listarProfissionais(pf);
		}catch (Exception e){
			LOGGER.error("Erro na consulta do profissional: " + e);
		}
		return lista;
	}
	
	private PessoaFisicaVo consultarProfissionalPorId(Integer idPessoa) {
		PessoaFisicaVo pf = null;
		try{
			pf = profissionalBusiness.consultarProfissionalPorId(idPessoa);
		}catch(Exception e){
			LOGGER.error("Erro na consulta do Profissional " + e);
		}
		return pf;
	}

	private ModelAndView getRetorno(String pagRetorno){
		ModelAndView mv = new ModelAndView(pagRetorno);
		mv.addObject("pagina", "profissional");
		return mv;
	}
}
