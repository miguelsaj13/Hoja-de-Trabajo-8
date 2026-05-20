public class Paciente implements Comparable<Paciente> {
    private String nombre;
    private int edad;
    private String emergencia;
    private String codigo;

    public Paciente(String nombre, int edad, String emergencia, String codigo) {
        this.nombre = nombre;
        this.edad = edad;
        this.emergencia = emergencia;
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getEmergencia() {
        return emergencia;
    }

    public String getCodigo() {
        return codigo;
    }

    @Override
    public int compareTo(Paciente other) {
        return this.emergencia.compareTo(other.emergencia);
    }
}