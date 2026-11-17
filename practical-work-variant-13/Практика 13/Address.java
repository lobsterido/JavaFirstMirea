import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Address {
    private String country;
    private String region;
    private String city;
    private String street;
    private String house;
    private String building;
    private String apartment;

    public Address() {
        country = "";
        region = "";
        city = "";
        street = "";
        house = "";
        building = "";
        apartment = "";
    }

    public void parseWithSplit(String source) {
        fill(source.split(","));
    }

    public void parseWithTokenizer(String source) {
        StringTokenizer tokenizer = new StringTokenizer(source, ",.;");
        List<String> parts = new ArrayList<>();
        while (tokenizer.hasMoreTokens()) {
            parts.add(tokenizer.nextToken());
        }
        fill(parts.toArray(new String[0]));
    }

    private void fill(String[] parts) {
        country = value(parts, 0);
        region = value(parts, 1);
        city = value(parts, 2);
        street = value(parts, 3);
        house = value(parts, 4);
        building = value(parts, 5);
        apartment = value(parts, 6);
    }

    private String value(String[] parts, int index) {
        if (index >= parts.length) {
            return "";
        }
        return parts[index].trim();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Страна: ").append(country)
                .append(", регион: ").append(region)
                .append(", город: ").append(city)
                .append(", улица: ").append(street)
                .append(", дом: ").append(house);
        if (!building.isEmpty()) {
            result.append(", корпус: ").append(building);
        }
        if (!apartment.isEmpty()) {
            result.append(", квартира: ").append(apartment);
        }
        return result.toString();
    }
}
