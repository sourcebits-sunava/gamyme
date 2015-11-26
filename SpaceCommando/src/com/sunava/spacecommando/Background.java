package com.sunava.spacecommando;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Background 
{
	Bitmap backBitmap;
	int x,y;
	int screenWidth;
	int countBackground;
	GamePanel rootGamePanel;
	
	public Background(Bitmap backBitmap,int screenWidth,GamePanel gamePanel)
	{
		this.backBitmap = backBitmap;
		this.screenWidth = screenWidth;
		x = 0;
		y =0;
		countBackground = screenWidth/backBitmap.getWidth();
		rootGamePanel = gamePanel;
	}
	
	public void draw(Canvas canvas)
	{
		//for( int i = 0; i < countBackground+i;++i)
		for( int i = 0; i < 4;++i)
		{
			if(canvas!=null)
				canvas.drawBitmap(backBitmap, backBitmap.getWidth()*i+x, y, null);
		}
		if(Math.abs(x)>backBitmap.getWidth())
		{
			x = x + backBitmap.getWidth();
		}
		
	}
	
	public void update(float delta)
	{
		x = (int) (x - rootGamePanel.shipSpeed*delta);
	}

}
