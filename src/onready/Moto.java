package onready;

/*
 *
 *  Autor:  Santillan, Lucas.
 *  DNI:    39.272.552
 *  Tel.:   11 3289 - 5164
 * 
 */
public class Moto extends Vehiculo{
    private final int cilindradas;
    
    public Moto(String marca, String modelo, int cilindradas, double precio){
        super(marca, modelo, precio);
        this.cilindradas = cilindradas;
    }
    
    //      Sobreescritura del método que retorna los datos del vehículo.
    @Override
    public String descripcion(){
        return "Marca:  " + getMarca() +
                " // Modelo:  " + getModelo() + " // Cilindradas:  " +
                cilindradas + "c // Precio:  $" + separarNumeros(getPrecio());
    }
    
}
