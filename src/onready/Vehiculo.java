package onready;

import java.text.DecimalFormat;

/*
 *
 *  Autor:  Santillan, Lucas.
 *  DNI:    39.272.552
 *  Tel.:   11 3289 - 5164
 * 
 */
public abstract class Vehiculo {
    
    private final String marca;
    private final String modelo;
    private final double precio;
    
    public Vehiculo(String marca, String modelo, double precio){
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
    }
    
    public String getMarca(){
        return marca;
    }
    
    public String getModelo(){
        return modelo;
    }
    
    public double getPrecio(){
        return precio;
    }
    
    //      Método que cambia el formato de los precios, separándolos con puntos y comas.
    public static String separarNumeros(double precio){
        DecimalFormat formatear = new DecimalFormat("#,###.00");
        return formatear.format(precio);
    }
    
    abstract String descripcion();
    
}
