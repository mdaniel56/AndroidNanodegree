package com.nanodegree.mdaniel.myappportfolio;

import android.graphics.Color;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Bind(R.id.button_Spotify) AppCompatButton spotifyButton;
    @Bind(R.id.button_ScoresApp) AppCompatButton scoresAppButton;
    @Bind(R.id.button_LibraryApp) AppCompatButton libraryAppButton;
    @Bind(R.id.button_BuildItBigger) AppCompatButton buildItBiggerButton;
    @Bind(R.id.button_XYZReader) AppCompatButton xyzReaderButton;
    @Bind(R.id.button_Capstone) AppCompatButton capstoneButton;
    @Bind(R.id.coordinatorLayout) CoordinatorLayout coordinatorLayout;
    TextView textSnackbar;
    Snackbar snackbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        spotifyButton.setOnClickListener(this);
        scoresAppButton.setOnClickListener(this);
        libraryAppButton.setOnClickListener(this);
        buildItBiggerButton.setOnClickListener(this);
        xyzReaderButton.setOnClickListener(this);
        capstoneButton.setOnClickListener(this);

        snackbar = Snackbar.make(coordinatorLayout, "", Snackbar.LENGTH_SHORT)
                .make(coordinatorLayout, "", Snackbar.LENGTH_LONG)
                .setAction("OK", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        snackbar.dismiss();
                    }
                });
        View snackbarView = snackbar.getView();
        snackbarView.setBackgroundColor(Color.DKGRAY);
        textSnackbar = (TextView) snackbarView.findViewById(android.support.design.R.id.snackbar_text);
        textSnackbar.setTextColor(Color.YELLOW);
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_Spotify:
                textSnackbar.setText(R.string.textSnackbar_Spotify);
                Toast.makeText(this, R.string.textSnackbar_Spotify, Toast.LENGTH_LONG).show();
                break;
            case R.id.button_ScoresApp:
                textSnackbar.setText(R.string.textSnackbar_ScoresApp);
                Toast.makeText(this, R.string.textSnackbar_ScoresApp, Toast.LENGTH_LONG).show();
                break;
            case R.id.button_LibraryApp:
                textSnackbar.setText(R.string.textSnackbar_LibraryApp);
                Toast.makeText(this, R.string.textSnackbar_LibraryApp, Toast.LENGTH_LONG).show();
                break;
            case R.id.button_BuildItBigger:
                textSnackbar.setText(R.string.textSnackbar_BuildItBigger);
                Toast.makeText(this, R.string.textSnackbar_BuildItBigger, Toast.LENGTH_LONG).show();
                break;
            case R.id.button_XYZReader:
                textSnackbar.setText(R.string.textSnackbar_XYZReader);
                Toast.makeText(this, R.string.textSnackbar_XYZReader, Toast.LENGTH_LONG).show();
                break;
            case R.id.button_Capstone:
                textSnackbar.setText(R.string.textSnackbar_Capstone);
                Toast.makeText(this, R.string.textSnackbar_Capstone, Toast.LENGTH_LONG).show();
                break;
        }
        snackbar.show();
    }

    //Could also use Binding with Listener :
    /*@OnClick(R.id.button_Spotify) void sayHello() {
        Toast.makeText(this, "Hello!", Toast.LENGTH_SHORT).show();
    }*/
}
