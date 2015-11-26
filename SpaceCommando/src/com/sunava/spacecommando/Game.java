package com.sunava.spacecommando;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;

public class Game extends Activity 
{

	GamePanel game_panel;
	RelativeLayout Rel_main_game;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.game);
		//Rel_main_game = (RelativeLayout)findViewById(R.id.main_game_ri);
		
		
		DisplayMetrics displayMetrics = new DisplayMetrics();
		this.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
		
		final int height = displayMetrics.heightPixels;
		final int width = displayMetrics.widthPixels;
		
		game_panel = new GamePanel(getApplicationContext(),this,width);
		//Rel_main_game.addView(game_panel);
		setContentView(game_panel);
	} 
}
