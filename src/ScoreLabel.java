import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JLabel;

/* This class is in charge of displaying the score for the user
constrains set the label to show at the bottom of the canvas*/
public class ScoreLabel extends JLabel {
  private int score;

  public GridBagConstraints constraints;

  public ScoreLabel(int score) {
    super("Your score is: " + Integer.toString(score));
    setFont(getFont().deriveFont(18.0f));

    this.score = score;

    this.constraints = new GridBagConstraints();
    this.constraints.fill = GridBagConstraints.BOTH;
    this.constraints.insets = new Insets(10, 10, 10, 10);
    this.constraints.gridx = 0;
    this.constraints.gridy = 5;
    this.constraints.gridwidth = 4;
    this.constraints.gridheight = 1;

    setHorizontalAlignment(JLabel.CENTER);
  }

  public void setScore(int score) {
    this.score = score;
    updateLabelText();
  }

  private void updateLabelText() {
    setText("Score: " + Integer.toString(score));
  }
}
