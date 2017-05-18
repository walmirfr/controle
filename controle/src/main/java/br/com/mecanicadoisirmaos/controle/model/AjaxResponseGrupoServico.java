package br.com.mecanicadoisirmaos.controle.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;

import br.com.mecanicadoisirmaos.controle.vo.GrupoServicoVo;

public class AjaxResponseGrupoServico {

	@JsonView
	private List<GrupoServicoVo> listaGrupoServico;

	/**
	 * Responsável por retornar o atributo listaGrupoServico
	 * @return o listaGrupoServico
	 */
	public List<GrupoServicoVo> getListaGrupoServico() {
		return listaGrupoServico;
	}

	/**
	 * Responsável por atribuir valor ao atributo listaGrupoServico
	 * @param listaGrupoServico para o atributo listaGrupoServico
	 */
	public void setListaGrupoServico(List<GrupoServicoVo> listaGrupoServico) {
		this.listaGrupoServico = listaGrupoServico;
	}

}