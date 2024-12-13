package repository;

import java.util.HashMap;
import java.util.Map;

public class StokRepository {
    private final Map<String, Integer> stok = new HashMap<>();

    public Map<String, Integer> getAllStok() {
        return stok;
    }

    public void tambahStok(String kode, int jumlah) {
        stok.put(kode, stok.getOrDefault(kode, 0) + jumlah);
    }

    public void kurangiStok(String kode, int jumlah) {
        if (stok.containsKey(kode)) {
            stok.put(kode, stok.get(kode) - jumlah);
        }
    }
}
