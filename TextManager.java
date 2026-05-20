import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *Lee archivos de texto y cargar pacientes en una cola de prioridad.
 */
public class TextManager {

    /**
     * Carga pacientes usando la implementación propia de cola de prioridad.
     * 
     * @param archivo nombre del archivo de texto
     * @param cola cola de prioridad
     */
    public static void cargarPacientes(String archivo, PriorityQueue<Paciente> cola)
    // pre: archivo existe y cola no es null
    // post: los pacientes del archivo fueron agregados a la cola
    {
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(archivo));

            String line;

            while ((line = reader.readLine()) != null)
            {
                String[] parts = line.split(",");

                String nombre = parts[0].trim();
                String emergencia = parts[1].trim();
                char codigo = parts[2].trim().charAt(0);

                Paciente paciente = new Paciente(nombre, emergencia, codigo);

                cola.add(paciente);
            }

            reader.close();
        }
        catch (IOException e)
        {
            System.out.println("Error leyendo el archivo.");
            e.printStackTrace();
        }
    }

    /**
     * Carga pacientes usando la PriorityQueue de Java Framework.
     * 
     * @param archivo nombre del archivo de texto
     * @param cola cola de prioridad de Java Collections Framework
     */
    public static void cargarPacientes(
        String archivo,
        java.util.PriorityQueue<Paciente> cola)
    // pre: archivo existe y cola no es null
    // post: los pacientes del archivo fueron agregados a la cola
    {
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(archivo));

            String line;

            while ((line = reader.readLine()) != null)
            {
                String[] parts = line.split(",");

                String nombre = parts[0].trim();
                String emergencia = parts[1].trim();
                char codigo = parts[2].trim().charAt(0);

                Paciente paciente = new Paciente(nombre, emergencia, codigo);

                cola.add(paciente);
            }

            reader.close();
        }
        catch (IOException e)
        {
            System.out.println("Error leyendo el archivo.");
            e.printStackTrace();
        }
    }
}