import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.*;

/**
 * This class is the main class of the application.
 * It is used to start the application.
 */
public class App {
   private static final char[] letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
   private static char letter = letters[(int) (Math.random() * letters.length)];
   private static int score = 0;

   /* These are the components of the application */
   private static GameWindow gameWindow;
   private static Title title = new Title("SignUs!");
   private static LetterToGuess letterToGuess = new LetterToGuess(letter);
   private static ScoreLabel scoreLabel = new ScoreLabel(score);

   /* This array contains all the possible answers */
   private static CardOptions[] allPossibleAnswers = {
      new CardOptions("images/a.jpeg", 'A'),
      new CardOptions("images/b.jpeg", 'B'),
      new CardOptions("images/c.jpeg", 'C'),
      new CardOptions("images/d.jpeg", 'D'),
      new CardOptions("images/e.jpeg", 'E'),
      new CardOptions("images/f.jpeg", 'F'),
      new CardOptions("images/g.jpeg", 'G'),
      new CardOptions("images/h.jpeg", 'H'),
      new CardOptions("images/i.jpeg", 'I'),
      new CardOptions("images/j.jpeg", 'J'),
      new CardOptions("images/k.jpeg", 'K'),
      new CardOptions("images/l.jpeg", 'L'),
      new CardOptions("images/m.jpeg", 'M'),
      new CardOptions("images/n.jpeg", 'N'),
      new CardOptions("images/o.jpeg", 'O'),
      new CardOptions("images/p.jpeg", 'P'),
      new CardOptions("images/q.jpeg", 'Q'),
      new CardOptions("images/r.jpeg", 'R'),
      new CardOptions("images/s.jpeg", 'S'),
      new CardOptions("images/t.jpeg", 'T'),
      new CardOptions("images/u.jpeg", 'U'),
      new CardOptions("images/v.jpeg", 'V'),
      new CardOptions("images/w.jpeg", 'W'),
      new CardOptions("images/x.jpeg", 'X'),
      new CardOptions("images/y.jpeg", 'Y'),
      new CardOptions("images/z.jpeg", 'Z'),
   };

   /* These are the buttons that display the images */
   private static ImageButton button1 = new ImageButton(allPossibleAnswers[0].imagePath, allPossibleAnswers[0].letter,
         0);
   private static ImageButton button2 = new ImageButton(allPossibleAnswers[1].imagePath, allPossibleAnswers[1].letter,
         1);
   private static ImageButton button3 = new ImageButton(allPossibleAnswers[2].imagePath, allPossibleAnswers[2].letter,
         2);
   private static ImageButton button4 = new ImageButton(allPossibleAnswers[3].imagePath, allPossibleAnswers[3].letter,
         3);

   /**
    * This is the main method of the application.
    * It is used to start the application.
   */
   public static void main(String[] args) throws Exception {
      SwingUtilities.invokeLater(() -> createAndShowGUI());
   }

