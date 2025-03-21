import java.awt.*;
import java.awt.event.*;

public class AIRiddleGame extends Frame implements ActionListener {
    Label questionLabel;
    TextField answerField;
    Button submitButton;
    Label resultLabel;

    String[][] riddles = {
        {"I speak without a mouth and hear without ears. I have no body, but I come alive with the wind. What am I?", "echo"},
        {"The more you take, the more you leave behind. What am I?", "footsteps"},
        {"I have cities, but no houses. I have forests, but no trees. I have rivers, but no water. What am I?", "map"}
    };

    int currentRiddleIndex = 0;

    public AIRiddleGame() {
        setLayout(new FlowLayout());
        setSize(1000, 800);
        setTitle("AI Riddle Game");
        setTitle("Welcome To AI World");

        questionLabel = new Label(riddles[currentRiddleIndex][0]);
        answerField = new TextField(20);
        submitButton = new Button("Submit");
        resultLabel = new Label("Answer the riddle above.");

        add(questionLabel);
        add(answerField);
        add(submitButton);
        add(resultLabel);

        submitButton.addActionListener(this);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        String userAnswer = answerField.getText().trim().toLowerCase();
        if (userAnswer.equals(riddles[currentRiddleIndex][1])) {
            resultLabel.setText("Correct! Well done.");
            currentRiddleIndex++;
        } else {
            resultLabel.setText("Incorrect. Try again!");
        }

        if (currentRiddleIndex < riddles.length) {
            questionLabel.setText(riddles[currentRiddleIndex][0]);
            answerField.setText("");
        } else {
            questionLabel.setText("Congratulations! You solved all riddles.");
            answerField.setVisible(false);
            submitButton.setVisible(false);
        }
    }

    public static void main(String[] args) {
        AIRiddleGame game = new AIRiddleGame();
        game.setVisible(true);
    }
} 
