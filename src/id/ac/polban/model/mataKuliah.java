package id.ac.polban.model;

public class mataKuliah {
    public static final int MIN_SKS_PER_MK = 1;
    public static final int MAX_SKS_PER_MK = 6;

    private String kode;
    private String nama;
    private int sks;

    public mataKuliah() {}

    public mataKuliah(String kode, String nama, int sks) {
        setKode(kode);
        setNama(nama);
        setSks(sks);
    }

    public String getKode() { return kode; }
    public void setKode(String kode) {
        if (kode == null || kode.isBlank()) {
            throw new IllegalArgumentException("Kode MK tidak boleh kosong.");
        }
        this.kode = kode.trim();
    }

    public String getNama() { return nama; }
    public void setNama(String nama) {
        if (nama == null || nama.isBlank()) {
            throw new IllegalArgumentException("Nama MK tidak boleh kosong.");
        }
        this.nama = nama.trim();
    }

    public int getSks() { return sks; }
    public void setSks(int sks) {
        if (sks < MIN_SKS_PER_MK || sks > MAX_SKS_PER_MK) {
            throw new IllegalArgumentException(
                "SKS MK harus " + MIN_SKS_PER_MK + "–" + MAX_SKS_PER_MK + "."
            );
        }
        this.sks = sks;
    }

    @Override
    public String toString() {
        return kode + " - " + nama + " (" + sks + " SKS)";
    }
}
