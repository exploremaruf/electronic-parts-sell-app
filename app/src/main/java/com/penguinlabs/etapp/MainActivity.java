package com.penguinlabs.etapp;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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

    private RecyclerView productRecyclerView;
    private EditText searchBar;
    private Button cartButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        setupInsets();
        initViews();
        setupRecyclerView();
        setupListeners();
    }

    private void setupInsets() {
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void initViews() {
        productRecyclerView = findViewById(R.id.productRecyclerView);
        searchBar = findViewById(R.id.searchBar);
        cartButton = findViewById(R.id.cartButton);
    }

    private void setupRecyclerView() {
        productRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        // productRecyclerView.setAdapter(new ProductAdapter(productList)); // later
    }

    private void setupListeners() {

        cartButton.setOnClickListener(v ->
                Toast.makeText(this, "Opening Cart...", Toast.LENGTH_SHORT).show()
        );

        searchBar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // filterProducts(s.toString()); // later filtering
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
    }
}
