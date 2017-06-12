package br.com.mecanicadoisirmaos.controle.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.mecanicadoisirmaos.controle.business.EmpresaBusiness;
import br.com.mecanicadoisirmaos.controle.util.Util;
import br.com.mecanicadoisirmaos.controle.vo.EmpresaVo;
import br.com.mecanicadoisirmaos.controle.vo.PessoaVo;

@Controller
@RequestMapping("/empresa")
public class EmpresaController {
	
private Logger LOGGER = Logger.getLogger(EmpresaController.class);
	
	private EmpresaVo empresaOriginal;
	
	@Autowired
	private EmpresaBusiness empresaBusiness;
	
	/*LINKS*/
	@RequestMapping("/cadastrar")
	public ModelAndView cadastraEmpresa(){
		ModelAndView mv = getRetorno("empresa/empresa-cadastrar");
		mv.addObject("funcao", "Cadastrar");
		mv.addObject("empresaVo", new EmpresaVo());
		return mv;
	}
	
	@RequestMapping("/consultar")
	public ModelAndView listarEmpresas(){
		ModelAndView mv = getRetorno("empresa/empresa-consultar");
		try{
			mv.addObject("listaEmpresas", empresaBusiness.listarEmpresas(null));
			
		}catch (Exception e){
			LOGGER.error("Erro ao listar os empresas: " + e);
			mv.addObject("erro", "Ocorreu um erro interno!");
		}
		return mv;
	}

	@RequestMapping("/filtrar")
	public ModelAndView filtrar(EmpresaVo emp){
		List<EmpresaVo> listaEmpresas = null;
		ModelAndView mv = getRetorno("empresa/empresa-consultar");
		if(emp.getNomeFantasia()!= null){
			listaEmpresas = carregarEmpresas(emp);
		}else{
			listaEmpresas = carregarEmpresas(null);
		}
		mv.addObject("listaEmpresas", listaEmpresas);
		mv.addObject("empresaVo", emp);
		return mv;
	}
	
	@RequestMapping("/visualizarAlterar")
	public ModelAndView visualizarAlterar(EmpresaVo empresa){
		ModelAndView mv = getRetorno("empresa/empresa-alterar");
		empresaOriginal = consultarEmpresaPorId(empresa.getIdPessoa());
		mv.addObject("empresaVo", empresaOriginal);
		mv.addObject("funcao", "Alterar");
		return mv;
	}
	

	@RequestMapping("/visualizar")
	public ModelAndView visualizar(EmpresaVo empresa){
		ModelAndView mv = getRetorno("empresa/empresa-visualizar");
		mv.addObject("empresaVo", consultarEmpresaPorId(empresa.getIdPessoa()));
		mv.addObject("funcao", "Visualizar");
		return mv;
	}

	/*Ações*/
	@RequestMapping("/inserirEmpresa")
	public ModelAndView inserirEmpresa(EmpresaVo empresa, final RedirectAttributes redirectAtributes){
		ModelAndView mv = null;
		try{
			if(empresaBusiness.inserirEmpresa(empresa)){
				mv = new ModelAndView("redirect:consultar");
				redirectAtributes.addFlashAttribute("sucesso", "O Empresa "+ empresa.getNomeFantasia() +" foi cadastrado com sucesso!");
			}else{
				mv = getRetorno("empresa/empresa-cadastrar");
				mv.addObject("funcao", "Cadastrar");
				mv.addObject("erro", "Já existe um empresa cadastrado com o nome "+ empresa.getNomeFantasia());
				Util.limparListaNullListTelefone(empresa.getListaTelefones());
				mv.addObject("empresaVo", empresa);
			}
		}catch (Exception e){
			LOGGER.error("Erro na inclusão do empresa: " + e);
		}
	
		return mv;
	}
	
	@RequestMapping("/alterarEmpresa")
	public ModelAndView alterarEmpresa(EmpresaVo empresa, final RedirectAttributes redirectAtributes){
		ModelAndView mv = null;
		try{
			if(empresaBusiness.alterarEmpresa(empresa, empresaOriginal)){
				mv = new ModelAndView("redirect:consultar");
				redirectAtributes.addFlashAttribute("sucesso", "Serviço alterado com sucesso!");
			}else{
				mv = getRetorno("empresa/empresa-alterar");
				mv.addObject("funcao", "Alterar");
				mv.addObject("erro", "Já existe um empresa cadastrado com o nome "+ empresa.getNomeFantasia());
				Util.limparListaNullListTelefone(empresa.getListaTelefones());
				mv.addObject("empresaVo", empresa);
			}
		}catch(Exception e){
			LOGGER.error("Erro na alteração do Empresa: " + e);
		}
		return mv;
	}
	
	@RequestMapping("/excluirEmpresa")
	public ModelAndView excluirEmpresa(Integer id, HttpServletResponse response, RedirectAttributes redirectAtributes){
		try{
			EmpresaVo empresa = new EmpresaVo();
			empresa.setIdPessoa(id);
			if(empresaBusiness.excluirEmpresa(empresa)){
				redirectAtributes.addAttribute("sucesso", "Empresa foi excluído com sucesso!");
			}
		}catch(Exception e){
			LOGGER.error("Erro na exclusão do Empresa: " + e);
		}
		redirectAtributes.addFlashAttribute("sucesso", "Empresa removido com sucesso!");
		return new ModelAndView("redirect:consultar");
	}
	
	@RequestMapping("/ativarDesativarEmpresa")
	public ModelAndView ativarDesativarEmpresa(Integer id, String funcao, RedirectAttributes redirectAtributes){
		try{
			PessoaVo pessoa = new PessoaVo();
			pessoa.setIdPessoa(id);
			if(empresaBusiness.ativarDesativarEmpresa(pessoa, funcao)){
				redirectAtributes.addFlashAttribute("sucesso", "Sucesso ao " + funcao + " o Empresa" );				
			}else{
				redirectAtributes.addFlashAttribute("error", "Falha ao tentar " + funcao + " o Empresa");
			}
		}catch(Exception e){
			LOGGER.error("Erro ao ativar desativar o Empresa: " + e);
		}
		return new ModelAndView("redirect:consultar");
	}
	
	public List<EmpresaVo> carregarEmpresas(EmpresaVo emp){
		List<EmpresaVo> lista = null;
		try{
			lista = empresaBusiness.listarEmpresas(emp);
		}catch (Exception e){
			LOGGER.error("Erro na consulta do empresa: " + e);
		}
		return lista;
	}
	
	private EmpresaVo consultarEmpresaPorId(Integer idPessoa) {
		EmpresaVo emp = null;
		try{
			emp = empresaBusiness.consultarEmpresaPorId(idPessoa);
		}catch(Exception e){
			LOGGER.error("Erro na consulta do Empresa " + e);
		}
		return emp;
	}
	private ModelAndView getRetorno(String pagRetorno){
		ModelAndView mv = new ModelAndView(pagRetorno);
		mv.addObject("pagina", "empresa");
		return mv;
	}
}
