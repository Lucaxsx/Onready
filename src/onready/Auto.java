package onready;

/*
 *
 *  Autor:  Santillan, Lucas.
 *  DNI:    39.272.552
 *  Tel.:   11 3289 - 5164
 * 
 */
public class Auto extends Vehiculo{
    private final int puertas;
    
    public Auto(String marca, String modelo, int puertas, double precio){
       
       super(marca, modelo, precio);
       this.puertas = puertas;
               
    }
    
    //      Sobreescritura del método que retorna los datos del vehículo.
    @Override
    public String descripcion(){
        return "Marca:  " + getMarca() +
                " // Modelo:  " + getModelo() + " // Puertas:  " +
                puertas + " Precio:  $" + separarNumeros(getPrecio());
    }
}
