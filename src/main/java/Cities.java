import java.util.ArrayList;
import java.util.List;

public class Cities {
    private final List<String> cities;

    public Cities() {
        cities = new ArrayList<>();
        initializeCitiesList();
    }

    private void initializeCitiesList() {
        cities.add("Berlin");
        cities.add("Brussels");
        cities.add("Dublin");
        cities.add("London");
        cities.add("Madrid");
        cities.add("Munich");
        cities.add("Paris");
        cities.add("Rome");
        cities.add("Zurich");
        cities.add("Vienna");
    }


    public List<String> getCities() {
        return cities;
    }


    @Override
    public String toString() {
        return "Cities{" + "cities=" + cities + '}';
    }
}
