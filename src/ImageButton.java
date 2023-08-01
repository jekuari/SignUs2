import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ImageButton extends JButton {

   public char letter;
   private GridBagConstraints constraints;

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

   public void update(String imagePath, char letter, int position) {

      // remove border from button

      setBorder(null);

      int desiredWidth = 100;
      int desiredHeight = 100;

      GridBagConstraints constraints = new GridBagConstraints();
      constraints.fill = GridBagConstraints.BOTH;
      constraints.insets = new Insets(10, 10, 10, 10);

      constraints.gridx = position;
      constraints.gridy = 4;
      constraints.gridwidth = 1;
      constraints.gridheight = 1;

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

   public GridBagConstraints getConstraints() {
      return constraints;
   }

   // method that adds a red border to the button when an incorrect letter is clicked

   public void showIncorrect() {
      setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0), 3));
   }
}