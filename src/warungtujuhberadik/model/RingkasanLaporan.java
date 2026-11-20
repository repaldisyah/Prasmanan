package warungtujuhberadik.model;

import java.math.BigDecimal;
import java.util.List;

public record RingkasanLaporan(String judulPeriode,BigDecimal totalPendapatan,int jumlahTransaksi,int totalPorsiTerjual,List<BarisLaporanMenu> barisMenu,List<BarisLaporanMenu> menuTerlaris,List<Transaksi> daftarTransaksi) {}
