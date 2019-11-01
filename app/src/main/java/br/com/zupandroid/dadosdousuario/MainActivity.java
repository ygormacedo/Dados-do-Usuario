package br.com.zupandroid.dadosdousuario;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatSpinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinnerCustom();
        clickCustom();
    }

    private void clickCustom(){
        AppCompatButton sendInformation = findViewById(R.id.btn_main_send);
        AppCompatButton clearInformation = findViewById(R.id.btn_main_clear);

        sendInformation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ReceiveActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void spinnerCustom(){
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