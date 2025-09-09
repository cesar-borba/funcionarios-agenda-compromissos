package br.com.soc.sistema.vo;

import java.time.LocalDate;

public class RelatorioVo {
	private LocalDate dataInicial;
	private LocalDate dataFinal;
	
	public RelatorioVo() {
		
	}
	
	public RelatorioVo(LocalDate dataInicial, LocalDate dataFinal) {
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
	}

	public LocalDate getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(LocalDate dataInicial) {
		this.dataInicial = dataInicial;
	}

	public LocalDate getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(LocalDate dataFinal) {
		this.dataFinal = dataFinal;
	}
}