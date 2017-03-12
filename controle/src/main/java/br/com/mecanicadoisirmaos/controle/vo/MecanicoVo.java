/**
 * 
 */
package br.com.mecanicadoisirmaos.controle.vo;

import java.util.List;

/**
 * @author walmi
 *
 */
public class MecanicoVo extends PessoaFisicaVo{

	private Double salario;
	private List<ManutencaoVo> listaManutencoes;
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
	 * Responsável por retornar o atributo listaManutencoes
	 * @return o listaManutencoes
	 */
	public List<ManutencaoVo> getListaManutencoes() {
		return listaManutencoes;
	}
	/**
	 * Responsável por atribuir valor ao atributo listaManutencoes
	 * @param listaManutencoes para o atributo listaManutencoes
	 */
	public void setListaManutencoes(List<ManutencaoVo> listaManutencoes) {
		this.listaManutencoes = listaManutencoes;
	}
}
