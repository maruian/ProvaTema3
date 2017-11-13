package com.example.a2dam.provatema3;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView tvUltimoDia, tvUltimoMes;
    EditText etNuevoDia,etNuevoMes;
    Button boton;
    SharedPreferences.Editor editor;
    SharedPreferences sp;

    public static final String PREFS="MisPreferencias";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvUltimoDia = (TextView)findViewById(R.id.ultimoDia);
        tvUltimoMes = (TextView)findViewById(R.id.ultimoMes);
        etNuevoDia = (EditText) findViewById(R.id.nuevoDia);
        etNuevoMes =(EditText) findViewById(R.id.nuevoMes);
        boton = (Button)findViewById(R.id.boto);

        sp = getSharedPreferences(PREFS,MainActivity.MODE_PRIVATE);
        editor = sp.edit();

        tvUltimoDia.setText(sp.getString("dia",""));
        tvUltimoMes.setText(sp.getString("mes",""));

        boton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
           editor.putString("dia",etNuevoDia.getText().toString());
           editor.putString("mes",etNuevoMes.getText().toString());
           editor.commit();
    }
}
