package warungtujuhberadik.config;

import java.awt.Color;
import java.nio.file.Path;

public final class Konfigurasi {
    public static final String NAMA_APLIKASI = "Sistem Informasi Warung Tujuh Beradik";
    public static final Path FILE_DATA = Path.of("data", "warung.dat");
    public static final Color DEEP_NAVY = Color.decode("#1B365D");
    public static final Color SLATE_BLUE = Color.decode("#2E6B9E");
    public static final int LEBAR_JENDELA = 1100;
    public static final int TINGGI_JENDELA = 700;

    private Konfigurasi() {}
}
