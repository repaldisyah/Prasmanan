package warung;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import warung.util.FormatRupiah;

class FormatRupiahTest {
    @Test void memformatRupiah() { assertEquals("Rp33.000", FormatRupiah.format(33000)); }
}
