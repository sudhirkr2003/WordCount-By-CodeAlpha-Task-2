package word.Counts.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WordCount extends JFrame implements ActionListener {

    int totalWords = 0;
    JLabel toWords;
    JButton wordCounts, exit, reset;
    JTextArea writeWords;
    JComboBox<Integer> fontSize;

    WordCount() {

        JLabel wordCount = new JLabel("WORDS COUNT");
        wordCount.setBounds(400, 20, 500, 60);
        wordCount.setFont(new Font("Helvetica", Font.BOLD, 40));
        add(wordCount);

        writeWords = new JTextArea();
        writeWords.setLineWrap(true);
        writeWords.setWrapStyleWord(true);
        add(writeWords);

        JScrollPane writeScroll = new JScrollPane(writeWords);
        writeScroll.setBounds(170, 100, 770, 300);
        add(writeScroll);

        toWords = new JLabel(totalWords + " WORDS");
        toWords.setBounds(515, 450, 150, 30);
        toWords.setFont(new Font("Arial", Font.BOLD, 20));
        add(toWords);

        wordCounts = new JButton("Word Count");
        wordCounts.setBounds(500, 500, 150, 30);
        wordCounts.setBackground(Color.BLACK);
        wordCounts.setForeground(Color.WHITE);
        wordCounts.addActionListener(this);
        add(wordCounts);

        Integer[] fontSizes = {10, 20, 30, 40};
        fontSize = new JComboBox<>(fontSizes);
        fontSize.setBounds(500, 400, 70, 30);
        fontSize.addActionListener(this);
        add(fontSize);

        exit = new JButton("EXIT");
        exit.setBounds(500, 550, 150, 30);
        exit.setBackground(Color.BLACK);
        exit.setForeground(Color.WHITE);
        exit.addActionListener(this);
        add(exit);

        reset = new JButton("Reset");
        reset.setBounds(700, 525, 100, 30);
        reset.setBackground(Color.RED);
        reset.setForeground(Color.WHITE);
        reset.addActionListener(this);
        add(reset);

        setSize(1170, 650);
        setLocation(450, 200);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == fontSize && e.getActionCommand().equals("comboBoxChanged")) {
            int fs = (int) fontSize.getSelectedItem();
            writeWords.setFont(new Font("Arial", Font.BOLD, fs));
        } else if (e.getSource() == wordCounts) {
            String data = writeWords.getText().trim();
            if (!data.isEmpty()) {
                String[] words = data.split("\\s+");
                totalWords = words.length;
            } else {
                totalWords = 0;
            }
            toWords.setText(totalWords + " WORDS");
        } else if (e.getSource() == reset) {
            writeWords.setText("");
            toWords.setText("0 WORDS");
        } else {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new WordCount();
    }
}
