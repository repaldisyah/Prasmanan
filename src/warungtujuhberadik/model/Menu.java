package warungtujuhberadik.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class Menu implements Serializable {
    private static final long serialVersionUID = 1L;
    private final String idMenu;
    private String namaMenu, jenisMenu;
    private BigDecimal harga;
    private StatusMenu status;
    public Menu(String idMenu, String namaMenu, BigDecimal harga, String jenisMenu, StatusMenu status) {
        this.idMenu=idMenu; this.namaMenu=namaMenu; this.harga=harga; this.jenisMenu=jenisMenu; this.status=status;
    }
    public String getIdMenu(){return idMenu;} public String getNamaMenu(){return namaMenu;} public BigDecimal getHarga(){return harga;}
    public String getJenisMenu(){return jenisMenu;} public StatusMenu getStatus(){return status;}
    public void setNamaMenu(String v){namaMenu=v;} public void setHarga(BigDecimal v){harga=v;} public void setJenisMenu(String v){jenisMenu=v;} public void setStatus(StatusMenu v){status=v;}
}
