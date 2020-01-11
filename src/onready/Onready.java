package onready;

/*
 *
 *  Autor:  Santillan, Lucas.
 *  DNI:    39.272.552
 *  Tel.:   11 3289 - 5164
 * 
 */
public class Onready implements Metodos{
    private static final Vehiculo[] vehiculos = new Vehiculo[4];

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
        
        System.out.println("Vehiculo mas caro:\t" + vehiculos[masCaro()].getMarca() + " " + vehiculos[masCaro()].getModelo());
        
        System.out.println("Vehiculo mas barato:\t" + vehiculos[masBarato()].getMarca() + " " + vehiculos[masBarato()].getModelo());
        
        buscarModeloPorLetra('Y');
        
        Separador();
        
        mayorAMenor(vehiculos);
    }
    
    //      Busca el vehículo cuyo modelo lleva la letra 'Y'
    public static void buscarModeloPorLetra(char letra){
        int index = 0;
        int posicion = 0;
        String modelo;
        for (Vehiculo v: vehiculos){
            modelo = v.getModelo();
            for(int i = 0; i < modelo.length(); i++){
                if(letra == modelo.charAt(i)){
                    index = posicion;
                }
            }
            posicion++;
        }
        System.out.print("Vehículo que contiene la letra '" + letra + "': ");
        System.out.println(vehiculos[index].getMarca() + " " + vehiculos[index].getModelo() + " $" +
                Vehiculo.separarNumeros(vehiculos[index].getPrecio()));
    }
    
    
    //      Devuelve el índice del objeto más caro del Array.
    public static int masCaro(){
        int i = 0;
        double mayor = 0;
        int indiceMayor = 0;
        for(Vehiculo v: vehiculos){
            if(!Metodos.mayorOmenor(mayor, v.getPrecio())){
                mayor = v.getPrecio();
                indiceMayor = i;
            }
            i++;
        }
        return indiceMayor;
    }
    
    
    //      Devuelve el índice del objeto más barato del Array.
    public static int masBarato(){
        int i = 0;
        int indiceMenor = 0;
        int coincidencias = 0;
        
        for(Vehiculo v: vehiculos){
            for(Vehiculo y: vehiculos){
                if(!Metodos.mayorOmenor(v.getPrecio(), y.getPrecio())){
                    coincidencias++;
                    if(coincidencias == (vehiculos.length-1)){
                        indiceMenor = i;
                    }
                }
            }
            i++;
        }
        
        return indiceMenor;        
    }
    
    //      Separa las consignas con muchos símbolos =.
    public static void Separador(){
        for (int i = 0; i < 30 ; i++){
            System.out.print("=");
        }
        System.out.print("\n");
    }    
    
    
    //      Imprime los objetos ordenados por precio de mayor a menor. 
    public static void mayorAMenor(Vehiculo[] o){
        int i = o.length;
        double[] aOrdenar = new double[i];
        int index = 0;
        for(Vehiculo v: o){
            aOrdenar[index] = v.getPrecio();
            index++;
        }
        
        //  Llama al método que devuelve un Array ordenado de mayor a menor.
        double[] ordenados = ordenar(aOrdenar);
        for(double d:ordenados){
            //      Imprime la marca y el modelo de los vehículos comparando los precios ordenados.
            System.out.println(buscarPorPrecio(d));
        }
    }
    
    
    //      Método Burbuja, para ordenar los precios de mayor a menor.
    public static double[] ordenar(double[] precios){
        double ordenado[];
        double aux;
        
        for(int i = 1; i < precios.length; i++){
            for(int x = 0; x < precios.length-i; x++){
                if(precios[x] < precios[x+1]){
                    aux = precios[x];
                    precios[x] = precios[x+1];
                    precios[x+1] = aux;
                }
            }
        }
        ordenado = precios;        
        return ordenado;
    }
    
    public static String buscarPorPrecio(double precio){
        int i = 0;
        int index = 0;
        for(Vehiculo v: vehiculos){
            if(v.getPrecio() == precio){
                index = i;
            }
            i++;
        }
        return vehiculos[index].getMarca() + " " + vehiculos[index].getModelo();
    }
    
}
