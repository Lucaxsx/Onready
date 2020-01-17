package onready;

/*
 *
 *  Autor:  Santillan, Lucas.
 *  DNI:    39.272.552
 *  Tel.:   11 3289 - 5164
 * 
 */
public class Onready{
    private static final Vehiculo[] vehiculos = new Vehiculo[4];
    //  Instancio un objeto de clase Interfaz, que implementa la interface Metodos
    private static Interfaz interfaz = new Interfaz();
    
    public static void main(String[] args) {        
        
        cargarDatos();        
        
        imprimirEnPantalla();
        
    }
    
    //      Instancia objetos en un Array de clase Vehiculo.
    public static void cargarDatos(){
        vehiculos[0] = new Auto("Peugeot", "206", 4, 200000);
        vehiculos[1] = new Moto("Honda", "Titan", 125, 60000);
        vehiculos[2] = new Auto("Peugeot", "208", 5, 250000);
        vehiculos[3] = new Moto("Yamaha", "YBR",  160, 80500.50);
    }
    
    public static void imprimirEnPantalla(){        
        
        //      Imprime la descripción de los objetos.
        for(Vehiculo v: vehiculos){
            System.out.println(v.descripcion());
        }
        
        Separador();
        
        System.out.println("Vehiculo mas caro:\t" + interfaz.masCaro(vehiculos));
        
        System.out.println("Vehiculo mas barato:\t" + interfaz.masBarato(vehiculos));
        
        System.out.println("Vehículo que contiene en el modelo la letra 'Y': " +
                interfaz.buscarModeloPorLetra('Y', vehiculos));
        
        Separador();
        
        interfaz.mayorAmenor(vehiculos);
    }  
    
    //      Separa las consignas con muchos símbolos =.
    public static void Separador(){
        for (int i = 0; i < 30 ; i++){
            System.out.print("=");
        }
        System.out.print("\n");
    }    
    
     
    
}
