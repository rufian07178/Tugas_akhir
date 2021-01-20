package View;
import Entity.BarangEntity;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class pembeliGUI {
    JFrame pembeli = new JFrame();
    JButton back, daftarbtn;
    JTextArea area = new JTextArea();
    JLabel datadiri,daftarBarang;
    JComboBox pilBarang = new JComboBox(BarangEntity.nama);
    int cek = AllObjctrl.pembeli.cekDaftarPembeli(AllObjctrl.pembeli.getData().getNama());
    
    public pembeliGUI() {
        pembeli.setSize(720,600);
        pembeli.setLayout(null);
        pembeli.getContentPane().setBackground(Color.BLUE);
        
        datadiri = new JLabel("Data Pembeli");
        datadiri.setFont(new Font("Timer New Roman",Font.BOLD,30));
        datadiri.setBounds(90, 30, 200, 30);
        pembeli.add(datadiri);
        area.setBounds(30, 90, 400, 300);
        pembeli.add(area);
        
        daftarBarang = new JLabel("Daftar Barang");
        daftarBarang.setBounds(450, 30, 250, 30);
        daftarBarang.setFont(new Font("Times New Roman",Font.BOLD,30));
        pembeli.add(daftarBarang);
        pilBarang.setBounds(450, 90, 230, 30);
        pembeli.add(pilBarang);
        
        daftarbtn = new JButton("Daftar");
        daftarbtn.setBounds(500, 200, 100, 30);
        daftarbtn.setBackground(Color.GRAY);
        pembeli.add(daftarbtn);
        
        back = new JButton("Back");
        back.setBounds(30, 500, 100, 30);
        back.setBackground(Color.GRAY);
        pembeli.add(back);
        
        pembeli.setVisible(true);
        pembeli.setLocationRelativeTo(null);
        pembeli.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        if(cek==-1){
             JOptionPane.showMessageDialog(null, "Anda Belum Daftar Barang", "Information", JOptionPane.INFORMATION_MESSAGE);
        }else if(cek==-2){
            JOptionPane.showMessageDialog(null,"Anda Belum Daftar Barang", "Information", JOptionPane.INFORMATION_MESSAGE);
        }else{
            area.setText(datapembeli());
        }
        daftarbtn.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                int indexbarang = pilBarang.getSelectedIndex();
                AllObjctrl.pembeli.daftarbarang(indexbarang,AllObjctrl.pembeli.getData(),false);
                area.setText(datapembeli());
            }
            
        });
        back.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                pembeli.dispose();
                GUI men = new GUI();
            }
            
        });
}
    String datapembeli(){
        int cek = AllObjctrl.pembeli.cekDaftarPembeli(AllObjctrl.pembeli.getData().getNama());
        String cekverif;
        if(AllObjctrl.pembeli.showDaftarPembeli(cek).isIsVerified()==false) {
            cekverif = "belum di verifikasi";
        }else{
            cekverif = "Sudah di verifikasi";
        }
        String text = "Nama = "+AllObjctrl.pembeli.showDaftarPembeli(cek).getPembeli().getNama()+"\n"
                +"Alamat = "+AllObjctrl.pembeli.showDaftarPembeli(cek).getPembeli().getAlamat()+"\n"
                +"Verifikasi = "+cekverif+"\n"
                +"Barang = "+BarangEntity.nama[AllObjctrl.pembeli.showDaftarPembeli(cek).getindexBarang()];
        return text;
    }
}