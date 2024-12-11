package services;

import entities.Pesanan;
import repository.StokRepository;

import java.util.ArrayList;
import java.util.List;

public class PemesananService {
    private List<Pesanan> daftarPesanan = new ArrayList<>();
    private StokRepository stokRepository;
    private double totalPendapatan = 0;

    public PemesananService(StokRepository stokRepository) {
        this.stokRepository = stokRepository;
    }

    public boolean buatPesanan(String baju, String ukuran, int jumlah, int hargaBaju) {
        String kodeBarang = baju + "-" + ukuran;
        if (stokRepository.getStok(kodeBarang) < jumlah) {
            return false;
        }

        int totalHarga = hargaBaju * jumlah;
        Pesanan pesananBaru = new Pesanan(baju, ukuran, jumlah, totalHarga);
        daftarPesanan.add(pesananBaru);
        stokRepository.updateStok(kodeBarang, -jumlah);
        totalPendapatan += totalHarga;
        return true;
    }

    public List<Pesanan> getDaftarPesanan() {
        return daftarPesanan;
    }

    public void hapusPesanan(int index) {
        if (index >= 0 && index < daftarPesanan.size()) {
            Pesanan pesanan = daftarPesanan.remove(index);
            String kodeBarang = pesanan.getBaju() + "-" + pesanan.getUkuran();
            stokRepository.updateStok(kodeBarang, pesanan.getJumlah());
            totalPendapatan -= pesanan.getTotalHarga();
        }
    }

    public double getTotalPendapatan() {
        return totalPendapatan;
    }
}
