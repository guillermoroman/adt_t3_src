package JDBC_creacion_tabla;

import databaseConnection.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_creacion_tabla {
    public static void main(String[] args) {
        //createTable();
        //alterTable();
        dropTable();
    }

    public static void createTable(){
        String sql = "CREATE TABLE clientes1 (" +
                "dni CHAR(9) NOT NULL, " +
                "apellido CHAR(20) NOT NULL, " +
                "cp INTEGER NOT NULL, " +
                "PRIMARY KEY (dni))";

        try (Connection c = DatabaseConnection.getConnection();
             Statement stmt = c.createStatement()){
            //Crear una nueva tabla
            stmt.execute(sql);
            System.out.println("Tabla 'clientes1' creada.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void alterTable(){
        String sql = "ALTER TABLE clientes1 MODIFY cp CHAR(5)";

        try (Connection c = DatabaseConnection.getConnection();
             Statement stmt = c.createStatement()) {
            // Ejecutar la sentencia de modificación
            stmt.execute(sql);
            System.out.println("La columna 'cp' de la tabla 'clientes1' ha sido modificada a CHAR(5).");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void dropTable(){
        String sql = "DROP TABLE IF EXISTS clientes1";

        try (Connection c = DatabaseConnection.getConnection();
             Statement stmt = c.createStatement()) {
            // Ejecutar la sentencia para eliminar la tabla
            stmt.execute(sql);
            System.out.println("La tabla 'clientes1' ha sido eliminada.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
