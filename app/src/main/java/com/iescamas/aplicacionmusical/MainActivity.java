package com.iescamas.aplicacionmusical;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.HashSet;

public class MainActivity extends AppCompatActivity {

    ArrayAdapter<CharSequence>adaptador;
    float puntuacion1 = 0;
    float puntuacion2 = 0;
    float puntuacion3 = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        noMostrarRating();
        adaptador = ArrayAdapter.createFromResource(this,R.array.sp_Elecciones, android.R.layout.simple_spinner_dropdown_item);
        ((Spinner) findViewById(R.id.sp_opciones)).setAdapter(adaptador);

        ((Spinner)findViewById(R.id.sp_opciones)).setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                eleccionArtistaMusica(i);
                //Comprobamos el id del boton si hay un cambio en el spinner
                int rbActualizado =((RadioGroup) findViewById(R.id.rg_elecciones)).getCheckedRadioButtonId();
                if(rbActualizado!=-1){
                    seleccionDiscos(rbActualizado);
                }

            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ((RadioGroup) findViewById(R.id.rg_elecciones)).setOnCheckedChangeListener((radioGroup, i) -> {
           seleccionDiscos(i);
        });

        findViewById(R.id.cb_disco1).setOnClickListener(view ->check(view,1));
        findViewById(R.id.cb_disco2).setOnClickListener(view ->check(view,2));
        findViewById(R.id.cb_disco3).setOnClickListener(view ->check(view,3));

