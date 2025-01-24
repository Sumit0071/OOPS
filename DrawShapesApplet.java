import java.applet.Applet;
import java.awt.*;

@SuppressWarnings("removal")
public class DrawShapesApplet extends Applet {
    @Override
    public void paint(Graphics g) {
        // Draw a Circle
        g.setColor(Color.RED);
        g.drawOval(50, 50, 100, 100); // x, y, width, height

        // Draw an Ellipse
        g.setColor(Color.BLUE);
        g.drawOval(200, 50, 150, 100); // x, y, width, height

        // Draw a Square
        g.setColor(Color.GREEN);
        g.drawRect(400, 50, 100, 100); // x, y, width, height
    }
}
