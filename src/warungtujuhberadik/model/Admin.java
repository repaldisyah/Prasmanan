package warungtujuhberadik.model;

public final class Admin extends Pengguna {
    private static final long serialVersionUID = 1L;
    public Admin(String id, String username, String passwordHash, String nama) { super(id, username, passwordHash, nama, Peran.ADMIN); }
    @Override public String getDeskripsiPeran() { return "Pemilik/Admin"; }
}
