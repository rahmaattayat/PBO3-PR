package id.ac.polban.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class mahasiswa {
    private static int totalMahasiswa = 0;

    private String nim;
    private String nama;
    private final List<mataKuliah> krs = new ArrayList<>(); // AGGREGATION

    public mahasiswa() {
        totalMahasiswa++;
    }

    public mahasiswa(String nim, String nama) {
        setNim(nim);
        setNama(nama);
        totalMahasiswa++;
    }

    public String getNim() { return nim; }
    public void setNim(String nim) {
        if (nim == null || nim.isBlank()) {
            throw new IllegalArgumentException("NIM tidak boleh kosong.");
        }
        this.nim = nim.trim();
    }

    public String getNama() { return nama; }
    public void setNama(String nama) {
        if (nama == null || nama.isBlank()) {
            throw new IllegalArgumentException("Nama tidak boleh kosong.");
        }
        this.nama = nama.trim();
    }

    public List<mataKuliah> getKrs() {
        return Collections.unmodifiableList(krs);
    }

    public void tambahMk(mataKuliah mk) {
        if (mk == null) throw new IllegalArgumentException("MK tidak boleh null.");
        krs.add(mk);
    }

    public boolean hapusMkByKode(String kode) {
        return krs.removeIf(mk -> mk.getKode().equalsIgnoreCase(kode));
    }

    public int totalSks() {
        int sum = 0;
        for (mataKuliah mk : krs) sum += mk.getSks();
        return sum;
    }

    public static int getTotalMahasiswa() { return totalMahasiswa; }

    @Override
    public String toString() {
        return nim + " - " + nama + " | Total MK: " + krs.size() + " | SKS: " + totalSks();
    }
}