        findViewById(R.id.btn_puntuacion).setOnClickListener(view ->mostrarMensaje(findViewById(R.id.rb1),
                findViewById(R.id.rb2),findViewById(R.id.rb3)));

    }

    private void noMostrarRating() {

       boolean estado = ((CheckBox) findViewById(R.id.cb_disco1)).isChecked();

       if(!estado){
           findViewById(R.id.rb1).setVisibility(View.INVISIBLE);

       }
       estado = ((CheckBox) findViewById(R.id.cb_disco2)).isChecked();
        if(!estado){
            findViewById(R.id.rb2).setVisibility(View.INVISIBLE);

        }
        estado = ((CheckBox) findViewById(R.id.cb_disco3)).isChecked();
        if(!estado){
            findViewById(R.id.rb3).setVisibility(View.INVISIBLE);

        }
    }
    private void eleccionArtistaMusica(int i){

        switch (i){
            case 0:
                ((RadioButton) findViewById(R.id.rb_eleccion1)).setText(R.string.rb_eleccion_1_1);
                ((RadioButton) findViewById(R.id.rb_eleccion2)).setText(R.string.rb_eleccion_1_2);
                ((RadioButton) findViewById(R.id.rb_elecion3)).setText(R.string.rb_eleccion_1_3);

                break;

            case 1:
                ((RadioButton) findViewById(R.id.rb_eleccion1)).setText(R.string.rb_eleccion_2_1);
                ((RadioButton) findViewById(R.id.rb_eleccion2)).setText(R.string.rb_eleccion_2_2);
                ((RadioButton) findViewById(R.id.rb_elecion3)).setText(R.string.rb_eleccion_2_3);
                break;

            case 2:
                ((RadioButton) findViewById(R.id.rb_eleccion1)).setText(R.string.rb_eleccion_3_1);
                ((RadioButton) findViewById(R.id.rb_eleccion2)).setText(R.string.rb_eleccion_3_2);
                ((RadioButton) findViewById(R.id.rb_elecion3)).setText(R.string.rb_eleccion_3_3);
                break;

        }

    }
    private void seleccionDiscos(int artista){

        if(artista == R.id.rb_eleccion1){

            if( ((RadioButton) findViewById (R.id.rb_eleccion1)).getText().toString().equals(getResources().getString(R.string.rb_eleccion_1_1))){
                ((CheckBox) findViewById(R.id.cb_disco1)).setText(R.string.cb_eleccion1_1);
                ((CheckBox) findViewById(R.id.cb_disco2)).setText(R.string.cb_eleccion1_2);
                ((CheckBox) findViewById(R.id.cb_disco3)).setText(R.string.cb_eleccion1_3);
            }
            else if( ((RadioButton) findViewById (R.id.rb_eleccion1)).getText().toString().equals(getResources().getString(R.string.rb_eleccion_2_1))){
                ((CheckBox) findViewById(R.id.cb_disco1)).setText(R.string.cb_eleccion4_1);
                ((CheckBox) findViewById(R.id.cb_disco2)).setText(R.string.cb_eleccion4_2);
                ((CheckBox) findViewById(R.id.cb_disco3)).setText(R.string.cb_eleccion4_3);
            }
            else{
                ((CheckBox) findViewById(R.id.cb_disco1)).setText(R.string.cb_eleccion7_1);
                ((CheckBox) findViewById(R.id.cb_disco2)).setText(R.string.cb_eleccion7_2);
                ((CheckBox) findViewById(R.id.cb_disco3)).setText(R.string.cb_eleccion7_3);

            }
        } else if (artista == R.id.rb_eleccion2) {
            if( ((RadioButton) findViewById (R.id.rb_eleccion2)).getText().toString().equals(getResources().getString(R.string.rb_eleccion_1_2))){
                ((CheckBox) findViewById(R.id.cb_disco1)).setText(R.string.cb_eleccion2_1);
                ((CheckBox) findViewById(R.id.cb_disco2)).setText(R.string.cb_eleccion2_2);
                ((CheckBox) findViewById(R.id.cb_disco3)).setText(R.string.cb_eleccion2_3);
            }
            else if( ((RadioButton) findViewById (R.id.rb_eleccion2)).getText().toString().equals(getResources().getString(R.string.rb_eleccion_2_2))){
                ((CheckBox) findViewById(R.id.cb_disco1)).setText(R.string.cb_eleccion5_1);
                ((CheckBox) findViewById(R.id.cb_disco2)).setText(R.string.cb_eleccion5_2);
                ((CheckBox) findViewById(R.id.cb_disco3)).setText(R.string.cb_eleccion5_3);
            }
            else{
                ((CheckBox) findViewById(R.id.cb_disco1)).setText(R.string.cb_eleccion8_1);
                ((CheckBox) findViewById(R.id.cb_disco2)).setText(R.string.cb_eleccion8_2);
                ((CheckBox) findViewById(R.id.cb_disco3)).setText(R.string.cb_eleccion8_3);

            }
        }
        else {
            if( ((RadioButton) findViewById (R.id.rb_elecion3)).getText().toString().equals(getResources().getString(R.string.rb_eleccion_1_3))){
                ((CheckBox) findViewById(R.id.cb_disco1)).setText(R.string.cb_eleccion3_1);
                ((CheckBox) findViewById(R.id.cb_disco2)).setText(R.string.cb_eleccion3_2);
                ((CheckBox) findViewById(R.id.cb_disco3)).setText(R.string.cb_eleccion3_3);
            }
            else if( ((RadioButton) findViewById (R.id.rb_elecion3)).getText().toString().equals(getResources().getString(R.string.rb_eleccion_2_3))){
                ((CheckBox) findViewById(R.id.cb_disco1)).setText(R.string.cb_eleccion6_1);
                ((CheckBox) findViewById(R.id.cb_disco2)).setText(R.string.cb_eleccion6_2);
                ((CheckBox) findViewById(R.id.cb_disco3)).setText(R.string.cb_eleccion6_3);
            }
            else{
                ((CheckBox) findViewById(R.id.cb_disco1)).setText(R.string.cb_eleccion9_1);
                ((CheckBox) findViewById(R.id.cb_disco2)).setText(R.string.cb_eleccion9_2);
                ((CheckBox) findViewById(R.id.cb_disco3)).setText(R.string.cb_eleccion9_3);

            }
        }

    }
    private void check(View v,int num){

        CheckBox cb = (CheckBox) v;

        switch (num){
            case 1:
                if (cb.isChecked()){
                    findViewById(R.id.rb1).setVisibility(View.VISIBLE);

                }
                else {
                    findViewById(R.id.rb1).setVisibility(View.INVISIBLE);
                    ((RatingBar)findViewById(R.id.rb1)).setRating(0);

                }
                break;
            case 2:
                if (cb.isChecked()){
                    findViewById(R.id.rb2).setVisibility(View.VISIBLE);

                }
                else {
                    findViewById(R.id.rb2).setVisibility(View.INVISIBLE);
                    ((RatingBar)findViewById(R.id.rb2)).setRating(0);

                }
                break;

            case 3:
                if (cb.isChecked()){
                    findViewById(R.id.rb3).setVisibility(View.VISIBLE);

                }
                else {
                    findViewById(R.id.rb3).setVisibility(View.INVISIBLE);
                    ((RatingBar)findViewById(R.id.rb3)).setRating(0);
                }
                break;
        }
    }
    private void mostrarMensaje(RatingBar rb1,RatingBar rb2, RatingBar rb3){

        String mensaje = "",disco1,disco2,disco3;
        disco1 = ((CheckBox) findViewById(R.id.cb_disco1)).getText().toString();
        disco2 = ((CheckBox) findViewById(R.id.cb_disco2)).getText().toString();
        disco3 = ((CheckBox) findViewById(R.id.cb_disco3)).getText().toString();

        rb1.setOnRatingBarChangeListener((ratingBar, v, b) -> puntuacion1=v);
        rb2.setOnRatingBarChangeListener((ratingBar, v, b) -> puntuacion2=v);
        rb3.setOnRatingBarChangeListener((ratingBar, v, b) -> puntuacion3=v);

        puntuacion1 = rb1.getRating();
        puntuacion2 = rb2.getRating();
        puntuacion3 = rb3.getRating();

        if(puntuacion1==0 && puntuacion2==0 && puntuacion3==0){
            mensaje="No realizaron votos";
        }
        else{
            if(puntuacion1!=0){
                mensaje+= disco1 + " tiene una puntuacion de " +puntuacion1 +"\n";

            }
            if (puntuacion2!=0){
                mensaje+= disco2 + " tiene una puntuacion de " +puntuacion2 +"\n";

            }
            if (puntuacion3!=0){
                mensaje+= disco3 + " tiene una puntuacion de " +puntuacion3;

            }
        }
        ((TextView)findViewById(R.id.lbl_infomarcion)).setText(mensaje);
        ponerACero(rb1,rb2,rb3);



    }
    private void ponerACero(RatingBar rb1,RatingBar rb2, RatingBar rb3){
        rb1.setRating(0);
        rb2.setRating(0);
        rb3.setRating(0);
        ((CheckBox) findViewById(R.id.cb_disco1)).setChecked(false);
        ((CheckBox) findViewById(R.id.cb_disco2)).setChecked(false);
        ((CheckBox) findViewById(R.id.cb_disco3)).setChecked(false);
        findViewById(R.id.rb1).setVisibility(View.INVISIBLE);
        findViewById(R.id.rb2).setVisibility(View.INVISIBLE);
        findViewById(R.id.rb3).setVisibility(View.INVISIBLE);

    }





    
}