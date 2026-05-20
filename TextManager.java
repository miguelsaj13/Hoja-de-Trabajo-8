import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TextManager {

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
}