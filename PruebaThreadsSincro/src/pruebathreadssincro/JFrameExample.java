package pruebathreadssincro;

import javax.swing.*;
import java.awt.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JFrameExample {

/*
	    public static void main(String[] args) {
	        JFrame frame = new JFrame("JDesktopPane Example");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setSize(800, 800);

	        JDesktopPane desktopPane = new JDesktopPane();
	        frame.setContentPane(desktopPane);

	        // Create the first internal frame
	        JInternalFrame internalFrame1 = new JInternalFrame("Internal Frame 1", true, true, true, true);
	        internalFrame1.setSize(800, 200);
	        internalFrame1.setLocation(0, 0);

	       
	        Particula particula = new Particula(0,100,10,"black");
	        
	        internalFrame1.add(particula);

	        // Create the second internal frame
	        JInternalFrame internalFrame2 = new JInternalFrame("Internal Frame 2", true, true, true, true);
	        internalFrame2.setSize(800, 400);
	        internalFrame2.setLocation(0, 200);

	        JButton button2 = new JButton("Button 2");
	        button2.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                JOptionPane.showMessageDialog(internalFrame2, "Button 2 clicked");
	            }
	        });
	        internalFrame2.add(button2);

	        // Add internal frames to the desktop pane
	        desktopPane.add(internalFrame1);
	        desktopPane.add(internalFrame2);

	        // Make internal frames visible
	        internalFrame1.setVisible(true);
	        internalFrame2.setVisible(true);
	        
	        // Create a progress bar
	        JProgressBar progressBar = new JProgressBar();
	        progressBar.setStringPainted(true);
	        progressBar.setMaximum(100); // Set the maximum value of the progress bar

	        // Add the progress bar to the desktop pane
	        desktopPane.add(progressBar);
	        progressBar.setSize(200, 20);
	        progressBar.setLocation(50, 200);

	        // Simulate variable changes and update the progress bar
	        Timer timer = new Timer(1000, new ActionListener() {
	            int progressValue = 0;

	            @Override
	            public void actionPerformed(ActionEvent e) {
	                // Update the progress bar value based on your variable
	                progressValue += 10; // For example, increment by 10 each time
	                progressBar.setValue(progressValue);

	                // Reset the progress when it reaches the maximum
	                if (progressValue >= 100) {
	                    progressValue = 0;
	                }
	            }
	        });
	        timer.start();

	        frame.setVisible(true);
 
	        
	    }
*/

}
