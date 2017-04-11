package com.thougthworks.vozdamulher.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import com.thougthworks.vozdamulher.R;
import com.thougthworks.vozdamulher.component.BusAutoCompleteAdapter;
import com.thougthworks.vozdamulher.model.Bus;

import java.text.Normalizer;
import java.util.ArrayList;

public class FormActivity extends AppCompatActivity {

    private ArrayList<Bus> arrayBus = new ArrayList<Bus>();
    private AutoCompleteTextView autoCompleteTextView;
    private Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        setBus();

        autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.atxt_onibus);
        BusAutoCompleteAdapter adapter = new BusAutoCompleteAdapter (this, R.layout.layout_auto_complete_bus_item, arrayBus);
        autoCompleteTextView.setAdapter(adapter);

        next = (Button) findViewById(R.id.btn_next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO passar os dados pra próxima tela
                startActivity(new Intent(FormActivity.this, MainActivity.class));
            }
        });

    }

    private void setBus() {
        arrayBus.add(new Bus("Circular (Conde da Boa Vista)", 100));
        arrayBus.add(new Bus("Circular (Conde da Boa Vista) - Rua do Sol", 101));
        arrayBus.add(new Bus("Ibura/Santa Luzia", 102));
        arrayBus.add(new Bus("UR-11/Barro", 103));
        arrayBus.add(new Bus("Circular (IMIP)", 104));
        arrayBus.add(new Bus("Parque Aeronáutica/Santa Luzia", 106));
        arrayBus.add(new Bus("Circular (Cabugá / Prefeitura)", 107));
        arrayBus.add(new Bus("Barro/CEASA", 108));
        arrayBus.add(new Bus("Piedade/Shopping Center", 10));
        arrayBus.add(new Bus("Pinheiros", 111));
        arrayBus.add(new Bus("TI Aeroporto / TI Afogados", 115));
        arrayBus.add(new Bus("Circular (Príncipe)", 116));
        arrayBus.add(new Bus("Circular (Prefeitura / Cabugá)", 117));
        arrayBus.add(new Bus("Prazeres/Boa Viagem", 118));
        arrayBus.add(new Bus("Circular/T.I. Cabo", 119));
        arrayBus.add(new Bus("Piedade/Derby", 11));

    }

    private Bus getBusByName(String name) {
        for (Bus bus: arrayBus)  {
            if (bus.getName().equals(name)) {
                return bus;
            }
        }
        return new Bus();
    }

}
