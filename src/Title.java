import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JLabel;

public class Title extends JLabel {

   private GridBagConstraints constraints;

   public Title(String text) {
      super(text);
      setFont(getFont().deriveFont(64.0f));
      GridBagConstraints constraints = new GridBagConstraints();
      constraints.fill = GridBagConstraints.BOTH;
      constraints.insets = new Insets(10, 10, 10, 10);

      constraints.gridx = 0;
      constraints.gridy = 0;
      constraints.gridwidth = 4;
      constraints.gridheight = 1;
      
      setHorizontalAlignment(JLabel.CENTER);

      this.constraints = constraints;
   }

   public GridBagConstraints getConstraints() {
      return constraints;
   }
}
