package com.example.ds_app_5;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;

import java.util.ArrayList;

public class LearningFragmentsActivity extends AppCompatActivity implements FragmentA.SendPosition {

    ArrayList<String> details;
    TextView tvDetail;
    View viewOfFragmentB;

    FragmentManager manager;

    View viewPortrait;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_learning_fragments);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        init();

        if(viewPortrait!=null)
        {
            manager
                    .beginTransaction()
                    .hide(manager.findFragmentById(R.id.detailFrag))
                    .show(manager.findFragmentById(R.id.namesFrag))
                    .commit();
        }
        else
        {
            manager
                    .beginTransaction()
                    .show(manager.findFragmentById(R.id.detailFrag))
                    .show(manager.findFragmentById(R.id.namesFrag))
                    .commit();
        }

    }

    private void init()
    {
        viewPortrait = findViewById(R.id.viewPortrait);

        details = new ArrayList<>();
        details.add("Detail of Waqas");
        details.add("Detail of Ali");
        details.add("Detail of Andaleeb");
        details.add("Detail of Aurangzaib");
        details.add("Detail of Maryam Nawaz");
        details.add("Detail of Waqas");
        details.add("Detail of Ali");
        details.add("Detail of Andaleeb");
        details.add("Detail of Aurangzaib");
        details.add("Detail of Maryam Nawaz");

        manager = getSupportFragmentManager();
        viewOfFragmentB = manager.findFragmentById(R.id.detailFrag).requireView();

        tvDetail = viewOfFragmentB.findViewById(R.id.tvDetail);

        tvDetail.setText("Empty");

    }

    @Override
    public void onSetPosition(int position) {
        tvDetail.setText(details.get(position));

        if(viewPortrait!=null)
        {
            manager
                    .beginTransaction()
                    .show(manager.findFragmentById(R.id.detailFrag))
                    .hide(manager.findFragmentById(R.id.namesFrag))
                    .addToBackStack(null)
                    .commit();
        }
    }
}