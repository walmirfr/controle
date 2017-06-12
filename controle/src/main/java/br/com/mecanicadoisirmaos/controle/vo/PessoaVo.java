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
	 * Respons�vel por retornar o atributo idPessoa
	 * @return o idPessoa
	 */
	public Integer getIdPessoa() {
		return idPessoa;
	}
	/**
	 * Respons�vel por atribuir valor ao atributo idPessoa
	 * @param idPessoa para o atributo idPessoa
	 */
	public void setIdPessoa(Integer idPessoa) {
		this.idPessoa = idPessoa;
	}
	/**
	 * Respons�vel por retornar o atributo email
	 * @return o email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * Respons�vel por atribuir valor ao atributo email
	 * @param email para o atributo email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * Respons�vel por retornar o atributo login
	 * @return o login
	 */
	public String getLogin() {
		return login;
	}
	/**
	 * Respons�vel por atribuir valor ao atributo login
	 * @param login para o atributo login
	 */
	public void setLogin(String login) {
		this.login = login;
	}
	/**
	 * Respons�vel por retornar o atributo senha
	 * @return o senha
	 */
	public String getSenha() {
		return senha;
	}
	/**
	 * Respons�vel por atribuir valor ao atributo senha
	 * @param senha para o atributo senha
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}
	/**
	 * Respons�vel por retornar o atributo ativo
	 * @return o ativo
	 */
	public Boolean getAtivo() {
		return ativo;
	}
	/**
	 * Respons�vel por atribuir valor ao atributo ativo
	 * @param ativo para o atributo ativo
	 */
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	/**
	 * Respons�vel por retornar o atributo endereco
	 * @return o endereco
	 */
	public EnderecoVo getEndereco() {
		return endereco;
	}
	/**
	 * Respons�vel por atribuir valor ao atributo endereco
	 * @param endereco para o atributo endereco
	 */
	public void setEndereco(EnderecoVo endereco) {
		this.endereco = endereco;
	}
	/**
	 * Respons�vel por retornar o atributo listaTelefones
	 * @return o listaTelefones
	 */
	public List<TelefoneVo> getListaTelefones() {
		return listaTelefones;
	}
	/**
	 * Respons�vel por atribuir valor ao atributo listaTelefones
	 * @param listaTelefones para o atributo listaTelefones
	 */
	public void setListaTelefones(List<TelefoneVo> listaTelefones) {
		this.listaTelefones = listaTelefones;
	}
	/**
	 * Respons�vel por retornar o atributo tipoPessoa
	 * @return o tipoPessoa
	 */
	public String getTipoPessoa() {
		return tipoPessoa;
	}
	/**
	 * Respons�vel por atribuir valor ao atributo tipoPessoa
	 * @param tipoPessoa para o atributo tipoPessoa
	 */
	public void setTipoPessoa(String tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}
	/**
	 * Respons�vel por retornar o atributo telefone
	 * @return o telefone
	 */
	public TelefoneVo getTelefone() {
		return telefone;
	}
	/**
	 * Respons�vel por atribuir valor ao atributo telefone
	 * @param telefone para o atributo telefone
	 */
	public void setTelefone(TelefoneVo telefone) {
		this.telefone = telefone;
	}
	/**
	 * Respons�vel por retornar o atributo vinculo
	 * @return o vinculo
	 */
	public Boolean getVinculo() {
		return vinculo;
	}
	/**
	 * Respons�vel por atribuir valor ao atributo vinculo
	 * @param vinculo para o atributo vinculo
	 */
	public void setVinculo(Boolean vinculo) {
		this.vinculo = vinculo;
	}
}