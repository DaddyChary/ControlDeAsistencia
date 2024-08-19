
package db.dao;

import db.Conexion;
import java.sql.SQLException;

/**
 *
 * @author DaddyChary
 */
public class DAOManager {

    private Conexion conn;
    private DAOAsistencia dAsistencia;
    private DAOUsuario dUsuario;

    public DAOManager() throws SQLException {
        conn = Conexion.getConexion();
        this.dAsistencia = new DAOAsistencia(conn);
        this.dUsuario = new DAOUsuario(conn);
    }

    public DAOAsistencia getdAsistencia() {
        return dAsistencia;   
    }

    public DAOUsuario getdUsuario() {
        return dUsuario;
    }
}
