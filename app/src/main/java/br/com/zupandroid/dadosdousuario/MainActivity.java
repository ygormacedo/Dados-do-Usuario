package br.com.zupandroid.dadosdousuario;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinnerDropDown();
    }

    private void spinnerDropDown() {

        Spinner estadosDynamic = findViewById(R.id.spi_main_stats);
        ArrayAdapter<CharSequence> staticAdapter = ArrayAdapter
                .createFromResource(this, R.array.estados_array,
                        android.R.layout.simple_spinner_item);
        staticAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        estadosDynamic.setAdapter(staticAdapter);

        Spinner schoolDinamic = findViewById(R.id.spi_main_school);
        staticAdapter = ArrayAdapter
                .createFromResource(this, R.array.escolaridade_array,
                        android.R.layout.simple_spinner_item);
        staticAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        schoolDinamic.setAdapter(staticAdapter);

    }
}