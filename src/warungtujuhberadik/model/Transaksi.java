package warungtujuhberadik.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Transaksi implements Serializable {
    private static final long serialVersionUID = 1L;
    private final String idTransaksi,idUser; private final LocalDate tanggal; private final LocalTime waktu; private final List<DetailTransaksi> detail; private final BigDecimal total; private StatusTransaksi status;
    public Transaksi(String idTransaksi,String idUser,LocalDate tanggal,LocalTime waktu,List<DetailTransaksi> detail,StatusTransaksi status){this.idTransaksi=idTransaksi;this.idUser=idUser;this.tanggal=tanggal;this.waktu=waktu;this.detail=List.copyOf(detail);this.total=detail.stream().map(DetailTransaksi::getSubtotal).reduce(BigDecimal.ZERO,BigDecimal::add);this.status=status;}
    public String getIdTransaksi(){return idTransaksi;} public String getIdUser(){return idUser;} public LocalDate getTanggal(){return tanggal;} public LocalTime getWaktu(){return waktu;} public List<DetailTransaksi> getDetail(){return detail;} public BigDecimal getTotal(){return total;} public StatusTransaksi getStatus(){return status;} public void setStatus(StatusTransaksi v){status=v;}
}
