package warungtujuhberadik.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import warungtujuhberadik.model.Menu;
import warungtujuhberadik.model.Transaksi;

public final class GeneratorId {
    private static final DateTimeFormatter TANGGAL = DateTimeFormatter.ofPattern("yyyyMMdd");
    private GeneratorId() {}
    public static String idMenuBerikutnya(List<Menu> daftar) {
        int terbesar = daftar.stream().map(Menu::getIdMenu).mapToInt(GeneratorId::angkaAkhir).max().orElse(0);
        return String.format("M%03d", terbesar + 1);
    }
    public static String idTransaksiBerikutnya(List<Transaksi> daftar, LocalDate tanggal) {
        String awalan = "TRX-" + tanggal.format(TANGGAL) + "-";
        int terbesar = daftar.stream().map(Transaksi::getIdTransaksi).filter(id -> id.startsWith(awalan)).mapToInt(GeneratorId::angkaAkhir).max().orElse(0);
        return awalan + String.format("%03d", terbesar + 1);
    }
    public static String idDetail(String idTransaksi, int urutan) { return idTransaksi + "-D" + urutan; }
    public static String idPembayaran(String idTransaksi) { return idTransaksi.replaceFirst("^TRX-", "PAY-"); }
    private static int angkaAkhir(String nilai) {
        Matcher matcher = Pattern.compile("(\\d+)$").matcher(nilai);
        return matcher.find() ? Integer.parseInt(matcher.group(1)) : 0;
    }
}
