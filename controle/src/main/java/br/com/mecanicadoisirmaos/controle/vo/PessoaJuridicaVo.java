/**
 * 
 */
package br.com.mecanicadoisirmaos.controle.vo;

/**
 * @author walmi
 *
 */
public class PessoaJuridicaVo extends PessoaVo{

	private String nomeFantasia;
	private String razaoSocial;
	private String cnpj;
	/**
	 * Respons�vel por retornar o atributo nomeFantasia
	 * @return o nomeFantasia
	 */
	public String getNomeFantasia() {
		return nomeFantasia;
	}
	/**
	 * Respons�vel por atribuir valor ao atributo nomeFantasia
	 * @param nomeFantasia para o atributo nomeFantasia
	 */
	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}
	/**
	 * Respons�vel por retornar o atributo razaoSocial
	 * @return o razaoSocial
	 */
	public String getRazaoSocial() {
		return razaoSocial;
	}
	/**
	 * Respons�vel por atribuir valor ao atributo razaoSocial
	 * @param razaoSocial para o atributo razaoSocial
	 */
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	/**
	 * Respons�vel por retornar o atributo cnpj
	 * @return o cnpj
	 */
	public String getCnpj() {
		return cnpj;
	}
	/**
	 * Respons�vel por atribuir valor ao atributo cnpj
	 * @param cnpj para o atributo cnpj
	 */
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
}
