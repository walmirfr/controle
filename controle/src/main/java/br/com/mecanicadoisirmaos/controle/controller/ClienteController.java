package br.com.mecanicadoisirmaos.controle.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.mecanicadoisirmaos.controle.business.ClienteBusiness;
import br.com.mecanicadoisirmaos.controle.util.Util;
import br.com.mecanicadoisirmaos.controle.vo.ClienteVo;
import br.com.mecanicadoisirmaos.controle.vo.PessoaFisicaVo;
import br.com.mecanicadoisirmaos.controle.vo.PessoaVo;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
	
	private Logger LOGGER = Logger.getLogger(ClienteController.class);
	
	private PessoaFisicaVo clienteOriginal;
	
	@Autowired
	private ClienteBusiness clienteBusiness;
	
	/*LINKS*/
	@RequestMapping("/cadastrar")
	public ModelAndView cadastraCliente(){
		ModelAndView mv = getRetorno("cliente/cliente-cadastrar");
		mv.addObject("funcao", "Cadastrar");
		mv.addObject("clienteVo", new ClienteVo());
		return mv;
	}
	
	@RequestMapping("/consultar")
	public ModelAndView listarClientes(){
		ModelAndView mv = getRetorno("cliente/cliente-consultar");
		try{
			mv.addObject("listaClientes", clienteBusiness.listarClientes(null));
		}catch (Exception e){
			LOGGER.error("Erro ao listar os clientes: " + e);
		}
		return mv;
	}

	@RequestMapping("/filtrar")
	public ModelAndView filtrar(PessoaFisicaVo pf){
		List<PessoaFisicaVo> listaClientes = null;
		ModelAndView mv = getRetorno("cliente/cliente-consultar");
		if(pf.getNome()!= null){
			listaClientes = carregarClientes(pf);
		}else{
			listaClientes = carregarClientes(null);
		}
		mv.addObject("listaClientes", listaClientes);
		mv.addObject("clienteVo", pf);
		return mv;
	}
	
	@RequestMapping("/visualizarAlterar")
	public ModelAndView visualizarAlterar(ClienteVo cliente){
		ModelAndView mv = getRetorno("cliente/cliente-alterar");
		clienteOriginal = consultarClientePorId(cliente.getIdPessoa());
		mv.addObject("clienteVo", clienteOriginal);
		mv.addObject("funcao", "Alterar");
		return mv;
	}
	

	@RequestMapping("/visualizar")
	public ModelAndView visualizar(ClienteVo cliente){
		ModelAndView mv = getRetorno("cliente/cliente-visualizar");
		mv.addObject("clienteVo", consultarClientePorId(cliente.getIdPessoa()));
		mv.addObject("funcao", "Visualizar");
		return mv;
	}

	/*Ações*/
	@RequestMapping("/inserirCliente")
	public ModelAndView inserirCliente(ClienteVo cliente, final RedirectAttributes redirectAtributes){
		ModelAndView mv = null;
		try{
			if(clienteBusiness.inserirCliente(cliente)){
				mv = new ModelAndView("redirect:consultar");
				redirectAtributes.addFlashAttribute("sucesso", "O Cliente "+ cliente.getNome() +" foi cadastrado com sucesso!");
			}else{
				mv = getRetorno("cliente/cliente-cadastrar");
				mv.addObject("funcao", "Cadastrar");
				mv.addObject("erro", "Já existe um cliente cadastrado com o nome "+ cliente.getNome());
				cliente.setNascimento(Util.formatarData(cliente.getDtNascimento()));
				Util.limparListaNullListTelefone(cliente.getListaTelefones());
				mv.addObject("clienteVo", cliente);
			}
		}catch (Exception e){
			LOGGER.error("Erro na inclusão do cliente: " + e);
		}
	
		return mv;
	}
	
	@RequestMapping("/alterarCliente")
	public ModelAndView alterarCliente(ClienteVo cliente, final RedirectAttributes redirectAtributes){
		ModelAndView mv = null;
		try{
			if(clienteBusiness.alterarCliente(cliente, clienteOriginal)){
				mv = new ModelAndView("redirect:consultar");
				redirectAtributes.addFlashAttribute("sucesso", "Serviço alterado com sucesso!");
			}else{
				mv = getRetorno("cliente/cliente-alterar");
				mv.addObject("funcao", "Alterar");
				mv.addObject("erro", "Já existe um cliente cadastrado com o nome "+ cliente.getNome());
				cliente.setNascimento(Util.formatarData(cliente.getDtNascimento()));
				Util.limparListaNullListTelefone(cliente.getListaTelefones());
				mv.addObject("clienteVo", cliente);
			}
		}catch(Exception e){
			LOGGER.error("Erro na alteração do Cliente: " + e);
		}
		return mv;
	}
	
	@RequestMapping("/excluirCliente")
	public ModelAndView excluirCliente(Integer id, HttpServletResponse response, RedirectAttributes redirectAtributes){
		try{
			ClienteVo cliente = new ClienteVo();
			cliente.setIdPessoa(id);
			if(clienteBusiness.excluirCliente(cliente)){
				redirectAtributes.addAttribute("sucesso", "Cliente foi excluído com sucesso!");
			}
		}catch(Exception e){
			LOGGER.error("Erro na exclusão do Cliente: " + e);
		}
		redirectAtributes.addFlashAttribute("sucesso", "Cliente removido com sucesso!");
		return new ModelAndView("redirect:consultar");
	}
	
	@RequestMapping("/ativarDesativarCliente")
	public ModelAndView ativarDesativarCliente(Integer id, String funcao, RedirectAttributes redirectAtributes){
		try{
			PessoaVo pessoa = new PessoaVo();
			pessoa.setIdPessoa(id);
			if(clienteBusiness.ativarDesativarCliente(pessoa, funcao)){
				redirectAtributes.addFlashAttribute("sucesso", "Sucesso ao " + funcao + " o Cliente" );				
			}else{
				redirectAtributes.addFlashAttribute("error", "Falha ao tentar " + funcao + " o Cliente");
			}
		}catch(Exception e){
			LOGGER.error("Erro ao ativar desativar o Cliente: " + e);
		}
		return new ModelAndView("redirect:consultar");
	}
	
	public List<PessoaFisicaVo> carregarClientes(PessoaFisicaVo pf){
		List<PessoaFisicaVo> lista = null;
		try{
			lista = clienteBusiness.listarClientes(pf);
		}catch (Exception e){
			LOGGER.error("Erro na consulta do cliente: " + e);
		}
		return lista;
	}
	
	private PessoaFisicaVo consultarClientePorId(Integer idPessoa) {
		PessoaFisicaVo pf = null;
		try{
			pf = clienteBusiness.consultarClientePorId(idPessoa);
		}catch(Exception e){
			LOGGER.error("Erro na consulta do Cliente " + e);
		}
		return pf;
	}
	
	private ModelAndView getRetorno(String pagRetorno){
		ModelAndView mv = new ModelAndView(pagRetorno);
		mv.addObject("pagina", "cliente");
		return mv;
	}
}
