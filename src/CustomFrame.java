import javax.swing.*;
import java.awt.*;

public class CustomFrame extends JFrame {
    private int height = 640;
    private int width = 640;
    private String title = "Butterfly Room";
    private Color bgColor = Color.BLACK;

    DrawingCanvas canvas = new DrawingCanvas();

    CustomFrame(){
        this.setSize(width,height);
        this.setTitle(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(bgColor);
        //this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        System.out.println(this.getSize());
        this.add(canvas);
        this.setIconImage(new ImageIcon(Butterfly.class.getResource("scaled.png")).getImage());
        this.setVisible(true);
    }
}
