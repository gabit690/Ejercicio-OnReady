import java.util.ArrayList;

/**
 * Una concesionaria es un establecimiento comercial encargado
 * de la venta de vehiculos.
 */
public class Concesionaria implements InformesDeStock{

	private ArrayList<Vehiculo> vehiculosDisponibles;

	/**
	 * POST: Crea una concesionaria sin vehículos disponibles 
	 * para la venta.
	 */
	public Concesionaria() {
		
		this.vehiculosDisponibles = new ArrayList<Vehiculo>();
	}
	
	/**
	 * POST: Indica si hay vehículos para la venta.
	 */
	public boolean hayVehiculosDisponibles() {
		
		return (this.vehiculosDisponibles.size() > 0);
	}
	
	/**
	 * PRE: El precio y las puertas tiene que ser mayores que 0.
	 * POST: Agrega un auto a los vehiculos disponibles para la venta
	 * con las caracteristicas indicadas por parametro.
	 */
	public void agregarAuto(String marca, String modelo, double precio, int puertas) {
		
		Auto nuevoAuto = new Auto(marca, modelo, precio, puertas);
		
		this.vehiculosDisponibles.add(nuevoAuto);
	}
	
	/**
	 * PRE: El precio y la cilindrada tiene que ser mayores que 0.
	 * POST: Agrega una moto a los vehiculos disponibles para la venta
	 * con las caracteristicas indicadas por parametro.
	 */
	public void agregarMoto(String marca, String modelo, double precio, int cilindrada) {
		
		Moto nuevaMoto = new Moto(marca, modelo, precio, cilindrada);
		
		this.vehiculosDisponibles.add(nuevaMoto);
	}
	
	/**
	 * POST: Agrega los vehiculos con los que la concesionaria
	 * comienza sus actividades comerciales.
	 */
	public void cargarVehiculosIniciales() {
		
		this.agregarAuto("Peugeot", "206", 200000, 4);
		
		this.agregarMoto("Honda", "Titan", 60000, 125);
		
		this.agregarAuto("Peugeot", "208", 250000, 5);
		
		this.agregarMoto("Yamaha", "YBR", 80500.50, 160);
	}
	
	/**
	 * POST: Devuelve la cantidad de vehiculos disponibles para la venta.
	 */
	public int cantidadDeVehiculos() {
		
		return this.vehiculosDisponibles.size();
	}
	
	
	@Override
	/**
	 * POST: Muestra la descripcion de cada vehículo disponible.
	 */
	public void mostrarInformacionDelStock() {

		for (Vehiculo v: this.vehiculosDisponibles) {
			
			System.out.println(v.obtenerDescripcion());
		}
	
	}

	@Override
	/**
	 * PRE: Hay vehículos disponibles para la venta.
	 * POST: Muestra cual es el vehículo con el precio más alto.
	 */
	public void mostrarProductoMasCaro() {

		if ( this.hayVehiculosDisponibles() ) {
			
			Vehiculo vehiculoMasCaro = this.vehiculosDisponibles.get(0);
			
			for (Vehiculo unVehiculo: this.vehiculosDisponibles) {
				
				if (unVehiculo.compareTo(vehiculoMasCaro) == 1) {
					
					vehiculoMasCaro = unVehiculo;
				}
				
			}
			
			System.out.println("Vehículo más caro: " + vehiculoMasCaro.obtenerMarca() + 
								" " + vehiculoMasCaro.obtenerModelo());
			
		} else {
				
			throw new RuntimeException("No hay vehículos para la venta.");
		}

	}

	@Override
	/**
	 * PRE: Hay vehículos disponibles para la venta.
	 * POST: Muestra cual es el vehículo con el precio más bajo.
	 */
	public void mostrarProductoMasBarato() {

		if ( this.hayVehiculosDisponibles() ) {
			
			Vehiculo vehiculoMasBarato = this.vehiculosDisponibles.get(0);
			
			for (Vehiculo unVehiculo: this.vehiculosDisponibles) {
				
				if (unVehiculo.compareTo(vehiculoMasBarato) == -1) {
					
					vehiculoMasBarato = unVehiculo;
				}
				
			}
			
			System.out.println("Vehículo más barato: " + vehiculoMasBarato.obtenerMarca() + 
								" " + vehiculoMasBarato.obtenerModelo());
			
		} else {
				
			throw new RuntimeException("No hay vehículos para la venta.");
		}
		
	}

	@Override
	/**
	 * PRE: Hay vehículos disponibles para la venta.
	 * POST: Muestra informacion del vehículo que lleva la letra buscada
	 * en su modelo.
	 */
	public void mostrarProductoQueLlevaLetra(char letraBuscada) {

		if ( this.hayVehiculosDisponibles() ) {
			
			boolean encontrado = false;
			
			for (Vehiculo unVehiculo: this.vehiculosDisponibles) {
				
				encontrado = unVehiculo.obtenerModelo().indexOf(letraBuscada) != -1;
				
				if (encontrado) {
					
					System.out.println("Vehículo que contiene en el modelo la letra ‘Y’: "
										+ unVehiculo.obtenerMarca() + " " 
										+ unVehiculo.obtenerModelo() + " $" 
										+ Vehiculo.formatoDePrecio.format(unVehiculo.obtenerPrecio()));
					
					break;
				}
				
			}
			
			if (!encontrado) {
				
				System.out.println("No hay un vehículo que lleve la letra \'" + 
									letraBuscada + "\' en su modelo.");
			}
			
			
			
		} else {
				
			throw new RuntimeException("No hay vehículos para la venta.");
		}
		
	}

	@Override
	/**
	 * PRE: Hay vehículos disponibles para la venta.
	 * POST: Muestra la marca y el modelo de los vehiculos
	 * ordenados segun su precio de venta del mas caro al mas barato.
	 */
	public void mostrarProductosPorPrecioDescendente() {

		if ( this.hayVehiculosDisponibles() ) {
			
			System.out.println("Vehículos ordenados por precio de mayor a menor:");
			
			ArrayList<Vehiculo> copiaVehiculosDisponibles = new ArrayList<Vehiculo>();
			
			for (Vehiculo unVehiculo: this.vehiculosDisponibles) {
				
				copiaVehiculosDisponibles.add(unVehiculo);
			}
			
			copiaVehiculosDisponibles.sort(new OrdenadorPorPrecio());
			
			for (Vehiculo unVehiculo: copiaVehiculosDisponibles) {
				
				System.out.println(unVehiculo.obtenerMarca() + 
								   " " + unVehiculo.obtenerModelo());
			}
			
		} else {
				
			throw new RuntimeException("No hay vehículos para la venta.");
		}
		
	}
	
	/**
	 * POST: Muestra la informacion requerida definida previamente.
	 * 1° Muestra la descripcion de cada vehículo.
	 * 2° Muestra cual es el vehículo mas caro.
	 * 3° Muestra cual es el vehículo mas barato.
	 * 4° Muestra cual es el vehículo que contiene la letra "Y"
	 * en su modelo.
	 * 5° Muestra la marca y modelo de los vehiculos ordenados de 
	 * forma descendente según su precio.
	 */
	public void mostrarInformesRequeridos() {
		
		this.mostrarInformacionDelStock();
		
		System.out.println("=============================");
		
		this.mostrarProductoMasCaro();
		
		this.mostrarProductoMasBarato();
		
		this.mostrarProductoQueLlevaLetra('Y');
		
		System.out.println("=============================");
		
		this.mostrarProductosPorPrecioDescendente();
	}
}
