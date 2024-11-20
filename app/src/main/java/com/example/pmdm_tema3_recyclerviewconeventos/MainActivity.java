package com.example.pmdm_tema3_recyclerviewconeventos;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ContactoAdapter.OnItemClickListener {

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

        ArrayList<Contacto> contactos = new ArrayList<>();
        contactos.add(new Contacto("Javier", "Milei", R.drawable.milei, 123456789));
        contactos.add(new Contacto("Leonel", "Messi", R.drawable.messi, 987654321));
        contactos.add(new Contacto("Cristiano", "Ronaldo", R.drawable.cr7, 123456789));
        contactos.add(new Contacto("Jude", "Bellingham", R.drawable.bellingham, 987654311));

        ContactoAdapter contactoAdapter = new ContactoAdapter(contactos,this);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(contactoAdapter);

    }

    @Override
    public void onItemClick(Contacto contacto) {
        Toast.makeText(this, contacto.getNombre() + ", " + contacto.getApellidos() + " telefono: " + String.valueOf(contacto.getNumero()), Toast.LENGTH_SHORT).show();

    }
}