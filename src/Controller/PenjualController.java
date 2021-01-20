
package Controller;
import Entity.PenjualEntity;
import Entity.daftarpembeli;
import Entity.PembeliEntity;
import java.util.ArrayList;

public class PenjualController implements ControllerInterface {
    int indexLogin = 0;
    public PenjualController() {
    }
    
    public void dataPenjual() {
        String namaPenjual[] = {"Rufian","Ardiansyah","Rossi"};
        String passwordPenjual[] = {"01","02","03"};
        String toko[] = {"Toko Delivery 1","toko Delevery 2","toko Delivery 3"};
        
        for (int i=0; i<namaPenjual.length;i++) {
            AllObjectModel.penjual.inserPenjual(new PenjualEntity(namaPenjual[i], passwordPenjual[i], toko[i]));
        }
    }
    public void viewpenjual() {
        AllObjectModel.penjual.view();
    }
    
    public void listPembeliBarang() {
        AllObjectModel.daftar.view();
    }
    
    @Override
    public void login(String nama, String password) {
        indexLogin = AllObjectModel.penjual.cekData(nama, password);
    }
    
    public PenjualEntity penjualEntity() {
        return AllObjectModel.penjual.showDataPenjual(indexLogin);
    }
    
    public void updateIsVerified(int index, int indexBarang, PembeliEntity pembeliEntity) {
        AllObjectModel.daftar.updateIsVerified(index, new daftarpembeli(pembeliEntity, true, indexBarang));
    }
    
    public ArrayList<daftarpembeli> cekDaftarModel() {
        return AllObjectModel.daftar.getDaftarArrayList();
    }
}
