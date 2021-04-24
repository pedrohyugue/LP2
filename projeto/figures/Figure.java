package figures;

import java.awt.Graphics;

public abstract class Figure {
	public int x, y;
	public int w, h;
	public int r,g,b;
    public int cr,cg,cb;
    public abstract void paint (Graphics g);
}