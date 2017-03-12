/**
 * 
 */
package br.com.mecanicadoisirmaos.controle.vo;

import java.util.List;

/**
 * @author walmi
 *
 */
public class EmpresaVo extends PessoaJuridicaVo{

	private FuncionarioVo funcionario;
	private VeiculoVo veiculo;
	private ManutencaoVo manutencao;
	private List<FuncionarioVo> listaFuncionarios;
	private List<VeiculoVo> listaVeiculos;
	private List<ManutencaoVo> listaManutencoes;
	/**
	 * Respons�vel por retornar o atributo funcionario
	 * @return o funcionario
	 */
	public FuncionarioVo getFuncionario() {
		return funcionario;
	}
	/**
	 * Respons�vel por atribuir valor ao atributo funcionario
	 * @param funcionario para o atributo funcionario
	 */
	public void setFuncionario(FuncionarioVo funcionario) {
		this.funcionario = funcionario;
	}
	/**
	 * Respons�vel por retornar o atributo veiculo
	 * @return o veiculo
	 */
	public VeiculoVo getVeiculo() {
		return veiculo;
	}
	/**
	 * Respons�vel por atribuir valor ao atributo veiculo
	 * @param veiculo para o atributo veiculo
	 */
	public void setVeiculo(VeiculoVo veiculo) {
		this.veiculo = veiculo;
	}
	/**
	 * Respons�vel por retornar o atributo manutencao
	 * @return o manutencao
	 */
	public ManutencaoVo getManutencao() {
		return manutencao;
	}
	/**
	 * Respons�vel por atribuir valor ao atributo manutencao
	 * @param manutencao para o atributo manutencao
	 */
	public void setManutencao(ManutencaoVo manutencao) {
		this.manutencao = manutencao;
	}
	/**
	 * Respons�vel por retornar o atributo listaFuncionarios
	 * @return o listaFuncionarios
	 */
	public List<FuncionarioVo> getListaFuncionarios() {
		return listaFuncionarios;
	}
	/**
	 * Respons�vel por atribuir valor ao atributo listaFuncionarios
	 * @param listaFuncionarios para o atributo listaFuncionarios
	 */
	public void setListaFuncionarios(List<FuncionarioVo> listaFuncionarios) {
		this.listaFuncionarios = listaFuncionarios;
	}
	/**
	 * Respons�vel por retornar o atributo listaVeiculos
	 * @return o listaVeiculos
	 */
	public List<VeiculoVo> getListaVeiculos() {
		return listaVeiculos;
	}
	/**
	 * Respons�vel por atribuir valor ao atributo listaVeiculos
	 * @param listaVeiculos para o atributo listaVeiculos
	 */
	public void setListaVeiculos(List<VeiculoVo> listaVeiculos) {
		this.listaVeiculos = listaVeiculos;
	}
	/**
	 * Respons�vel por retornar o atributo listaManutencoes
	 * @return o listaManutencoes
	 */
	public List<ManutencaoVo> getListaManutencoes() {
		return listaManutencoes;
	}
	/**
	 * Respons�vel por atribuir valor ao atributo listaManutencoes
	 * @param listaManutencoes para o atributo listaManutencoes
	 */
	public void setListaManutencoes(List<ManutencaoVo> listaManutencoes) {
		this.listaManutencoes = listaManutencoes;
	}
}
