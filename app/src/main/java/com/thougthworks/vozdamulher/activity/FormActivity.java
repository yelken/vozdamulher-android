package com.thougthworks.vozdamulher.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import com.thougthworks.vozdamulher.R;
import com.thougthworks.vozdamulher.component.BusAutoCompleteAdapter;
import com.thougthworks.vozdamulher.model.Bus;

import java.util.ArrayList;

public class FormActivity extends AppCompatActivity {

    private ArrayList<Bus> bus = new ArrayList<Bus>();
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
        BusAutoCompleteAdapter adapter = new BusAutoCompleteAdapter (this, R.layout.layout_auto_complete_bus_item, bus);
        autoCompleteTextView.setAdapter(adapter);

        next = (Button) findViewById(R.id.btn_next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO passar os dados pra próxima tela
            }
        });

    }

    private void setBus() {
        bus.add(new Bus("Circular (Conde da Boa Vista)", 100));
        bus.add(new Bus("Circular (Conde da Boa Vista) - Rua do Sol", 101));
        bus.add(new Bus("Ibura/Santa Luzia", 102));
        bus.add(new Bus("UR-11/Barro", 103));
        bus.add(new Bus("Circular (IMIP)", 104));
        bus.add(new Bus("Parque Aeronáutica/Santa Luzia", 106));
        bus.add(new Bus("Circular (Cabugá / Prefeitura)", 107));
        bus.add(new Bus("Barro/CEASA", 108));
        bus.add(new Bus("Piedade/Shopping Center", 10));
        bus.add(new Bus("Pinheiros", 111));
        bus.add(new Bus("TI Aeroporto / TI Afogados", 115));
        bus.add(new Bus("Circular (Príncipe)", 116));
        bus.add(new Bus("Circular (Prefeitura / Cabugá)", 117));
        bus.add(new Bus("Prazeres/Boa Viagem", 118));
        bus.add(new Bus("Circular/T.I. Cabo", 119));
        bus.add(new Bus("Piedade/Derby", 11));

    }

}
