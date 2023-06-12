package FindTheWord;
import javax.swing.*; 
import java.awt.*; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 

public class JuegoFindTheWord extends JFrame implements ActionListener { 

    private String[] palabrasEspanol = {"Raton", "Teclado", "Pantalla", "Audifonos", " Microfono"}; 
    private String[] palabrasIngles = {"Mouse", "Keyboard", "Screen", "earphones", "Microphone"}; 
    private JButton[] botonesEspanol; 
    private JButton[] botonesIngles; 
    
    public JuegoFindTheWord() { 
        
        super("Juego de Coincidencia de Palabras"); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        JPanel panel = new JPanel(new GridLayout(5, 3, 10, 10)); 
        botonesEspanol = new JButton[5]; 
        botonesIngles = new JButton[5]; 
        
        for (int i = 0; i < 5; i++) { 
            botonesEspanol[i] = new JButton(palabrasEspanol[i]); 
            botonesIngles[i] = new JButton(palabrasIngles[i]);
            
            botonesEspanol[i].addActionListener(this); 
            botonesIngles[i].addActionListener(this); 
            
            panel.add(botonesEspanol[i]); 
            panel.add(botonesIngles[i]); 
            panel.add(new JLabel(" ")); 
        } 
        
        add(panel, BorderLayout.CENTER); 
        pack(); 
        setLocationRelativeTo(null); 
        setVisible(true); 
    } 
    @Override 

    public void actionPerformed(ActionEvent e) { 
        
        JButton botonPresionado = (JButton) e.getSource(); 
        // Buscar el índice del botón presionado en los arreglos de botones 
        int indice = -1; 
        
        for (int i = 0; i < 5; i++) { 
            if (botonesEspanol[i] == botonPresionado) { 
                indice = i; 
                break; 
            } else if (botonesIngles[i] == botonPresionado) { 
                indice = i; 
                break; 
            } 
        } 
        if (indice != -1) { 
            // Verificar si el botón presionado pertenece a la columna de palabras en español o en inglés 
            if (botonPresionado == botonesEspanol[indice]) { 
                JOptionPane.showMessageDialog(this, "Palabra incorrecta. Intenta de nuevo."); 
            } else { 
                JOptionPane.showMessageDialog(this, "Palabra correcta. ¡Ganaste!"); 
                
                // Deshabilitar los botones correspondientes 
                botonesEspanol[indice].setEnabled(false); 
                botonesIngles[indice].setEnabled(false); 
            } 
        } 
    } 
    public static void main(String[] args) { 

        SwingUtilities.invokeLater(() -> new JuegoFindTheWord()); 
    } 
} 
