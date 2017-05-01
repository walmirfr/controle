package br.com.mecanicadoisirmaos.controle.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.mecanicadoisirmaos.controle.business.ClienteBusiness;
import br.com.mecanicadoisirmaos.controle.business.MarcaBusiness;
import br.com.mecanicadoisirmaos.controle.business.ModeloBusiness;
import br.com.mecanicadoisirmaos.controle.business.VeiculoBusiness;
import br.com.mecanicadoisirmaos.controle.vo.ClienteVo;
import br.com.mecanicadoisirmaos.controle.vo.MarcaVo;
import br.com.mecanicadoisirmaos.controle.vo.ModeloVo;
import br.com.mecanicadoisirmaos.controle.vo.VeiculoVo;

@Controller
@RequestMapping("/veiculo")
public class VeiculoController {

	private Logger LOGGER = Logger.getLogger(VeiculoController.class);
	
	@Autowired
	private VeiculoBusiness veiculoBusiness;
	
	@Autowired
	private MarcaBusiness marcaBusiness;
	
	@Autowired
	private ModeloBusiness modeloBusiness;
	
	@Autowired
	private ClienteBusiness clienteBusiness;
	
	/*LINKS*/
	@RequestMapping("/cadastrar")
	public ModelAndView cadastrarVeiculo(){
		ModelAndView mv = getRetorno("veiculo/veiculo-cadastrar");
		mv.addObject("funcao", "Cadastrar");
		try{
			mv.addObject("listaModelos",listarModelosPorMarca(1));
			mv.addObject("listaMarcas", listarMarcas());
			mv.addObject("listaClientes", listarClientesPart());
		}catch(Exception e){
			LOGGER.error("Error ao listar Marcas: "+ e);
		}
		return mv;
	}
	
	@RequestMapping("/consultar")
	public ModelAndView listarVeiculos(){
		ModelAndView mv = getRetorno("veiculo/veiculo-consultar");
		try{
			mv.addObject("listaVeiculos", veiculoBusiness.listarVeiculosPart());
		}catch(Exception e){
			LOGGER.error("Erro ao listar os Veiculos: "+ e);
		}
		return mv;
	}
	
	/*Ações*/
	@RequestMapping("/inserirVeiculo")
	public ModelAndView inserirVeiculo(VeiculoVo veiculo){
		try{
			veiculoBusiness.inserirVeiculo(veiculo);
		}catch(Exception e){
			LOGGER.error("Erro ao inserir na Entidade Veiculo: " + e);
		}
		return new ModelAndView("redirect:consultar");
	}
	
	@RequestMapping("/inserirMarca")
	public ModelAndView inserirMarca(MarcaVo marca){
		try{
			marcaBusiness.inserirMarca(marca);
			return cadastrarVeiculo();
		}catch(Exception e){
			LOGGER.error("Erro ao inserir a Marca: "+ e);
		}
		return null;
	}
	
	@RequestMapping("/inserirModelo")
	public ModelAndView inserirModelo(ModeloVo modelo){
		try{
			modeloBusiness.inserirModelo(modelo);
			return cadastrarVeiculo();
		}catch(Exception e){
			LOGGER.error("Erro ao inserir Modelo: "+ e);
		}
		return null;
	}
	
	@RequestMapping("/listarModelosPorMarca")
	private @ResponseBody List<ModeloVo> listarModelosPorMarca(Integer idMarca) throws Exception{
		return modeloBusiness.listarModelosPorMarca(idMarca);
	}
	
	/*Funções*/
	private ModelAndView getRetorno(String pagRetorno){
		ModelAndView mv = new ModelAndView(pagRetorno);
		mv.addObject("pagina", "veiculo");
		return mv;
	}
	
	
	private List<MarcaVo> listarMarcas() throws Exception{
		return marcaBusiness.listarMarcas();
	}
	private List<ClienteVo> listarClientesPart() throws Exception{
		return clienteBusiness.listarClientesPart();
	}
}