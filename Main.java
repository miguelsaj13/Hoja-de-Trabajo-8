/**
 * Clase principal para ejecutar la versión que usa la implementación personal de
 * cola de prioridad.
 */
public class Main {

    /**
     * Método principal del programa.
     * 
     * @param args argumentos de línea de comandos
     */
    public static void main(String[] args) {

        VectorHeap<Paciente> colaPacientes = new VectorHeap<>();

        TextManager.cargarPacientes("pacientes.txt", colaPacientes);

        System.out.println("Hoja de trabajo 8 - Priority Queue - Miguel Sajquín (252149)");
        System.out.println("Lista de pacientes ordenados por prioridad:");

        while (!colaPacientes.isEmpty())
        {
            Paciente paciente = colaPacientes.remove();

            System.out.println(paciente);
        }
    }
}