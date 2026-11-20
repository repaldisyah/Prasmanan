package warungtujuhberadik.model;

import java.io.Serializable;

public abstract class Pengguna implements Serializable {
    private static final long serialVersionUID = 1L;
    private final String idUser, username, passwordHash;
    private String nama;
    private final Peran peran;
    protected Pengguna(String idUser, String username, String passwordHash, String nama, Peran peran) {
        this.idUser = idUser; this.username = username; this.passwordHash = passwordHash; this.nama = nama; this.peran = peran;
    }
    public String getIdUser() { return idUser; }
    public String getUsername() { return username; }
    public String getPasswordHash() { return passwordHash; }
    public String getNama() { return nama; }
    public Peran getPeran() { return peran; }
    public abstract String getDeskripsiPeran();
}
