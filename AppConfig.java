package config;

import repository.StokRepository;
import services.PemesananService;
import services.LaporanService;
import view.MainMenu;

public class AppConfig {
    public static MainMenu initMainMenu() {
        // Dummy data
        String[] daftarBaju = {"Kaos", "Kemeja", "Jaket"};
        int[] hargaBaju = {50000, 100000, 150000};
        String[] ukuran = {"S", "M", "L", "XL"};

        // Dependencies
        StokRepository stokRepository = new StokRepository();
        PemesananService pemesananService = new PemesananService();
        LaporanService laporanService = new LaporanService();

        // Initialize stock
        stokRepository.tambahStok("Kaos - S", 10);
        stokRepository.tambahStok("Kaos - M", 8);
        stokRepository.tambahStok("Kemeja - L", 5);

        return new MainMenu(pemesananService, laporanService, stokRepository, daftarBaju, hargaBaju, ukuran);
    }
}
