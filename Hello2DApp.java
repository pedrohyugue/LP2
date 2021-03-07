import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.*;

public class Hello2DApp {
    public static void main (String[] args) {
        Hello2DFrame frame = new Hello2DFrame();
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.lightGray);

    }
}

class Hello2DFrame extends JFrame {
    public Hello2DFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }

        );

        this.setTitle("Java2D - Hello World!");
        this.setSize(350, 350);
    }

    public void paint (Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
     
        g2d.setPaint(Color.black);
      
        g2d.draw(new RoundRectangle2D.Double(80, 100,
                                   100,
                                   200,
                                   10, 10));

        CubicCurve2D c = new CubicCurve2D.Double();
		c.setCurve(40, 50, 20,
           30, 20, 30, 80, 100);
		g2d.draw(c);
		c.setCurve(50, 40, 20,
           20, 30, 30, 100, 80);

		g2d.setPaint(Color.blue);
		g2d.draw(c);

		g2d.setPaint(Color.green);
        int w = getWidth();
        int h = getHeight();
        g2d.drawLine(0,0, w,h);
        g2d.drawLine(0,h, w,0);
    }
}