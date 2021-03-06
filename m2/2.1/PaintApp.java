import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

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

class PaintApp {
    public static void main(String[] args){
        PaintFrame frame = new PaintFrame();
        frame.setVisible(true);
    }
}
class PaintFrame extends JFrame{
	Rect r1, r2, r3;
    PaintFrame() {
        this.addWindowListener(
        	new WindowAdapter() {
            public void windowClosing (WindowEvent e){
                System.exit(0);
            	}
        	}
        );
        this.setTitle("Painting Figures");
		this.setSize(350,350);
        this.r1 = new Rect(50, 90, 100, 30, 101, 98, 0, 226, 69, 0);
		this.r2 = new Rect(100, 120, 100, 30, 226, 69, 0, 25, 69, 37); 
		this.r3 = new Rect(125, 150, 60, 30, 249, 69, 37, 249, 69, 229);
    }

    public void paint(Graphics g){
        super.paint(g);
        r1.paint(g);
        r2.paint(g);
        r3.paint(g);
        
    }
}
