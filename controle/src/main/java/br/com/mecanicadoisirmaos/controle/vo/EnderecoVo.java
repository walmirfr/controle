/**
 * 
 */
package br.com.mecanicadoisirmaos.controle.vo;

/**
 * @author walmi
 *
 */
public class EnderecoVo {

	private Integer idEndereco;
	private String rua;
	private Integer numero;
	private String complemento;
	private String cep;
	private String bairro;
	private String cidade;
	private String uf;
	
	private PessoaVo pessoa; 
	/**
	 * Responsável por retornar o atributo idEndereco
	 * @return o idEndereco
	 */
	public Integer getIdEndereco() {
		return idEndereco;
	}
	/**
	 * Responsável por atribuir valor ao atributo idEndereco
	 * @param idEndereco para o atributo idEndereco
	 */
	public void setIdEndereco(Integer idEndereco) {
		this.idEndereco = idEndereco;
	}
	/**
	 * Responsável por retornar o atributo rua
	 * @return o rua
	 */
	public String getRua() {
		return rua;
	}
	/**
	 * Responsável por atribuir valor ao atributo rua
	 * @param rua para o atributo rua
	 */
	public void setRua(String rua) {
		this.rua = rua;
	}
	/**
	 * Responsável por retornar o atributo numero
	 * @return o numero
	 */
	public Integer getNumero() {
		return numero;
	}
	/**
	 * Responsável por atribuir valor ao atributo numero
	 * @param numero para o atributo numero
	 */
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	/**
	 * Responsável por retornar o atributo complemento
	 * @return o complemento
	 */
	public String getComplemento() {
		return complemento;
	}
	/**
	 * Responsável por atribuir valor ao atributo complemento
	 * @param complemento para o atributo complemento
	 */
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	/**
	 * Responsável por retornar o atributo cep
	 * @return o cep
	 */
	public String getCep() {
		return cep;
	}
	/**
	 * Responsável por atribuir valor ao atributo cep
	 * @param cep para o atributo cep
	 */
	public void setCep(String cep) {
		this.cep = cep;
	}
	/**
	 * Responsável por retornar o atributo bairro
	 * @return o bairro
	 */
	public String getBairro() {
		return bairro;
	}
	/**
	 * Responsável por atribuir valor ao atributo bairro
	 * @param bairro para o atributo bairro
	 */
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	/**
	 * Responsável por retornar o atributo cidade
	 * @return o cidade
	 */
	public String getCidade() {
		return cidade;
	}
	/**
	 * Responsável por atribuir valor ao atributo cidade
	 * @param cidade para o atributo cidade
	 */
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	/**
	 * Responsável por retornar o atributo uf
	 * @return o uf
	 */
	public String getUf() {
		return uf;
	}
	/**
	 * Responsável por atribuir valor ao atributo uf
	 * @param uf para o atributo uf
	 */
	public void setUf(String uf) {
		this.uf = uf;
	}
	/**
	 * @return the pessoa
	 */
	public PessoaVo getPessoa() {
		return pessoa;
	}
	/**
	 * @param pessoa the pessoa to set
	 */
	public void setPessoa(PessoaVo pessoa) {
		this.pessoa = pessoa;
	}
	
}
