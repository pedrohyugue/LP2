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
    Figure focus = null;
    Point pontoant;

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

        this.addMouseListener (
            new MouseAdapter(){
	            public void mousePressed (MouseEvent evt){
	                for (Figure fig: figs) {
	                    int x4 = fig.x + fig.w;
	                    int y4 = fig.y + fig.h;
	                    if ( (fig.x<=evt.getX()) && (x4>= evt.getX()) && (fig.y<=evt.getY()) && (y4>= evt.getY())){
	                        focus	=	fig;
	                     
	                	}
            		}
		            pontoant = evt.getPoint();
		            repaint();
        		}
        	}
        );


        this.addMouseMotionListener(

            new MouseMotionAdapter() {

	            public void mouseDragged (MouseEvent evt) {
	                if (focus != null) {

	                    Point pontoat = evt.getPoint();
	                    int px = (int)(pontoat.getX() - pontoant.getX());
	                    int py = (int)(pontoat.getY() - pontoant.getY());
	                    focus.x = (int)((focus.x) + (px));
	                    focus.y = (int)((focus.y) + (py));

	                    pontoant = pontoat;
	                    repaint();
	                }
	            }
        	}
  		);

        this.addKeyListener(
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
                    }
                    else if(evt.getKeyChar()=='l'){
                        int x5 = rand.nextInt(350);
                        int y5 = rand.nextInt(350);
                        int w5 = rand.nextInt(50);
                        int h5 = rand.nextInt(50);
                        int r5 = rand.nextInt(255);
                        int g5 = rand.nextInt(255);
                        int b5 = rand.nextInt(255);
                        figs.add(new Line(x5,y5,w5,h5,r5,g5,b5));
                    }
                    else if (((evt.getKeyCode() == java.awt.event.KeyEvent.VK_DELETE))){
                        for (int i = 0; i< figs.size();i++){
                            if (figs.get(i) == focus){
                                figs.remove(figs.get(i));
                                focus=null;
                            }
                        }
                    }
                    else if ((evt.getKeyChar()=='+')&& (focus != null)){
                        focus.w = focus.w+100;
                        focus.h = focus.h+100;
                    }
                    else if ((evt.getKeyChar()=='-')&& (focus != null)){
                        if((focus.w !=0)||(focus.h != 0)){
                            focus.w = focus.w-100;
                            focus.h = focus.h-100;
                        }
                    }
                    else if ((evt.getKeyChar()=='z')&& (focus != null)){
                        if(focus.r<=254){
                            focus.r = focus.r+2; 
                        }
                        if(focus.g<=254){
                            focus.g = focus.g+1;
                        }
                        if(focus.b<=254){
                            focus.b = focus.b+1;
                        }
                    }
                    else if ((evt.getKeyChar()=='c')&& (focus != null)){
                        if(focus.cr<=254){
                            focus.cr = focus.cr+2;
                        }
                        if(focus.cg<=254){
                            focus.cg = focus.cg+1;
                        }
                        if(focus.cb<=254){
                            focus.cb = focus.cb+1;
                        }
                    }
                    else if ((evt.getKeyChar()=='x')&& (focus != null)){
                        if(focus.r>=1){
                            focus.r = focus.r-2; 
                        }
                        if(focus.g>=1){
                            focus.g = focus.g-1;
                        }
                        if(focus.b>=1){
                            focus.b = focus.b-1;
                        }
                    }
                    else if ((evt.getKeyChar()=='v')&& (focus != null)){
                        if(focus.cr>=1){
                            focus.cr = focus.cr-2;
                        }
                        if(focus.cg>=1){
                            focus.cg = focus.cg-1;
                        }
                        if(focus.cb>=1){
                            focus.cb = focus.cb-1;
                        }
                    }
                    repaint();  // outer.repaint()
                }
            }
        );
    }
    public void paint (Graphics g) {
        super.paint(g);

        for (Figure fig: this.figs) {
            fig.paint(g);
        }
        if (focus != null){
            focus.paint(g);
            g.setColor(Color.red);
            g.drawRect(focus.x, focus.y, focus.w, focus.h);
        }
    }
}