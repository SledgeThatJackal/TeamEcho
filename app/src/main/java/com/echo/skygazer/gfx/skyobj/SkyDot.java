package com.echo.skygazer.gfx.skyobj;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.echo.skygazer.Main;
import com.echo.skygazer.gfx.SkyObject;

public class SkyDot extends SkyObject
{
    int color = Color.rgb(255, 200, 200);  //Color to render shape
    int sizePx = 5;             //Size of circle in pixels
    int screenX = 100;
    int screenY = 100;
    String displayName = "null";

    public SkyDot(int screenX, int screenY, String displayName) {
        this.screenX = screenX;
        this.screenY = screenY;
        this.displayName = displayName;

    }
    public SkyDot(int screenX, int screenY) {
        this( screenX, screenY,"Celestia "+String.valueOf(Main.random.nextInt(100000)) );
    }
    public SkyDot() {
        this( Main.random.nextInt(1000), Main.random.nextInt(1000) );
    }

    @Override
    protected void draw(Canvas cs, Paint pt) {
        //Outer circle
        pt.setColor(Color.WHITE);
        cs.drawCircle(screenX, screenY, sizePx+1, pt);
        //Inner circle
        pt.setColor( color );
        cs.drawCircle(screenX, screenY, sizePx, pt);

        pt.setColor(Color.WHITE);
        pt.setTextSize(50);
        cs.drawText(displayName, screenX+sizePx, screenY+sizePx, pt);
    }

    public int getScreenX() { return screenX; }
    public int getScreenY() { return screenY; }
}
