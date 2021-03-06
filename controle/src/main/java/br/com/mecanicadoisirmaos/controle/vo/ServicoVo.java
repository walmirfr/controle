/**
 * 
 */
package br.com.mecanicadoisirmaos.controle.vo;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
/**
 * @author walmi
 *
 */
public class ServicoVo {

	private Integer idServico;
	
	@NotNull(message="servico.nome.obrigatorio")@Size(min = 5, message = "Tamanho mínimo de 5 caracteres.")
	private String nome;
	
	private Integer tempoEstimado;
	
	private String descricao;
	private Boolean ativo;
	private Boolean vinculo;
	private Double preco;
	private GrupoServicoVo grupoServico;
	private ManutencaoVo manutencao;
	private List<ManutencaoVo> listaManutencoes;
	/**
	 * Responsável por retornar o atributo idServico
	 * @return o idServico
	 */
	public Integer getIdServico() {
		return idServico;
	}
	/**
	 * Responsável por atribuir valor ao atributo idServico
	 * @param idServico para o atributo idServico
	 */
	public void setIdServico(Integer idServico) {
		this.idServico = idServico;
	}
	/**
	 * Responsável por retornar o atributo preco
	 * @return o preco
	 */
	public Double getPreco() {
		return preco;
	}
	/**
	 * Responsável por atribuir valor ao atributo preco
	 * @param preco para o atributo preco
	 */
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	/**
	 * Responsável por retornar o atributo tempoEstivamo
	 * @return o tempoEstivamo
	 */
	public Integer getTempoEstimado() {
		return tempoEstimado;
	}
	/**
	 * Responsável por atribuir valor ao atributo tempoEstivamo
	 * @param tempoEstivamo para o atributo tempoEstivamo
	 */
	public void setTempoEstimado(Integer tempoEstimado) {
		this.tempoEstimado = tempoEstimado;
	}
	/**
	 * Responsável por retornar o atributo nome
	 * @return o nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * Responsável por atribuir valor ao atributo nome
	 * @param nome para o atributo nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * Responsável por retornar o atributo descricao
	 * @return o descricao
	 */
	public String getDescricao() {
		return descricao;
	}
	/**
	 * Responsável por atribuir valor ao atributo descricao
	 * @param descricao para o atributo descricao
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	/**
	 * Responsável por retornar o atributo ativo
	 * @return o ativo
	 */
	public Boolean getAtivo() {
		return ativo;
	}
	/**
	 * Responsável por atribuir valor ao atributo ativo
	 * @param ativo para o atributo ativo
	 */
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	/**
	 * Responsável por retornar o atributo grupoServico
	 * @return o grupoServico
	 */
	public GrupoServicoVo getGrupoServico() {
		return grupoServico;
	}
	/**
	 * Responsável por atribuir valor ao atributo grupoServico
	 * @param grupoServico para o atributo grupoServico
	 */
	public void setGrupoServico(GrupoServicoVo grupoServico) {
		this.grupoServico = grupoServico;
	}
	/**
	 * Responsável por retornar o atributo manutencao
	 * @return o manutencao
	 */
	public ManutencaoVo getManutencao() {
		return manutencao;
	}
	/**
	 * Responsável por atribuir valor ao atributo manutencao
	 * @param manutencao para o atributo manutencao
	 */
	public void setManutencao(ManutencaoVo manutencao) {
		this.manutencao = manutencao;
	}
	/**
	 * Responsável por retornar o atributo listaManutencoes
	 * @return o listaManutencoes
	 */
	public List<ManutencaoVo> getListaManutencoes() {
		return listaManutencoes;
	}
	/**
	 * Responsável por atribuir valor ao atributo listaManutencoes
	 * @param listaManutencoes para o atributo listaManutencoes
	 */
	public void setListaManutencoes(List<ManutencaoVo> listaManutencoes) {
		this.listaManutencoes = listaManutencoes;
	}
	/**
	 * Responsável por retornar o atributo vinculo
	 * @return o vinculo
	 */
	public Boolean getVinculo() {
		return vinculo;
	}
	/**
	 * Responsável por atribuir valor ao atributo vinculo
	 * @param vinculo para o atributo vinculo
	 */
	public void setVinculo(Boolean vinculo) {
		this.vinculo = vinculo;
	}
}
