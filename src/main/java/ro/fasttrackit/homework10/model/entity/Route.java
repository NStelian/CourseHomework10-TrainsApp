package ro.fasttrackit.homework10.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "routes")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Route {
    @Id
    private String routeId;

    private String startLocationId;
    private String destinationLocationId;
    private int length;
    private String trainId;
}
