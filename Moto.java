/**
 * Una moto es un vehículo de 2 ruedas para viajar por tierra conducido por una persona
 * mediante un manubrio.
 */
public class Moto extends Vehiculo {

	private int cilindrada;
	
	/**
	 * PRE: El precio y la cilindrada deden ser mayores a 0.
	 * POST: Crea una moto para la venta con la marca, modelo, precio y
	 * la cilindrada indicada por parámetro.
	 */
	public Moto(String marca, String modelo, double precio, int cilindrada) {
		
		super(marca, modelo, precio);
		
		if (cilindrada <= 0) {
			
			throw new RuntimeException("La cilindrada debe ser mayor a 0.");
		}
		
		this.cilindrada = cilindrada;
	}

	/**
	 * POST: Devuelve la cilindrada que tiene la moto.
	 */
	public int obtenerCilindrada() {
		
		return this.cilindrada;
	}
	
	@Override
	/**
	 * POST: Muestra por pantalla cual es la marca, el modelo, la cilindrada
	 * y el precio que tiene la moto.
	 */
	public String obtenerDescripcion() {
		
		String info = "Marca: " + this.obtenerMarca() + " // " + 
		 			  "Modelo: " + this.obtenerModelo() + " // " + 
		 			  "Cilindrada: " + this.obtenerCilindrada() + "c" + 
		 			  " // " + "Precio: $" + 
					  Vehiculo.formatoDePrecio.format(this.obtenerPrecio());

		return info;
	}
}
