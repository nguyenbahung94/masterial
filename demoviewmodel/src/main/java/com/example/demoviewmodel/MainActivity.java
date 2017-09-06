package com.example.demoviewmodel;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ScoreViewModel scoreViewModel;
    private static int tam=10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scoreViewModel = ViewModelProviders.of(this).get(ScoreViewModel.class);
        addOneForTeam();

    }

    public void addOneForTeam() {
        scoreViewModel.ScoreTeamA = scoreViewModel.ScoreTeamA + 2;
        disPlayView();
    }

    public void disPlayView() {
        Toast.makeText(getApplicationContext(), "A" + scoreViewModel.ScoreTeamA + "/" + "B"+tam + scoreViewModel.ScoreTeamB, Toast.LENGTH_SHORT).show();
    }
}
