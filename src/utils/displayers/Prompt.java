package utils.displayers;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import utils.Constants;

public class Prompt implements ActionListener {

    private JFrame frame;
    private JPanel panel;

    private JLabel question;
    
    private JButton option1;
    private JButton option2;
    private JButton option3;
    private JButton option4;

    private boolean isClosed;

    public Prompt() {
        frame = new JFrame();
        panel = new JPanel();

        question = new JLabel("", SwingConstants.CENTER);
        option1 = new JButton();
        option2 = new JButton();
        option3 = new JButton();
        option4 = new JButton();

        option1.addActionListener(this);
        option2.addActionListener(this);
        option3.addActionListener(this);
        option4.addActionListener(this);

        panel.setLayout(new GridLayout(0, 1));
        panel.add(question);
        panel.add(option1);
        panel.add(option2);
        panel.add(option3);
        panel.add(option4);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setPreferredSize(new Dimension(Constants.FRAME_WIDTH / 3, Constants.FRAME_HEIGHT / 2));
		frame.setTitle("Prompt");
        frame.setVisible(false);
        frame.setLocationRelativeTo(null);
        frame.pack();
        
        isClosed = true;
    }

    public void displayFrame(String[] data) {
        question.setText(data[0]);
        option1.setText(data[1]);
        option2.setText(data[2]);
        option3.setText(data[3]);
        option4.setText(data[4]);

        frame.setVisible(true);

        isClosed = false;
    }

    public void closeFrame() {
        frame.dispose();
        isClosed = true;
    }

    public boolean isClosed() {
        return isClosed;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(option1)) {
            System.out.println("Correct");
            closeFrame();
        } else {
            System.out.println("Wrong");
        }
    }
    
}
