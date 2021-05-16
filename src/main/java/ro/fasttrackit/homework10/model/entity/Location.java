package ro.fasttrackit.homework10.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "locations")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Location {
    @Id
    private String locationId;

    private String city;
}
