import gestores.GestorSensor;
import modelos.Plaga;
import modelos.Sensor;

public class Main {
    public static void main(String[] args) {
        // Crear el gestor de sensores
        GestorSensor gestor = new GestorSensor();

        // Crear plagas
        Plaga plagaInsectos = new Plaga("Hormiga", "insectos", "Hormiga común que invade cocinas.");
        Plaga plagaRoedores = new Plaga("Rata", "roedores", "Rata que causa daño en instalaciones.");
        Plaga plagaAcaros = new Plaga("Ácaro del polvo", "ácaros", "Ácaros que afectan la salud respiratoria.");
        Plaga plagaAves = new Plaga("Paloma", "aves", "Palomas que pueden causar desorden en áreas urbanas.");

        // Registrar sensores
        gestor.registrarSensor(new Sensor("001", plagaInsectos, "Bodega", 10, true));
        gestor.registrarSensor(new Sensor("002", plagaRoedores, "Cocina", 5, false));
        gestor.registrarSensor(new Sensor("003", plagaAcaros, "Oficina", 3, true));
        gestor.registrarSensor(new Sensor("004", plagaAves, "Terraza", 8, false));

        // Buscar un sensor por ID
        String idBuscado = "002";
        Sensor sensorBuscado = gestor.buscarSensorPorId(idBuscado);
        if (sensorBuscado != null) {
            System.out.println("Sensor encontrado: " + sensorBuscado);
        } else {
            System.out.println("Sensor con ID " + idBuscado + " no encontrado.");
        }

        // Modificar el estado de un sensor
        String idModificar = "002";
        boolean nuevoEstado = true;
        if (gestor.modificarEstadoSensor(idModificar, nuevoEstado)) {
            System.out.println("Estado del sensor " + idModificar + " modificado a " + nuevoEstado);
        } else {
            System.out.println("Error al modificar el estado del sensor " + idModificar);
        }

        // Obtener y mostrar sensores inactivos
        System.out.println("Sensores inactivos:");
        for (Sensor sensor : gestor.obtenerSensoresInactivos()) {
            System.out.println(sensor);
        }
    }
}
