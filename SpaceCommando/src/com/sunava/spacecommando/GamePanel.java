package com.sunava.spacecommando;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class GamePanel extends SurfaceView implements SurfaceHolder.Callback
{

	public Mainthread thread;
	public boolean pause_game;
	private Background background;
	public float shipSpeed;
	
	public GamePanel(Context context, Game game,int screenWidth) 
	{
		super(context);
		getHolder().addCallback(this);
		shipSpeed = screenWidth/2.f;
		thread = new Mainthread(getHolder(),this);
		background = new Background(BitmapFactory.decodeResource(getResources(), R.drawable.gamebackground), screenWidth, this);
		setFocusable(true);
		//shipSpeed = screenWidth/2.f;
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		return super.onTouchEvent(event);
	}
	
	void Draw(Canvas canvas)
	{
		if(!pause_game)
		{
			if(canvas!=null)
			{
				background.draw(canvas);
			}
		}
		
	}

	void Update(float delta)
	{
		background.update(delta);
	}
	
	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) 
	{
		thread.setRunning(true);
		thread.start();
		
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) 
	{
		boolean retry = true;
		while(retry)
		{
			try
			{
				thread.join();
				retry = false;
			}
			catch(InterruptedException e)
			{
				
			}
		}
		
	}

	

}
