package warungtujuhberadik.model;

public final class Kasir extends Pengguna {
    private static final long serialVersionUID = 1L;
    public Kasir(String id, String username, String passwordHash, String nama) { super(id, username, passwordHash, nama, Peran.KASIR); }
    @Override public String getDeskripsiPeran() { return "Kasir/Pegawai"; }
}
