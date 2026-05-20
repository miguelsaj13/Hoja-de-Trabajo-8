//Clase obtenida de los módulos del curso

import java.util.Vector;

/**
 * Implementación de una Priority Queue usando Min Heap.
 * 
 * @param <E> tipo de dato comparable almacenado en el heap
 */
public class VectorHeap<E extends Comparable<E>> implements PriorityQueue<E>
{

	protected Vector<E> data; // the data, kept in heap order

	/**
	 * Construye un heap vacío.
	 */
	public VectorHeap()
	// post: constructs a new priority queue
	{
		data = new Vector<E>();
	}

	/**
	 * Construye un heap a partir de un vector.
	 * 
	 * @param v vector inicial
	 */
	public VectorHeap(Vector<E> v)
	// post: constructs a new priority queue from an unordered vector
	{
		int i;
		data = new Vector<E>(v.size()); // we know ultimate size
		for (i = 0; i < v.size(); i++)
		{ // add elements to heap
			add(v.get(i));
		}
	}

	/**
	 * Obtiene el índice del padre.
	 * 
	 * @param i índice del nodo
	 * @return índice del padre
	 */
	protected static int parent(int i)
	// pre: 0 <= i < size
	// post: returns parent of node at location i
	{
		return (i - 1) / 2;
	}

	/**
	 * Obtiene el índice del hijo izquierdo.
	 * 
	 * @param i índice del nodo
	 * @return índice del hijo izquierdo
	 */
	protected static int left(int i)
	// pre: 0 <= i < size
	// post: returns index of left child of node at location i
	{
		return 2 * i + 1;
	}

	/**
	 * Obtiene el índice del hijo derecho.
	 * 
	 * @param i índice del nodo
	 * @return índice del hijo derecho
	 */
	protected static int right(int i)
	// pre: 0 <= i < size
	// post: returns index of right child of node at location i
	{
		return (2 * i + 1) + 1;
	}

	/**
	 * Reacomoda un nodo hacia arriba para mantener el heap.
	 * 
	 * @param leaf posición del nodo
	 */
	protected void percolateUp(int leaf)
	// pre: 0 <= leaf < size
	// post: moves node at index leaf up to appropriate position
	{
		int parent = parent(leaf);
		E value = data.get(leaf);

		while (leaf > 0 &&
			   (value.compareTo(data.get(parent)) < 0))
		{
			data.set(leaf, data.get(parent));
			leaf = parent;
			parent = parent(leaf);
		}

		data.set(leaf, value);
	}

	/**
	 * Agrega un elemento al heap.
	 * 
	 * @param value elemento a insertar
	 */
	@Override
	public void add(E value)
	// pre: value is non-null comparable
	// post: value is added to priority queue
	{
		data.add(value);
		percolateUp(data.size() - 1);
	}

	/**
	 * Reacomoda la raíz hacia abajo para mantener el heap.
	 * 
	 * @param root índice de la raíz
	 */
	protected void pushDownRoot(int root)
	// pre: 0 <= root < size
	// post: moves node at index root down
	// to appropriate position in subtree
	{
		int heapSize = data.size();
		E value = data.get(root);

		while (root < heapSize)
		{
			int childpos = left(root);

			if (childpos < heapSize)
			{
				if ((right(root) < heapSize) &&
					((data.get(childpos + 1)).compareTo
					(data.get(childpos)) < 0))
				{
					childpos++;
				}

				// Assert: childpos indexes smaller of two children

				if ((data.get(childpos)).compareTo(value) < 0)
				{
					data.set(root, data.get(childpos));
					root = childpos; // keep moving down
				}
				else
				{ // found right location
					data.set(root, value);
					return;
				}
			}
			else
			{ // at a leaf! insert and halt
				data.set(root, value);
				return;
			}
		}
	}

	/**
	 * Elimina y retorna el elemento más pequeño del heap.
	 * 
	 * @return elemento más pequeño
	 */
	@Override
	public E remove()
	// pre: !isEmpty()
	// post: returns and removes minimum value from queue
	{
		if (isEmpty())
		{
			return null;
		}

		E minVal = getFirst();

		E last = data.remove(data.size() - 1);

		if (!isEmpty())
		{
			data.set(0, last);
			pushDownRoot(0);
		}

		return minVal;
	}

	/**
	 * Retorna el elemento más pequeño del heap.
	 * 
	 * @return elemento mínimo
	 */
	@Override
	public E getFirst()
	// pre: !isEmpty()
	// post: returns the minimum value in priority queue
	{
		return data.get(0);
	}

	/**
	 * Verifica si el heap está vacío.
	 * 
	 * @return true si no hay elementos
	 */
	@Override
	public boolean isEmpty()
	// post: returns true iff no elements are in queue
	{
		return data.isEmpty();
	}

	/**
	 * Retorna la cantidad de elementos en el heap.
	 * 
	 * @return tamaño del heap
	 */
	@Override
	public int size()
	// post: returns number of elements within queue
	{
		return data.size();
	}

	/**
	 * Elimina todos los elementos del heap.
	 */
	@Override
	public void clear()
	// post: removes all elements from queue
	{
		data.clear();
	}
}