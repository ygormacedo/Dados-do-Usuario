package br.com.zupandroid.dadosdousuario;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

public class SpinnerAdapter extends ArrayAdapter {

    private Context context;

    public SpinnerAdapter(@NonNull Context context, int resource) {
        super(context, R.layout.spinner_item);
        this.context = context;

    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
      TextView view = (TextView) super.getDropDownView(position, convertView, parent);
      view.setTextColor(ContextCompat.getColor(context, R.color.colorSegundary));
      return view;
    }
}
