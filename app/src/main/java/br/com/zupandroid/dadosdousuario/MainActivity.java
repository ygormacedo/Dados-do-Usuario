package br.com.zupandroid.dadosdousuario;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatSpinner;

public class MainActivity extends AppCompatActivity {

    private AppCompatEditText editNameMain, lastNameMain, telephoneMain, celphoneMain, cpfMain, zipCodeMain, neighborhoodMain;
    private AppCompatSpinner schoolingMain, statsMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinnerCustom();
        clickListenner();

        editNameMain = findViewById(R.id.et_main_name);
        lastNameMain = findViewById(R.id.et_main_last_name);
        telephoneMain = findViewById(R.id.et_main_telephone);
        celphoneMain = findViewById(R.id.et_main_celular);
        cpfMain = findViewById(R.id.et_main_cpf);
        schoolingMain = findViewById(R.id.spi_main_school);
        zipCodeMain = findViewById(R.id.et_main_zipCode);
        neighborhoodMain = findViewById(R.id.et_main_neighborhood);
        statsMain = findViewById(R.id.spi_main_stats);

    }

    private void clickListenner() {
        AppCompatButton btnSend = findViewById(R.id.btn_main_send);
        AppCompatButton btnClear = findViewById(R.id.btn_main_clear);


        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                userDate mUser = new userDate();

                if (mUser != null) {
                    Toast.makeText(MainActivity.this, "Por favor, inseria os dados acima", Toast.LENGTH_LONG).show();
                } else {
                    mUser.setName(editNameMain.getText().toString());
                    mUser.setLastName(lastNameMain.getText().toString());
                    mUser.setTelephone(telephoneMain.getText().toString());
                    mUser.setCelphone(celphoneMain.getText().toString());
                    mUser.setCpf(cpfMain.getText().toString());
                    mUser.setSchooling(schoolingMain.getSelectedItem().toString());
                    mUser.setZipCode(zipCodeMain.getText().toString());
                    mUser.setNeighborhood(neighborhoodMain.getText().toString());
                    mUser.setStats(statsMain.getSelectedItem().toString());
                    Intent intent = new Intent(MainActivity.this, ReceiveActivity.class);
                    intent.putExtra("name", mUser);
                    startActivity(intent);
                }
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent clear = new Intent();
                startActivity(clear);

            }
        });
    }

    private void spinnerCustom() {
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