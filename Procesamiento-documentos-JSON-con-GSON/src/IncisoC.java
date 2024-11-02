import org.json.JSONObject;
import org.json.XML;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class IncisoC {

    public static void main(String[] args) {
        String rutaXML = "C:\\Users\\zCrow\\IdeaProjects\\Procesamiento-documentos-JSON-con-GSON\\car_sales.xml";
        String rutaJSON = "C:\\Users\\zCrow\\IdeaProjects\\Procesamiento-documentos-JSON-con-GSON\\car_sales.json";
        String contenidoXML;

        try {
            contenidoXML = new String(Files.readAllBytes(Paths.get(rutaXML)));
            JSONObject json = XML.toJSONObject(contenidoXML);
            Files.write(Paths.get(rutaJSON), json.toString(4).getBytes());
            System.out.println("Conversión completa. Datos guardados en 'car_sales_convertido.json'.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
