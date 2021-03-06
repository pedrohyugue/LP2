package figures;

import ivisible.IVisible;
import java.awt.Graphics;

public abstract class Figure implements IVisible {
    public int x, y;
    public int w, h;
	public int r,g,b;
    public int cr,cg,cb;

    public abstract void paint (Graphics g);

    public Figure (int x, int y, int w, int h, int r, int g, int b) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.r = r;
        this.g = g;
        this.b = b;
        

    }

    public void drag (int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    public boolean clicked (int x, int y) {
        return (this.x<=x && x<=this.x+this.w && this.y<=y && y<=this.y+this.h);
    }
}