import javax.swing.JFrame;
import javax.swing.JPanel;
 
public class Fenetre extends JFrame {
  private final JPanel container = new JPanel();
  private final Panneau pane = new Panneau();
  
public Fenetre(){
    this.setTitle("Animation");
    this.setSize(300, 300);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    this.setContentPane(pane);
    this.setVisible(true);
    go();
    
    this.setVisible(true);            
  }
private void go(){
    for(int i = -50; i < pane.getWidth(); i++){
      int x = pane.getPosX(), y = pane.getPosY();
      x++;
      y++;
      pane.setPosX(x);
      pane.setPosY(y);
      pane.repaint();  
      try {
        Thread.sleep(10);
      } catch (InterruptedException e) {
      }
    }
  }       
}

