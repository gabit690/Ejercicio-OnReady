/**
 * Son funciones que permiten obtener información de un conjunto
 * de productos.
 */
public interface InformesDeStock {

	void mostrarInformacionDelStock();
	
	void mostrarProductoMasCaro();
	
	void mostrarProductoMasBarato();
	
	void mostrarProductoQueLlevaLetra(char letraBuscada);
	
	void mostrarProductosPorPrecioDescendente();
}
