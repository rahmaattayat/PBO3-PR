package id.ac.polban.service;

import java.util.Objects;

import id.ac.polban.model.mahasiswa;
import id.ac.polban.model.mataKuliah;

public class KRSService {

    public static final int MAX_SKS_PER_SEMESTER = 24;

    public static void tambahKrs(mahasiswa mhs, mataKuliah mk) {
        Objects.requireNonNull(mhs, "Mahasiswa null.");
        Objects.requireNonNull(mk, "Mata kuliah null.");

        int sksSetelahTambah = mhs.totalSks() + mk.getSks();
        if (sksSetelahTambah > MAX_SKS_PER_SEMESTER) {
            throw new IllegalStateException(
                "Gagal tambah MK: total SKS (" + sksSetelahTambah + ") melebihi batas " +
                MAX_SKS_PER_SEMESTER + "."
            );
        }
        mhs.tambahMk(mk);
    }

    public static boolean hapusKrsByKode(mahasiswa mhs, String kodeMk) {
        Objects.requireNonNull(mhs, "Mahasiswa null.");
        if (kodeMk == null || kodeMk.isBlank()) return false;
        return mhs.hapusMkByKode(kodeMk);
    }

    public static String ringkasKrs(mahasiswa mhs) {
        var sb = new StringBuilder();
        sb.append(mhs.toString()).append('\n');
        for (var mk : mhs.getKrs()) {
            sb.append(" - ").append(mk.toString()).append('\n');
        }
        return sb.toString();
    }
}