package br.com.soc.sistema.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import br.com.soc.sistema.vo.CompromissoVo;
import br.com.soc.sistema.vo.RelatorioVo;

public class RelatorioDao extends Dao{
	
	public List<CompromissoVo> filtraDatas(RelatorioVo relatorioVo) throws SQLException{
		StringBuilder query = new StringBuilder("SELECT rowid id, funcionario_id f_id, ")
				.append("agenda_id a_id, data, horario FROM compromisso ")
				.append("WHERE data BETWEEN ? AND ?");
		try(Connection con = getConexao();
				PreparedStatement ps = con.prepareStatement(query.toString())){
			
			int i = 1;
			ps.setObject(i++, relatorioVo.getDataInicial());
			ps.setObject(i++, relatorioVo.getDataFinal());

			try(ResultSet rs = ps.executeQuery()){
				CompromissoVo vo = null;
				List<CompromissoVo> compromissos = new ArrayList<>();

				while (rs.next()) {
					vo = new CompromissoVo();
					vo.setRowid(rs.getString("id"));
					vo.setRowidFuncionario(rs.getString("f_id")); ;
					vo.setRowidAgenda(rs.getString("a_id"));
					vo.setData(rs.getObject("data", LocalDate.class));
					vo.setHorario(rs.getObject("horario", LocalTime.class));
					compromissos.add(vo);
				}
			return compromissos;
			}
			}catch (SQLException e) {
			e.printStackTrace();
			
			throw e;
		}

	}
	
}
