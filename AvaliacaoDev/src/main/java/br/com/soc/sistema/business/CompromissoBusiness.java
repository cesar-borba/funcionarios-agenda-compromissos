package br.com.soc.sistema.business;

import java.util.List;

import br.com.soc.sistema.dao.CompromissoDao;
import br.com.soc.sistema.exception.BusinessException;
import br.com.soc.sistema.exception.TechnicalException;
import br.com.soc.sistema.vo.AgendaVo;
import br.com.soc.sistema.vo.CompromissoVo;
import br.com.soc.sistema.vo.Periodo;

public class CompromissoBusiness implements Business {

	private CompromissoDao dao;

	public CompromissoBusiness() {
		this.dao = new CompromissoDao();
	}

	public void atualizarCompromisso(CompromissoVo compromissoVo, AgendaVo agendaVo) {
		try {
			if(compromissoVo.getRowidAgenda().isEmpty() || compromissoVo.getRowidFuncionario().isEmpty())
				throw new IllegalArgumentException(VALORES_NAO_PODEM_SER_NULOS);
			
			if((agendaVo.getPeriodo() == Periodo.MANHA) && 
					(compromissoVo.getHorario().getHour() < 7 || 
							compromissoVo.getHorario().getHour() > 13)) {
				throw new BusinessException(AGENDA_MANHA_NAO_POSSUI_DISPONIBILIDADE);
			}
			
			if((agendaVo.getPeriodo() == Periodo.TARDE) && 
					(compromissoVo.getHorario().getHour() < 13 || 
							compromissoVo.getHorario().getHour() > 18)) {
				throw new BusinessException(AGENDA_TARDE_NAO_POSSUI_DISPONIBILIDADE);
			}

			dao.updateCompromisso(compromissoVo);
		} catch (IllegalArgumentException | BusinessException e) {
			throw new BusinessException(e.getMessage());
		} catch (Exception e) {
			throw new BusinessException(ERRO_ATUALIZACAO_REGISTRO);
		}
	}

	public List<CompromissoVo> trazerTodosOsCompromissos(){
		try {
			return dao.findAllCompromissos();
		} catch (Exception e) {
			throw new TechnicalException(ERRO_AO_BUSCAR_COMPROMISSOS);
		}
	}

	public void salvarCompromisso(CompromissoVo compromissoVo, AgendaVo agendaVo) {
		try {
			if(compromissoVo.getRowidAgenda().isEmpty() || compromissoVo.getRowidFuncionario().isEmpty())
				throw new IllegalArgumentException(VALORES_NAO_PODEM_SER_NULOS);
			
			if((agendaVo.getPeriodo() == Periodo.MANHA) && 
					(compromissoVo.getHorario().getHour() < 7 || 
							compromissoVo.getHorario().getHour() > 13)) {
				throw new BusinessException(AGENDA_MANHA_NAO_POSSUI_DISPONIBILIDADE);
			}
			
			if((agendaVo.getPeriodo() == Periodo.TARDE) && 
					(compromissoVo.getHorario().getHour() < 13 || 
							compromissoVo.getHorario().getHour() > 18)) {
				throw new BusinessException(AGENDA_TARDE_NAO_POSSUI_DISPONIBILIDADE);
			}

			dao.insertCompromisso(compromissoVo);
		} catch (IllegalArgumentException | BusinessException e) {
			throw new BusinessException(e.getMessage());
		} catch (Exception e) {
			throw new BusinessException(ERRO_ATUALIZACAO_REGISTRO);
		}

	}
	
	public void excluirCompromisso(String codigo) {
		try {
			Integer cod = Integer.parseInt(codigo);

			dao.deleteCompromisso(cod);
		} catch (Exception e) {
			throw new BusinessException(ERRO_EXCLUSAO_REGISTRO);
		}
	}
	
	
	public CompromissoVo buscarCompromissoPor(String codigo) {
		try {
			Integer cod = Integer.parseInt(codigo);
			return dao.findByCodigo(cod);
		}catch (NumberFormatException e) {
			throw new BusinessException(FOI_INFORMADO_CARACTER_NO_LUGAR_DE_UM_NUMERO);
		} catch (Exception e) {
			throw new BusinessException(ERRO_AO_BUSCAR_COMPROMISSO);
		}
	}
}
