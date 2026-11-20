package warung.model;

public class User {
    private int idUser;
    private String username;
    private String passwordHash;
    private String nama;
    private String role;

    public User() {}
    public User(int idUser, String username, String passwordHash, String nama, String role) { this.idUser=idUser; this.username=username; this.passwordHash=passwordHash; this.nama=nama; this.role=role; }
    public int getIdUser(){return idUser;} public void setIdUser(int v){idUser=v;}
    public String getUsername(){return username;} public void setUsername(String v){username=v;}
    public String getPasswordHash(){return passwordHash;} public void setPasswordHash(String v){passwordHash=v;}
    public String getNama(){return nama;} public void setNama(String v){nama=v;}
    public String getRole(){return role;} public void setRole(String v){role=v;}
}
