import config.StokInitializer;
import repository.StokRepository;
import services.PemesananService;
import services.LaporanService;
import view.MainMenu;

public class Main {
    public static void main(String[] args) {
        String[] daftarBaju = {"Kaos", "Kemeja", "Jaket", "Celana", "Rok"};
        int[] hargaBaju = {50000, 100000, 200000, 150000, 120000};
        String[] ukuran = {"S", "M", "L", "XL"};

        StokRepository stokRepository = new StokRepository(StokInitializer.initializeStok(daftarBaju, ukuran));
        PemesananService pemesananService = new PemesananService(stokRepository);
        LaporanService laporanService = new LaporanService();

        MainMenu mainMenu = new MainMenu(pemesananService, laporanService, stokRepository, daftarBaju, hargaBaju, ukuran);
        mainMenu.tampilkan();
    }
}
