package br.com.zupandroid.dadosdousuario;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppCompatSpinner spinnerStats = findViewById(R.id.spi_main_stats);
        ArrayAdapter<CharSequence> adapterStats = SpinnerAdapter.createFromResource(this,
                R.array.estados_array, R.layout.spinner_item);
        adapterStats.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinnerStats.setAdapter(adapterStats);

        AppCompatSpinner spinnerSchool = findViewById(R.id.spi_main_school);
        ArrayAdapter<CharSequence> adapterSchool = SpinnerAdapter.createFromResource(this, R.array.escolaridade_array, R.layout.spinner_item);
        adapterSchool.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinnerSchool.setAdapter(adapterSchool);

    }
}


//        AppCompatSpinner estadosDynamic = findViewById(R.id.spi_main_stats);
//        ArrayAdapter<CharSequence> staticAdapter = ArrayAdapter
//                .createFromResource(this, R.array.estados_array,
//                        R.layout.);
//        staticAdapter.setDropDownViewResource(R.layout.spinner_item);
//        estadosDynamic.setAdapter(staticAdapter);
//
//        AppCompatSpinner schoolDinamic = findViewById(R.id.spi_main_school);
//        staticAdapter = ArrayAdapter
//                .createFromResource(this, R.array.escolaridade_array,
//                        R.layout.support_simple_spinner_dropdown_item);
//        staticAdapter.setDropDownViewResource(R.layout.spinner_item);
//        schoolDinamic.setAdapter(staticAdapter);
