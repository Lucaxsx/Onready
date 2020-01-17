package onready;


/*
 *
 *  Autor:  Santillan, Lucas.
 *  DNI:    39.272.552
 *  Tel.:   11 3289 - 5164
 * 
 */
public interface Metodos {
    
    public abstract String buscarModeloPorLetra(char letra, Vehiculo[] v);
    
    public abstract String masCaro(Vehiculo[] v);
    
    public abstract String masBarato(Vehiculo[] v);
    
    public abstract double[] ordenar(double[] precios);
    
    public abstract void mayorAmenor(Vehiculo[] v);
    
}
