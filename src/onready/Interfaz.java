package onready;


public class Interfaz implements Metodos {
	
    //  Devuelve Modelo, Marca y Precio del objeto cuyo Modelo contenga la letra 'Y'
    @Override
    public String buscarModeloPorLetra(char letra, Vehiculo[] vehiculo){
        int index = 0;
	int position = 0;
	String modelo;
	for(Vehiculo v:vehiculo){
            modelo = v.getModelo();
            for(int i = 0; i<modelo.length(); i++) {
		if(letra == modelo.charAt(i)) {
			position = index;
			}
		}
		index++;
	}
	return vehiculo[position].getMarca() + " " 
                + vehiculo[position].getModelo() + " $"
                + Vehiculo.separarNumeros(vehiculo[position].getPrecio());
	}
        
    @Override
    public String masCaro(Vehiculo[] vehiculo){
        int i = 0;
        int position = 0;
        double mayor = 0;
        for(Vehiculo v:vehiculo){
            if(mayorOmenor(mayor, v.getPrecio())){
                position = i;
            }else{
                mayor = v.getPrecio();
                i++;
            }
        }
        return vehiculo[position].getMarca() + " "
               + vehiculo[position].getModelo();
    }
        
    @Override
    public String masBarato(Vehiculo[] vehiculo){
        int i = 0;
        int position = 0;
        int coincidencias = 0;

        for(Vehiculo v: vehiculo){
            for(Vehiculo y: vehiculo){
                if(!mayorOmenor(v.getPrecio(), y.getPrecio())){
                    coincidencias++;
                    if(coincidencias == (vehiculo.length-1)){
                        position = i;
                    }
                }
            }
            i++;
        }    
            
        return vehiculo[position].getMarca() + " "
               + vehiculo[position].getModelo();
    }    
    
    //      Método Burbuja, para ordenar los precios de mayor a menor.
    @Override
    public double[] ordenar(double[] precios){
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
    
    
    //      Imprime los objetos ordenados de mayor a menor según su precio.
    @Override
    public void mayorAmenor(Vehiculo[] vehiculo){
        int i = vehiculo.length;
        int index = 0;
        double[] aOrdenar = new double[i];
        for(Vehiculo v: vehiculo){
            aOrdenar[index] = v.getPrecio();
            index++;
        }
        
        //  Llama al método que devuelve un Array ordenado de mayor a menor.
        double[] ordenados = ordenar(aOrdenar);
        for(double d:ordenados){
            //      Imprime la marca y el modelo de los vehículos comparando los precios ordenados.
            System.out.println(buscarPorPrecio(d, vehiculo));
        }
    }
    
    private String buscarPorPrecio(double precio, Vehiculo[] vehiculo){
        int i = 0;
        int position = 0;
        for(Vehiculo v: vehiculo){
            if(v.getPrecio() == precio){
                position = i;
            }
            i++;
        }
        return vehiculo[position].getMarca() + " " + vehiculo[position].getModelo();
    }
        
    private boolean mayorOmenor(double a, double b){
        return a >= b;
    }
        
}
