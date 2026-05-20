import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class VectorHeapTest {

    private VectorHeap<Integer> heap;

    @Before
    public void configurar() {

        // Se crea un heap vacío antes de cada prueba
        heap = new VectorHeap<>();
    }

    @Test
    public void probarHeapVacioInicialmente() {

        // El heap debería iniciar vacío
        assertTrue(heap.isEmpty());
    }

    @Test
    public void probarTamanoInicialCero() {

        // El tamaño inicial debe ser 0
        assertEquals(0, heap.size());
    }

    @Test
    public void probarAgregarUnElemento() {

        heap.add(10);

        // Verifica que el elemento fue agregado
        assertFalse(heap.isEmpty());
        assertEquals(1, heap.size());
        assertEquals(Integer.valueOf(10), heap.getFirst());
    }

    @Test
    public void probarPropiedadMinHeap() {

        // Se agregan elementos desordenados
        heap.add(30);
        heap.add(10);
        heap.add(20);
        heap.add(5);

        // El menor debe quedar en la raíz
        assertEquals(Integer.valueOf(5), heap.getFirst());
    }

    @Test
    public void probarRemoveRetornaElMenor() {

        heap.add(40);
        heap.add(10);
        heap.add(25);

        int eliminado = heap.remove();

        // Remove debe devolver el menor valor
        assertEquals(10, eliminado);
    }

    @Test
    public void probarRemoveMantieneOrdenHeap() {

        heap.add(50);
        heap.add(20);
        heap.add(10);
        heap.add(30);

        // Los elementos deben salir ordenados
        assertEquals(10, (int) heap.remove());
        assertEquals(20, (int) heap.remove());
        assertEquals(30, (int) heap.remove());
        assertEquals(50, (int) heap.remove());
    }

    @Test
    public void probarGetFirstNoEliminaElemento() {

        heap.add(15);
        heap.add(5);

        int primero = heap.getFirst();

        // getFirst solo consulta, no elimina
        assertEquals(5, primero);
        assertEquals(2, heap.size());
    }

    @Test
    public void probarClear() {

        heap.add(1);
        heap.add(2);
        heap.add(3);

        heap.clear();

        // El heap debe quedar vacío
        assertTrue(heap.isEmpty());
        assertEquals(0, heap.size());
    }

    @Test
    public void probarRemoveEnHeapVacio() {

        // Debe retornar null si no hay elementos
        assertNull(heap.remove());
    }

    @Test
    public void probarRemoveConUnSoloElemento() {

        heap.add(99);

        int eliminado = heap.remove();

        // Después de remover, debe quedar vacío
        assertEquals(99, eliminado);
        assertTrue(heap.isEmpty());
    }

    @Test
    public void probarValoresDuplicados() {

        heap.add(10);
        heap.add(10);
        heap.add(10);

        // El heap debe manejar duplicados correctamente
        assertEquals(10, (int) heap.remove());
        assertEquals(10, (int) heap.remove());
        assertEquals(10, (int) heap.remove());
    }

    @Test
    public void probarInsercionesGrandes() {

        // Inserta muchos elementos en orden inverso
        for (int i = 100; i >= 1; i--) {
            heap.add(i);
        }

        // Deben salir ordenados de menor a mayor
        for (int i = 1; i <= 100; i++) {
            assertEquals(i, (int) heap.remove());
        }
    }
}