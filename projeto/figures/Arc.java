package figures;

import java.awt.*;

public class Arc extends Figure {
	int sAngle, aAngle;

	public Arc (int x, int y, int w, int h, int sAngle, int aAngle, int r, int g, int b, int cr, int cg, int cb) {
        super(x,y,w,h,r,g,b);
		
		this.sAngle = sAngle;
		this.aAngle= aAngle;
        this.cr = cr;
        this.cg = cg;
        this.cb = cb;

	}

	public void print () {
        System.out.format("Arc de tamanho (%d,%d) na posicao (%d,%d) de angulo (%d, %d).\n",
            this.x, this.y, this.w, this.h, this.sAngle, this.aAngle);
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(new Color(this.r,this.g,this.b));
        g2d.fillArc(this.x, this.y, this.w, this.h, this.sAngle, this.aAngle);
        g2d.setColor(new Color(this.cr,this.cg,this.cb));
        g2d.drawArc(this.x, this.y, this.w, this.h, this.sAngle, this.aAngle);

    }
}