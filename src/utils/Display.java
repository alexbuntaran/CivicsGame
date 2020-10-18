package utils;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Display {

    private JFrame frame;
    private Canvas canvas;
    
    public Display() {
        frame = new JFrame("Civics Game");
        canvas = new Canvas();
    }

    public void initialize() {
        canvas.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
        canvas.setMaximumSize(Toolkit.getDefaultToolkit().getScreenSize());
        canvas.setMinimumSize(Toolkit.getDefaultToolkit().getScreenSize());
        frame.add(canvas, BorderLayout.CENTER);
	    frame.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.pack();
    }

}
