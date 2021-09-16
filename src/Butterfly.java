import java.awt.geom.*;
import java.util.Random;
import java.awt.*;
import javax.swing.*;

public class Butterfly {
    
    private Vector2 position = new Vector2(100,100);
    private Vector2 velocity = new Vector2(0,0);
    private Vector2 acceleration = new Vector2(0.001, 0.001);

    private Random r = new Random();
    private double velScale = 2.5;
    private double wander = 2;
    private int size = 30;

    Image img = new ImageIcon(Butterfly.class.getResource("scaled.png")).getImage().getScaledInstance(size, size, Image.SCALE_FAST);
    public AffineTransform myTransform = new AffineTransform();

    public void update() {
        acceleration.set(MouseInfo.getPointerInfo().getLocation().getX() - img.getWidth(null)/2 - position.getX(), (MouseInfo.getPointerInfo().getLocation().getY() - img.getHeight(null)/2 - position.getY()));
        acceleration.normalize();
        acceleration.set(acceleration.getX() + (r.nextDouble() - 0.5)*wander, acceleration.getY() + (r.nextDouble() - 0.5)*wander);
        acceleration.normalize();

        velocity.add(acceleration);
        velocity.normalize(velScale);

        position.add(velocity);
        
        myTransform.setToIdentity();
        myTransform.translate(position.getX()-(img.getWidth(null)/2), position.getY()-(img.getHeight(null)/2));
        myTransform.rotate(Math.atan2(velocity.getY(), velocity.getX()) + Math.PI/2, img.getWidth(null)/2, img.getHeight(null)/2);
    }

    public void redraw(Graphics2D g2d) {
        g2d.drawImage(img, myTransform, null);
        //Ellipse2D.Double e1 = new Ellipse2D.Double(position.getX(),position.getY(),10,10);
        //g2d.setColor(Color.ORANGE);
        //g2d.fill(e1);
    }

    public void checkbounds(int sizeX, int sizeY) {

        if (this.position.getX() >= sizeX - 10 || this.position.getX() <= 0) {
            this.velocity.multX(-1);
            this.acceleration.multX(-1);
        }
        if (this.position.getY() >= sizeY - 10 || this.position.getY() <= 0) {
            this.velocity.multY(-1);
            this.acceleration.multY(-1);
        }
    }

    public void refresh(Graphics2D g2d, int x, int y) {
        update();
        checkbounds(x, y);
        redraw(g2d);
    }
}
