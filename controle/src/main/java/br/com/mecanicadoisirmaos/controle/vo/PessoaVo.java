/**
 * 
 */
package br.com.mecanicadoisirmaos.controle.vo;

import java.util.List;

/**
 * @author walmi
 *
 */
public class PessoaVo {

	private Integer idPessoa;
	private String email;
	private String login;
	private String senha;
	private Boolean ativo;
	private String tipoPessoa;
	private Boolean vinculo;
	
	private EnderecoVo endereco;
	private TelefoneVo telefone;
	private List<TelefoneVo> listaTelefones;
	/**
	 * Responsável por retornar o atributo idPessoa
	 * @return o idPessoa
	 */
	public Integer getIdPessoa() {
		return idPessoa;
	}
	/**
	 * Responsável por atribuir valor ao atributo idPessoa
	 * @param idPessoa para o atributo idPessoa
	 */
	public void setIdPessoa(Integer idPessoa) {
		this.idPessoa = idPessoa;
	}
	/**
	 * Responsável por retornar o atributo email
	 * @return o email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * Responsável por atribuir valor ao atributo email
	 * @param email para o atributo email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * Responsável por retornar o atributo login
	 * @return o login
	 */
	public String getLogin() {
		return login;
	}
	/**
	 * Responsável por atribuir valor ao atributo login
	 * @param login para o atributo login
	 */
	public void setLogin(String login) {
		this.login = login;
	}
	/**
	 * Responsável por retornar o atributo senha
	 * @return o senha
	 */
	public String getSenha() {
		return senha;
	}
	/**
	 * Responsável por atribuir valor ao atributo senha
	 * @param senha para o atributo senha
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}
	/**
	 * Responsável por retornar o atributo ativo
	 * @return o ativo
	 */
	public Boolean getAtivo() {
		return ativo;
	}
	/**
	 * Responsável por atribuir valor ao atributo ativo
	 * @param ativo para o atributo ativo
	 */
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	/**
	 * Responsável por retornar o atributo endereco
	 * @return o endereco
	 */
	public EnderecoVo getEndereco() {
		return endereco;
	}
	/**
	 * Responsável por atribuir valor ao atributo endereco
	 * @param endereco para o atributo endereco
	 */
	public void setEndereco(EnderecoVo endereco) {
		this.endereco = endereco;
	}
	/**
	 * Responsável por retornar o atributo listaTelefones
	 * @return o listaTelefones
	 */
	public List<TelefoneVo> getListaTelefones() {
		return listaTelefones;
	}
	/**
	 * Responsável por atribuir valor ao atributo listaTelefones
	 * @param listaTelefones para o atributo listaTelefones
	 */
	public void setListaTelefones(List<TelefoneVo> listaTelefones) {
		this.listaTelefones = listaTelefones;
	}
	/**
	 * Responsável por retornar o atributo tipoPessoa
	 * @return o tipoPessoa
	 */
	public String getTipoPessoa() {
		return tipoPessoa;
	}
	/**
	 * Responsável por atribuir valor ao atributo tipoPessoa
	 * @param tipoPessoa para o atributo tipoPessoa
	 */
	public void setTipoPessoa(String tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}
	/**
	 * Responsável por retornar o atributo telefone
	 * @return o telefone
	 */
	public TelefoneVo getTelefone() {
		return telefone;
	}
	/**
	 * Responsável por atribuir valor ao atributo telefone
	 * @param telefone para o atributo telefone
	 */
	public void setTelefone(TelefoneVo telefone) {
		this.telefone = telefone;
	}
	/**
	 * Responsável por retornar o atributo vinculo
	 * @return o vinculo
	 */
	public Boolean getVinculo() {
		return vinculo;
	}
	/**
	 * Responsável por atribuir valor ao atributo vinculo
	 * @param vinculo para o atributo vinculo
	 */
	public void setVinculo(Boolean vinculo) {
		this.vinculo = vinculo;
	}
}