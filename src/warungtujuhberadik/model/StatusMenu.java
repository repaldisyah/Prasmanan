package warungtujuhberadik.model;

public enum StatusMenu {
    TERSEDIA("Tersedia"), TIDAK_TERSEDIA("Tidak tersedia");
    private final String label;
    StatusMenu(String label) { this.label = label; }
    public String getLabel() { return label; }
}
