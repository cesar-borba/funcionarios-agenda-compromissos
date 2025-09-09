package br.com.soc.sistema.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.soc.sistema.vo.AgendaVo;
import br.com.soc.sistema.vo.Periodo;

public class AgendaDao extends Dao{

	public void updateAgenda(AgendaVo agendaVo) {
		StringBuilder query = new StringBuilder("UPDATE agenda ")
				.append("SET nm_agenda = ? , periodo = ? ")
				.append("WHERE rowid = ?");

		try(Connection con = getConexao();
				PreparedStatement ps = con.prepareStatement(query.toString())){

			int i=1;
			ps.setString(i++, agendaVo.getNome());
			ps.setString(i++, agendaVo.getPeriodo().name());
			ps.setString(i++, agendaVo.getRowid());
			ps.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteAgenda(Integer codigo) throws SQLException {
		StringBuilder query = new StringBuilder("DELETE FROM agenda WHERE rowid = ?");

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

	public void insertAgenda(AgendaVo agendaVo){
		StringBuilder query = new StringBuilder("INSERT INTO agenda (nm_agenda, periodo) values (?, ?)");
		try(
				Connection con = getConexao();
				PreparedStatement  ps = con.prepareStatement(query.toString())){

			int i=1;
			ps.setString(i++, agendaVo.getNome());
			ps.setString(i++, agendaVo.getPeriodo().name());
			ps.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<AgendaVo> findAllAgendas(){
		StringBuilder query = new StringBuilder("SELECT rowid id, nm_agenda nome, periodo FROM agenda");
		try(
				Connection con = getConexao();
				PreparedStatement  ps = con.prepareStatement(query.toString());
				ResultSet rs = ps.executeQuery()){

			AgendaVo vo =  null;
			List<AgendaVo> agendas = new ArrayList<>();
			while (rs.next()) {
				vo = new AgendaVo();
				vo.setRowid(rs.getString("id"));
				vo.setNome(rs.getString("nome"));
				vo.setPeriodo(Periodo.valueOf(rs.getString("periodo")));
				
				agendas.add(vo);
			}
			return agendas;
		}catch (SQLException e) {
			e.printStackTrace();
		}

		return Collections.emptyList();
	}
	
	public List<AgendaVo> findAllByNome(String nome){
		StringBuilder query = new StringBuilder("SELECT rowid id, nm_agenda nome, periodo FROM agenda ")
				.append("WHERE lower(nm_agenda) like lower(?)");

		try(Connection con = getConexao();
				PreparedStatement ps = con.prepareStatement(query.toString())){
			int i = 1;

			ps.setString(i, "%"+nome+"%");

			try(ResultSet rs = ps.executeQuery()){
				AgendaVo vo =  null;
				List<AgendaVo> agendas = new ArrayList<>();

				while (rs.next()) {
					vo = new AgendaVo();
					vo.setRowid(rs.getString("id"));
					vo.setNome(rs.getString("nome"));
					vo.setPeriodo(Periodo.valueOf(rs.getString("periodo")));

					agendas.add(vo);
				}
				return agendas;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}		
		return Collections.emptyList();
	}
	
	public AgendaVo findByCodigo(Integer codigo){
		StringBuilder query = new StringBuilder("SELECT rowid id, nm_agenda nome, periodo FROM agenda ")
				.append("WHERE rowid = ?");

		try(Connection con = getConexao();
				PreparedStatement ps = con.prepareStatement(query.toString())){
			int i = 1;

			ps.setInt(i, codigo);

			try(ResultSet rs = ps.executeQuery()){
				AgendaVo vo =  null;

				while (rs.next()) {
					vo = new AgendaVo();
					vo.setRowid(rs.getString("id"));
					vo.setNome(rs.getString("nome"));
	                vo.setPeriodo(Periodo.valueOf(rs.getString("periodo")));
				}
				return vo;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}		
		return null;
	}
}
