package home.spring_demo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Location {
    private double latitude;
    private double longitude;

    public double distance(final Location other) {
        double dlat = latitude - other.getLatitude();
        double dlon = longitude - other.getLongitude();
        return Math.sqrt(dlat * dlat + dlon * dlon);
    }
}
