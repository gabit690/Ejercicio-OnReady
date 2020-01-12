/**
 * Un auto es un vehículo de 4 ruedas para viajar por tierra conducido 
 * por una persona mediante un volante.
 */
public class Auto extends Vehiculo {
	
	private int puertas;

	/**
	 * PRE: El precio y la cantidad de puertas deben ser mayores a 0.
	 * POST: Crea un auto para la venta con la marca, modelo, precio y
	 * la cantidad de puertas indicadas por parámetro.
	 */
	public Auto(String marca, String modelo, double precio, int puertas) {
		
		super(marca, modelo, precio);
		
		if (puertas <= 0) {
			
			throw new RuntimeException("Las puertas deben ser mayores a 0.");
		}
		
		this.puertas = puertas;
	}
	
	/**
	 * POST: Devuelve el número de puertas que tiene el auto.
	 */
	public int obtenerPuertas() {
		
		return this.puertas;
	}
	
	@Override
	/**
	 * POST: Muestra por pantalla cual es la marca, el modelo, la cantidad 
	 * de puertas y el precio que tiene el auto.
	 */
	public String obtenerDescripcion() {
		
		String info = "Marca: " + this.obtenerMarca() + " // " + 
					  "Modelo: " + this.obtenerModelo() + " // " + 
					  "Puertas: " + this.obtenerPuertas() + " // " + 
					  "Precio: $" + 
					  Vehiculo.formatoDePrecio.format(this.obtenerPrecio());
		
		return info;		
	}

}
