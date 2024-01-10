package JDBC_transacciones;

import databaseConnection.DatabaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBC_transacciones {
    public static void main(String[] args) {
        try (Connection c = DatabaseConnection.getConnection()){
            try(PreparedStatement sInsert = c.prepareStatement ("INSERT INTO " +
                    "clientes1 (dni, apellido, cp) VALUES (?,?,?);")){
                c.setAutoCommit(false);

                sInsert.setString(1, "54320198V");
                sInsert.setString(2, "CARVAJAL");
                sInsert.setString(3, "10109");
                sInsert.executeUpdate();

                sInsert.setString(1, "76543210S");
                sInsert.setString(2, "MARQUEZ");
                sInsert.setString(3, "56987");
                sInsert.executeUpdate();

                sInsert.setString(1, "90123445A");
                sInsert.setString(2, "MOLINA");
                sInsert.setString(3, "35153");
                sInsert.executeUpdate();

                c.commit();
            } catch (SQLException e){
                muestraErrorSQL(e);
                try {
                    c.rollback();
                    System.err.println("Se hace ROLLBACK");
                } catch (SQLException er) {
                    System.err.println("Error haciendo ROLLBACK");
                    muestraErrorSQL(er);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error de conexión");
            e.printStackTrace(System.err);
        }
    }

    public static void muestraErrorSQL (SQLException e) {
        System.err.println("SQL ERROR message: " + e.getMessage());
        System.err.println("SQL Estado: " + e.getSQLState());
        System.err.println("SQL Código específico: " + e.getErrorCode());
    }
}
