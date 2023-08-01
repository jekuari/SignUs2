import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.Timer;

public class GameWindow extends JFrame {

   public Timer localTimer;
   public int timeLeft = 15;

   public GameWindow() {

      super("SignUs!");
      setLayout(new GridBagLayout());
      GridBagConstraints constraints = new GridBagConstraints();
      constraints.fill = GridBagConstraints.BOTH;
      constraints.insets = new Insets(10, 10, 10, 10);
      this.setSize(640, 480);
      this.setVisible(true);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setLocationRelativeTo(null);
   }
}