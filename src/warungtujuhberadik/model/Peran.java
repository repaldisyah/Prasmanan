package warungtujuhberadik.model;

public enum Peran {
    KASIR("Kasir/Pegawai"), ADMIN("Pemilik/Admin");
    private final String label;
    Peran(String label) { this.label = label; }
    public String getLabel() { return label; }
}
