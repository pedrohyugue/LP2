package figures;

import java.awt.*;

public class Line extends Figure {

    public Line (int x, int y, int w, int h, int r, int g, int b){
        super(x,y,w,h,r,g,b);
        
    }
    public void print () {
        System.out.format("Linha de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }
    public boolean isLine(){
        return true;
    }

    public boolean clicked (int x, int y){
        return ((x >= this.x && this.w >= x && y >= this.y && this.h >= y) 
            || (x <= this.x && this.w <= x && y >= this.y && this.h >= y) ||
                (x >= this.x && this.w >= x && y <= this.y && this.h <= y) ||
                (x <= this.x && this.w <= x && y <= this.y && this.h <= y));
    }
    public void drag (int dx, int dy) {
        this.x += dx;
        this.y += dy;
        this.w += dx;
        this.h += dy;
    }
    public void paint (Graphics g, boolean focused){
        Graphics2D g2d = (Graphics2D) g;
        if (focused) {
            g2d.setPaint(Color.RED);
            g2d.drawLine(this.x-2,this.y-2, this.w+4,this.h+4);
        }
        g2d.setColor(new Color(this.r,this.g,this.b));
	    g2d.drawLine(this.x, this.y, this.w, this.h);
	
    }
}