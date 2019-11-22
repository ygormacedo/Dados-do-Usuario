package br.com.zupandroid.dadosdousuario;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.core.widget.ContentLoadingProgressBar;

import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;

public class MainActivity extends AppCompatActivity {

    private AppCompatEditText editNameMain, lastNameMain, rgMain, telephoneMain,
                              celphoneMain, cpfMain, zipCodeMain, neighborhoodMain, passwordOk, passwordConfirm;
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

                UserDate mUser = new UserDate();
                boolean validator = useValidate();

                mUser.setName(editNameMain.getText().toString());
                mUser.setLastName(lastNameMain.getText().toString());
                mUser.setTelephone(telephoneMain.getText().toString());
                mUser.setCelphone(celphoneMain.getText().toString());
                mUser.setCpf(cpfMain.getText().toString());
                mUser.setSchooling(schoolingMain.getSelectedItem().toString());
                mUser.setZipCode(zipCodeMain.getText().toString());
                mUser.setNeighborhood(neighborhoodMain.getText().toString());
                mUser.setStats(statsMain.getSelectedItem().toString());
                mUser.setPassword(passwordOk.getText().toString());
                mUser.setRePassword(passwordConfirm.getText().toString());
                mUser.setRg(rgMain.getText().toString());
                Intent intent = new Intent(MainActivity.this, ReceiveActivity.class);
                intent.putExtra("name", mUser);

