/**
 * 
 */
package br.com.mecanicadoisirmaos.controle.vo;

import java.util.List;

/**
 * @author walmi
 *
 */
public class GrupoServicoVo {

	private Integer idGrupoServico;
	private String nome;
	private ServicoVo servico;
	private List<ServicoVo> listaServicos;
	/**
	 * Respons�vel por retornar o atributo idGrupoServico
	 * @return o idGrupoServico
	 */
	public Integer getIdGrupoServico() {
		return idGrupoServico;
	}
	/**
	 * Respons�vel por atribuir valor ao atributo idGrupoServico
	 * @param idGrupoServico para o atributo idGrupoServico
	 */
	public void setIdGrupoServico(Integer idGrupoServico) {
		this.idGrupoServico = idGrupoServico;
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
	 * Respons�vel por retornar o atributo nome
	 * @return o nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * Respons�vel por atribuir valor ao atributo nome
	 * @param nome para o atributo nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
}
