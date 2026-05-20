    public class Paciente implements Comparable<Paciente> {
        private String nombre;
        private String emergencia;
        private char codigo;

        public Paciente(String nombre, String emergencia, char codigo) {
            this.nombre = nombre;
            this.emergencia = emergencia;
            this.codigo = codigo;
        }

        public String getNombre() {
            return nombre;
        }

        public String getEmergencia() {
            return emergencia;
        }

        public char getCodigo() {
            return codigo;
        }

        @Override
        public int compareTo(Paciente other) {
            return Character.compare(this.codigo, other.codigo);
        }
        @Override
        public String toString() {
            return nombre + " - Edad: " + " - Emergencia: " + emergencia + " - Código: " + codigo;
        }
    }