
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class FroggerIcon implements Icon {

	   public FroggerIcon()
	   {
	     icons = new ArrayList<Icon>();

	     width = height = 0;
	     curr = 0;
	   }

	   public void addIcon(String filename)
	   {
	     Icon icon = new ImageIcon(filename);

	     icons.add(icon);

	     if (icon.getIconWidth() > width)
	       width = icon.getIconWidth();

	     if (icon.getIconHeight() > height)
	       height = icon.getIconHeight();
	   }

	   public int getIconHeight()
	   {
	     return height;
	   }

	   public int getIconWidth()
	   {
	     return width;
	   }

	   public void paintIcon(Component comp, Graphics g, int x, int y)
	   {
	     icons.get(curr).paintIcon(comp, g, x, y);

	     if (curr >= icons.size()) curr = 0;
	   }
	   public void changeCurr(int now){
		   
		   if (now > 0)
		   {
			   curr++;
		   }
		   if (now < 0){
			   curr--;
		   }
		   if (curr >= icons.size()) curr = 0;
		   if (curr < 1 && now < 0) curr = icons.size()-1;
	   }

	   private ArrayList<Icon> icons;
	   private int width;
	   private int height;
	   private int curr;
}
