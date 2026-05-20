//Main para la versión del programa que usa el Java Collections Framework

/**
 * Clase principal para ejecutar la versión que usa Java Collections Framework.
 */
public class Main2 {

    /**
     * Método principal del programa.
     * 
     * @param args argumentos de línea de comandos
     */
    public static void main(String[] args) {

        java.util.PriorityQueue<Paciente> colaPacientes = new java.util.PriorityQueue<>();

        TextManager.cargarPacientes("pacientes.txt", colaPacientes);

        System.out.println("Hoja de trabajo 8 - Priority Queue con Java Framework - Miguel Sajquín (252149)");
        System.out.println("Lista de pacientes ordenados por prioridad:");

        while (!colaPacientes.isEmpty())
        {
            Paciente paciente = colaPacientes.remove();

            System.out.println(paciente);
        }
    }
}