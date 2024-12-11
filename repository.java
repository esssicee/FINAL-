package repository;

import java.util.HashMap;

public class StokRepository {
    private HashMap<String, Integer> stok;

    public StokRepository(HashMap<String, Integer> stok) {
        this.stok = stok;
    }

    public int getStok(String kodeBarang) {
        return stok.getOrDefault(kodeBarang, 0);
    }

    public void updateStok(String kodeBarang, int jumlah) {
        stok.put(kodeBarang, stok.getOrDefault(kodeBarang, 0) + jumlah);
    }

    public HashMap<String, Integer> getAllStok() {
        return stok;
    }
}
