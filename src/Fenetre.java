import javax.swing.JFrame;
 
public class Fenetre extends JFrame {
  private final Panneau pane = new Panneau();
  
public Fenetre(){
    this.setTitle("Tournee Bus");
    this.setSize(900, 1000);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    this.setContentPane(pane);
    this.setVisible(true);
  }
}
