/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Disponibilidad;

/**
 *
 * @author Felipe
 */
public interface DisponibilidadDAO {
    public Disponibilidad buscarDisponibilidadHabitacion(int idTipoHabitacion);
}
