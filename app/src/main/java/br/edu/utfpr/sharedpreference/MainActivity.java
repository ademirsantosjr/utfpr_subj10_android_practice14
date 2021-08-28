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

    private void saveColorPreference(int newValue) {
        SharedPreferences sharedPreferences = getSharedPreferences(FILE,
                Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putInt(COLOR, newValue);

        editor.commit();

        option = newValue;

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
    public boolean onPrepareOptionsMenu(Menu menu) {

        MenuItem menuItem;

        switch (option) {
            case Color.BLUE:
                menuItem = menu.findItem(R.id.menuItemBlue);
                menuItem.setChecked(true);
                break;

            case Color.YELLOW:
                menuItem = menu.findItem(R.id.menuItemYellow);
                menuItem.setChecked(true);
                break;

            case Color.RED:
                menuItem = menu.findItem(R.id.menuItemRed);
                menuItem.setChecked(true);
                break;

            default:
                return false;
        }

        menuItem.setChecked(true);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        item.setChecked(true);

        switch (item.getItemId()) {
            case R.id.menuItemYellow:
                saveColorPreference(Color.YELLOW);
                return true;

            case R.id.menuItemBlue:
                saveColorPreference(Color.BLUE);
                return true;

            case R.id.menuItemRed:
                saveColorPreference(Color.RED);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}