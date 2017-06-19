

public class Tache {

	int Time_init ;

	int Time_Finish ;

	String Lieu_init ;

	String Lieu_finish ;

	Chauffeur chauffeur ;
	
	public Tache(){
		Time_init = 0;

		Time_Finish = 0;

		Lieu_init = "";

		Lieu_finish = "";

		chauffeur = null ;
	}
	public void affiche_tache(){
		System.out.println("Debut : "+(Time_init/60)+"h"+(Time_init%60)+"  Fin : "+(Time_Finish/60)+"h"+(Time_Finish%60)+"  Lieu début : "+Lieu_init+"  Lieu arriver : "+Lieu_finish);
	}

}
