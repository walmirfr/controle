package br.com.mecanicadoisirmaos.controle.vo;

/**
 * @author walmi
 *
 */
public class TelefoneVo {

	private PessoaVo pessoa;
	private String numero;
	private String dd;
	
	/**
	 * Responsável por retornar o atributo pessoa
	 * @return o pessoa
	 */
	public PessoaVo getPessoa() {
		return pessoa;
	}
	/**
	 * Responsável por atribuir valor ao atributo pessoa
	 * @param pessoa para o atributo pessoa
	 */
	public void setPessoa(PessoaVo pessoa) {
		this.pessoa = pessoa;
	}
	/**
	 * Responsável por retornar o atributo numero
	 * @return o numero
	 */
	public String getNumero() {
		return numero;
	}
	/**
	 * Responsável por atribuir valor ao atributo numero
	 * @param numero para o atributo numero
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}
	/**
	 * Responsável por retornar o atributo dd
	 * @return o dd
	 */
	public String getDd() {
		return dd;
	}
	/**
	 * Responsável por atribuir valor ao atributo dd
	 * @param dd para o atributo dd
	 */
	public void setDd(String dd) {
		this.dd = dd;
	}
	public String getNumeroCompleto(){
		return dd+numero;
	}
}
