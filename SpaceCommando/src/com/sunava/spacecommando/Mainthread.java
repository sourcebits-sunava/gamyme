package com.sunava.spacecommando;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class Mainthread extends Thread 
{
	private SurfaceHolder surfaceHolder;
	private GamePanel gamePanel;
	private boolean running;
	float delta;

	public Mainthread(SurfaceHolder surfaceHolder, GamePanel gamePanel) 
	{
		this.surfaceHolder = surfaceHolder;
		this.gamePanel = gamePanel;
		delta = 0;
	}
	void setRunning(boolean running)
	{
		this.running = running;
	}
	
	@Override
	public void run() 
	{
		Canvas canvas;
		
		while(running)
		{
			if(!gamePanel.pause_game)
			{
				long startDraw = System.currentTimeMillis();
				canvas = null;
				try
				{
					canvas = surfaceHolder.lockCanvas();
					synchronized (surfaceHolder) 
					{
						gamePanel.Update(delta);
						gamePanel.Draw(canvas);
						
					}
				}
				finally
				{
					if(canvas!=null)
					{
						surfaceHolder.unlockCanvasAndPost(canvas);
					}
				}
				
				
				long endDraw = System.currentTimeMillis();
				delta = (endDraw - startDraw)/1000.f;
				
			}
			
		}
	}

}
