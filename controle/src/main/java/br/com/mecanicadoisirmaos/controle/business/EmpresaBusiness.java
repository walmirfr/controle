package br.com.mecanicadoisirmaos.controle.business;

import java.util.List;

import br.com.mecanicadoisirmaos.controle.vo.EmpresaVo;
import br.com.mecanicadoisirmaos.controle.vo.PessoaVo;

public interface EmpresaBusiness {

	public List<EmpresaVo> listarEmpresas(EmpresaVo empresaVo) throws Exception;
	
	public Boolean inserirEmpresa(EmpresaVo empresa) throws Exception;
	
	public List<EmpresaVo> listarEmpresasPart() throws Exception;
	
	public Boolean excluirEmpresa(EmpresaVo empresa) throws Exception;
	
	public Boolean ativarDesativarEmpresa(PessoaVo pessoa, String funcao) throws Exception;
	
	public EmpresaVo consultarEmpresaPorId(Integer idPessoa) throws Exception;
	
	public Boolean alterarEmpresa(EmpresaVo empresa,EmpresaVo empresaOriginal) throws Exception;
}
