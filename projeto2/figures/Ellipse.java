package figures;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;

public class Ellipse extends Figure {

    public Ellipse (int x, int y, int w, int h, int r, int g, int b, int cr, int cg, int cb) {
        super(x,y,w,h,r,g,b);
        this.cr = cr;
        this.cg = cg;
        this.cb = cb;
    }

    public void print () {
        System.out.format("Elipse de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }
    public boolean isLine(){
        return false;
    }

    public void paint (Graphics g, boolean focused) {
        Graphics2D g2d = (Graphics2D) g;
        if (focused) {
            g2d.setPaint(Color.RED);
            g2d.drawOval(this.x-2,this.y-2, this.w+4,this.h+4);
        }
        g2d.setColor(new Color(this.r,this.g,this.b));
        g2d.fillOval(this.x, this.y, this.w, this.h);
        g2d.setColor(new Color(this.cr,this.cg,this.cb));
        g2d.drawOval(this.x,this.y, this.w,this.h);
    }
}