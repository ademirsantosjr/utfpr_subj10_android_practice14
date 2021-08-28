package br.edu.utfpr.sharedpreference;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private static final String FILE = "br.edu.utfpr.sharedpreference.COLOR_PREFERENCE";
    private static final String COLOR = "COLOR";
    private ConstraintLayout layoutMain;
    private int option = Color.BLUE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layoutMain = findViewById(R.id.layoutMain);

        readColorPreference();
    }

    private void readColorPreference() {
        SharedPreferences sharedPreferences = getSharedPreferences(FILE,
                Context.MODE_PRIVATE);

        option = sharedPreferences.getInt(COLOR, option);

        changeBackGroundColor();
    }

    private void changeBackGroundColor() {
        layoutMain.setBackgroundColor(option);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        item.setChecked(true);

        switch (item.getItemId()) {
            case R.id.menuItemYellow:
                layoutMain.setBackgroundColor(Color.YELLOW);
                return true;

            case R.id.menuItemBlue:
                layoutMain.setBackgroundColor(Color.BLUE);
                return true;

            case R.id.menuItemRed:
                layoutMain.setBackgroundColor(Color.RED);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}