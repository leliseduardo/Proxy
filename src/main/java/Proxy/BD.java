package Proxy;

import java.util.HashMap;
import java.util.Map;

public class BD {

    // Using a HashMap to store loads with Integer keys
    private static Map<Integer, Load> loads = new HashMap<>();

    // Method to retrieve a load by its codigo (key)
    public static Load getLoad(Integer codigo) {
        return loads.get(codigo);
    }

    // Method to add a load to the database
    public static void addLoad(Load load) {
        loads.put(load.getCode(), load); // Using getCodigo() as the key
    }
}

