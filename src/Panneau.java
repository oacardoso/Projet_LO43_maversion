import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;
 
public class Panneau extends JPanel { 
  @Override
  public void paintComponent(Graphics g){
    Font font = new Font("Courier", Font.BOLD, 20);
    g.setColor(Color.red);
    g.fillOval(posX, posY, 50, 50);
    g.setColor(Color.red);
  }
  private int posX = -50;
  private int posY = -50;

  public int getPosX() {
    return posX;
  }

  public void setPosX(int posX) {
    this.posX = posX;
  }

  public int getPosY() {
    return posY;
  }

  public void setPosY(int posY) {
    this.posY = posY;
  }        
}