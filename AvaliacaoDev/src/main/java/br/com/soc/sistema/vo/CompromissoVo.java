package br.com.soc.sistema.vo;

import java.time.LocalDate;
import java.time.LocalTime;

public class CompromissoVo {
	private String rowid;
	private String rowidFuncionario;
	private String rowidAgenda;
    private LocalDate data;
    private LocalTime horario;
    
    public CompromissoVo() {
    }
    
	public CompromissoVo(String rowid, String rowidFuncionario, String rowidAgenda, LocalDate data,
			LocalTime horario) {
		this.rowid = rowid;
		this.rowidFuncionario = rowidFuncionario;
		this.rowidAgenda = rowidAgenda;
		this.data = data;
		this.horario = horario;
	}

	public String getRowid() {
		return rowid;
	}

	public void setRowid(String rowid) {
		this.rowid = rowid;
	}

	public String getRowidFuncionario() {
		return rowidFuncionario;
	}

	public void setRowidFuncionario(String rowidFuncionario) {
		this.rowidFuncionario = rowidFuncionario;
	}

	public String getRowidAgenda() {
		return rowidAgenda;
	}

	public void setRowidAgenda(String rowidAgenda) {
		this.rowidAgenda = rowidAgenda;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public LocalTime getHorario() {
		return horario;
	}

	public void setHorario(LocalTime horario) {
		this.horario = horario;
	}
}
