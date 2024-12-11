package view;

import entities.Pesanan;
import services.PemesananService;
import services.LaporanService;
import repository.StokRepository;

import java.util.Scanner;

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
                            daftarBaju);
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
        // Implementasi sama seperti pada kode awal.
    }

    private void lihatDaftarPesanan() {
        for (Pesanan pesanan : pemesananService.getDaftarPesanan()) {
            System.out.println(pesanan);
        }
    }

    private void cekStok() {
        stokRepository.getAllStok().forEach((key, value) -> System.out.println(key + ": " + value));
    }
}
