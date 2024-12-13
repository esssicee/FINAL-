package view;

import java.util.Scanner;
import services.PemesananService;
import services.LaporanService;
import repository.StokRepository;
import entities.Pesanan;

public class MainMenu {
    private Scanner input = new Scanner(System.in);
    private PemesananService pemesananService;
    private LaporanService laporanService;
    private StokRepository stokRepository;
    private String[] daftarBaju;
    private int[] hargaBaju;
    private String[] ukuran;

    public MainMenu(PemesananService pemesananService, LaporanService laporanService, StokRepository stokRepository,
                    String[] daftarBaju, int[] hargaBaju, String[] ukuran) {
        this.pemesananService = pemesananService;
        this.laporanService = laporanService;
        this.stokRepository = stokRepository;
        this.daftarBaju = daftarBaju;
        this.hargaBaju = hargaBaju;
        this.ukuran = ukuran;
    }

    public void tampilkan() {
        boolean lanjut = true;
        while (lanjut) {
            System.out.println("\n1. Buat Pesanan Baru");
            System.out.println("2. Lihat Daftar Pesanan");
            System.out.println("3. Cek Stok");
            System.out.println("4. Lihat Laporan Penjualan");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");

            int pilihan = input.nextInt();
            input.nextLine(); // Clear input buffer

            switch (pilihan) {
                case 1:
                    buatPesanan();
                    break;
                case 2:
                    lihatDaftarPesanan();
                    break;
                case 3:
                    cekStok();
                    break;
                case 4:
                    laporanService.tampilkanLaporan(
                            pemesananService.getDaftarPesanan(),
                            pemesananService.getTotalPendapatan(),
                            daftarBaju
                    );
                    break;
                case 0:
                    lanjut = false;
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private void buatPesanan() {
        // Tampilkan daftar baju
        System.out.println("Daftar Baju:");
        for (int i = 0; i < daftarBaju.length; i++) {
            System.out.println((i + 1) + ". " + daftarBaju[i] + " - Rp" + hargaBaju[i]);
        }

        // Pilih baju
        System.out.print("Pilih baju (nomor): ");
        int pilihanBaju = input.nextInt();
        input.nextLine(); // Clear input buffer

        if (pilihanBaju < 1 || pilihanBaju > daftarBaju.length) {
            System.out.println("Pilihan baju tidak valid.");
            return;
        }

        // Tampilkan ukuran
        System.out.println("Pilih Ukuran:");
        for (int i = 0; i < ukuran.length; i++) {
            System.out.println((i + 1) + ". " + ukuran[i]);
        }

        // Pilih ukuran
        System.out.print("Pilih ukuran (nomor): ");
        int pilihanUkuran = input.nextInt();
        input.nextLine(); // Clear input buffer

        if (pilihanUkuran < 1 || pilihanUkuran > ukuran.length) {
            System.out.println("Pilihan ukuran tidak valid.");
            return;
        }

        // Pilih jumlah
        System.out.print("Masukkan jumlah: ");
        int jumlah = input.nextInt();
        input.nextLine(); // Clear input buffer

        if (jumlah <= 0) {
            System.out.println("Jumlah harus lebih dari 0.");
            return;
        }

        // Proses pesanan
        String namaBaju = daftarBaju[pilihanBaju - 1];
        String ukuranPilihan = ukuran[pilihanUkuran - 1];
        int harga = hargaBaju[pilihanBaju - 1];
        int totalHarga = harga * jumlah;

        // Cek stok
        String kodeStok = namaBaju + " - " + ukuranPilihan;
        int stokTersedia = stokRepository.getAllStok().getOrDefault(kodeStok, 0);

        if (stokTersedia < jumlah) {
            System.out.println("Maaf, stok tidak mencukupi. Stok tersedia: " + stokTersedia);
            return;
        }

        // Buat pesanan
        Pesanan pesanan = new Pesanan(namaBaju, ukuranPilihan, jumlah, totalHarga);
        pemesananService.tambahPesanan(pesanan);

        // Update stok
        stokRepository.kurangiStok(kodeStok, jumlah);

        System.out.println("Pesanan berhasil dibuat!");
    }

    private void lihatDaftarPesanan() {
        if (pemesananService.getDaftarPesanan().isEmpty()) {
            System.out.println("Tidak ada pesanan.");
            return;
        }
        for (Pesanan pesanan : pemesananService.getDaftarPesanan()) {
            System.out.println(pesanan);
        }
    }

    private void cekStok() {
        if (stokRepository.getAllStok().isEmpty()) {
            System.out.println("Tidak ada stok tersedia.");
            return;
        }
        stokRepository.getAllStok().forEach((key, value) -> System.out.println(key + ": " + value));
    }
}
