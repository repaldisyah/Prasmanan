package warungtujuhberadik.model;

public enum MetodePembayaran {
    TUNAI("Tunai"), QRIS_EWALLET("QRIS/e-wallet");
    private final String label;
    MetodePembayaran(String label) { this.label = label; }
    public String getLabel() { return label; }
}
