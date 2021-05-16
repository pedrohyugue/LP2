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
    public void paint (Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(new Color(this.r,this.g,this.b));
	    g2d.drawLine(this.x, this.y, this.w, this.h);
	

    }
}