                if (validator) {
                    startActivity(intent);
                } else {
                    clickListenner();
                }

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
                        passwordConfirm.getText().clear();
                        passwordOk.getText().clear();
                        rgMain.getText().clear();
                    }
                });
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        final AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Você realmente deseja sair?");
        alert.setCancelable(false)
                .setNegativeButton("Não", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        AlertDialog alertDialog = alert.create();
        alertDialog.show();
    }

    private void validataFields() {

        SimpleMaskFormatter cpfMask = new SimpleMaskFormatter("NNN.NNN.NNN-NN");
        MaskTextWatcher cpfMaskText = new MaskTextWatcher(cpfMain, cpfMask);
        cpfMain.addTextChangedListener(cpfMaskText);

        SimpleMaskFormatter telephoneMask = new SimpleMaskFormatter("(NN)NNNN-NNNN");
        MaskTextWatcher telephoneMaskText = new MaskTextWatcher(telephoneMain, telephoneMask);
        telephoneMain.addTextChangedListener(telephoneMaskText);

        SimpleMaskFormatter celphoneMask = new SimpleMaskFormatter("(NN)NNNNN-NNNN");
        MaskTextWatcher celphoneMaskText = new MaskTextWatcher(celphoneMain, celphoneMask);
        celphoneMain.addTextChangedListener(celphoneMaskText);

        SimpleMaskFormatter rgMask = new SimpleMaskFormatter("NN.NNN.NNN-N");
        MaskTextWatcher rgMaskText = new MaskTextWatcher(rgMain, rgMask);
        rgMain.addTextChangedListener(rgMaskText);
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

    private void namesIds() {
        editNameMain = findViewById(R.id.et_main_name);
        lastNameMain = findViewById(R.id.et_main_last_name);
        telephoneMain = findViewById(R.id.et_main_telephone);
        celphoneMain = findViewById(R.id.et_main_celular);
        cpfMain = findViewById(R.id.et_main_cpf);
        schoolingMain = findViewById(R.id.spi_main_school);
        zipCodeMain = findViewById(R.id.et_main_zipCode);
        neighborhoodMain = findViewById(R.id.et_main_neighborhood);
        statsMain = findViewById(R.id.spi_main_stats);
        passwordOk = findViewById(R.id.et_main_password);
        passwordConfirm = findViewById(R.id.et_main_confirm_password);
        rgMain = findViewById(R.id.et_main_rg);
    }

    private MensagemError mensagemLog() {

        MensagemError msgLog = new MensagemError();

        msgLog.setLogName("O campo Nome é obrigatorio");
        msgLog.setLogLastName("O campo Sobrenome é obrigatorio");
        msgLog.setLogCelphone("O campo Celular é obrigatorio");
        msgLog.setLogTelephone("O campo Tefone é obrigatorio ");
        msgLog.setLogCpf("O campo CPF é obrigatorio");
        msgLog.setLogNeighborhood("O campo Bairro é obrigatorio");
        msgLog.setLogZipCod("O campo Endereço é obrigatorio");
        msgLog.setLogPassword("O Campo senha é obrigatorio");
        msgLog.setLogRePassword("O Campo de confirmação da senha é obrigatorio");
        msgLog.setLogRg("O campo RG é obrigatorio");

        return msgLog;
    }

    public boolean useValidate() {
        UserDate userDate = new UserDate();
        MensagemError msgLog = mensagemLog();
        userDate.setName(editNameMain.getText().toString());
        userDate.setLastName(lastNameMain.getText().toString());
        userDate.setTelephone(telephoneMain.getText().toString());
        userDate.setCelphone(celphoneMain.getText().toString());
        userDate.setCpf(cpfMain.getText().toString());
        userDate.setSchooling(schoolingMain.getSelectedItem().toString());
        userDate.setZipCode(zipCodeMain.getText().toString());
        userDate.setNeighborhood(neighborhoodMain.getText().toString());
        userDate.setPassword(passwordOk.getText().toString());
        userDate.setRePassword(passwordConfirm.getText().toString());
        userDate.setStats(statsMain.getSelectedItem().toString());
        userDate.setRg(rgMain.getText().toString());
        boolean validator = true;
        if (userDate.getName().length() == 0) {
            Toast.makeText(MainActivity.this, msgLog.getLogName(), Toast.LENGTH_LONG).show();
            validator = false;
        } else if (userDate.getRg().length() == 0) {
            userDate.setRg(rgMain.getText().toString());
            Toast.makeText(MainActivity.this, msgLog.getLogRg(), Toast.LENGTH_LONG).show();
            validator = false;
        } else if (userDate.getLastName().length() == 0) {
            userDate.setLastName(lastNameMain.getText().toString());
            Toast.makeText(MainActivity.this, msgLog.getLogLastName(), Toast.LENGTH_LONG).show();
            validator = false;
        } else if (userDate.getTelephone().length() == 0) {
            userDate.setTelephone(telephoneMain.getText().toString());
            Toast.makeText(MainActivity.this, msgLog.getLogTelephone(), Toast.LENGTH_LONG).show();
            validator = false;
        } else if (userDate.getCelphone().length() == 0) {
            userDate.setCelphone(celphoneMain.getText().toString());
            Toast.makeText(MainActivity.this, msgLog.getLogCelphone(), Toast.LENGTH_LONG).show();
            validator = false;
        } else if (userDate.getCpf().length() == 0) {
            userDate.setCpf(cpfMain.getText().toString());
            Toast.makeText(MainActivity.this, msgLog.getLogCpf(), Toast.LENGTH_LONG).show();
            validator = false;

        } else if (userDate.getNeighborhood().length() == 0) {
            userDate.setNeighborhood(neighborhoodMain.getText().toString());
            Toast.makeText(MainActivity.this, msgLog.getLogNeighborhood(), Toast.LENGTH_LONG).show();
            validator = false;

        } else if (userDate.getZipCode().length() == 0) {
            userDate.setZipCode(zipCodeMain.getText().toString());
            Toast.makeText(MainActivity.this, msgLog.getLogZipCod(), Toast.LENGTH_LONG).show();
            validator = false;

        } else if (userDate.getPassword().length() == 0) {
            userDate.setPassword(passwordOk.getText().toString());
            Toast.makeText(MainActivity.this, msgLog.getLogPassword(), Toast.LENGTH_LONG).show();
            validator = false;

        } else if (userDate.getRePassword().length() == 0) {
            userDate.setRePassword(passwordConfirm.getText().toString());
            Toast.makeText(MainActivity.this, msgLog.getLogRePassword(), Toast.LENGTH_LONG).show();
            validator = false;

        }
        return validator;
    }
}