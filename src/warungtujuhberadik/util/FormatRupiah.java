package warungtujuhberadik.util;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public final class FormatRupiah {
    private FormatRupiah() {}
    public static String format(BigDecimal nilai) {
        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("id-ID"));
        format.setMaximumFractionDigits(0);
        format.setMinimumFractionDigits(0);
        return format.format(nilai).replace("Rp", "Rp").replace(" ", "");
    }
}
