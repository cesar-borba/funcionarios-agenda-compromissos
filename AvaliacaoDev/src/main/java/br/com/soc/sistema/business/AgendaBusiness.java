package br.com.soc.sistema.business;

import java.util.ArrayList;
import java.util.List;

import org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException;

import br.com.soc.sistema.dao.AgendaDao;
import br.com.soc.sistema.exception.BusinessException;
import br.com.soc.sistema.filter.AgendaFilter;
import br.com.soc.sistema.vo.AgendaVo;

public class AgendaBusiness implements Business{
	
	private AgendaDao dao;
	
	public AgendaBusiness() {
		this.dao = new AgendaDao();
	}
	
	public List<AgendaVo> trazerTodosAsAgendas(){
		return dao.findAllAgendas();
	}	
	
	public void atualizarAgenda(AgendaVo agendaVo) {
		try {
			if(agendaVo.getNome().isEmpty() || agendaVo.getPeriodo().name().isEmpty())
				throw new IllegalArgumentException(VALORES_NAO_PODEM_SER_NULOS);
			
			dao.updateAgenda(agendaVo);
		} catch (IllegalArgumentException e) {
			throw new BusinessException(e.getMessage());
		} catch (Exception e) {
			throw new BusinessException(ERRO_ATUALIZACAO_REGISTRO);
		}
	}
	
	public void salvarAgenda(AgendaVo agendaVo) {
		try {
			if(agendaVo.getNome().isEmpty())
				throw new IllegalArgumentException(NOME_NAO_PODE_SER_EM_BRANCO);
			
			dao.insertAgenda(agendaVo);
		} catch (IllegalArgumentException e) {
			throw new BusinessException(e.getMessage());
		} catch (Exception e) {
			throw new BusinessException(ERRO_INCLUSAO_REGISTRO);
		}
		
	}
	
	public void excluirAgenda(String codigo) {
		try {
			Integer cod = Integer.parseInt(codigo);
			
			dao.deleteAgenda(cod);
		} catch (JdbcSQLIntegrityConstraintViolationException e) {
			throw new BusinessException(AGENDA_POSSUI_COMPROMISSOS_VINCULADOS);
		}
		catch (Exception e) {
			throw new BusinessException(ERRO_EXCLUSAO_REGISTRO);
		}
		
	}
	
	public List<AgendaVo> filtrarAgendas(AgendaFilter filter){
		List<AgendaVo> agendas = new ArrayList<>();
		
		switch (filter.getOpcoesCombo()) {
			case ID:
				try {
					Integer codigo = Integer.parseInt(filter.getValorBusca());
					agendas.add(dao.findByCodigo(codigo));
				}catch (NumberFormatException e) {
					throw new BusinessException(FOI_INFORMADO_CARACTER_NO_LUGAR_DE_UM_NUMERO);
				}
			break;

			case NOME:
				agendas.addAll(dao.findAllByNome(filter.getValorBusca()));
			break;
		}
		
		return agendas;
	}
	
	public AgendaVo buscarAgendaPor(String codigo) {
		try {
			Integer cod = Integer.parseInt(codigo);
			return dao.findByCodigo(cod);
		}catch (NumberFormatException e) {
			throw new BusinessException(FOI_INFORMADO_CARACTER_NO_LUGAR_DE_UM_NUMERO);
		}
	}	
}
