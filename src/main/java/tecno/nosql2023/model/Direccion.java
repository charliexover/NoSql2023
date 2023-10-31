package tecno.nosql2023.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@TypeAlias("Direccion")
@Document(collection = "Direcciones")
public class Direccion {
    @Id
    private int id_Dir;
    private String departamento;
    private String localidad;
    private String calle;
    private int nro;
    private int apto;
    private int padron;
    private String ruta;
    private int km;
    private char letra;
    private String barrio;
}
