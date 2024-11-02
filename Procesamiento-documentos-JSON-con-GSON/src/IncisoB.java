import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class IncisoB {

    public static void main(String[] args) {
        String ruta = "C:\\Users\\zCrow\\IdeaProjects\\Procesamiento-documentos-JSON-con-GSON\\car_sales.json";
        JSONArray ventasCarros = new JSONArray();

        try {
            String contenido = new String(Files.readAllBytes(Paths.get(ruta)));
            ventasCarros = new JSONArray(contenido);
        } catch (IOException e) {
            e.printStackTrace();
        }

        JFrame ventana = new JFrame("Ventas de Carros");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        DefaultTableModel modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("ID");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Apellido");
        modeloTabla.addColumn("Carro");
        modeloTabla.addColumn("Precio");
        modeloTabla.addColumn("Estado");

        for (int i = 0; i < ventasCarros.length(); i++) {
            JSONObject venta = ventasCarros.getJSONObject(i);
            modeloTabla.addRow(new Object[]{
                    venta.getInt("id"),
                    venta.getString("first_name"),
                    venta.getString("last_name"),
                    venta.getString("car"),
                    venta.getString("price"),
                    venta.getString("state")
            });
        }

        JTable tabla = new JTable(modeloTabla);
        JScrollPane panelDesplazamiento = new JScrollPane(tabla);

        ventana.add(panelDesplazamiento);
        ventana.setSize(800, 400);
        ventana.setVisible(true);
    }
}
