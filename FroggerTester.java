
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class FroggerTester {

	 public static void main(String[] args) throws InterruptedException
	   {
	      final FroggerIcon frogicon = new FroggerIcon();
	      
	      for (int i = 0; i < 8; ++i)
	      {
	        frogicon.addIcon("0" + i + "Frog.gif");
	      }
	      

	      JLabel myfrog  = new JLabel();
	      JComponent comp = new FroggerComponent(frogicon);
	      JLabel mycar = new JLabel(); 
	      BufferedImage img = null;
	      try {
	          img = ImageIO.read(new File("Car3.gif"));
	      } catch (IOException e) {
	          e.printStackTrace();
	      }
	      BufferedImage img1 = null;
	      try {
	    	  img1 = ImageIO.read(new File("Frog.gif"));
	      } catch (IOException e) {
	    	  e.printStackTrace();
	      }
	      Image fimg = img1.getScaledInstance(25,25, Image.SCALE_SMOOTH);
	      ImageIcon frogIcon = new ImageIcon(fimg);
	      
	      Image dimg = img.getScaledInstance(50, 50,Image.SCALE_SMOOTH);
	      ImageIcon carIcon = new ImageIcon(dimg);

	      myfrog.setIcon(frogIcon);
	      mycar.setIcon(carIcon);

	      JFrame     frame = new JFrame();
	      frame.add(mycar);
	      //frame.add(myfrog);
	      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      frame.pack();
	      frame.setBounds(100,0,500, 200);
	      frame.setVisible(true);
	      
	   
	   frame.addKeyListener(new KeyListener() {
		   
		   public void keyPressed(KeyEvent e) {
			   if (e.getKeyCode()==KeyEvent.VK_LEFT) {
				   
				   frogicon.changeCurr(-1);
				   comp.repaint();
				   
			   } if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
			
				   frogicon.changeCurr(1);
				   comp.repaint();
				   
			   } if (e.getKeyCode()==KeyEvent.VK_UP) {
				   
				   frogicon.changeCurr(-1);
				   comp.repaint();
				   
			   } if (e.getKeyCode()==KeyEvent.VK_DOWN) {
				   
				   frogicon.changeCurr(-1);
				   comp.repaint();
			   }
		   }
		   public void keyReleased(KeyEvent e) {
			   }
		   public void keyTyped(KeyEvent e) {
		   }
	   } );
	   ActionListener taskPerformer = new ActionListener() {
		      int x=0;
		      int move;
		      public void actionPerformed(ActionEvent evt) {
		    	  	if(x<500)
		            mycar.setLocation(move+=10, 0);
		    	  	x+=10;
		    	  	if(x<1500 && x>500){mycar.setLocation(move-=10,0);
		    	  	x+=10;
		    	  	System.out.println(x);
		    	  	if(x==1500){x=0;mycar.setLocation(0,0);}
		    	  	}		      }
		  };
		  
		  new Timer(100, taskPerformer).start();}
	 
	 }
         


