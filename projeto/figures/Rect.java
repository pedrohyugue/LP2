package figures;

import java.awt.*;

public class Rect extends Figure {

    public Rect (int x, int y, int w, int h, int r, int g, int b, int cr, int cg, int cb){
        super(x,y,w,h,r,g,b);
        this.cr = cr;
        this.cg = cg;
        this.cb = cb;
    }
    public void print () {
        System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }
    public void paint (Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(new Color(this.r,this.g,this.b));
        g2d.fillRect(this.x, this.y, this.w, this.h);
        g2d.setColor(new Color(this.cr,this.cg,this.cb));
        g2d.drawRect(this.x, this.y, this.w, this.h);

    }
}