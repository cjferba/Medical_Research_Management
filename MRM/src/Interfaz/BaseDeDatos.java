/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import oracle.jdbc.OracleResultSet;

/**
 *
 * @author Carlos Basso
 */
public class BaseDeDatos {

    Statement stmt;
    Connection conexion;

    BaseDeDatos() {

        conexion = abreConexion("oracle.jdbc.driver.OracleDriver", "jdbc:oracle:thin:@oracle0.ugr.es:1521:practbd",
                "x5927137", "x5927137");
        try {
            stmt = conexion.createStatement();
        } catch (SQLException ex) {
            //errores.setText(ex.getMessage());
        }
    }

    BaseDeDatos(String Usuario, String pass, String driver, String server) {
        conexion = abreConexion(driver, server, Usuario, pass);
        try {
            stmt = conexion.createStatement();
        } catch (SQLException ex) {
            //errores.setText(ex.getMessage());
        }
    }

    private Connection abreConexion(String driver, String servidor, String usuario, String clave) {
        try {
            Class.forName(driver);
            //busca el controlador y abre la conexion
            return DriverManager.getConnection(servidor, usuario, clave);
        } catch (ClassNotFoundException e) {
            //errores.setText("No se ha podido cargar los controladores");
            return null;
        } catch (SQLException e) {
            //errores.setText("No se ha podido acceder a la base de datos");
            return null;
        }

    }

    public void Cerrar() {
        try {
            conexion.close();
        } catch (SQLException ex) {
            //errores.setText(ex.getMessage());
        }

    }

    public OracleResultSet EjecutaConsulta(String a) {
        OracleResultSet resultado;
        try {

            String miconsulta = a;
            resultado = (OracleResultSet) stmt.executeQuery(miconsulta);
            return resultado;
        } catch (SQLException ex) {
            //errores.setText(ex.getMessage());
            return null;
        }
        //as= casti del tipo(tipo)resultsetoracle.getORAData(Numparametro,tipo.getORADataFactory())
        //prar cursores utilizarlo igual con getcursor
    }
    
    
}
