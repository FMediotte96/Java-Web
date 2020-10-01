package com.facu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.facu.connector.AdministradorDeConexiones;
import com.facu.entities.Alumno;

public class AlumnoDAO {
	
	private Connection conn;

	public AlumnoDAO() throws Exception {
		this.conn = AdministradorDeConexiones.getConnection();
	}

	public AlumnoDAO(Connection conn) {
		this.conn = conn;
	}
	
	public boolean save(Alumno a) {
		String sql = "insert into alumnos (nombre,apellido) values (?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, a.getNombre());
			ps.setString(2, a.getApellido());
			ps.execute();
			
			ResultSet rs = ps.getGeneratedKeys();
			if(rs.next()) { 
				a.setId(rs.getInt(1));
				ps.close();
				return true;
			} else {
				ps.close();
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} 
	}
	
	public boolean update(Alumno a) {
		String sql = "update alumnos set nombre = ?, apellido = ? where alumno_id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, a.getNombre());
			ps.setString(2, a.getApellido());
			ps.setInt(3, a.getId());
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean delete(int id) {
		String sql = "delete from alumnos where alumno_id = " + id;
		try {
			Statement deleteStatement = conn.createStatement();
			if(deleteStatement.executeUpdate(sql) > 0) {
				deleteStatement.close();
				return true;
			}
			deleteStatement.close();
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public Alumno getById(int id) {
		Alumno alumno = null;
		String sql = "select * from alumnos where alumno_id=" + id;
		ResultSet rs;
		try {
			rs = conn.createStatement().executeQuery(sql);
			if(rs.next()) {
				alumno = new Alumno(rs.getInt("alumno_id"), 
									rs.getString("nombre"),
									rs.getString("apellido")
						);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return alumno;
	}
	
	public ArrayList<Alumno> getByFiltro(String filtro) {
		String sql = "select * from alumnos " + filtro;
		ArrayList<Alumno> lista = new ArrayList<Alumno>();
		try {
			ResultSet rs = conn.createStatement().executeQuery(sql);
			while(rs.next()) {
				lista.add(new Alumno(rs.getInt("alumno_id"), 
									 rs.getString("nombre"),
									 rs.getString("apellido")
									)
						);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public ArrayList<Alumno> getAll() {
		return getByFiltro("where 1=1");
	}
	
	public ArrayList<Alumno> getByName(String nombre) {
		return getByFiltro("where nombre like '%"+ nombre +"%'");
	}

	public ArrayList<Alumno> getByLastName(String apellido) {
		return getByFiltro("where apellido like '%"+ apellido +"%'");
	}
	
	public ArrayList<Alumno> getAlumno(Alumno alumno) {
		return getByFiltro("where alumno_id = " + alumno.getId() + " and nombre = " + alumno.getNombre() 
						+ " and apellido = " + alumno.getApellido());
	}
	
}
