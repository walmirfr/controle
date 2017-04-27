/**
 * 
 */
package br.com.mecanicadoisirmaos.controle.vo;

import java.util.Date;
import java.util.List;

/**
 * @author walmi
 *
 */
public class ManutencaoVo {
	
	private Integer idManutencao;
	private Date dtEntrada;
	private Date dtSaida;
	private Integer km;
	private String observacao;
	private VeiculoVo veiculo;
	private ServicoVo servico;
	private PessoaVo proprietario;
	private ProfissionalVo mecanico;
	private List<ServicoVo> listaServicos;
	private List<ProfissionalVo> listaMecanicos;
	/**
	 * Responsável por retornar o atributo idManutencao
	 * @return o idManutencao
	 */
	public Integer getIdManutencao() {
		return idManutencao;
	}
	/**
	 * Responsável por atribuir valor ao atributo idManutencao
	 * @param idManutencao para o atributo idManutencao
	 */
	public void setIdManutencao(Integer idManutencao) {
		this.idManutencao = idManutencao;
	}
	/**
	 * Responsável por retornar o atributo dtEntrada
	 * @return o dtEntrada
	 */
	public Date getDtEntrada() {
		return dtEntrada;
	}
	/**
	 * Responsável por atribuir valor ao atributo dtEntrada
	 * @param dtEntrada para o atributo dtEntrada
	 */
	public void setDtEntrada(Date dtEntrada) {
		this.dtEntrada = dtEntrada;
	}
	/**
	 * Responsável por retornar o atributo dtSaida
	 * @return o dtSaida
	 */
	public Date getDtSaida() {
		return dtSaida;
	}
	/**
	 * Responsável por atribuir valor ao atributo dtSaida
	 * @param dtSaida para o atributo dtSaida
	 */
	public void setDtSaida(Date dtSaida) {
		this.dtSaida = dtSaida;
	}
	/**
	 * Responsável por retornar o atributo km
	 * @return o km
	 */
	public Integer getKm() {
		return km;
	}
	/**
	 * Responsável por atribuir valor ao atributo km
	 * @param km para o atributo km
	 */
	public void setKm(Integer km) {
		this.km = km;
	}
	/**
	 * Responsável por retornar o atributo observacao
	 * @return o observacao
	 */
	public String getObservacao() {
		return observacao;
	}
	/**
	 * Responsável por atribuir valor ao atributo observacao
	 * @param observacao para o atributo observacao
	 */
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	/**
	 * Responsável por retornar o atributo veiculo
	 * @return o veiculo
	 */
	public VeiculoVo getVeiculo() {
		return veiculo;
	}
	/**
	 * Responsável por atribuir valor ao atributo veiculo
	 * @param veiculo para o atributo veiculo
	 */
	public void setVeiculo(VeiculoVo veiculo) {
		this.veiculo = veiculo;
	}
	/**
	 * Responsável por retornar o atributo servico
	 * @return o servico
	 */
	public ServicoVo getServico() {
		return servico;
	}
	/**
	 * Responsável por atribuir valor ao atributo servico
	 * @param servico para o atributo servico
	 */
	public void setServico(ServicoVo servico) {
		this.servico = servico;
	}
	/**
	 * Responsável por retornar o atributo proprietario
	 * @return o proprietario
	 */
	public PessoaVo getProprietario() {
		return proprietario;
	}
	/**
	 * Responsável por atribuir valor ao atributo proprietario
	 * @param proprietario para o atributo proprietario
	 */
	public void setProprietario(PessoaVo proprietario) {
		this.proprietario = proprietario;
	}
	/**
	 * Responsável por retornar o atributo mecanico
	 * @return o mecanico
	 */
	public ProfissionalVo getMecanico() {
		return mecanico;
	}
	/**
	 * Responsável por atribuir valor ao atributo mecanico
	 * @param mecanico para o atributo mecanico
	 */
	public void setMecanico(ProfissionalVo mecanico) {
		this.mecanico = mecanico;
	}
	/**
	 * Responsável por retornar o atributo listaServicos
	 * @return o listaServicos
	 */
	public List<ServicoVo> getListaServicos() {
		return listaServicos;
	}
	/**
	 * Responsável por atribuir valor ao atributo listaServicos
	 * @param listaServicos para o atributo listaServicos
	 */
	public void setListaServicos(List<ServicoVo> listaServicos) {
		this.listaServicos = listaServicos;
	}
	/**
	 * Responsável por retornar o atributo listaMecanicos
	 * @return o listaMecanicos
	 */
	public List<ProfissionalVo> getListaMecanicos() {
		return listaMecanicos;
	}
	/**
	 * Responsável por atribuir valor ao atributo listaMecanicos
	 * @param listaMecanicos para o atributo listaMecanicos
	 */
	public void setListaMecanicos(List<ProfissionalVo> listaMecanicos) {
		this.listaMecanicos = listaMecanicos;
	}
	
}
