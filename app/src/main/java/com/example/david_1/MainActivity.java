package com.example.david_1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    EditText jetcantidad;
    TextView jtvcelular,jtvdescuento, jtvtotal;
    RadioButton jrbiphone14,jrbiphone13,jrbiphone12;
    CheckBox jcbseguro,jcbaccesorio;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();
        jetcantidad=findViewById(R.id.etcantidad);
        jtvcelular=findViewById(R.id.tvcelular);
        jtvdescuento=findViewById(R.id.tvdescuento);
        jtvtotal=findViewById(R.id.tvtotal);
        jrbiphone14=findViewById(R.id.rbiphone14);
        jrbiphone13=findViewById(R.id.rbiphone13);
        jrbiphone12=findViewById(R.id.rbiphone12);
        jcbseguro=findViewById(R.id.cbseguro);
        jcbaccesorio = findViewById(R.id.cbaccesorio);
    }

    public void Calcular_valor(View view){
        String cantidad_personas=jetcantidad.getText().toString();
        if (cantidad_personas.isEmpty()){
            Toast.makeText(this, "La cantidad de celulares es requerida", Toast.LENGTH_SHORT).show();
            jetcantidad.requestFocus();
        }
        else{
            int cantidad,valor_celular,descuento = 0,valor_total,valor_opcional,accesorio;
            cantidad= Integer.parseInt(cantidad_personas);

            if (cantidad < 1){
                Toast.makeText(this, "La cantidad mínima requerida es 1", Toast.LENGTH_SHORT).show();
                jetcantidad.requestFocus();
            }
            else{
                if (jrbiphone14.isChecked()){
                    jtvcelular.setText("5000000");
                    valor_celular=5000000;
                }
                else{
                    if (jrbiphone13.isChecked()){
                        jtvcelular.setText("3500000");
                        valor_celular=3500000;
                    }
                    else {
                        jtvcelular.setText("2500000");
                        valor_celular=2500000;
                    }
                }

                if (cantidad <3){
                    jtvdescuento.setText("0%");
                    descuento= 0;

                }
                else {
                    if (cantidad >= 3 && cantidad <= 8){
                        jtvdescuento.setText("20%");
                        descuento= (valor_celular * cantidad)*20/100;

                    }
                    else {
                        if (cantidad >= 9) {
                            jtvdescuento.setText("30%");
                            descuento = (valor_celular * cantidad) * 30 / 100;

                        }
                    }
                }

                if (jcbseguro.isChecked()){

                    valor_opcional= cantidad * 300000;

                }
                else {

                    valor_opcional= 0;

                }

                if(jcbaccesorio.isChecked()){
                    accesorio = cantidad * 20000;

                }else{
                    accesorio = 0;
                }



                valor_total= (valor_celular * cantidad) - descuento + valor_opcional + accesorio;
                jtvtotal.setText(String.valueOf(valor_total));

            }
        }

    }

    public void LimpiarDatos(View view){
        //System.out.println("El codigo pasa por aqui");
        jrbiphone14.setChecked(true);
        jcbseguro.setChecked(false);
        jcbaccesorio.setChecked(false);
        jtvdescuento.setText("Descuento");
        jtvcelular.setText("5000000");
        jtvtotal.setText("0");
        jetcantidad.setText("");
        jetcantidad.requestFocus();
    }

}



