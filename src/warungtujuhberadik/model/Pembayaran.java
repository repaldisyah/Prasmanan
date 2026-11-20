package warungtujuhberadik.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Pembayaran implements Serializable {
    private static final long serialVersionUID = 1L;
    private final String idPembayaran,idTransaksi; private final MetodePembayaran metode; private final BigDecimal jumlahBayar; private final LocalDateTime tanggalPembayaran; private final StatusPembayaran status;
    public Pembayaran(String idPembayaran,String idTransaksi,MetodePembayaran metode,BigDecimal jumlahBayar,LocalDateTime waktu,StatusPembayaran status){this.idPembayaran=idPembayaran;this.idTransaksi=idTransaksi;this.metode=metode;this.jumlahBayar=jumlahBayar;this.tanggalPembayaran=waktu;this.status=status;}
    public String getIdPembayaran(){return idPembayaran;} public String getIdTransaksi(){return idTransaksi;} public MetodePembayaran getMetode(){return metode;} public BigDecimal getJumlahBayar(){return jumlahBayar;} public LocalDateTime getTanggalPembayaran(){return tanggalPembayaran;} public StatusPembayaran getStatus(){return status;}
}
