package main;

import java.awt.Canvas;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Interface {

    private JFrame frame;
    private Canvas canvas;
    
    public Interface(String title) {
        frame = new JFrame(title);
        canvas = new Canvas();
    }

    public void initialize() {
	    frame.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
		frame.setVisible(true);
        
        canvas.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
        canvas.setMaximumSize(Toolkit.getDefaultToolkit().getScreenSize());
        canvas.setMinimumSize(Toolkit.getDefaultToolkit().getScreenSize());

        frame.add(canvas);
        frame.pack();
    }

}
