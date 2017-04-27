/**
 * 
 */
package br.com.mecanicadoisirmaos.controle.vo;

import java.util.Date;

/**
 * @author walmi
 *
 */
public class PessoaFisicaVo extends PessoaVo{

	private String nome;
	private String cpf;
	private Date dtNascimento;
	private String tipoPessoaFisica;
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
	 * Responsável por retornar o atributo cpf
	 * @return o cpf
	 */
	public String getCpf() {
		return cpf;
	}
	/**
	 * Responsável por atribuir valor ao atributo cpf
	 * @param cpf para o atributo cpf
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	/**
	 * Responsável por retornar o atributo dtNascimento
	 * @return o dtNascimento
	 */
	public Date getDtNascimento() {
		return dtNascimento;
	}
	/**
	 * Responsável por atribuir valor ao atributo dtNascimento
	 * @param dtNascimento para o atributo dtNascimento
	 */
	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}
	/**
	 * Responsável por retornar o atributo tipoPessoaFisica
	 * @return o tipoPessoaFisica
	 */
	public String getTipoPessoaFisica() {
		return tipoPessoaFisica;
	}
	/**
	 * Responsável por atribuir valor ao atributo tipoPessoaFisica
	 * @param tipoPessoaFisica para o atributo tipoPessoaFisica
	 */
	public void setTipoPessoaFisica(String tipoPessoaFisica) {
		this.tipoPessoaFisica = tipoPessoaFisica;
	}
	
}
