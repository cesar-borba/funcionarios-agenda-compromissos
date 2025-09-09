package br.com.soc.sistema.business;

import java.util.List;

import br.com.soc.sistema.dao.RelatorioDao;
import br.com.soc.sistema.exception.BusinessException;
import br.com.soc.sistema.vo.CompromissoVo;
import br.com.soc.sistema.vo.RelatorioVo;

public class RelatorioBusiness implements Business{
	
	private RelatorioDao dao;
	
	public RelatorioBusiness() {
		this.dao = new RelatorioDao();
	}
	
	public List<CompromissoVo> filtraDatas(RelatorioVo relatorioVo) {
		
		try {
			System.out.println();
			return dao.filtraDatas(relatorioVo);
			
		} catch(Exception e) {
			throw new BusinessException("Houve um erro ao emitir o relatório.");
		}
	}
}