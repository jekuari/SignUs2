import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.*;

/**
 * This class is a JLabel that displays the time left in the game.
 * It is used to display the time left in the game.
 */
public class CountDown extends JLabel {
  private int secondsLeft;
  public GridBagConstraints constraints;

  /**
   * Constructor
   * Parameters:
   * * initialSeconds - The number of seconds to start the countdown at
   */
  public CountDown(int initialSeconds) {
    this.secondsLeft = initialSeconds;
    updateLabelText();
    setFont(getFont().deriveFont(24.0f));
    this.constraints = new GridBagConstraints();
    this.constraints.fill = GridBagConstraints.BOTH;
    this.constraints.insets = new Insets(10, 10, 10, 10);
    this.constraints.gridx = 0;
    this.constraints.gridy = 1;
    this.constraints.gridwidth = 4;
    this.constraints.gridheight = 1;

    setHorizontalAlignment(JLabel.CENTER);
  }

  public void setSecondsLeft(int secondsLeft) {
    this.secondsLeft = secondsLeft;
    updateLabelText();
  }

  private void updateLabelText() {
    setText("Time left: " + secondsToString(secondsLeft));
  }

  private String secondsToString(int seconds) {
    int minutes = seconds / 60;
    int remainingSeconds = seconds % 60;
    return String.format("%02d:%02d", minutes, remainingSeconds);
  }
}
