package warungtujuhberadik.model;

import java.math.BigDecimal;

public class ItemKeranjang {
    private final String idMenu, namaMenu; private final BigDecimal hargaSatuan; private int jumlah;
    public ItemKeranjang(String idMenu,String namaMenu,BigDecimal hargaSatuan,int jumlah){this.idMenu=idMenu;this.namaMenu=namaMenu;this.hargaSatuan=hargaSatuan;this.jumlah=jumlah;}
    public String getIdMenu(){return idMenu;} public String getNamaMenu(){return namaMenu;} public BigDecimal getHargaSatuan(){return hargaSatuan;} public int getJumlah(){return jumlah;}
    public void setJumlah(int v){jumlah=v;} public BigDecimal getSubtotal(){return hargaSatuan.multiply(BigDecimal.valueOf(jumlah));}
}
