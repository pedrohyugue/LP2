import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;

class RectEllipseApp {
    public static void main (String[] args) {
        RectEllipseFrame frame = new RectEllipseFrame();
        frame.setVisible(true);
    }
}

class RectEllipseFrame extends JFrame {
    Ellipse e1, e2, e3;
    RectEllipseFrame() {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Ellipse");
        this.setSize(350, 350);

        this.e1 = new Ellipse(30, 180, 20, 30, 17, 69, 229,17, 69, 118);
        this.e2 = new Ellipse(90, 110, 60, 30, 250, 69, 118, 250, 244, 118);
        this.e3 = new Ellipse(60, 130, 80, 30, 80, 21, 118, 237, 129, 15);
    }

    public void paint (Graphics g) {
        super.paint(g);
        this.e1.paint(g);
        this.e2.paint(g);
        this.e3.paint(g);
    }
}

class Rect{
    int x,y;
    int w,h;
    int r,g,b;
    int cr,cg,cb;
    Rect (int x, int y, int w, int h, int r, int g, int b, int cr, int cg, int cb){
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.r = r;
        this.g = g;
        this.b = b;
        this.cr = cr;
        this.cg = cg;
        this.cb = cb;

    }
    void print () {
        System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }
    void paint (Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(new Color(this.r,this.g,this.b));
        g2d.fillRect(this.x, this.y, this.w, this.h);
        g2d.setColor(new Color(this.cr,this.cg,this.cb));
        g2d.drawRect(this.x, this.y, this.w, this.h);

    }
}

class Ellipse {
    int x, y;
    int w, h;
    int r,g,b;
    int cr,cg,cb;

    Ellipse (int x, int y, int w, int h, int r, int g, int b, int cr, int cg, int cb) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.r = r;
        this.g = g;
        this.b = b;
        this.cr = cr;
        this.cg = cg;
        this.cb = cb;
    }

    void print () {
        System.out.format("Elipse de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

    void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(new Color(this.r,this.g,this.b));
        g2d.fillOval(this.x, this.y, this.w, this.h);
        g2d.setColor(new Color(this.cr,this.cg,this.cb));
        g2d.drawOval(this.x,this.y, this.w,this.h);
    }
}