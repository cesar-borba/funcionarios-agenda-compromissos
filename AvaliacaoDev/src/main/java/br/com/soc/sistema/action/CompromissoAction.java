package br.com.soc.sistema.action;

import java.util.ArrayList;
import java.util.List;

import br.com.soc.sistema.business.AgendaBusiness;
import br.com.soc.sistema.business.CompromissoBusiness;
import br.com.soc.sistema.infra.Action;
import br.com.soc.sistema.vo.CompromissoVo;

public class CompromissoAction extends Action{

	private List<CompromissoVo> compromissos = new ArrayList<>();
	private CompromissoBusiness business = new CompromissoBusiness();
	private CompromissoVo compromissoVo = new CompromissoVo();
	private AgendaBusiness businessAgenda = new AgendaBusiness();

	public String atualizar() {
		if(compromissoVo.getRowid() == null)
			return INPUT;
		
		business.atualizarCompromisso(compromissoVo, businessAgenda.buscarAgendaPor(compromissoVo.getRowidAgenda()));

		return REDIRECT;
	}

	public String todos() {
		compromissos.addAll(business.trazerTodosOsCompromissos());

		return SUCCESS;
	}

	public String novo() {
		if(compromissoVo.getRowid() == null)
			return INPUT;
		
		business.salvarCompromisso(compromissoVo, businessAgenda.buscarAgendaPor(compromissoVo.getRowidAgenda()));

		return REDIRECT;
	}

	public String excluir() {
		if(compromissoVo.getRowid() == null)
			return REDIRECT;

		business.excluirCompromisso(compromissoVo.getRowid());

		return REDIRECT;
	}

	public String editar() {
		if(compromissoVo.getRowid() == null)
			return REDIRECT;

		compromissoVo = business.buscarCompromissoPor(compromissoVo.getRowid());

		return INPUT;
	}

	public List<CompromissoVo> getCompromissos() {
		return compromissos;
	}

	public void setCompromissos(List<CompromissoVo> compromissos) {
		this.compromissos = compromissos;
	}

	public CompromissoVo getCompromissoVo() {
		return compromissoVo;
	}

	public void setCompromissoVo(CompromissoVo compromissoVo) {
		this.compromissoVo = compromissoVo;
	}

}