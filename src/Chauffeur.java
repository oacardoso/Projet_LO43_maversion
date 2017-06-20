
import java.util.ArrayList;
import java.util.List;

public class Chauffeur {
        int Numero;

	int Worker_time_sun;

	int UnderTime ;

	int IdleTime;

	int Cost ;
	
        List<Integer> Litache= new ArrayList<>();
	
	
	public Chauffeur(int x){
            this.Numero=x;
            this.Worker_time_sun=0;
            this.IdleTime=0;
            this.Cost=0;
            this.UnderTime=0;
		
	};
	
	public void Calcul_Worker_time(Tache T1,Tache T2) {
            int newWts = T1.Time_Finish-T1.Time_init;
            int idleT = this.Calcul_IdleTime(T1,T2);
            Worker_time_sun = Worker_time_sun + newWts + idleT;
		
	}
        public void Calcul_Worker2_time(Tache T1){
            int newWts = T1.Time_Finish-T1.Time_init;
            Worker_time_sun = Worker_time_sun + newWts;
            
        }
	public void Calcul_UnderTime() {
            UnderTime = Math.abs(480-Worker_time_sun);
	}

	public int Calcul_IdleTime(Tache T1,Tache T2) {
            return IdleTime = T2.Time_init - T1.Time_Finish ;
		
	}

	public void Calcul_cost() {
            Cost = UnderTime+IdleTime;
	}
	public void affiche_chauffeur(){
            System.out.println("Le chauffeur numéro :"+(this.Numero));
            System.out.println(this.Worker_time_sun);
            System.out.println(this.UnderTime);
            System.out.println(this.IdleTime);
            System.out.println(this.Cost);
            System.out.println("La liste des tache de ce Chauffeur est :");
            for (int i = 0;i<this.Litache.size();i++){
                System.out.println(this.Litache.get(i));
                
            }
		}
	}
