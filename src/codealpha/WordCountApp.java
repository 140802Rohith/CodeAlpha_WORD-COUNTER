import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WordCountApp extends JFrame {

    private JTextArea textArea;
    private JButton countButton;
    private JLabel resultLabel;

    public WordCountApp() {
        setTitle("Word Count Application");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        textArea = new JTextArea();
        countButton = new JButton("Count Words");
        resultLabel = new JLabel("Word count will appear here");

        countButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get text from the text area
                String text = textArea.getText();
                // Count words
                int wordCount = countWords(text);
                // Update the result label
                resultLabel.setText("Number of words: " + wordCount);
            }
        });

        add(textArea, BorderLayout.CENTER);
        add(countButton, BorderLayout.SOUTH);
        add(resultLabel, BorderLayout.NORTH);

        setVisible(true);
    }

    private int countWords(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }
        // Split the text into words by whitespace
        String[] words = text.split("\\s+");
        // Return the number of words
        return words.length;
    }

    public static void main(String[] args) {
        // Create an instance of the WordCountApp
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new WordCountApp();
            }
        });
    }
}
