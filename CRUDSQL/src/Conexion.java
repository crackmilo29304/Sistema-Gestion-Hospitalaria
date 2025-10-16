import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    public static Connection getConexion(){
        try {
            // Cargar driver explícitamente
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            // CORREGIDO: Formato correcto para JDBC
            String url = "jdbc:sqlserver://localhost:1433;"
                       + "databaseName=escuela;"
                       + "encrypt=true;"
                       + "trustServerCertificate=true";
            
            String user = "sa";
            String password = "UnaClaveSegura123!";
            
            System.out.println("Conectando a: " + url);
            System.out.println("Usuario: " + user);
            
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("¡CONEXIÓN EXITOSA!");
            return con;
            
        } catch(ClassNotFoundException e) {
            System.out.println("Error: Driver no encontrado - " + e.getMessage());
            return null;
        } catch(SQLException e) {
            System.out.println("Error SQL: " + e.getMessage());
            
            // Información específica para diagnóstico
            if (e.getMessage().contains("login")) {
                System.out.println("⚠️ Problema de autenticación - Verifica usuario/contraseña");
            } else if (e.getMessage().contains("database")) {
                System.out.println("⚠️ La base de datos 'escuela' no existe");
            }
            
            return null;
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== PRUEBA DE CONEXIÓN ===");
        System.out.println("Estado: SQL Server RUNNING, Puerto 1433 LISTENING");
        
        Connection conn = getConexion();
        if (conn != null) {
            System.out.println("✅ ¡CONEXIÓN EXITOSA! Todo está funcionando.");
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("❌ Falla en autenticación o base de datos");
        }
    }
}