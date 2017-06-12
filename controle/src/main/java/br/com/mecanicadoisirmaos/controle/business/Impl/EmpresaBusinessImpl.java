package br.com.mecanicadoisirmaos.controle.business.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.mecanicadoisirmaos.controle.business.EmpresaBusiness;
import br.com.mecanicadoisirmaos.controle.dao.EmpresaDao;
import br.com.mecanicadoisirmaos.controle.dao.EnderecoDao;
import br.com.mecanicadoisirmaos.controle.dao.PessoaDao;
import br.com.mecanicadoisirmaos.controle.dao.PessoaFisicaDao;
import br.com.mecanicadoisirmaos.controle.util.Constants;
import br.com.mecanicadoisirmaos.controle.util.Util;
import br.com.mecanicadoisirmaos.controle.vo.EmpresaVo;
import br.com.mecanicadoisirmaos.controle.vo.FuncionarioVo;
import br.com.mecanicadoisirmaos.controle.vo.PessoaVo;
import br.com.mecanicadoisirmaos.controle.vo.TelefoneVo;

@Component
public class EmpresaBusinessImpl implements EmpresaBusiness {

	@Autowired
	private EmpresaDao empresaDao;
	
	@Autowired
	private PessoaDao pessoaDao;
	
	@Autowired
	private PessoaFisicaDao pessoaFisicaDao;
	
	@Autowired
	private EnderecoDao enderecoDao;
		
	@Transactional
	public Boolean inserirEmpresa(EmpresaVo empresa) throws Exception {
		
		if(empresaDao.consultarEmpresaCadastrada(empresa.getNomeFantasia(), null) > 0){
			return false;
		}
		
		empresa.setTipoPessoa(Constants.TP_PESSOA_JURIDICA);
		Integer idPessoa = empresaDao.inserirEmpresa(empresa);
		empresa.setIdPessoa(idPessoa);

		if(empresa.getEndereco() != null){
			empresa.getEndereco().setPessoa(empresa);
			enderecoDao.inserirEndereco(empresa.getEndereco());
		}

		inserirTelefone(empresa.getListaTelefones(), empresa);
		
		return true;
	}

	private void inserirTelefone(List<TelefoneVo> listaTelefones, PessoaVo pessoa){
		if(!listaTelefones.isEmpty()){
			Util.limparListaNullListTelefone(listaTelefones);
			for(TelefoneVo telefone: listaTelefones){
				telefone.setPessoa(pessoa);
				pessoaDao.inserirTelefone(telefone);
			}			
		}
	}
	
	public List<EmpresaVo> listarEmpresas(EmpresaVo empresaVo) throws Exception {
		List<EmpresaVo> listaEmpresas = empresaDao.listarEmpresas(empresaVo);
		for(EmpresaVo emp : listaEmpresas){
			emp.setListaTelefones(pessoaDao.consultarTelefonesPorPessoa(emp.getIdPessoa()));
		}
		return listaEmpresas;
	}
	
	public List<EmpresaVo> listarEmpresasPart() throws Exception {
		return empresaDao.listarEmpresas(null);
	}

	public Boolean excluirEmpresa(EmpresaVo empresa) throws Exception {
		if(empresaDao.excluirFuncionarioPorEmpresa(empresa.getIdPessoa()) == 0){
			return false;
		}
		if(pessoaDao.excluirTelefone(empresa.getIdPessoa()) == 0){
			return false;
		}
		if(enderecoDao.excluirEndereco(empresa.getIdPessoa()) == 0){
			return false;
		}
		if(pessoaDao.excluirPessoa(empresa.getIdPessoa()) == 0){
			return false;
		}
		return true;
	}

	public Boolean ativarDesativarEmpresa(PessoaVo pessoa, String funcao) throws Exception {

		if(Constants.ATIVAR.equals(funcao)){
			pessoa.setAtivo(true);
		}else if(Constants.DESATIVAR.equals(funcao)){
			pessoa.setAtivo(false);
		}

		if(pessoaDao.ativarDesativarPessoa(pessoa) > 0){
			return true;
		}
		return false;
	}

	public EmpresaVo consultarEmpresaPorId(Integer idPessoa) throws Exception {
		EmpresaVo emp = empresaDao.consultarEmpresaPorId(idPessoa);
		emp.setListaTelefones(pessoaDao.consultarTelefonesPorPessoa(idPessoa));
		emp.setEndereco(enderecoDao.consultarEnderecoPorPessoa(idPessoa));
		emp.setListaFuncionarios(pessoaFisicaDao.listarFuncionariosPorEmpresa(emp.getIdPessoa()));
		
		return emp;
	}

	@Transactional
	public Boolean alterarEmpresa(EmpresaVo empresa,EmpresaVo empresaOriginal) throws Exception {
		if(empresaDao.consultarEmpresaCadastrada(empresa.getNomeFantasia(), empresaOriginal) > 0){
			return false;
		}
		
		//Alterar Telefone
		pessoaDao.excluirTelefone(empresa.getIdPessoa());
		if(empresa.getListaTelefones() != null && !empresa.getListaTelefones().isEmpty()){
			inserirTelefone(empresa.getListaTelefones(), empresa);
		}
		
		//Endereço
		empresa.getEndereco().setPessoa(empresa);
		enderecoDao.alterarEndereco(empresa.getEndereco());
		
		for(FuncionarioVo func : empresa.getListaFuncionarios()){
			pessoaFisicaDao.alterarPessoaFisica(func);
		}
		
		empresaDao.alterarEmpresa(empresa);
				
		return true;
	}

}
