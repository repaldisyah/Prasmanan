package warungtujuhberadik.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class DetailTransaksi implements Serializable {
    private static final long serialVersionUID = 1L;
    private final String idDetail,idTransaksi,idMenu,namaMenu; private final int jumlah; private final BigDecimal hargaSatuan,subtotal;
    public DetailTransaksi(String idDetail,String idTransaksi,String idMenu,String namaMenu,int jumlah,BigDecimal hargaSatuan){this.idDetail=idDetail;this.idTransaksi=idTransaksi;this.idMenu=idMenu;this.namaMenu=namaMenu;this.jumlah=jumlah;this.hargaSatuan=hargaSatuan;this.subtotal=hargaSatuan.multiply(BigDecimal.valueOf(jumlah));}
    public String getIdDetail(){return idDetail;} public String getIdTransaksi(){return idTransaksi;} public String getIdMenu(){return idMenu;} public String getNamaMenu(){return namaMenu;} public int getJumlah(){return jumlah;} public BigDecimal getHargaSatuan(){return hargaSatuan;} public BigDecimal getSubtotal(){return subtotal;}
}
