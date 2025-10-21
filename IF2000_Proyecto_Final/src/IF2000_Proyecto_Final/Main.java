
package IF2000_Proyecto_Final;

import Interface.Interface;

/**
 *
 * @author mayco
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // Maycol
  

        javax.swing.SwingUtilities.invokeLater(() -> {
            new Interface().setVisible(true);
        });
    }
}