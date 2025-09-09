package br.com.soc.sistema.action;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

import br.com.soc.sistema.business.AgendaBusiness;
import br.com.soc.sistema.business.FuncionarioBusiness;
import br.com.soc.sistema.business.RelatorioBusiness;
import br.com.soc.sistema.exception.BusinessException;
import br.com.soc.sistema.infra.Action;
import br.com.soc.sistema.vo.CompromissoVo;
import br.com.soc.sistema.vo.RelatorioVo;

public class RelatorioAction extends Action{
	
	private RelatorioVo relatorioVo = new RelatorioVo();
	private RelatorioBusiness business = new RelatorioBusiness();
	private FuncionarioBusiness businessFuncionario = new FuncionarioBusiness();
	private AgendaBusiness businessAgenda = new AgendaBusiness();
	private InputStream arquivoExcelStream;
    private String nomeDoArquivo;
    private List<CompromissoVo> compromissos;
	
    public String todos() {
    	return INPUT;
    }
    
    public String imprimir() {
    	if(relatorioVo.getDataFinal() == null || relatorioVo.getDataInicial() == null)
			return INPUT;
		
    	this.compromissos = business.filtraDatas(relatorioVo);
		
		return "impressao";
    }
    
	public String emitir() {
		
		try {
			
			if(relatorioVo.getDataFinal() == null || relatorioVo.getDataInicial() == null)
				return INPUT;
			
			List<CompromissoVo> compromissos = business.filtraDatas(relatorioVo);
			
			HSSFWorkbook workbook = new HSSFWorkbook();
			HSSFSheet sheet = workbook.createSheet("Relatorio");
			
			Row headerRow = sheet.createRow(0);
			headerRow.createCell(0).setCellValue("ID Compromisso");
			headerRow.createCell(1).setCellValue("ID Funcionário");
			headerRow.createCell(2).setCellValue("Nome Funcionário");
			headerRow.createCell(3).setCellValue("ID Agenda");
			headerRow.createCell(4).setCellValue("Nome Agenda");
			headerRow.createCell(5).setCellValue("Data Compromisso");
			headerRow.createCell(6).setCellValue("Horário Compromisso");
			
			int rowNum = 1;
			for (CompromissoVo compromisso : compromissos) {
				Row row = sheet.createRow(rowNum++);
				row.createCell(0).setCellValue(compromisso.getRowid());
				row.createCell(1).setCellValue(compromisso.getRowidFuncionario());
				row.createCell(2).setCellValue(businessFuncionario.buscarFuncionarioPor(compromisso.getRowidFuncionario()).getNome());
				row.createCell(3).setCellValue(compromisso.getRowidAgenda());
				row.createCell(4).setCellValue(businessAgenda.buscarAgendaPor(compromisso.getRowidAgenda()).getNome());
				row.createCell(5).setCellValue(compromisso.getData().toString());
				row.createCell(6).setCellValue(compromisso.getHorario().toString());
			}
			
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			workbook.write(baos);
			
			this.arquivoExcelStream = new ByteArrayInputStream(baos.toByteArray());
            this.nomeDoArquivo = "relatorio_compromissos.xls";
            
            return SUCCESS;
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException("houve um erro ao tentar emitir a planilha");
		}
		
	}
	
	public InputStream getArquivoExcelStream() {
        return arquivoExcelStream;
    }

    public String getNomeDoArquivo() {
        return nomeDoArquivo;
    }

	public RelatorioVo getRelatorioVo() {
		return relatorioVo;
	}

	public void setRelatorioVo(RelatorioVo relatorioVo) {
		this.relatorioVo = relatorioVo;
	}

	public void setArquivoExcelStream(InputStream arquivoExcelStream) {
		this.arquivoExcelStream = arquivoExcelStream;
	}

	public void setNomeDoArquivo(String nomeDoArquivo) {
		this.nomeDoArquivo = nomeDoArquivo;
	}

	public List<CompromissoVo> getCompromissos() {
		return compromissos;
	}

	public void setCompromissos(List<CompromissoVo> compromissos) {
		this.compromissos = compromissos;
	}

	public FuncionarioBusiness getBusinessFuncionario() {
		return businessFuncionario;
	}

	public void setBusinessFuncionario(FuncionarioBusiness businessFuncionario) {
		this.businessFuncionario = businessFuncionario;
	}

	public AgendaBusiness getBusinessAgenda() {
		return businessAgenda;
	}

	public void setBusinessAgenda(AgendaBusiness businessAgenda) {
		this.businessAgenda = businessAgenda;
	}
    
}