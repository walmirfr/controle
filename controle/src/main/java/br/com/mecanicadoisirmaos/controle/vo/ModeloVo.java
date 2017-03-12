/**
 * 
 */
package br.com.mecanicadoisirmaos.controle.vo;

/**
 * @author walmi
 *
 */
public class ModeloVo {

	private Integer idModelo;
	private String nome;
	private MarcaVo marca;
	/**
	 * Respons�vel por retornar o atributo idModelo
	 * @return o idModelo
	 */
	public Integer getIdModelo() {
		return idModelo;
	}
	/**
	 * Respons�vel por atribuir valor ao atributo idModelo
	 * @param idModelo para o atributo idModelo
	 */
	public void setIdModelo(Integer idModelo) {
		this.idModelo = idModelo;
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