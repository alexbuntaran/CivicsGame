package utils.displayers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Prompt implements ActionListener {

    private JFrame frame;
    private JPanel panel;

    private JLabel question;

    private JButton option1;
    private JButton option2;
    private JButton option3;
    private JButton option4;

    public Prompt(String question, String op1, String op2, String op3, String op4) {
        
    }

    public void closeFrame() {
        frame.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
    
}
