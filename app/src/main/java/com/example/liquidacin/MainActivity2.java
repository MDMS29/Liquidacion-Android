package com.example.liquidacin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity2 extends AppCompatActivity {
    private EditText etNombres, etApellidos, etSueldo, etDiasLab, etCargo;
    private CheckBox chkDescuento, chkSalud, chkPension;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button btnLiquidar = findViewById(R.id.btnLiquidar);
        Button btnRegresar = findViewById(R.id.btnRegresar);

        etNombres = findViewById(R.id.etNombres);
        etApellidos = findViewById(R.id.etApellidos);
        etCargo = findViewById(R.id.etCargo);
        etSueldo = findViewById(R.id.etSueldo);
        etDiasLab = findViewById(R.id.etDiasLab);

        chkDescuento = findViewById(R.id.chkDescuento);
        chkSalud = findViewById(R.id.chkSalud);
        chkPension = findViewById(R.id.chkPension);

        btnLiquidar.setOnClickListener(view -> liquidar());

        btnRegresar.setOnClickListener(view -> startActivity(new Intent(MainActivity2.this, MainActivity.class)));
    }

    public void liquidar() {
        String nombres = etNombres.getText().toString();
        String apellidos = etApellidos.getText().toString();
        String cargo = etCargo.getText().toString();
        double sueldo = Double.parseDouble(etSueldo.getText().toString());
        int diasLaborados = Integer.parseInt(etDiasLab.getText().toString());
        boolean tieneDescuento = chkDescuento.isChecked();
        boolean tieneSalud = chkSalud.isChecked();
        boolean tienePension = chkPension.isChecked();
        if ( (etNombres.getText().toString().equals("")) ||( etApellidos.getText().toString().equals("")) || (etCargo.getText().toString().equals("")) || (etSueldo.getText().toString().equals(""))){
            Toast.makeText(this, "¡Debe llenar todos los campos!", Toast.LENGTH_SHORT).show();
        }else{
            Intent intent = new Intent(this, MainActivity3.class);
            intent.putExtra("nombres", nombres);
            intent.putExtra("apellidos", apellidos);
            intent.putExtra("cargo", cargo);
            intent.putExtra("sueldo", sueldo);
            intent.putExtra("diasLab", diasLaborados);
            intent.putExtra("descuento", tieneDescuento);
            intent.putExtra("salud", tieneSalud);
            intent.putExtra("pension", tienePension);

            startActivity(intent);
        }
    }
}