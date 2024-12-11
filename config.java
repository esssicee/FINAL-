package config;

import java.util.HashMap;

public class StokInitializer {
    public static HashMap<String, Integer> initializeStok(String[] daftarBaju, String[] ukuran) {
        HashMap<String, Integer> stok = new HashMap<>();
        for (String baju : daftarBaju) {
            for (String size : ukuran) {
                stok.put(baju + "-" + size, 50);
            }
        }
        return stok;
    }
}
