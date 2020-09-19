package com.facu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.facu.connector.AdministradorDeConexiones;
import com.facu.entities.User;

public class UserDAO {

	private Connection conn;
	
	public UserDAO() throws Exception {
		this.conn = AdministradorDeConexiones.getConnection();
	}

	public UserDAO(Connection conn) {
		this.conn = conn;
	}
	
	public boolean save(User user) {
		String sql = "insert into users (username, email, password) values (?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPassword());
			ps.execute();
			
			ResultSet rs = ps.getGeneratedKeys();
			if(rs.next()) {
				user.setId(rs.getInt(1));
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
	
	public List<User> getAll() {
		return getByFiltro("1=1");
	}
	
	public List<User> getLikeUsername(String username) {
		return getByFiltro("username like '%" + username + "%'");
	}
	
	public List<User> getByFiltro(String filtro) {
		String query = "select * from users where " + filtro;
		List<User> lista = new ArrayList<User>();
		try {
			ResultSet rs = conn.createStatement().executeQuery(query);
			while(rs.next()) {
				lista.add(
					new User(
						rs.getInt("id"),
						rs.getString("username"), 
						rs.getString("email"),
						rs.getString("password")
					)
				);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
}
