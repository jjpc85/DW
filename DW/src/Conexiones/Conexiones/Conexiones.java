package Conexiones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.*;
import javax.swing.*;



public class Conexiones {
	String user;
	String pass;
	String url;
	Connection conex;
	Statement stm;

	public Conexiones() {
		user = "SYSTEM";
		pass = "1234";
		url = "jdbc:oracle:thin:@localhost:1521:XE";
		conex = null;
		stm = null;

	}

	public void conectar() throws InstantiationException, IllegalAccessException, SQLException {
            String url= "jdbc:oracle:thin:@localhost:1521:XE";
            conex = DriverManager.getConnection(url, user, pass);
            stm = conex.createStatement();
            JOptionPane.showMessageDialog(null, "Conexon realizada");

	}

	

	public String leerdatos() throws SQLException {
		stm = conex.createStatement();
		String cadSql = "";
		try {
			cadSql = "select * from ENTRENAMIENTOS";
			ResultSet rs = stm.executeQuery(cadSql);
			String datos = "";
			while (rs.next()) {
				datos += (rs.getString("ID") + " " + rs.getString(2) + " " + rs.getString(3)) + "\n";
			}

			return datos;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "La tabla no existe");
			return null;
		}

	}

	public void ingresarDatosBD(String id, String nombre, String rutina)
			throws SQLException {

		int r;
		String cadSql;
		stm = conex.createStatement();

		try {

			cadSql = "INSERT INTO ENTRENAMIENTOS VALUES ('" + id + "', '" + nombre
					+ "','" + rutina + "')";
			r = stm.executeUpdate(cadSql);
			JOptionPane.showMessageDialog(null, r + " registro agregado");

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Registro no agregado");
		}

	}

	public String buscarDatosBD(String id) throws SQLException {
		stm = conex.createStatement();

		String cadSql;

		try {
			String nombre = "";
			cadSql = "SELECT * FROM ENTRENAMIENTOS WHERE ID='" + id + "'";
			ResultSet rs = stm.executeQuery(cadSql);
			while (rs.next()) {
				nombre = rs.getString(1) + " " + rs.getString(2) + " "
						+ rs.getString(3);

			}
			return nombre;

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "El codigo no existe");

			return null;
		}

	}

	public void eliminarDatos(String id) throws SQLException {
		int r;
		String cadSql;
		stm = conex.createStatement();
		try {
			cadSql = "DELETE FROM ENTRENAMIENTOS WHERE ID='" + id + "'";
			r = stm.executeUpdate(cadSql);
			JOptionPane.showMessageDialog(null, r + " registro eliminado");
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "No se encontro el registro");
		}
	}

	public void eliminarTabla() throws SQLException {
		int r;
		String cadSql;
		stm = conex.createStatement();
		try {
			cadSql = "DROP TABLE ENTRENAMIENTOS";
			r = stm.executeUpdate(cadSql);
			JOptionPane.showMessageDialog(null, (r + 1) + "tabla eliminada");
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "No se encontro la tabla");

		}
	}

	public Connection getConex() {
		return conex;
	}

}