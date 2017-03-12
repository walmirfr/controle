/**
 * 
 */
package br.com.mecanicadoisirmaos.controle.vo;

import java.util.List;

/**
 * @author walmi
 *
 */
public class MarcaVo {

	private Integer idMarca;
	private String nome;
	private ModeloVo modelo;
	private List<ModeloVo> listaModelos;
	/**
	 * Respons�vel por retornar o atributo idMarca
	 * @return o idMarca
	 */
	public Integer getIdMarca() {
		return idMarca;
	}
	/**
	 * Respons�vel por atribuir valor ao atributo idMarca
	 * @param idMarca para o atributo idMarca
	 */
	public void setIdMarca(Integer idMarca) {
		this.idMarca = idMarca;
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
	 * Respons�vel por retornar o atributo listaModelos
	 * @return o listaModelos
	 */
	public List<ModeloVo> getListaModelos() {
		return listaModelos;
	}
	/**
	 * Respons�vel por atribuir valor ao atributo listaModelos
	 * @param listaModelos para o atributo listaModelos
	 */
	public void setListaModelos(List<ModeloVo> listaModelos) {
		this.listaModelos = listaModelos;
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
