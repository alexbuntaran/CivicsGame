package utils.displayers;

import java.awt.BorderLayout;
import java.awt.Canvas;

import javax.swing.JFrame;

import utils.Constants;

public class Display {

    private JFrame frame;
    private Canvas canvas;
    
    public Display() {
        frame = new JFrame(Constants.GAME_NAME);
        canvas = new Canvas();
    }

    public void initialize() {
        canvas.setPreferredSize(Constants.FRAME_SIZE);
        canvas.setMaximumSize(Constants.FRAME_SIZE);
        canvas.setMinimumSize(Constants.FRAME_SIZE);
        canvas.setFocusable(false);
        frame.add(canvas, BorderLayout.CENTER);
	    frame.setPreferredSize(Constants.FRAME_SIZE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.pack();
    }

    public JFrame getFrame() {
        return frame;
    }

    public Canvas getCanvas() {
        return canvas;
    }

}
