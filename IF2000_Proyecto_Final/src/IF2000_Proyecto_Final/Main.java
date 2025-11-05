
package IF2000_Proyecto_Final;
import javax.swing.JFrame;
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
 
         // Crear la ventana principal
        JFrame frame = new JFrame("Sistema de Reservas de Vuelos");
        
        // Configurar la interfaz
        Interface interfacePanel = new Interface();
        
        // Configurar el JFrame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(interfacePanel);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null); // Centrar en la pantalla
        frame.setVisible(true);
        }
    }