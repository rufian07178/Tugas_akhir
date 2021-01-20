package View;
import Entity.BarangEntity;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class UpdateGUI {
    JComboBox pilBaju = new JComboBox(BarangEntity.nama);
    JButton konfirmasi,kembali;
    JFrame TampilanAwal = new JFrame();
    JTextArea area = new JTextArea();
    JLabel update,labelBajuUpdate;
    JTextField textBajuUpdate;
    public UpdateGUI() {
        
        TampilanAwal.setSize(720,600);
        TampilanAwal.setLayout(null);
        TampilanAwal.getContentPane().setBackground(Color.MAGENTA);
        
        update = new JLabel("Update Data");
        update.setFont(new Font("Times New Roman",Font.BOLD,43));
        update.setBounds(240,30,300,80);
        TampilanAwal.add(update);
        
        labelBajuUpdate = new JLabel("Nama Pembeli");
        labelBajuUpdate.setBounds(300,180,150,30);
        TampilanAwal.add(labelBajuUpdate);
        
        textBajuUpdate = new JTextField();
        textBajuUpdate.setBounds(250,210,200,40);
        TampilanAwal.add(textBajuUpdate);
        
        pilBaju.setBounds(276,270,150,40);
        TampilanAwal.add(pilBaju);
        
        konfirmasi = new JButton("KONFIRMASI");
        konfirmasi.setBounds(290,330,120,40);
        konfirmasi.setBackground(Color.GREEN);
        TampilanAwal.add(konfirmasi);
        
        kembali = new JButton("KEMBALI");
        kembali.setBounds(290,380,120,40);
        kembali.setBackground(Color.GREEN);
        TampilanAwal.add(kembali);
        
        TampilanAwal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        TampilanAwal. setVisible(true);
        TampilanAwal.setLocationRelativeTo(null);
        
        konfirmasi.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                int BajuUpdate = pilBaju.getSelectedIndex();
                AllObjctrl.pembeli.update(textBajuUpdate.getText(), BajuUpdate);
                JOptionPane.showMessageDialog(null,"PILIHAN BARANG BERHASIL DI UPDATE","INFORMATION",JOptionPane.INFORMATION_MESSAGE);
                kosong();
            }
            
        });
        
        kembali.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                TampilanAwal.dispose();
                GUI men = new GUI();
            }
            
        });
    }
    void kosong() {
        textBajuUpdate.setText(null);
    }
}
