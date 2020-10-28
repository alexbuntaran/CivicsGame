package utils.displayers;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import entities.characters.Player;
import utils.Constants;

public class Prompt implements ActionListener {

    private JFrame frame;
    private JPanel panel;

    private JLabel question;
    
    private JButton option1;
    private JButton option2;
    private JButton option3;
    private JButton option4;

    private Player player;
    private String answer;
    private boolean isClosed;

    public Prompt(Player player) {
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
        frame.pack();
        
        this.player = player;
        isClosed = true;
    }
    
    public void displayFrame(String[] data) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        Random rand = new Random();
        int index = 0;
        answer = data[1];

        question.setText(data[0]);

        index = rand.nextInt(list.size());
        option1.setText(data[list.get(index)]);
        list.remove(index);

        index = rand.nextInt(list.size());
        option2.setText(data[list.get(index)]);
        list.remove(index);

        index = rand.nextInt(list.size());
        option3.setText(data[list.get(index)]);
        list.remove(index);

        index = rand.nextInt(list.size());
        option4.setText(data[list.get(index)]);
        list.remove(index);

        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.pack();

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
        JButton ans = (JButton) e.getSource();
        if (ans.getText().equals(answer)) {
            player.correct();
            closeFrame();
        } else {
            player.incorrect();
        }
    }
    
}
