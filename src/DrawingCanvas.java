import javax.swing.*;
import java.awt.*;

public class DrawingCanvas extends JComponent{

    Butterfly[] arr = new Butterfly[10]; {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Butterfly();
        }
    }
    Image img = new ImageIcon(DrawingCanvas.class.getResource("scaled.png")).getImage();

    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        RenderingHints rh = new RenderingHints(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHints(rh);
        //g2d.drawImage(img, , 1, null);
        
        for (int i = 0; i < arr.length; i++) {
            arr[i].refresh(g2d, DrawingCanvas.super.getWidth(),DrawingCanvas.super.getHeight());
        }
    }
}
