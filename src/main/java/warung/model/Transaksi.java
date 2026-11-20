package warung.model;

public class Transaksi {
    private int idTransaksi,idUser; private String noTransaksi,tanggal,waktu,status; private long total;
    public Transaksi() {}
    public Transaksi(int idTransaksi,String noTransaksi,String tanggal,String waktu,long total,String status,int idUser){this.idTransaksi=idTransaksi;this.noTransaksi=noTransaksi;this.tanggal=tanggal;this.waktu=waktu;this.total=total;this.status=status;this.idUser=idUser;}
    public int getIdTransaksi(){return idTransaksi;} public void setIdTransaksi(int v){idTransaksi=v;} public String getNoTransaksi(){return noTransaksi;} public void setNoTransaksi(String v){noTransaksi=v;} public String getTanggal(){return tanggal;} public void setTanggal(String v){tanggal=v;} public String getWaktu(){return waktu;} public void setWaktu(String v){waktu=v;} public long getTotal(){return total;} public void setTotal(long v){total=v;} public String getStatus(){return status;} public void setStatus(String v){status=v;} public int getIdUser(){return idUser;} public void setIdUser(int v){idUser=v;}
}
