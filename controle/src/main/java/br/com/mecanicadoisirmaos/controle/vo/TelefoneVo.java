package br.com.mecanicadoisirmaos.controle.vo;

/**
 * @author walmi
 *
 */
public class TelefoneVo {

	private PessoaVo pessoa;
	private String numero;
	/**
	 * Respons�vel por retornar o atributo pessoa
	 * @return o pessoa
	 */
	public PessoaVo getPessoa() {
		return pessoa;
	}
	/**
	 * Respons�vel por atribuir valor ao atributo pessoa
	 * @param pessoa para o atributo pessoa
	 */
	public void setPessoa(PessoaVo pessoa) {
		this.pessoa = pessoa;
	}
	/**
	 * Respons�vel por retornar o atributo numero
	 * @return o numero
	 */
	public String getNumero() {
		return numero;
	}
	/**
	 * Respons�vel por atribuir valor ao atributo numero
	 * @param numero para o atributo numero
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
}
