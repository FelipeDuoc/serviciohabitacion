/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import DAO.DisponibilidadDAO;
import DAOImpl.DisponibilidadDAOImpl;
import Modelo.Disponibilidad;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;

/**
 *
 * @author Duoc
 */
@WebService(serviceName = "servicioHabitacion")
public class servicioHabitacion {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "DisponibilidadHabitaciones")
    @WebResult(name ="Disponible")
    public Disponibilidad getDisponibilidad(@WebParam(name = "idTipoHabitacion") int idTipoHabitacion) {
        
        Disponibilidad disp = new Disponibilidad();
        DisponibilidadDAO res = new DisponibilidadDAOImpl();
        
        disp = res.buscarDisponibilidadHabitacion(idTipoHabitacion);
        
        return disp;
          
    }
}
