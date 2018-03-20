
import java.awt.Graphics;
import javax.swing.Icon;
import javax.swing.JComponent;

// This component draws Frogger.

public class FroggerComponent extends JComponent {

	  public FroggerComponent(Icon icon)
	  {
	    this.icon = icon;
	  }

	  public void paintComponent(Graphics g)
	  {
	    icon.paintIcon(this, g, 0, 0);
	  }

	
	  private Icon icon;
}
