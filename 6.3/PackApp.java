import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;
import figures.*;

class PackApp {
    public static void main (String[] args) {
        PackFrame frame = new PackFrame();
        frame.setVisible(true);
    }
}

class PackFrame extends JFrame {
    ArrayList<Figure> figs = new ArrayList<Figure>();
    Random rand = new Random();    

    PackFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Java Packages");
        this.setSize(350, 350);
        this.addKeyListener (
            new KeyAdapter() {
                public void keyPressed (KeyEvent evt) {
                    if (evt.getKeyChar() == 'r') {
                        int x1 = rand.nextInt(350);
                        int y1 = rand.nextInt(350);
                        int w1 = rand.nextInt(50);
                        int h1 = rand.nextInt(50);
                        int r1 = rand.nextInt(255);
                        int g1 = rand.nextInt(255);
                        int b1 = rand.nextInt(255);
                        int cr1 = rand.nextInt(255);
                        int cg1 = rand.nextInt(255);
                        int cb1 = rand.nextInt(255);
                        figs.add(new Rect(x1,y1,w1,h1,r1,g1,b1,cr1,cg1,cb1));
                        repaint();  // outer.repaint()
                    }
                    else if (evt.getKeyChar() == 'e') {
                        int x2 = rand.nextInt(350);
                        int y2 = rand.nextInt(350);
                        int w2 = rand.nextInt(50);
                        int h2 = rand.nextInt(50);
                        int r2 = rand.nextInt(255);
                        int g2= rand.nextInt(255);
                        int b2 = rand.nextInt(255);
                        int cr2 = rand.nextInt(255);
                        int cg2 = rand.nextInt(255);
                        int cb2 = rand.nextInt(255);
                        figs.add(new Ellipse(x2,y2,w2,h2,r2,g2,b2,cr2,cg2,cb2));
                        repaint();  // outer.repaint()
                    }
                    else if (evt.getKeyChar() == 'a') {
                        int x3 = rand.nextInt(350);
                        int y3 = rand.nextInt(350);
                        int w3 = rand.nextInt(50);
                        int h3 = rand.nextInt(50);
                        int sAngle = rand.nextInt(360);
                        int aAngle = rand.nextInt(360);
                        int r3 = rand.nextInt(255);
                        int g3= rand.nextInt(255);
                        int b3 = rand.nextInt(255);
                        int cr3 = rand.nextInt(255);
                        int cg3 = rand.nextInt(255);
                        int cb3 = rand.nextInt(255);
                        figs.add(new Arc(x3,y3,w3,h3,sAngle,aAngle,r3,g3,b3,cr3,cg3,cb3));
                        repaint();  // outer.repaint()
                    }
                }
            }
        );
    }


    public void paint (Graphics g) {
        super.paint(g);

        for (Figure fig: this.figs) {
            fig.paint(g);
        }
    }
}