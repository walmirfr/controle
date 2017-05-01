/**
 * 
 */
package br.com.mecanicadoisirmaos.controle.vo;

import java.util.List;

/**
 * @author walmi
 *
 */
public class VeiculoVo {

	private Integer idVeiculo;
	private String cor;
	private Integer ano;
	private String placa;
	private Boolean ativo;
	private String observacao;
	private PessoaVo proprietario;
	private MarcaVo marca;
	private ModeloVo modelo;
	private ManutencaoVo manutencao;
	private List<ManutencaoVo> listaManutencoes;
	/**
	 * Respons�vel por retornar o atributo idVeiculo
	 * @return o idVeiculo
	 */
	public Integer getIdVeiculo() {
		return idVeiculo;
	}
	/**
	 * Respons�vel por atribuir valor ao atributo idVeiculo
	 * @param idVeiculo para o atributo idVeiculo
	 */
	public void setIdVeiculo(Integer idVeiculo) {
		this.idVeiculo = idVeiculo;
	}
	/**
	 * Respons�vel por retornar o atributo cor
	 * @return o cor
	 */
	public String getCor() {
		return cor;
	}
	/**
	 * Respons�vel por atribuir valor ao atributo cor
	 * @param cor para o atributo cor
	 */
	public void setCor(String cor) {
		this.cor = cor;
	}
	/**
	 * Respons�vel por retornar o atributo ano
	 * @return o ano
	 */
	public Integer getAno() {
		return ano;
	}
	/**
	 * Respons�vel por atribuir valor ao atributo ano
	 * @param ano para o atributo ano
	 */
	public void setAno(Integer ano) {
		this.ano = ano;
	}
	/**
	 * Respons�vel por retornar o atributo placa
	 * @return o placa
	 */
	public String getPlaca() {
		return placa;
	}
	/**
	 * Respons�vel por atribuir valor ao atributo placa
	 * @param placa para o atributo placa
	 */
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	/**
	 * Respons�vel por retornar o atributo ativo
	 * @return o ativo
	 */
	public Boolean getAtivo() {
		return ativo;
	}
	/**
	 * Respons�vel por atribuir valor ao atributo ativo
	 * @param ativo para o atributo ativo
	 */
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
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
	 * Respons�vel por retornar o atributo modelo
	 * @return o modelo
	 */
	public ModeloVo getModelo() {
		return modelo;
	}
	/**
	 * Respons�vel por atribuir valor ao atributo modelo
	 * @param modelo para o atributo modelo
	 */
	public void setModelo(ModeloVo modelo) {
		this.modelo = modelo;
	}
	/**
	 * Respons�vel por retornar o atributo manutencao
	 * @return o manutencao
	 */
	public ManutencaoVo getManutencao() {
		return manutencao;
	}
	/**
	 * Respons�vel por atribuir valor ao atributo manutencao
	 * @param manutencao para o atributo manutencao
	 */
	public void setManutencao(ManutencaoVo manutencao) {
		this.manutencao = manutencao;
	}
	/**
	 * Respons�vel por retornar o atributo listaManutencoes
	 * @return o listaManutencoes
	 */
	public List<ManutencaoVo> getListaManutencoes() {
		return listaManutencoes;
	}
	/**
	 * Respons�vel por atribuir valor ao atributo listaManutencoes
	 * @param listaManutencoes para o atributo listaManutencoes
	 */
	public void setListaManutencoes(List<ManutencaoVo> listaManutencoes) {
		this.listaManutencoes = listaManutencoes;
	}
	/**
	 * Respons�vel por retornar o atributo marca
	 * @return o marca
	 */
	public MarcaVo getMarca() {
		return marca;
	}
	/**
	 * Respons�vel por atribuir valor ao atributo marca
	 * @param marca para o atributo marca
	 */
	public void setMarca(MarcaVo marca) {
		this.marca = marca;
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
}
