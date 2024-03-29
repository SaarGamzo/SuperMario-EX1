package com.example.mario_game_ex1.UI;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mario_game_ex1.R;
import com.google.android.material.button.MaterialButton;

public class MainMenuActivity extends AppCompatActivity {

    private MaterialButton main_BTN_play; // play game button
    private MaterialButton main_BTN_settings; // Go to settings button
    private MaterialButton main_BTN_quit; // quit game button

    private int COLS;
    private int ROWS;

    private int GAMESPEED;

    private boolean isVibrator = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        findViews();
        GAMESPEED = getIntent().getIntExtra("updatedGameSpeed", 1); // get value from settings screen
        COLS = getIntent().getIntExtra("updatedCols", 3); // get value from settings screen
        ROWS = getIntent().getIntExtra("updatedRows", 5); // get value from settings screen
        isVibrator = getIntent().getBooleanExtra("vibrateValue", true); // get value from settings screen
        // set listeners
        setListeners();
    }

    private void setListeners() {
        main_BTN_play.setOnClickListener(view -> playClicked());
        main_BTN_settings.setOnClickListener(view -> settingsClicked());
        main_BTN_quit.setOnClickListener(view -> quitClicked());
    }

    //find views
    private void findViews () {
        main_BTN_play = findViewById(R.id.main_BTN_play);
        main_BTN_settings = findViewById(R.id.main_BTN_settings);
        main_BTN_quit = findViewById(R.id.main_BTN_quit);
    }
    // play button pressed -> move to play game activity
    private void playClicked() {
        // Start the game activity or navigate to the game screen
        Intent intent = new Intent(this, MainGameActivity.class);
        intent.putExtra("updatedGameSpeed", this.GAMESPEED);
        intent.putExtra("updatedCols", this.COLS);
        intent.putExtra("updatedRows", this.ROWS);
        intent.putExtra("vibrateValue", this.isVibrator);
        startActivity(intent);
    }
    // settings button pressed -> move to settings activity
    private void settingsClicked() {
        Intent intent = new Intent(this, SettingsActivity.class);
        intent.putExtra("initialGameSpeed", this.GAMESPEED);
        intent.putExtra("initialCols", this.COLS);
        intent.putExtra("initialRows", this.ROWS);
        intent.putExtra("vibrateValue", this.isVibrator);
        startActivity(intent);
    }
    // quit button pressed -> close applictaion
    private void quitClicked() {
        finishAffinity();
    }
}
