/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Felipe
 */
public class Disponibilidad {
    private int cantidadDisponible;
    private int valorHabitacion;

    public Disponibilidad() {
    }

    public Disponibilidad(int cantidadDisponible, int valorHabitacion) {
        this.cantidadDisponible = cantidadDisponible;
        this.valorHabitacion = valorHabitacion;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    public int getValorHabitacion() {
        return valorHabitacion;
    }

    public void setValorHabitacion(int valorHabitacion) {
        this.valorHabitacion = valorHabitacion;
    }

    @Override
    public String toString() {
        return "Disponibilidad{" + "cantidadDisponible=" + cantidadDisponible + ", valorHabitacion=" + valorHabitacion + '}';
    }
    
    
    
}
