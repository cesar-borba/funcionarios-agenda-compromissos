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

public class CompromissoDao extends Dao{

	public void updateCompromisso(CompromissoVo compromissoVo) throws SQLException {
		StringBuilder query = new StringBuilder("UPDATE compromisso ")
				.append("SET funcionario_id = ? , agenda_id = ? , ")
				.append("data = ? , horario = ? ")
				.append("WHERE rowid = ?");

		try(Connection con = getConexao();
				PreparedStatement ps = con.prepareStatement(query.toString())){

			int i=1;
			ps.setString(i++, compromissoVo.getRowidFuncionario());
			ps.setString(i++, compromissoVo.getRowidAgenda());
			ps.setObject(i++, compromissoVo.getData());
			ps.setObject(i++, compromissoVo.getHorario());
			ps.setString(i++, compromissoVo.getRowid());
			ps.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}

	public List<CompromissoVo> findAllCompromissos() throws SQLException{
		StringBuilder query = new StringBuilder("SELECT rowid id, funcionario_id f_id, ")
				.append("agenda_id a_id, data, horario FROM compromisso");

		try(
				Connection con = getConexao();
				PreparedStatement  ps = con.prepareStatement(query.toString());
				ResultSet rs = ps.executeQuery()){

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
		}catch (SQLException e) {
			e.printStackTrace();
			
			throw e;
		}

	}

	public void insertCompromisso(CompromissoVo compromissoVo) throws SQLException{
		StringBuilder query = new StringBuilder("INSERT INTO compromisso ")
				.append("(funcionario_id, agenda_id, data, horario) ")
				.append("values (?, ?, ?, ?)");
		try(
				Connection con = getConexao();
				PreparedStatement  ps = con.prepareStatement(query.toString())){

			int i=1;
			ps.setString(i++, compromissoVo.getRowidFuncionario());
			ps.setString(i++, compromissoVo.getRowidAgenda());
			ps.setObject(i++, compromissoVo.getData());
			ps.setObject(i++, compromissoVo.getHorario());
			ps.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
			
			throw e;
		}
	}


	public void deleteCompromisso(Integer codigo) throws SQLException {
		StringBuilder query = new StringBuilder("DELETE FROM compromisso WHERE rowid = ?");

		try(Connection con = getConexao();
				PreparedStatement ps = con.prepareStatement(query.toString())){

			int i = 1;

			ps.setInt(i, codigo);
			ps.execute();
		}catch (SQLException e) {
			e.printStackTrace();
			
			throw e;
		}
	}


	public CompromissoVo findByCodigo(Integer codigo) throws SQLException{
		StringBuilder query = new StringBuilder("SELECT rowid id, funcionario_id f_id, ")
				.append("agenda_id a_id, data, horario FROM compromisso ")
				.append("WHERE rowid = ?");

		try(Connection con = getConexao();
				PreparedStatement ps = con.prepareStatement(query.toString())){
			
			int i = 1;

			ps.setInt(i, codigo);

			try(ResultSet rs = ps.executeQuery()){
				CompromissoVo vo =  null;

				while (rs.next()) {
					vo = new CompromissoVo();
					vo.setRowid(rs.getString("id"));
					vo.setRowidFuncionario(rs.getString("f_id")); ;
					vo.setRowidAgenda(rs.getString("a_id"));
					vo.setData(rs.getObject("data", LocalDate.class));
					vo.setHorario(rs.getObject("horario", LocalTime.class));
				}
				return vo;
			}
		}catch (SQLException e) {
			e.printStackTrace();
			
			throw e;
		}		
	}

}