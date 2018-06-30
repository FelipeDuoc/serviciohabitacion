/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOImpl;

import DAO.DisponibilidadDAO;
import Modelo.Conexion;
import Modelo.Disponibilidad;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.internal.OracleTypes;

/**
 *
 * @author Felipe
 */
public class DisponibilidadDAOImpl implements DisponibilidadDAO{
    private static final Logger logger = Logger.getLogger(DisponibilidadDAOImpl.class.getName());
    private Connection con;
    private Conexion cx;
    
    @Override
    public Disponibilidad buscarDisponibilidadHabitacion(int idTipoHabitacion) {
        Disponibilidad disp = new Disponibilidad();
        cx = new Conexion();
        con = cx.getCon();
        OracleCallableStatement ps = null;
        ResultSet rs = null;
        try {
            ps = (OracleCallableStatement) con.prepareCall("{call PKG_TIPO_HABITACION.PROC_DISPONIBILIDAD_HABITACION(?,?,?)}");
            ps.setInt(1, idTipoHabitacion);
            ps.registerOutParameter(2, OracleTypes.INTEGER);
            ps.registerOutParameter(3, OracleTypes.INTEGER);
            
            ps.execute();
            
            disp.setCantidadDisponible((int) ps.getObject(2));
            disp.setValorHabitacion((int) ps.getObject(3));
            
            
        } catch (SQLException ex) {
            logger.log(Level.INFO, "CALL PROCEDURE PKG_TIPO_HABITACION.PROC_DISPONIBILIDAD_HABITACION, sql exception statement: {0}", ex.getMessage());
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                logger.log(Level.SEVERE, null, ex);
            }
        }
        return disp;
    }
    
}
