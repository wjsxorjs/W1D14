package extra;

import java.awt.Color;

public class Bullet extends Thread{
	int x, y, width, height;
	Color c;
	SpaceFrame sf;
	
	
	public Bullet(SpaceFrame sf) {
		
		x = 0;
		y = 0;
		
		width = 10;
		height = 20;
		
		c = Color.YELLOW;
		
		this.sf = sf;
		
	}
	
	
	
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	public Color getC() {
		return c;
	}
	
	
	@Override
	public void run() {
		while(this.y > 0) {
			this.y -= 5;
			sf.revalidate();
			
			try {
				Thread.sleep(5);
			} catch (Exception e) {}
		}
		sf.b_list.remove(this);
		
	}
	
	
}
