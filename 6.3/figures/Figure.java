package figures;

import java.awt.Graphics;

public abstract class Figure {
	int x, y;
	int w, h;
	int r,g,b;
    int cr,cg,cb;
    public abstract void paint (Graphics g);
}