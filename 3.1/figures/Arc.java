package figures;

import java.awt.*;

public class Arc {
	int x, y;
	int w, h;
	int sAngle, aAngle;

	public Arc (int x, int y, int w, int h, int sAngle, int aAngle) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.sAngle = sAngle;
		this.aAngle= aAngle;
	}

	public void print () {
        System.out.format("Arc de tamanho (%d,%d) na posicao (%d,%d) de angulo (%d, %d).\n",
            this.x, this.y, this.w, this.h, this.sAngle, this.aAngle);
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawArc(this.x, this.y, this.w, this.h, this.sAngle, this.aAngle);
    }
}