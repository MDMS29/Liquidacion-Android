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
        double valorDia = sueldo / 30;
        txtValorDia.setText("Valor x Día : \n $" + valorDia);

        double salarioNeto = sueldo;

        if (descuento) {
            double desc = (sueldo * 3 / 100);
            salarioNeto = salarioNeto - desc
            txtDescuento.setText("Descuento 3%: "+desc);
        }
        if (salud) {
            double sal = (sueldo * 4 / 100);
            salarioNeto = salarioNeto - sal
            txtSalud.setText("Salud 4%: "+sal);
        }
        if (pension) {
            double pen = (sueldo * 4 / 100);
            salarioNeto = salarioNeto - pen
            txtPension.setText("Pensión 4%: "+pen);
        }
        txtTotal.setText("Sueldo Neto: " + salarioNeto);
    }
}