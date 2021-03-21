import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import figures.*;

class PackApp {
    public static void main (String[] args) {
        PackFrame frame = new PackFrame();
        frame.setVisible(true);
    }
}

class PackFrame extends JFrame {
    Rect r1;
    Ellipse e1;
	Arc a1;

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
        this.r1 = new Rect(88,50, 150,100, 40, 69, 229, 17, 69, 118);
        this.e1 = new Ellipse(30, 180, 20, 30, 80, 69, 170,17, 69, 118);
		this.a1 = new Arc(200, 100, 80, 150, 180, 100, 50, 150, 229, 17, 69, 118);
    }

    public void paint (Graphics g) {
        super.paint(g);
        this.r1.paint(g);
        this.e1.paint(g);
		this.a1.paint(g);
    }
}