import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;

public class Tournee_Bus {
	public static void main (String[] args){
		// Initialisation des listes necessaires
		List <Tache> Taff =new ArrayList<>();
		List <Chauffeur> Ontime;
		String File ;
                
                JFileChooser dialogue = new JFileChooser();
             
                // affichage de la fenetre de choix du fichier
                dialogue.showOpenDialog(null);
             
                // récupération du fichier sélectionné
                File trye = dialogue.getSelectedFile();
                File = trye.getAbsolutePath();
            

                
		try {readFile(File, Taff ) ;} //Lecture fichier avec completion liste tache
		
                catch (Exception ex){}
                
                Liste_Chauffeur ListeC = new Liste_Chauffeur();//Initialisation de la classe permettant de creer la liste des chauffeur et
                //de mettre a jour la liste des taches
                ListeC.Taff=Taff;//On donne comme paramettre a notre classe liste de chauffeur la liste des taches
                
                ListeC.list();//On effectue la fonction permettant de creer la liste des chauffeur complété
                
                Ontime=ListeC.Ontime;//On récupere cette liste
                
                Fenetre fen = new Fenetre(Ontime,Taff);//création de la fenetre
                fen.pack();//On pack les pannels
                fen.setVisible(true);//on rend visible le tout
                
}


        private static BufferedReader reader;
		 
    	 
        public static void readFile (String pathToFile, List <Tache> Litache) {//Fonction qui va lire ligne par ligne le fichier instance
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
    } 
	        
}
	    
		
