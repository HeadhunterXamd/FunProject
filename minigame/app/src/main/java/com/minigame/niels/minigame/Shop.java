package com.minigame.niels.minigame;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewParent;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class Shop extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        updateCount();
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

    public void BuyCheap(View view) {
        if(MainScreen.count >= 10){
            MainScreen.plusValue += 2;
            MainScreen.count -= 10;
            updateCount();
        }else{
            NotEnough();
        }

    }

    public void SuperBuy(View view) {
        if(MainScreen.count >= 50){
            MainScreen.count -= 50;
            MainScreen.plusValue += 10;
            updateCount();
        }else{
            NotEnough();
        }
    }

    public void GoBack(View view) {
        MainScreen.UpdateCounterFromOtherView();
        finish();
    }


    private void NotEnough(){
        Toast t = Toast.makeText(getBaseContext(), "you don't have enough money", Toast.LENGTH_SHORT);
        t.show();
    }


    private void updateCount(){
        TextView score = (TextView)findViewById(R.id.Score);
        score.setText(""+MainScreen.count);
    }
}
