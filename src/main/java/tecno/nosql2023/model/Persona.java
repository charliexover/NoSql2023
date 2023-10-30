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
@TypeAlias("Persona")
@Document(collection = "Personas")
public class Persona {
    @Id
    private String ci;
    private String nombre;
    private String apellido;
    private String edad;
}
