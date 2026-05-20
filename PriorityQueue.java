//Clase obtenida de los módulos del curso

/**
 * Interfaz para una cola de prioridad.
 * 
 * @param <E> tipo de dato comparable almacenado en la cola
 */
public interface PriorityQueue<E extends Comparable<E>>
{
	/**
	 * Retorna el elemento con mayor prioridad.
	 * 
	 * @return elemento mínimo de la cola
	 */
	public E getFirst();
	// pre: !isEmpty()
	// post: returns the minimum value in priority queue
	
	/**
	 * Elimina y retorna el elemento con mayor prioridad.
	 * 
	 * @return elemento mínimo eliminado
	 */
	public E remove();
	// pre: !isEmpty()
	// post: returns and removes minimum value from queue
	
	/**
	 * Agrega un elemento.
	 * 
	 * @param value elemento a insertar
	 */
	public void add(E value);
	// pre: value is non-null comparable
	// post: value is added to priority queue
	
	/**
	 * Verifica si la cola está vacía.
	 * 
	 * @return true si no hay elementos
	 */
	public boolean isEmpty();
	// post: returns true iff no elements are in queue
	
	/**
	 * Retorna la cantidad de elementos.
	 * 
	 * @return tamaño de la cola
	 */
	public int size();
	// post: returns number of elements within queue
	
	/**
	 * Elimina todos los elementos de la cola.
	 */
	public void clear();
	// post: removes all elements from queue
}