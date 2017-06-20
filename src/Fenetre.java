import java.awt.BorderLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
 
public class Fenetre extends JFrame {
    private final JPanel pan = new JPanel();
    private final JPanel Cont = new JPanel();
    
public Fenetre(List <Chauffeur> Ontime,List <Tache> Taff){
    this.setTitle("Tournee Bus");
    this.setSize(1000, 500);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    this.setContentPane(pan);

    
    JTable tbl = new JTable();
    DefaultTableModel dtm = new DefaultTableModel(0,0);
    JTable tbl2 = new JTable();
    DefaultTableModel dtm2 = new DefaultTableModel(0,0);

    String header[] = new String[] {"Numero Chauffeur","Worker Time","IdleTime","UnderTime","Cost"};
    dtm.setColumnIdentifiers(header);
    tbl.setModel(dtm);String header2[] = new String[] {"Numéro chauffeur","Numéro Tache","Heure Depart","Heure Arrivee","Lieu Depart","Lieu Arrivé"};
    dtm2.setColumnIdentifiers(header2);
    tbl2.setModel(dtm2);
    for(int i = 0;i<Ontime.size();i++){
                    dtm.addRow(new Object[] {Ontime.get(i).Numero+1,Ontime.get(i).Worker_time_sun,Ontime.get(i).IdleTime,Ontime.get(i).UnderTime,Ontime.get(i).Cost});
                    for(int ii = 0;ii<Ontime.get(i).Litache.size();ii++){
                        
                        dtm2.addRow(new Object[] {Taff.get(Ontime.get(i).Litache.get(ii)).chauffeur.Numero,Ontime.get(i).Litache.get(ii),Taff.get(Ontime.get(i).Litache.get(ii)).Time_init,Taff.get(Ontime.get(i).Litache.get(ii)).Time_Finish,Taff.get(Ontime.get(i).Litache.get(ii)).Lieu_init,Taff.get(Ontime.get(i).Litache.get(ii)).Lieu_finish});
                    
                }
                    
                    }
                
    this.getContentPane().add(tbl.getTableHeader(), BorderLayout.NORTH);
    this.getContentPane().add(tbl, BorderLayout.CENTER);
    this.getContentPane().add(new JScrollPane(tbl));
    this.getContentPane().add(tbl2.getTableHeader(), BorderLayout.NORTH);
    this.getContentPane().add(tbl2, BorderLayout.CENTER);
    this.getContentPane().add(new JScrollPane(tbl2));

    

    TableColumn column = null;
    for (int i = 0; i < 5; i++) {
        column = tbl.getColumnModel().getColumn(i);
        column.setPreferredWidth(100); //third column is bigger
        
    }
    TableColumn columnn = null;
    for (int i = 0; i < 6; i++) {
        columnn = tbl2.getColumnModel().getColumn(i);
        columnn.setPreferredWidth(100); 
        
    }

    
    
     
    
    
    this.setVisible(true);              
  }

    Fenetre() {
        this.setTitle("Tournee Bus");
        this.setSize(1000, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setContentPane(pan);

    }
}