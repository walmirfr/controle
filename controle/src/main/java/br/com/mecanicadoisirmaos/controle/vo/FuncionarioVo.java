/**
 * 
 */
package br.com.mecanicadoisirmaos.controle.vo;

/**
 * @author walmi
 *
 */
public class FuncionarioVo extends PessoaFisicaVo{

	private EmpresaVo empresa;
	
	public FuncionarioVo() {
	}
	
	public FuncionarioVo(EmpresaVo empresa) {
		this.empresa = empresa;
	}

	/**
	 * Respons�vel por retornar o atributo empresa
	 * @return o empresa
	 */
	public EmpresaVo getEmpresa() {
		return empresa;
	}

	/**
	 * Respons�vel por atribuir valor ao atributo empresa
	 * @param empresa para o atributo empresa
	 */
	public void setEmpresa(EmpresaVo empresa) {
		this.empresa = empresa;
	}
	
}
