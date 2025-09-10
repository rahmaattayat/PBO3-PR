package id.ac.polban.app;

import java.util.Scanner;
import id.ac.polban.model.mahasiswa;
import id.ac.polban.model.mataKuliah;
import id.ac.polban.service.KRSService;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Masukkan NIM: ");
        String nim = in.nextLine();
        System.out.print("Masukkan Nama: ");
        String nama = in.nextLine();

        mahasiswa mhs = new mahasiswa(nim, nama);

        while (true) {
            System.out.println("\nTotal SKS saat ini: " + mhs.totalSks() +
                    " / " + KRSService.MAX_SKS_PER_SEMESTER);

            if (mhs.totalSks() >= KRSService.MAX_SKS_PER_SEMESTER) {
                System.out.println("Batas SKS per semester sudah tercapai.");
                break;
            }

            System.out.print("Tambah MK? (y/n): ");
            String ya = in.nextLine().trim();
            if (!ya.equalsIgnoreCase("y")) break;

            try {
                System.out.print("Kode MK   : ");
                String kd = in.nextLine();
                System.out.print("Nama MK   : ");
                String nm = in.nextLine();
                System.out.print("SKS (1-6) : ");
                int sks = Integer.parseInt(in.nextLine());

                mataKuliah mk = new mataKuliah(kd, nm, sks);
                KRSService.tambahKrs(mhs, mk);
                System.out.println("-> MK ditambahkan.");

            } catch (Exception e) {
                System.out.println("!! Gagal menambah MK: " + e.getMessage());
            }
        }

        System.out.println("\n=== DATA KRS MAHASISWA ===");
        System.out.println(KRSService.ringkasKrs(mhs));

        System.out.println("Total objek mahasiswa dibuat: " + mahasiswa.getTotalMahasiswa());
        System.out.println("Batas SKS per semester: " + KRSService.MAX_SKS_PER_SEMESTER);

        in.close();
    }
}
