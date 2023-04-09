package bg.fmi.course.week5.dealership.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Dealership {
    private String name;

    public Dealership(@JsonProperty("name") String name) {
        this.name = name;
    }
}
