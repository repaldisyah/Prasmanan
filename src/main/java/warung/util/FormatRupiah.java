package warung.util;

import java.text.NumberFormat;
import java.util.Locale;

public final class FormatRupiah {
    private FormatRupiah() {}
    public static String format(long nilai) {
        return "Rp" + NumberFormat.getIntegerInstance(Locale.forLanguageTag("id-ID")).format(nilai);
    }
}
