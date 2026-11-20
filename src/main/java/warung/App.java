package warung;

import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import warung.util.Database;

public final class App {
    private App() {}
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                FlatLightLaf.setup();
                new Database().initialize();
                JFrame frame = new JFrame("Warung Tujuh Beradik");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(700, 450);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Database tidak dapat disiapkan: " + e.getMessage(), "Kesalahan", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}
