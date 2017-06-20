import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class Tournee_Bus {
	public static void main (String[] args){
		// Init
		List <Tache> Taff =new ArrayList<>();
		List <Chauffeur> Ontime =new ArrayList<>();
		int x = 0 ; //Numero du chauffeur -1
		int y = 0; //Num�ro de la tache -1
		int huit = 480; // huit heures de travail
		int dix = 600; // 10 h de travail
		int flag = 0; //si tache restante = 0
		
		try {readFile("C:\\Users\\miiixx-94\\Documents\\Java Proj\\LO43\\sujet_habillage_tournees\\Instance_1\\Instance_1.txt", Taff ) ;} //Lecture fichier avec completion liste tache
		catch (Exception ex){
                    System.err.println("Veuillez changer le nom du fichier");
                    }
                
		Ontime.add(new Chauffeur(x));
		//Core 

		while(flag!=1){
                    flag = 1;// flag pour savoir si toute les tache ont un chauffeur
                    if(Ontime.get(x).Worker_time_sun>huit){ //Le travailleur fait + de 8 heures
                        if((Taff.get(y).Time_Finish - Taff.get(y).Time_init) >= dix - Ontime.get(x).Worker_time_sun ){//le travailleur fait + de 10h
                            //changement de chauffeur
                            x++;
                            Ontime.add(new Chauffeur(x));
                        }
                    }
                    int j=-1;// flag pour savoir si il reste des taches compatible avec le chauffeur
                    for (int i = 0; i<Taff.size();i++) {
                        if(Taff.get(i).chauffeur==null){
                            if (Taff.get(i).Lieu_init == null ? Taff.get(y).Lieu_finish == null : Taff.get(i).Lieu_init.equals(Taff.get(y).Lieu_finish)) {
                                if(Taff.get(y).Time_Finish < Taff.get(i).Time_init){//Condition que la tache suivante ce passe après
                                j=i;
                                break;
                                }
                            }
                        }
                    }
                    if(j!=-1){//la tache correspond au chauffeur alors on met a jours ses données
                            Ontime.get(x).Calcul_Worker_time(Taff.get(y), Taff.get(j));
                            Ontime.get(x).Calcul_UnderTime();
                            Ontime.get(x).Calcul_IdleTime(Taff.get(y), Taff.get(j));
                            Taff.get(y).chauffeur=Ontime.get(x); //on affecte la tache au chauffeur
                            Ontime.get(x).Litache.add(y);
                            y=j;//changement de tache de début
                    }
                    else{//changement de chauffeur car aucune tache ne correspond au chauffeur
                        Ontime.get(x).Calcul_Worker2_time(Taff.get(y));
                        Ontime.get(x).Calcul_UnderTime();
                        Taff.get(y).chauffeur=Ontime.get(x); //on affecte la tache au chauffeur
                        Ontime.get(x).Litache.add(y);
                        x++;
                        Ontime.add(new Chauffeur(x));
                        for (int i = 0;i<Taff.size();i++){
                            if(Taff.get(i).chauffeur==null){
                                y=i;
                                break;
                            }             
                        }
                    }
                    int compteur=0 ; //compteur de tâche null            
                    for (int i = 0;i<Taff.size();i++) {//verification que toutes les taches ne sont pas attribué
                        if(Taff.get(i).chauffeur==null) {
                           compteur++;
                       }
                    }
                    
                    if (compteur!=1) {
                        flag=0;
                    } else {
			Taff.get(y).chauffeur=Ontime.get(x); //on affecte la tache au chauffeur
                        Ontime.get(x).Calcul_Worker2_time(Taff.get(y));
			Ontime.get(x).Calcul_UnderTime();
                        Ontime.get(x).Litache.add(y);
                    }
		}
                
		for(int i =0;i<Ontime.size();i++){//calcul du cout pour tout les chauffeurs
			Ontime.get(i).Calcul_cost();
                       }
//            for (int i = 0;i<Taff.size();i++) {//affichage des taches
//                System.out.println("Tache numero "+(i+1));
//                Taff.get(i).affiche_tache();
//            }
                for (int i = 0;i<Ontime.size();i++){
                    Ontime.get(i).affiche_chauffeur();
                }
                
    
                Fenetre fen = new Fenetre();
                //CHAUFFEUR
                JTable tbl = new JTable();
                DefaultTableModel dtm = new DefaultTableModel(0,0);
                JTable tbl2 = new JTable();
                DefaultTableModel dtm2 = new DefaultTableModel(0,0);
    
                String header[] = new String[] {"Numero Chauffeur","Worker Time","IdleTime","UnderTime","Cost"};
                dtm.setColumnIdentifiers(header);
                tbl.setModel(dtm);String header2[] = new String[] {"Numéro Tache","Heure Depart","Heure Arrivee","Lieu Depart","Lieu Arrivé","Numéro chauffeur"};
                dtm2.setColumnIdentifiers(header2);
                tbl2.setModel(dtm2);
                for(int i = 0;i<Ontime.size();i++){
                    dtm.addRow(new Object[] {Ontime.get(i).Numero,Ontime.get(i).Worker_time_sun,Ontime.get(i).IdleTime,Ontime.get(i).UnderTime,Ontime.get(i).Cost});
                    for(int ii = 0;ii<Ontime.get(i).Litache.size();ii++){
                        
                        dtm2.addRow(new Object[] {Ontime.get(i).Litache.get(ii),Taff.get(Ontime.get(i).Litache.get(ii)).Time_init,Taff.get(Ontime.get(i).Litache.get(ii)).Time_Finish,Taff.get(Ontime.get(i).Litache.get(ii)).Lieu_init,Taff.get(Ontime.get(i).Litache.get(ii)).Lieu_finish,Taff.get(Ontime.get(i).Litache.get(ii)).chauffeur.Numero});
                    
                }
                    
                    }
                
                fen.getContentPane().add(tbl.getTableHeader(), BorderLayout.NORTH);
                fen.getContentPane().add(tbl, BorderLayout.CENTER);
                fen.getContentPane().add(new JScrollPane(tbl));
                fen.getContentPane().add(tbl2.getTableHeader(), BorderLayout.NORTH);
                fen.getContentPane().add(tbl2, BorderLayout.CENTER);
                fen.getContentPane().add(new JScrollPane(tbl2));
                
                
                
                
                
                
                
                
                   //TACHE
                
                
                
                
                
                
                
                
                
                
                
                
                
                TableColumn column = null;
                for (int i = 0; i < 5; i++) {
                    column = tbl.getColumnModel().getColumn(i);
                    if (i == 0) {
                        column.setPreferredWidth(100); //third column is bigger
                    } else {
                        column.setPreferredWidth(50);
                    }
                }
                TableColumn columnn = null;
                for (int i = 0; i < 6; i++) {
                    columnn = tbl2.getColumnModel().getColumn(i);
                    if ((i == 0) || (i == 1)||(i == 2)||(i == 5)){
                        columnn.setPreferredWidth(100); //third column is bigger
                    } else {
                        columnn.setPreferredWidth(50);
                    }
                }
                
                
                
                
                
                fen.setVisible(true);
                
                System.out.println("SALUUUUUT");
                
}


        private static BufferedReader reader;
		 
    	 
        public static void readFile (String pathToFile, List <Tache> Litache) {
        try {
            reader = new BufferedReader(new FileReader(new File(pathToFile)));
            String ligne;

            int h;
            while((ligne = reader.readLine()) != null){
                        Tache temp=new Tache();
                        h=0;
                        if (ligne.indexOf(" ")== 0){//Horraire d�but (heures)
                                int i = Integer.parseInt(ligne.substring(1, 2));
                                i=i*60;

                                h=h+i;
                                }
                        else {
                                int i = Integer.parseInt(ligne.substring(0, 2));
                                i=i*60;
                        h=h+i;
                        }

                        String min_deb=ligne.substring(3,5);//Horraire d�but (minute)

                                if (min_deb.indexOf(" ")== 0){
                                        int ii = Integer.valueOf(ligne.substring(4, 5));
                            h=h+ii;
                        }
                                else {
                                        int ii = Integer.valueOf(ligne.substring(3 ,5));
                                        h=h+ii;
                                }

                                temp.Time_init=h;
                        h=0;
                        String h_fin=ligne.substring(9,11);//Horraire fin (heure)

                                if (h_fin.indexOf(" ")== 0){
                                        int ii = Integer.valueOf(ligne.substring(10, 11));
                                        ii=ii*60;
                            h=h+ii;
                        }
                                else {
                                        int ii = Integer.valueOf(ligne.substring(9 ,11));

                                        ii=ii*60;
                                        h=h+ii;
                                }
                                String min_fin=ligne.substring(12,14);//Horraire fin (minute)

                                if (min_fin.indexOf(" ")== 0){
                                        int ii = Integer.valueOf(ligne.substring(13, 14));
                            h=h+ii;

                        }
                                else {
                                        int ii = Integer.valueOf(ligne.substring(12,14));

                                        h=h+ii;
                                }
                                temp.Time_Finish=h;
                                temp.Lieu_init=ligne.substring(18,19);
                                temp.Lieu_finish=ligne.substring(23,24);
                                Litache.add(temp);
            }


            } catch (IOException | NumberFormatException ex){
                System.err.println("Error. "+ex.getMessage());
            }
	            } //fonctions permettant de creer la liste des taches
	        
	    }
	    
		
