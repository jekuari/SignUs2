import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * This class is a JButton that displays an image.
 * It is used to display an image.
 */
public class ImageButton extends JButton {
  public char letter;
  private GridBagConstraints constraints;

  /**
   * Constructor
   * Parameters:
   * * imagePath - The path to the image to display
   * * letter - The letter that the image represents
   * * position - The position of the image in the grid
   */
  public ImageButton(String imagePath, char letter, int position) {
    int desiredWidth = 100;
    int desiredHeight = 100;

    GridBagConstraints constraints = new GridBagConstraints();
    constraints.fill = GridBagConstraints.BOTH;
    constraints.insets = new Insets(10, 10, 10, 10);

    constraints.gridx = position;
    constraints.gridy = 4;
    constraints.gridwidth = 1;
    constraints.gridheight = 1;

    /* Resize the image to the desired size */
    ImageIcon imageIcon = new ImageIcon(imagePath);
    Image icon = imageIcon.getImage();
    Image resizedImage = icon.getScaledInstance(desiredWidth, desiredHeight, Image.SCALE_SMOOTH);
    imageIcon = new ImageIcon(resizedImage);
    setIcon(imageIcon);
    Dimension size = new Dimension(desiredWidth, desiredHeight);
    setPreferredSize(size);
    setMaximumSize(size);
    setToolTipText("Click me!");
    this.letter = letter;
    this.constraints = constraints;
  }

  /**
   * Update the image displayed by the button
   * Parameters:
   * * imagePath - The path to the image to display
   * * letter - The letter that the image represents
   * * position - The position of the image in the grid
   */
  public void update(String imagePath, char letter, int position) {
    setBorder(null); // remove border from button

    int desiredWidth = 100;
    int desiredHeight = 100;

    GridBagConstraints constraints = new GridBagConstraints();
    constraints.fill = GridBagConstraints.BOTH;
    constraints.insets = new Insets(10, 10, 10, 10);

    constraints.gridx = position;
    constraints.gridy = 4;
    constraints.gridwidth = 1;
    constraints.gridheight = 1;

    /* Resize the image to the desired size */
    ImageIcon imageIcon = new ImageIcon(imagePath);
    Image icon = imageIcon.getImage();
    Image resizedImage = icon.getScaledInstance(desiredWidth, desiredHeight, Image.SCALE_SMOOTH);
    imageIcon = new ImageIcon(resizedImage);
    setIcon(imageIcon);
    Dimension size = new Dimension(desiredWidth, desiredHeight);
    setPreferredSize(size);
    setMaximumSize(size);
    setToolTipText("Click me!");
    this.letter = letter;
    this.constraints = constraints;
  }

  public char getLetter() {
    return letter;
  }

  public void setLetter(char letter) {
    this.letter = letter;
  }

  /* Get properties of the button */
  public GridBagConstraints getConstraints() {
    return constraints;
  }

  /* Adds a red border to the button when an incorrect letter is clicked */
  public void showIncorrect() {
    setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0), 3));
  }
}