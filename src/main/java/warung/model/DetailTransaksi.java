package warung.model;

public class DetailTransaksi {
    private int idDetail,idTransaksi,idMenu,jumlah; private String namaMenu; private long harga,subtotal;
    public DetailTransaksi() {}
    public DetailTransaksi(int idDetail,int idTransaksi,int idMenu,String namaMenu,int jumlah,long harga,long subtotal){this.idDetail=idDetail;this.idTransaksi=idTransaksi;this.idMenu=idMenu;this.namaMenu=namaMenu;this.jumlah=jumlah;this.harga=harga;this.subtotal=subtotal;}
    public int getIdDetail(){return idDetail;} public void setIdDetail(int v){idDetail=v;} public int getIdTransaksi(){return idTransaksi;} public void setIdTransaksi(int v){idTransaksi=v;} public int getIdMenu(){return idMenu;} public void setIdMenu(int v){idMenu=v;} public String getNamaMenu(){return namaMenu;} public void setNamaMenu(String v){namaMenu=v;} public int getJumlah(){return jumlah;} public void setJumlah(int v){jumlah=v;} public long getHarga(){return harga;} public void setHarga(long v){harga=v;} public long getSubtotal(){return subtotal;} public void setSubtotal(long v){subtotal=v;}
}
