package sistematickets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionBD {

    private static final String URL = "jdbc:mysql://shinkansen.proxy.rlwy.net:23994/railway";
    private static final String USER = "root";
    private static final String PASSWORD = "dHqqodLUzWdoNvpYemIHRrsJaIcOFWhS";

    public static Connection conectar() {
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("✅ Conexión exitosa a la base de datos");
            return conn;
        } catch (SQLException e) {
            System.out.println("❌ Error de conexión: " + e.getMessage());
            return null;
        }
    }

    public static void crearTablaUsuariosSiNoExiste() {
        String sql = "CREATE TABLE IF NOT EXISTS usuarios ("
                   + "id INT AUTO_INCREMENT PRIMARY KEY,"
                   + "nombre VARCHAR(100),"
                   + "correo VARCHAR(100) UNIQUE,"
                   + "contrasena VARCHAR(100)"
                   + ");";
        try (Connection conn = conectar(); Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("✅ Tabla 'usuarios' verificada o creada con éxito");
        } catch (SQLException e) {
            System.out.println("❌ Error creando tabla: " + e.getMessage());
        }
    }
}