   public static void createAndShowGUI() {
      gameWindow = new GameWindow();
      gameWindow.setVisible(true); // show the window

      /* Add the components to the window */
      CountDown countdownLabel = new CountDown(30);
      gameWindow.add(countdownLabel, countdownLabel.constraints);

      /* Create a timer that counts down from 30 seconds */
      Timer timer = new Timer(1000, new ActionListener() {
         int remainingTime = 30;

         /* This method is called every second */
         @Override
         public void actionPerformed(ActionEvent e) {
            remainingTime--;
            if (remainingTime >= 0) {
               countdownLabel.setSecondsLeft(remainingTime);
            } else {
               ((Timer) e.getSource()).stop();
               JOptionPane.showMessageDialog(gameWindow, "Time's up! Final score: " + score);
               System.exit(0);
            }
         }
      });

      gameWindow.add(letterToGuess, letterToGuess.constraints);

      gameWindow.add(title, title.getConstraints());

      gameWindow.add(scoreLabel, scoreLabel.constraints);

      gameWindow.add(button1, button1.getConstraints());
      gameWindow.add(button2, button2.getConstraints());
      gameWindow.add(button3, button3.getConstraints());
      gameWindow.add(button4, button4.getConstraints());

      /* Add action listeners to the buttons */
      button1.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            if (button1.letter == letter) {
               score++;
               updateScore();
            } else {
               button1.showIncorrect();
            }
         }
      });
      button2.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            if (button2.letter == letter) {
               score++;
               updateScore();
            } else {
               button2.showIncorrect();
            }
         }
      });
      button3.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            if (button3.letter == letter) {
               score++;
               updateScore();
            } else {
               button3.showIncorrect();
            }
         }
      });
      button4.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            if (button4.letter == letter) {
               score++;
               updateScore();
            } else {
               button4.showIncorrect();
            }
         }
      });

      timer.start();
      startNewRound();
   }

   public static void startNewRound() {
      /* Generate a random letter */
      letter = generateRandomLetter();
      letterToGuess.setText(Character.toString(letter));

      /* Generate a random set of answers */
      CardOptions[] randomCardOptions = generateRandomSetOfCardOptions(letter);
      updateAnswers(randomCardOptions); // Update the answers
   }

   public static void updateScore() {
      scoreLabel.setText("Score:" + Integer.toString(score));
      startNewRound();
   }

   public static void updateAnswers(CardOptions[] randomCardOptions) {

      button1.update(randomCardOptions[0].imagePath, randomCardOptions[0].letter, 0);

      button2.update(randomCardOptions[1].imagePath, randomCardOptions[1].letter, 1);

      button3.update(randomCardOptions[2].imagePath, randomCardOptions[2].letter, 2);

      button4.update(randomCardOptions[3].imagePath, randomCardOptions[3].letter, 3);

      gameWindow.revalidate();
   }

   public static char generateRandomLetter() {
      letter = letters[(int) (Math.random() * letters.length)];
      return letter;
   }

   public static int getIndexOfCorrectAnswer(char letter) {
      int index = 0;
      for (int i = 0; i < allPossibleAnswers.length; i++) {
         if (allPossibleAnswers[i].letter == letter) {
            index = i;
         }
      }
      return index;
   }

   public static int[] generateRandomIndexes(int respectedIndex) {

      int[] randomIndexes = new int[4];

      while (true) {

         boolean containsRepeated = false;

         randomIndexes[0] = respectedIndex;
         randomIndexes[1] = (int) (Math.random() * allPossibleAnswers.length);
         randomIndexes[2] = (int) (Math.random() * allPossibleAnswers.length);
         randomIndexes[3] = (int) (Math.random() * allPossibleAnswers.length);

         for (int i = 0; i < randomIndexes.length; i++) {
            for (int j = 0; j < randomIndexes.length; j++) {
               if (randomIndexes[i] == randomIndexes[j] && i != j) {
                  containsRepeated = true;
               }
            }
         }

         if (!containsRepeated) {
            break;
         }
      }

      return randomIndexes;

   }

   public static CardOptions[] generateRandomSetOfCardOptions(char rightAnswer) {
      CardOptions[] randomCardOptions = new CardOptions[4];
      int indexOfCorrectAnswerChar = getIndexOfCorrectAnswer(rightAnswer);

      int[] randomIndexes = generateRandomIndexes(indexOfCorrectAnswerChar);

      // randomize the order of the randomIndexes

      for (int i = 0; i < randomIndexes.length; i++) {
         int randomIndex = (int) (Math.random() * randomIndexes.length);
         int temp = randomIndexes[i];
         randomIndexes[i] = randomIndexes[randomIndex];
         randomIndexes[randomIndex] = temp;
      }

      System.out.println("randomIndexes: " + Arrays.toString(randomIndexes));

      randomCardOptions[0] = allPossibleAnswers[randomIndexes[0]];
      randomCardOptions[1] = allPossibleAnswers[randomIndexes[1]];
      randomCardOptions[2] = allPossibleAnswers[randomIndexes[2]];
      randomCardOptions[3] = allPossibleAnswers[randomIndexes[3]];

      return randomCardOptions;
   }

}
