
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author miiixx-94
 */
public class Liste_Chauffeur {
    List <Tache> Taff =new ArrayList<>();
    List <Chauffeur> Ontime =new ArrayList<>();
    private int x = 0 ; //Numero du chauffeur -1
    private int y = 0; //Num�ro de la tache -1
    private final int huit = 480; // huit heures de travail
    private final int dix = 600; // 10 h de travail
    private int flag = 0; //si tache restante = 0
    Liste_Chauffeur (){  
    }
    public void list(){
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
    }
}