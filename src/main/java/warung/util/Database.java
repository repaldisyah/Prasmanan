package warung.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.Base64;

public final class Database {
    private static final String DEFAULT_URL = "jdbc:sqlite:warung.db";
    private final String url;

    public Database() { this(DEFAULT_URL); }
    public Database(String url) { this.url = url; }
    public Connection connect() throws SQLException {
        Connection connection = DriverManager.getConnection(url);
        try (Statement statement = connection.createStatement()) {
            statement.execute("PRAGMA foreign_keys = ON");
        }
        return connection;
    }
    public void initialize() throws SQLException {
        try (Connection connection = connect(); Statement statement = connection.createStatement()) {
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS user (id_user INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT NOT NULL UNIQUE, password_hash TEXT NOT NULL, nama TEXT NOT NULL, role TEXT NOT NULL CHECK (role IN ('KASIR','ADMIN')))");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS menu (id_menu INTEGER PRIMARY KEY AUTOINCREMENT, nama_menu TEXT NOT NULL, harga INTEGER NOT NULL CHECK (harga >= 0), jenis_menu TEXT NOT NULL DEFAULT 'LAUK', status TEXT NOT NULL DEFAULT 'AKTIF' CHECK (status IN ('AKTIF','NONAKTIF')))");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS transaksi (id_transaksi INTEGER PRIMARY KEY AUTOINCREMENT, no_transaksi TEXT NOT NULL UNIQUE, tanggal TEXT NOT NULL, waktu TEXT NOT NULL, total INTEGER NOT NULL, status TEXT NOT NULL DEFAULT 'SELESAI', id_user INTEGER NOT NULL REFERENCES user(id_user))");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS detail_transaksi (id_detail INTEGER PRIMARY KEY AUTOINCREMENT, id_transaksi INTEGER NOT NULL REFERENCES transaksi(id_transaksi) ON DELETE CASCADE, id_menu INTEGER NOT NULL REFERENCES menu(id_menu), nama_menu TEXT NOT NULL, jumlah INTEGER NOT NULL CHECK (jumlah > 0), harga INTEGER NOT NULL, subtotal INTEGER NOT NULL)");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS pembayaran (id_pembayaran INTEGER PRIMARY KEY AUTOINCREMENT, id_transaksi INTEGER NOT NULL UNIQUE REFERENCES transaksi(id_transaksi) ON DELETE CASCADE, metode_pembayaran TEXT NOT NULL CHECK (metode_pembayaran IN ('TUNAI','QRIS')), jumlah_bayar INTEGER NOT NULL, kembalian INTEGER NOT NULL DEFAULT 0, tanggal_pembayaran TEXT NOT NULL, status_pembayaran TEXT NOT NULL DEFAULT 'LUNAS')");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS biaya (id_biaya INTEGER PRIMARY KEY AUTOINCREMENT, tanggal TEXT NOT NULL, kategori TEXT NOT NULL, keterangan TEXT, jumlah INTEGER NOT NULL CHECK (jumlah >= 0))");
        }
        seedIfEmpty();
    }
    private void seedIfEmpty() throws SQLException {
        try (Connection connection = connect()) {
            if (isEmpty(connection, "user")) {
                try (PreparedStatement ps = connection.prepareStatement("INSERT INTO user(username,password_hash,nama,role) VALUES (?,?,?,?)")) {
                    insertUser(ps, "admin", "admin123", "Pemilik", "ADMIN");
                    insertUser(ps, "kasir", "kasir123", "Kasir 1", "KASIR");
                }
            }
            if (isEmpty(connection, "menu")) {
                try (PreparedStatement ps = connection.prepareStatement("INSERT INTO menu(nama_menu,harga,jenis_menu,status) VALUES (?,?,?,?)")) {
                    insertMenu(ps, "Ayam", 10000, "LAUK"); insertMenu(ps, "Ikan", 8000, "LAUK"); insertMenu(ps, "Nasi", 5000, "NASI");
                }
            }
        }
    }
    private static boolean isEmpty(Connection c, String table) throws SQLException {
        try (Statement s = c.createStatement(); var rs = s.executeQuery("SELECT COUNT(*) FROM " + table)) { return rs.next() && rs.getInt(1) == 0; }
    }
    private static void insertUser(PreparedStatement ps,String username,String password,String nama,String role) throws SQLException { ps.setString(1,username); ps.setString(2,hash(password)); ps.setString(3,nama); ps.setString(4,role); ps.executeUpdate(); }
    private static void insertMenu(PreparedStatement ps,String nama,long harga,String jenis) throws SQLException { ps.setString(1,nama); ps.setLong(2,harga); ps.setString(3,jenis); ps.setString(4,"AKTIF"); ps.executeUpdate(); }
    private static String hash(String password) {
        try { byte[] salt = new byte[16]; new SecureRandom().nextBytes(salt); byte[] digest = MessageDigest.getInstance("SHA-256").digest(concat(salt, password.getBytes(StandardCharsets.UTF_8))); return Base64.getEncoder().encodeToString(salt) + ":" + Base64.getEncoder().encodeToString(digest); }
        catch (NoSuchAlgorithmException e) { throw new IllegalStateException(e); }
    }
    private static byte[] concat(byte[] a, byte[] b) { byte[] result = new byte[a.length+b.length]; System.arraycopy(a,0,result,0,a.length); System.arraycopy(b,0,result,a.length,b.length); return result; }
}
