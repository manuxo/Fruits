package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.entities.Fruit;

public class FruitRepository implements IFruitRepository {

	@Override
	public List<Fruit> findAll() {
		List<Fruit> fruits = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String query = "SELECT id,name FROM fruits";
		try {
			conn = ConnectionManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				int index = 1;
				int id = rs.getInt(index++);
				String name = rs.getString(index++);
				fruits.add(new Fruit(id,name));
			}
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace(System.out);
		}finally {
			ConnectionManager.close(rs);
			ConnectionManager.close(stmt);
			ConnectionManager.close(conn);
		}
		return fruits;
	}

	@Override
	public Fruit findById(Integer id) {
		Fruit fruit = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "SELECT id,name FROM fruits WHERE id=?";
		try {
			conn = ConnectionManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String name = rs.getString(2);
				fruit = new Fruit(id,name);
				break;
			}
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace(System.out);
		}finally {
			ConnectionManager.close(rs);
			ConnectionManager.close(pstmt);
			ConnectionManager.close(conn);
		}
		return fruit;
	}

	@Override
	public int save(Fruit entity) {
		int rowsAffected = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String query = "INSERT INTO fruits(name) VALUES(?)";
		try {
			conn = ConnectionManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, entity.getName());
			rowsAffected = pstmt.executeUpdate();
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace(System.out);
		}finally {
			ConnectionManager.close(pstmt);
			ConnectionManager.close(conn);
		}
		return rowsAffected;
	}

	@Override
	public int update(Fruit entity) {
		int rowsAffected = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String query = "UPDATE fruits SET name=? WHERE id=?";
		try {
			conn = ConnectionManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, entity.getName());
			pstmt.setInt(2, entity.getId());
			rowsAffected = pstmt.executeUpdate();
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace(System.out);
		}finally {
			ConnectionManager.close(pstmt);
			ConnectionManager.close(conn);
		}
		return rowsAffected;
	}

	@Override
	public int delete(Integer id) {
		int rowsAffected = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String query = "DELETE FROM fruits WHERE id=?";
		try {
			conn = ConnectionManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, id);
			rowsAffected = pstmt.executeUpdate();
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace(System.out);
		}finally {
			ConnectionManager.close(pstmt);
			ConnectionManager.close(conn);
		}
		return rowsAffected;
	}

}
