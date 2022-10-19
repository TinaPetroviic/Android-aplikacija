package com.example.flowers;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;


public class DetailActivity extends AppCompatActivity {

    ImageView plantImage;
    TextView plantName;
    TextView plantDescription;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        this.plantImage = findViewById(R.id.plantImage);
        this.plantName = findViewById(R.id.plantName);
        this.plantDescription = findViewById(R.id.plantDescription);


        Plants plants = FlowersActivity3.selectedPlant;
        this.plantName.setText(plants.getName());
        this.plantDescription.setText(plants.getDescription());
        this.plantImage.setImageResource(plants.getImage());

        /*Button crashButton = new Button(this);
        crashButton.setText("Test Crash");
        crashButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                throw new RuntimeException("Test Crash");

    }
        });

        addContentView(crashButton, new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));*/

    }
}