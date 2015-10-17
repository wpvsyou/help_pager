package com.wp.demo;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HelpPagerViewFrameLayout
                helpPager = (HelpPagerViewFrameLayout)findViewById(R.id.help_pager);
        helpPager.setOnHelpAnimationFinishListener(new OnHelpAnimationFinishListener() {
            @Override
            public void onHelpAnimationFinish() {

            }
        });
        helpPager.setHelpPagerDetails(null);
        try {
            helpPager.start();
        } catch (HelpPagerViewFrameLayout.HelpPagerDataNullException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
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
}
