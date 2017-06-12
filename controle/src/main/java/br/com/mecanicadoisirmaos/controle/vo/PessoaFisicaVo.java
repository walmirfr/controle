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
	private String sexo;
	private Date dtNascimento;
	private String nascimento;
	private String tipoPessoaFisica;
	private Double salario;
	private EmpresaVo empresa;
	
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
	/**
	 * Responsável por retornar o atributo sexo
	 * @return o sexo
	 */
	public String getSexo() {
		return sexo;
	}
	/**
	 * Responsável por atribuir valor ao atributo sexo
	 * @param sexo para o atributo sexo
	 */
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	/**
	 * Responsável por retornar o atributo nascimento
	 * @return o nascimento
	 */
	public String getNascimento() {
		return nascimento;
	}
	/**
	 * Responsável por atribuir valor ao atributo nascimento
	 * @param nascimento para o atributo nascimento
	 */
	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}
	/**
	 * Responsável por retornar o atributo salario
	 * @return o salario
	 */
	public Double getSalario() {
		return salario;
	}
	/**
	 * Responsável por atribuir valor ao atributo salario
	 * @param salario para o atributo salario
	 */
	public void setSalario(Double salario) {
		this.salario = salario;
	}
	/**
	 * Responsável por retornar o atributo empresa
	 * @return o empresa
	 */
	public EmpresaVo getEmpresa() {
		return empresa;
	}
	/**
	 * Responsável por atribuir valor ao atributo empresa
	 * @param empresa para o atributo empresa
	 */
	public void setEmpresa(EmpresaVo empresa) {
		this.empresa = empresa;
	}
	
}
