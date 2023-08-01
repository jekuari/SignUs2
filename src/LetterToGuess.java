import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JLabel;

public class LetterToGuess extends JLabel {
   private int secondsLeft;
   public GridBagConstraints constraints;
   private char letter;

   public LetterToGuess(char letter) {
      super(Character.toString(letter));
      setFont(getFont().deriveFont(48.0f));

      this.letter = letter;

      this.constraints = new GridBagConstraints();
      this.constraints.fill = GridBagConstraints.BOTH;
      this.constraints.insets = new Insets(10, 10, 10, 10);
      this.constraints.gridx = 0;
      this.constraints.gridy = 2;
      this.constraints.gridwidth = 4;
      this.constraints.gridheight = 1;

      setHorizontalAlignment(JLabel.CENTER);
   }
}
