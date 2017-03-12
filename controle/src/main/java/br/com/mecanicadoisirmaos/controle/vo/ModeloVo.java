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
	 * Responsável por retornar o atributo idModelo
	 * @return o idModelo
	 */
	public Integer getIdModelo() {
		return idModelo;
	}
	/**
	 * Responsável por atribuir valor ao atributo idModelo
	 * @param idModelo para o atributo idModelo
	 */
	public void setIdModelo(Integer idModelo) {
		this.idModelo = idModelo;
	}
	/**
	 * Responsável por retornar o atributo marca
	 * @return o marca
	 */
	public MarcaVo getMarca() {
		return marca;
	}
	/**
	 * Responsável por atribuir valor ao atributo marca
	 * @param marca para o atributo marca
	 */
	public void setMarca(MarcaVo marca) {
		this.marca = marca;
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
}