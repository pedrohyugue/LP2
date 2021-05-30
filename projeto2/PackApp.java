import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.io.*;
import figures.*;


class PackApp {
    public static void main (String[] args) {
        PackFrame frame = new PackFrame();
        frame.setVisible(true);
    }
}

class PackFrame extends JFrame {
    private ArrayList<Figure> figs = new ArrayList<Figure>();
    private ArrayList<Button> buts = new ArrayList<Button>();
    private Random rand = new Random();    
    private Figure focus = null;
    private Figure ult_focus = null;
    private Button focus_but = null;
    private ImageIcon img = new ImageIcon(getClass().getResource("1.png"));
    private Image image = img.getImage();
    private int s = 0;
    private Point pontoant;

    PackFrame () {
        try {
            FileInputStream f = new FileInputStream("proj.bin");
            ObjectInputStream o = new ObjectInputStream(f);
            this.figs = (ArrayList<Figure>) o.readObject();
            o.close();
        } catch (Exception x) {
            System.out.println("ERRO!");
        }

        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                   try {
                        FileOutputStream f = new FileOutputStream("proj.bin");
                        ObjectOutputStream o = new ObjectOutputStream(f);
                        o.writeObject(figs);
                        o.flush();
                        o.close();
                    } catch (Exception x) {
                    }
                    System.exit(0);
                }
            }
        );
        this.setTitle("Java Packages");
        this.setSize(350, 350);

        this.setFocusTraversalKeysEnabled(false);

        buts.add(new Button(1, new Rect(300,80,5,30,0,0,0,0,0,0)));
        buts.add(new Button(2, new Ellipse(5,20,5,5,0,0,0,0,0,0)));
        buts.add(new Button(3, new Arc(5,5,5,30,150,180,0,0,0,0,0,0)));
        buts.add(new Button(4, new Line(30, 190, 50, 210,0,0,0)));
        buts.add(new Button(5, new Arc(0,0,0,0,0,0,0,0,0,0,0,0)));

        this.addMouseListener (
            new MouseAdapter(){
	            public void mousePressed (MouseEvent evt){
                    if ((focus_but != null) &&
                        ((56<evt.getX() || evt.getX()<24) || (218<evt.getY() || evt.getY()<62))
                        ){
                    	
                         if (focus_but.idx == 1){
                            figs.add(new Rect(evt.getX()-15,evt.getY()-15,30,30,0,0,0,0,0,0));
                        } else if (focus_but.idx == 2){
                            figs.add(new Ellipse(evt.getX()-15,evt.getY()-15,30,30,0,0,0,0,0,0));
                        } else if (focus_but.idx == 3){
                            figs.add(new Arc(evt.getX()-15,evt.getY()-15,30,30,150,180,0,0,0,0,0,0));
                        } else if (focus_but.idx == 4){
                            figs.add(new Line(evt.getX(),evt.getY(),rand.nextInt(300),rand.nextInt(300),0,0,0));
                        }
                    }
                    focus = null;
                    focus_but = null;

	                for (Figure fig: figs) {
	                    if (fig.clicked(evt.getX(), evt.getY())){
	                        focus	=	fig;
	                	}
            		}

                    for (Button but: buts){
                        if (but.clicked(evt.getX(), evt.getY())){
                            focus_but = but;

                            if (focus_but.idx == 5 && ult_focus != null){
                                figs.remove(ult_focus);
                            }
                            focus = null;
                            ult_focus = null;
                        }
                    }
                    ult_focus = focus;
                        
                    
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
                        focus.drag(px, py);

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
                        figs.remove(focus);
                        focus = null;
                    }
                    else if ((evt.getKeyChar()=='+')&& (focus != null)){
                        focus.w = focus.w+10;
                        focus.h = focus.h+10;
                        
                    }
                    else if ((evt.getKeyChar()=='-')&& (focus != null)){
                        if((focus.w !=0)||(focus.h != 0)){
                            focus.w = focus.w-10;
                            focus.h = focus.h-10;
                        }
                    }
                    else if ((evt.getKeyChar()=='z')&& (focus != null)){
                        focus.r = rand.nextInt(255);
                        focus.g = rand.nextInt(255);
                        focus.b = rand.nextInt(255);
                    }
                    else if ((evt.getKeyChar()=='c')&& (focus != null)){
                        focus.cr = rand.nextInt(255);
                        focus.cg = rand.nextInt(255);
                        focus.cb = rand.nextInt(255);
                    }
                    else if ((evt.getKeyCode() == java.awt.event.KeyEvent.VK_UP) && (focus != null)) {

                        if (focus.isLine()){
                            focus.y -= 10;
                            focus.h -= 10;
                        } else {focus.y -= 10;}
                        
                    } 
                    else if  ((evt.getKeyCode() == java.awt.event.KeyEvent.VK_DOWN) && (focus != null)) {

                        if (focus.isLine()){
                            focus.y += 10;
                            focus.h += 10;
                        } else {focus.y += 10;}

                    } 
                    else if  ((evt.getKeyCode() == java.awt.event.KeyEvent.VK_LEFT) && (focus != null)) {

                        if (focus.isLine()){
                            focus.x -= 10;
                            focus.w -= 10;
                        } else {focus.x -= 10;}

                    } 
                    else if  ((evt.getKeyCode() == java.awt.event.KeyEvent.VK_RIGHT) && (focus != null)) {

                        if (focus.isLine()){
                            focus.x += 10;
                            focus.w += 10;
                        } else {focus.x += 10;}
                    }



                    else if( evt.getKeyChar() == java.awt.event.KeyEvent.VK_TAB) {
                        int tamanho = figs.size();
                        focus = figs.get(s);
                        s++;
                        if (s >= tamanho){ 
                            s = 0;
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
            fig.paint(g, false);
        }
        if (focus != null) focus.paint(g, true);
        for (Button but: this.buts) {
             but.paint(g, but == focus_but);
        }
        g.drawImage(image, 25,225, null);

    }
}