package com.example.liquidacin;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity3 extends AppCompatActivity {
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        TextView textNombres = findViewById(R.id.nombres);
        TextView txtApellidos = findViewById(R.id.apellidos);
        TextView txtCargo = findViewById(R.id.cargo);
        TextView txtSueldo = findViewById(R.id.sueldo);
        TextView txtDiasLab = findViewById(R.id.diasLab);
        TextView txtValorDia = findViewById(R.id.valorDia);
        TextView txtDescuento = findViewById(R.id.descuento);
        TextView txtSalud = findViewById(R.id.salud);
        TextView txtPension = findViewById(R.id.pension);
        TextView txtTotal = findViewById(R.id.total);

        Button btnSalir = findViewById(R.id.btnSalir);

        String nombres = getIntent().getStringExtra("nombres");
        String apellidos = getIntent().getStringExtra("apellidos");
        String cargo = getIntent().getStringExtra("cargo");
        double sueldo = getIntent().getDoubleExtra("sueldo", 0.0);
        int diasLab = getIntent().getIntExtra("diasLab", 0);
        boolean descuento = getIntent().getBooleanExtra("descuento", false);
        boolean salud = getIntent().getBooleanExtra("salud", false);
        boolean pension = getIntent().getBooleanExtra("pension", false);

        btnSalir.setOnClickListener(view -> finish());

        textNombres.setText(nombres);
        txtApellidos.setText(apellidos);
        txtCargo.setText("Cargo: \n "+ cargo);
        txtSueldo.setText("Sueldo: \n $ " + sueldo);
        txtDiasLab.setText("Dias laborados: " + diasLab);
        double valorDia = sueldo / diasLab;
        txtValorDia.setText("Valor x Día : \n $" + valorDia);
        if (descuento) {
            txtDescuento.setText("Descuento: Sí");
            sueldo = sueldo - (sueldo * 3 / 100);
        }else{
            txtDescuento.setText("Descuento: No");
        }
        if (salud) {
            txtSalud.setText("Salud: Sí");
            sueldo = sueldo - (sueldo * 4 / 100);
        }else{
            txtSalud.setText("Salud: No");
        }
        if (pension) {
            txtPension.setText("Pensión: Sí");
            sueldo = sueldo - (sueldo * 4 / 100);
        }else{
            txtPension.setText("Pensión: No");
        }
        txtTotal.setText("Sueldo Neto: " + sueldo);
    }
}