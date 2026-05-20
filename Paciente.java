/**
 * Representa un paciente.
 * 
 * Los pacientes se ordenan según su código de prioridad.
 */
public class Paciente implements Comparable<Paciente> {

    private String nombre;
    private String emergencia;
    private char codigo;

    /**
     * Construye un nuevo paciente.
     * 
     * @param nombre nombre del paciente
     * @param emergencia descripción de la emergencia
     * @param codigo código de prioridad
     */
    public Paciente(String nombre, String emergencia, char codigo) {
        this.nombre = nombre;
        this.emergencia = emergencia;
        this.codigo = codigo;
    }

    /**
     * Retorna el nombre del paciente.
     * 
     * @return nombre del paciente
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Retorna la emergencia.
     * 
     * @return emergencia del paciente
     */
    public String getEmergencia() {
        return emergencia;
    }

    /**
     * Retorna el código de prioridad.
     * 
     * @return código de prioridad
     */
    public char getCodigo() {
        return codigo;
    }

    /**
     * Compara pacientes según su prioridad.
     * 
     * @param other paciente a comparar
     * @return valor negativo, positivo o cero
     */
    @Override
    public int compareTo(Paciente other) {
        return Character.compare(this.codigo, other.codigo);
    }

    /**
     * Retorna una texto con información del paciente.
     * 
     * @return información del paciente
     */
    @Override
    public String toString() {
        return nombre + " - Emergencia: " + emergencia + " - Código: " + codigo;
    }
}