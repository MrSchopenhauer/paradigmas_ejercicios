package daemonthreadtest;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class ModeloEspacio {
	
	public static void main(String[] args) {
		
		 // Create new frame
		 JFrame frame= new JFrame();
		 // Tells program to exit when user closes this frame
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 // Frame has 0 default size; give it a size
		 frame.setSize(700, 600); // setSize(int x, int y)
		 // Frame invisible by default; make it visible
		 frame.setVisible(true);
		 }
		 // main() ends but Swing thread stays alive
	
	

}
