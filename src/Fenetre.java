import java.awt.BorderLayout;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
 
public class Fenetre extends JFrame {
    private final JPanel pan = new JPanel();//Création du pannel ou mettre les tableaux
    
public Fenetre(List <Chauffeur> Ontime,List <Tache> Taff){//Fonction permettant l'affichage des tableaus en fonction de la liste de chauffeur et des taches
    this.setTitle("Tournee Bus");//Initialisation de la fenetre principal
    this.setSize(1000, 500);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    this.setContentPane(pan);

    
    
    
    
    JTable tbl = new JTable();
    DefaultTableModel dtm = new DefaultTableModel(0,0);//Tableau de gauche
    JTable tbl2 = new JTable();
    DefaultTableModel dtm2 = new DefaultTableModel(0,0);//Tableau de droite
    String header[] = new String[] {"Numero Chauffeur","Worker Time","IdleTime","UnderTime","Cost"};
    dtm.setColumnIdentifiers(header);
    tbl.setModel(dtm);String header2[] = new String[] {"Numéro chauffeur","Numéro Tache","Heure Depart","Heure Arrivee","Lieu Depart","Lieu Arrivé"};
    dtm2.setColumnIdentifiers(header2);
    tbl2.setModel(dtm2);
    for(int i = 0;i<Ontime.size();i++){//for permettant l'affichage des chauffeurs dans l'ordre ainsi que leurs taches classé par ordre des chauffeurs puis d'execution des chauffeurs
                    dtm.addRow(new Object[] {Ontime.get(i).Numero+1,(Ontime.get(i).Worker_time_sun/60+"h"+Ontime.get(i).Worker_time_sun%60),(Ontime.get(i).IdleTime/60+"h"+Ontime.get(i).IdleTime%60),(Ontime.get(i).UnderTime/60+"h"+Ontime.get(i).UnderTime%60),Ontime.get(i).Cost});
                    for(int ii = 0;ii<Ontime.get(i).Litache.size();ii++){
                        
                        dtm2.addRow(new Object[] {Taff.get(Ontime.get(i).Litache.get(ii)).chauffeur.Numero+1,Ontime.get(i).Litache.get(ii),(Taff.get(Ontime.get(i).Litache.get(ii)).Time_init/60+"h"+Taff.get(Ontime.get(i).Litache.get(ii)).Time_init%60),(Taff.get(Ontime.get(i).Litache.get(ii)).Time_Finish/60+"h"+Taff.get(Ontime.get(i).Litache.get(ii)).Time_Finish%60),Taff.get(Ontime.get(i).Litache.get(ii)).Lieu_init,Taff.get(Ontime.get(i).Litache.get(ii)).Lieu_finish});
                    
                }
                    
                    }
    this.getContentPane().add(tbl.getTableHeader(), BorderLayout.NORTH);
    this.getContentPane().add(tbl, BorderLayout.CENTER);
    this.getContentPane().add(new JScrollPane(tbl));
    this.getContentPane().add(tbl2.getTableHeader(), BorderLayout.NORTH);
    this.getContentPane().add(tbl2, BorderLayout.CENTER);
    this.getContentPane().add(new JScrollPane(tbl2));//Position des tableaux
    TableColumn column = null;
    for (int i = 0; i < 5; i++) {//Agrandissement des colonnes
        column = tbl.getColumnModel().getColumn(i);
        column.setPreferredWidth(100); 
    }
    TableColumn columnn = null;
    for (int i = 0; i < 6; i++) {
        columnn = tbl2.getColumnModel().getColumn(i);
        columnn.setPreferredWidth(100);
    }    
    
    
    
    this.setVisible(true);//Rendre visible le tableau              
  }

    Fenetre() {//Initialisation par defaut d'une fenetre
        this.setTitle("Tournee Bus 2");
        this.setSize(1000, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setContentPane(pan);

    }
}