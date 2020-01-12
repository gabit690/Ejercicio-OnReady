import java.text.DecimalFormat;

/**
 * Un vehículo es una máquina utilizada para desplazarse desde un 
 * punto hacia otro.
 * Este vehículo esta destinado a la venta al público.
 */
public abstract class Vehiculo implements Comparable<Vehiculo> {

	private String marca;
	
	private String modelo;
	
	private double precio;
	
	public static DecimalFormat formatoDePrecio;
	
	/**
	 * PRE: El precio es mayor a 0.
	 * POST: Crea un vehículo de la marca, modelo y el precio indicados 
	 * por parámetro.
	 */
	public Vehiculo(String marca, String modelo, double precio) {
		
		if (precio <= 0) {
			
			throw new RuntimeException("El precio debe ser mayor a 0.");
		}
		
		this.marca = marca;
		
		this.modelo = modelo;
		
		this.precio = precio;
        
		// Formato del precio del vehículo que se quiere mostrar.
        Vehiculo.formatoDePrecio = new DecimalFormat("#,###.00");
	}
	
	/**
	 * PRE: El nuevo precio es mayor a 0.
	 * POST: Cambia el precio del vehículo al nuevo precio.
	 */
	public void cambiarPrecio(double nuevoPrecio) {
		
		if (nuevoPrecio <= 0) {
			
			throw new RuntimeException("El precio debe ser mayor a 0.");
		}
		
		this.precio = nuevoPrecio;
	}
	
	/**
	 * POST: Devuelve la marca.
	 */
	public String obtenerMarca() {
		
		return this.marca;
	}
	
	/**
	 * POST: Devuelve el modelo.
	 */
	public String obtenerModelo() {
		
		return this.modelo;
	}
	
	/**
	 * POST: Devuelve el precio.
	 */
	public double obtenerPrecio() {
		
		return this.precio;
	}
	
	/**
	 * POST: Devuelve la informacion del vehículo.
	 */
	public abstract String obtenerDescripcion();

	/**
    * POST: devuelve un entero que indica si el vehículo tiene un precio 
    * mayor, menor o igual a otroVehiculo.
    * Si devuelve -1: otroVehiculo tiene un mayor precio.
    * Si devuelve 1: otroVehiculo tiene un menor precio.
    * Si devuelve 0: ambos productos tiene el mismo precio.
	 */
	public int compareTo(Vehiculo otroVehiculo) {

        double diferenciaDePrecios = this.precio - otroVehiculo.obtenerPrecio();

        if(diferenciaDePrecios < 0){

            return -1;
            
        }

        if(diferenciaDePrecios > 0){

            return 1;
            
        } else {

            return 0;
        }

	}
	
}
