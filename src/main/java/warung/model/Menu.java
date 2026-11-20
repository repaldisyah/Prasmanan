package warung.model;

public class Menu {
    private int idMenu; private String namaMenu; private long harga; private String jenisMenu; private String status;
    public Menu() {}
    public Menu(int idMenu,String namaMenu,long harga,String jenisMenu,String status){this.idMenu=idMenu;this.namaMenu=namaMenu;this.harga=harga;this.jenisMenu=jenisMenu;this.status=status;}
    public int getIdMenu(){return idMenu;} public void setIdMenu(int v){idMenu=v;} public String getNamaMenu(){return namaMenu;} public void setNamaMenu(String v){namaMenu=v;} public long getHarga(){return harga;} public void setHarga(long v){harga=v;} public String getJenisMenu(){return jenisMenu;} public void setJenisMenu(String v){jenisMenu=v;} public String getStatus(){return status;} public void setStatus(String v){status=v;}
}
