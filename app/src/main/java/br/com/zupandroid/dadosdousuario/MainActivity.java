package br.com.zupandroid.dadosdousuario;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatSpinner;

import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;

public class MainActivity extends AppCompatActivity {

    private AppCompatEditText editNameMain, lastNameMain, telephoneMain, celphoneMain, cpfMain, zipCodeMain, neighborhoodMain;
    private AppCompatSpinner schoolingMain, statsMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        namesIds();
        clickListenner();
        spinnerCustom();

    }
    private void clickListenner() {

        AppCompatButton btnSend = findViewById(R.id.btn_main_send);
        final AppCompatButton btnClear = findViewById(R.id.btn_main_clear);


        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                userDate mUser = new userDate();
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
        });

        validataFields();

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                namesIds();
                btnClear.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        editNameMain.getText().clear();
                        lastNameMain.getText().clear();
                        telephoneMain.getText().clear();
                        celphoneMain.getText().clear();
                        cpfMain.getText().clear();
                        schoolingMain.setSelected(true);
                        zipCodeMain.getText().clear();
                        neighborhoodMain.getText().clear();
                        statsMain.setSelected(true);
                    }
                });

            }
        });
    }

    private void validataFields() {

        SimpleMaskFormatter cpfMask = new SimpleMaskFormatter("NNN.NNN.NNN-NN");
        MaskTextWatcher cpfMaskText = new MaskTextWatcher(cpfMain, cpfMask);
        cpfMain.addTextChangedListener(cpfMaskText);

        SimpleMaskFormatter telephoneMask = new SimpleMaskFormatter("(NN)NNNN-NNNN");
        MaskTextWatcher telephoneMaskText = new MaskTextWatcher(telephoneMain,telephoneMask);
        telephoneMain.addTextChangedListener(telephoneMaskText);

        SimpleMaskFormatter celphoneMask = new SimpleMaskFormatter("(NN)NNNNN-NNNN");
        MaskTextWatcher celphoneMaskText = new MaskTextWatcher(celphoneMain,celphoneMask);
        celphoneMain.addTextChangedListener(celphoneMaskText);
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

    private void namesIds(){
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
}