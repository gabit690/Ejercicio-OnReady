import java.util.Comparator;

/**
 * Un ordenador por precio se utiliza para darle un orden a
 * una cantidad de vehiculos segun su precio de forma descendente.
 */
public class OrdenadorPorPrecio implements Comparator<Vehiculo> {

	@Override
	public int compare(Vehiculo v1, Vehiculo v2) {

		return v2.compareTo(v1);
	}

}
