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
	 * Respons�vel por retornar o atributo idManutencao
	 * @return o idManutencao
	 */
	public Integer getIdManutencao() {
		return idManutencao;
	}
	/**
	 * Respons�vel por atribuir valor ao atributo idManutencao
	 * @param idManutencao para o atributo idManutencao
	 */
	public void setIdManutencao(Integer idManutencao) {
		this.idManutencao = idManutencao;
	}
	/**
	 * Respons�vel por retornar o atributo dtEntrada
	 * @return o dtEntrada
	 */
	public Date getDtEntrada() {
		return dtEntrada;
	}
	/**
	 * Respons�vel por atribuir valor ao atributo dtEntrada
	 * @param dtEntrada para o atributo dtEntrada
	 */
	public void setDtEntrada(Date dtEntrada) {
		this.dtEntrada = dtEntrada;
	}
	/**
	 * Respons�vel por retornar o atributo dtSaida
	 * @return o dtSaida
	 */
	public Date getDtSaida() {
		return dtSaida;
	}
	/**
	 * Respons�vel por atribuir valor ao atributo dtSaida
	 * @param dtSaida para o atributo dtSaida
	 */
	public void setDtSaida(Date dtSaida) {
		this.dtSaida = dtSaida;
	}
	/**
	 * Respons�vel por retornar o atributo km
	 * @return o km
	 */
	public Integer getKm() {
		return km;
	}
	/**
	 * Respons�vel por atribuir valor ao atributo km
	 * @param km para o atributo km
	 */
	public void setKm(Integer km) {
		this.km = km;
	}
	/**
	 * Respons�vel por retornar o atributo observacao
	 * @return o observacao
	 */
	public String getObservacao() {
		return observacao;
	}
	/**
	 * Respons�vel por atribuir valor ao atributo observacao
	 * @param observacao para o atributo observacao
	 */
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	/**
	 * Respons�vel por retornar o atributo veiculo
	 * @return o veiculo
	 */
	public VeiculoVo getVeiculo() {
		return veiculo;
	}
	/**
	 * Respons�vel por atribuir valor ao atributo veiculo
	 * @param veiculo para o atributo veiculo
	 */
	public void setVeiculo(VeiculoVo veiculo) {
		this.veiculo = veiculo;
	}
	/**
	 * Respons�vel por retornar o atributo servico
	 * @return o servico
	 */
	public ServicoVo getServico() {
		return servico;
	}
	/**
	 * Respons�vel por atribuir valor ao atributo servico
	 * @param servico para o atributo servico
	 */
	public void setServico(ServicoVo servico) {
		this.servico = servico;
	}
	/**
	 * Respons�vel por retornar o atributo proprietario
	 * @return o proprietario
	 */
	public PessoaVo getProprietario() {
		return proprietario;
	}
	/**
	 * Respons�vel por atribuir valor ao atributo proprietario
	 * @param proprietario para o atributo proprietario
	 */
	public void setProprietario(PessoaVo proprietario) {
		this.proprietario = proprietario;
	}
	/**
	 * Respons�vel por retornar o atributo mecanico
	 * @return o mecanico
	 */
	public ProfissionalVo getMecanico() {
		return mecanico;
	}
	/**
	 * Respons�vel por atribuir valor ao atributo mecanico
	 * @param mecanico para o atributo mecanico
	 */
	public void setMecanico(ProfissionalVo mecanico) {
		this.mecanico = mecanico;
	}
	/**
	 * Respons�vel por retornar o atributo listaServicos
	 * @return o listaServicos
	 */
	public List<ServicoVo> getListaServicos() {
		return listaServicos;
	}
	/**
	 * Respons�vel por atribuir valor ao atributo listaServicos
	 * @param listaServicos para o atributo listaServicos
	 */
	public void setListaServicos(List<ServicoVo> listaServicos) {
		this.listaServicos = listaServicos;
	}
	/**
	 * Respons�vel por retornar o atributo listaMecanicos
	 * @return o listaMecanicos
	 */
	public List<ProfissionalVo> getListaMecanicos() {
		return listaMecanicos;
	}
	/**
	 * Respons�vel por atribuir valor ao atributo listaMecanicos
	 * @param listaMecanicos para o atributo listaMecanicos
	 */
	public void setListaMecanicos(List<ProfissionalVo> listaMecanicos) {
		this.listaMecanicos = listaMecanicos;
	}
	
}
