package com.minigame.niels.minigame;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class MainScreen extends ActionBarActivity {

    public static int count;
    public static int plusValue;

    public static TextView m_vCounter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        m_vCounter = (TextView)findViewById(R.id.MoneyCounter);
        count = 0;
        UpdateCounter();
        plusValue = 0;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void UpdateCounter(){
        m_vCounter.setText("" + count + " points");
    }

    public static void UpdateCounterFromOtherView(){
        m_vCounter.setText("" + count + " points");
    }

    public void CountUp(View view) {
        count += plusValue + 1;
        UpdateCounter();
    }

    public void startShop(View view) {
        Intent intent = new Intent(this, Shop.class);
        startActivity(intent);
    }
}
