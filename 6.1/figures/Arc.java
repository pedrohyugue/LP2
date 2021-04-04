package figures;

import java.awt.*;

public class Arc extends Figure {
	int x, y;
	int w, h;
	int sAngle, aAngle;
	int r,g,b;
    int cr,cg,cb;

	public Arc (int x, int y, int w, int h, int sAngle, int aAngle, int r, int g, int b, int cr, int cg, int cb) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.sAngle = sAngle;
		this.aAngle= aAngle;
		this.r = r;
        this.g = g;
        this.b = b;
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