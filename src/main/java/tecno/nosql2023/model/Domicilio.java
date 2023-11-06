package tecno.nosql2023.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
@TypeAlias("Domicilio")
@Document(collection = "Domicilios")
public class Domicilio {
    @Id
    private int idDom;
    private String ciPer;
    private String departamento;
    private String localidad;
    private String calle;
    private int nro;
    private int apto;
    private int padron;
    private int ruta;
    private int km;
    private char letra;
    private String barrio;
}
