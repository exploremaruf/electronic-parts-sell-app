package com.penguinlabs.etapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    RecyclerView productRecyclerView;
    EditText searchBar;
    Button cartButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize Views
        productRecyclerView = findViewById(R.id.productRecyclerView);
        searchBar = findViewById(R.id.searchBar);
        cartButton = findViewById(R.id.cartButton);

        // RecyclerView setup
        productRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Cart button click
        cartButton.setOnClickListener(v ->
                Toast.makeText(MainActivity.this, "Cart Opened", Toast.LENGTH_SHORT).show()
        );
    }
}
