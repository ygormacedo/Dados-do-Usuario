package br.com.zupandroid.dadosdousuario;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class ReceiveActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive);

        TextView nameUSer = findViewById(R.id.txt_receive_name);
        TextView lastNameUser = findViewById(R.id.txt_receive_last_name);
        TextView telephoneUser = findViewById(R.id.txt_receive_tel);
        TextView celphoneUser = findViewById(R.id.txt_receive_cel);
        TextView cpfUser = findViewById(R.id.txt_receive_cpf);
        TextView schoolingUser = findViewById(R.id.txt_receive_school);
        TextView zipCodeUser = findViewById(R.id.txt_receive_zip_code);
        TextView neighborhoodUser = findViewById(R.id.txt_receive_neighborhood);
        TextView statsUser = findViewById(R.id.txt_receive_stats);

        Bundle bundle = getIntent().getExtras();

        UserDate mNameUser = (UserDate) Objects.requireNonNull(bundle).getSerializable("name");

        nameUSer.setText(Objects.requireNonNull(mNameUser).getName());
        lastNameUser.setText(mNameUser.getLastName());
        telephoneUser.setText(mNameUser.getTelephone());
        celphoneUser.setText(mNameUser.getCelphone());
        cpfUser.setText(mNameUser.getCpf());
        schoolingUser.setText(mNameUser.getSchooling());
        zipCodeUser.setText(mNameUser.getZipCode());
        neighborhoodUser.setText(mNameUser.getNeighborhood());
        statsUser.setText(mNameUser.getStats());
    }
}
