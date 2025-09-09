package br.com.soc.sistema.action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.soc.sistema.business.AgendaBusiness;
import br.com.soc.sistema.filter.AgendaFilter;
import br.com.soc.sistema.infra.Action;
import br.com.soc.sistema.infra.OpcoesComboBuscar;
import br.com.soc.sistema.vo.AgendaVo;
import br.com.soc.sistema.vo.Periodo;

public class AgendaAction extends Action{

	private List<AgendaVo> agendas = new ArrayList<>();
	private AgendaBusiness business = new AgendaBusiness();
	private AgendaFilter filtrar = new AgendaFilter();
	private AgendaVo agendaVo = new AgendaVo();

	public String atualizar() {
		if(agendaVo.getNome() == null)
			return INPUT;

		business.atualizarAgenda(agendaVo);

		return REDIRECT;
	}

	public String todos() {
		agendas.addAll(business.trazerTodosAsAgendas());

		return SUCCESS;
	}

	public String filtrar() {
		if(filtrar.isNullOpcoesCombo())
			return REDIRECT;

		agendas = business.filtrarAgendas(filtrar);

		return SUCCESS;
	}

	public String novo() {
		if(agendaVo.getNome() == null)
			return INPUT;

		business.salvarAgenda(agendaVo);

		return REDIRECT;
	}

	public String excluir() {
		if(agendaVo.getRowid() == null)
			return REDIRECT;

		business.excluirAgenda(agendaVo.getRowid());

		return REDIRECT;
	}

	public String editar() {
		if(agendaVo.getRowid() == null)
			return REDIRECT;

		agendaVo = business.buscarAgendaPor(agendaVo.getRowid());

		return INPUT;
	}

	public List<OpcoesComboBuscar> getListaOpcoesCombo(){
		return Arrays.asList(OpcoesComboBuscar.values());
	}
	
	public List<Periodo> getListaPeriodos() {
		return Arrays.asList(Periodo.values());
	}

	public List<AgendaVo> getAgendas() {
		return agendas;
	}

	public void setAgendas(List<AgendaVo> agendas) {
		this.agendas = agendas;
	}

	public AgendaFilter getFiltrar() {
		return filtrar;
	}

	public void setFiltrar(AgendaFilter filtrar) {
		this.filtrar = filtrar;
	}

	public AgendaVo getAgendaVo() {
		return agendaVo;
	}

	public void setAgendaVo(AgendaVo agendaVo) {
		this.agendaVo = agendaVo;
	}
}