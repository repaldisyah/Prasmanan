package warung.model;

public class Pembayaran {
    private int idPembayaran,idTransaksi; private String metodePembayaran,tanggalPembayaran,statusPembayaran; private long jumlahBayar,kembalian;
    public Pembayaran() {}
    public Pembayaran(int idPembayaran,int idTransaksi,String metodePembayaran,long jumlahBayar,long kembalian,String tanggalPembayaran,String statusPembayaran){this.idPembayaran=idPembayaran;this.idTransaksi=idTransaksi;this.metodePembayaran=metodePembayaran;this.jumlahBayar=jumlahBayar;this.kembalian=kembalian;this.tanggalPembayaran=tanggalPembayaran;this.statusPembayaran=statusPembayaran;}
    public int getIdPembayaran(){return idPembayaran;} public void setIdPembayaran(int v){idPembayaran=v;} public int getIdTransaksi(){return idTransaksi;} public void setIdTransaksi(int v){idTransaksi=v;} public String getMetodePembayaran(){return metodePembayaran;} public void setMetodePembayaran(String v){metodePembayaran=v;} public long getJumlahBayar(){return jumlahBayar;} public void setJumlahBayar(long v){jumlahBayar=v;} public long getKembalian(){return kembalian;} public void setKembalian(long v){kembalian=v;} public String getTanggalPembayaran(){return tanggalPembayaran;} public void setTanggalPembayaran(String v){tanggalPembayaran=v;} public String getStatusPembayaran(){return statusPembayaran;} public void setStatusPembayaran(String v){statusPembayaran=v;}
}
