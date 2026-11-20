package warungtujuhberadik.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Keranjang {
    private final List<ItemKeranjang> item = new ArrayList<>(); private boolean sudahDisimpan;
    public void tambahItem(Menu menu,int jumlah){if(jumlah<=0)throw new IllegalArgumentException("Jumlah harus lebih dari nol."); for(ItemKeranjang i:item)if(i.getIdMenu().equals(menu.getIdMenu())){i.setJumlah(i.getJumlah()+jumlah);return;} item.add(new ItemKeranjang(menu.getIdMenu(),menu.getNamaMenu(),menu.getHarga(),jumlah));}
    public void ubahJumlah(String id,int jumlah){if(jumlah<=0)throw new IllegalArgumentException("Jumlah harus lebih dari nol."); cari(id).setJumlah(jumlah);}
    public void hapusItem(String id){item.removeIf(i->i.getIdMenu().equals(id));}
    private ItemKeranjang cari(String id){return item.stream().filter(i->i.getIdMenu().equals(id)).findFirst().orElseThrow(()->new IllegalArgumentException("Item tidak ditemukan."));}
    public List<ItemKeranjang> getItem(){return List.copyOf(item);} public BigDecimal hitungTotal(){return item.stream().map(ItemKeranjang::getSubtotal).reduce(BigDecimal.ZERO,BigDecimal::add);} public boolean isKosong(){return item.isEmpty();} public void kosongkan(){item.clear();sudahDisimpan=false;} public boolean isSudahDisimpan(){return sudahDisimpan;} public void tandaiSudahDisimpan(){sudahDisimpan=true;}
}
