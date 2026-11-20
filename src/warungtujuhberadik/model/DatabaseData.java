package warungtujuhberadik.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DatabaseData implements Serializable {
    private static final long serialVersionUID = 1L;
    private final List<Pengguna> pengguna = new ArrayList<>();
    private final List<Menu> menu = new ArrayList<>();
    private final List<Transaksi> transaksi = new ArrayList<>();
    private final List<Pembayaran> pembayaran = new ArrayList<>();
    public List<Pengguna> getPengguna(){return pengguna;} public List<Menu> getMenu(){return menu;} public List<Transaksi> getTransaksi(){return transaksi;} public List<Pembayaran> getPembayaran(){return pembayaran;}
}
