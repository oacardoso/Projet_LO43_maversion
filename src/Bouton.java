import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
  
public class Bouton extends JButton implements MouseListener{
  private String name;

  public Bouton(String str){
    super(str);
    this.name = str;
    this.addMouseListener(this);
  }

  @Override
  public void paintComponent(Graphics g){
    Graphics2D g2d = (Graphics2D)g;
    g2d.setColor(Color.black);
    g2d.drawString(this.name, this.getWidth() / 2 - (this.getWidth()  /3), (this.getHeight() / 2) + 5);
  }

  @Override
  public void mouseClicked(MouseEvent event) {
    //Inutile d'utiliser cette méthode ici                      
  }

  @Override
  public void mouseEntered(MouseEvent event) {
    //Nous changeons le fond de notre image pour le jaune lors du survol, avec le fichier fondBoutonHover.png
   
  }

  @Override
  public void mouseExited(MouseEvent event) {
  //Nous changeons le fond de notre image pour le vert lorsque nous quittons le bouton, avec le fichier fondBouton.png

  }

  @Override
  public void mousePressed(MouseEvent event) {
    //Nous changeons le fond de notre image pour le jaune lors du clic gauche, avec le fichier fondBoutonClic.png

  }
 
  @Override
public void mouseReleased(MouseEvent event) {
  //Nous changeons le fond de notre image pour le orange lorsque nous relâchons le clic avec le fichier fondBoutonHover.png si la souris est toujours sur le bouton
  
}
}

