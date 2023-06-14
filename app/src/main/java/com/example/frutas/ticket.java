package com.example.frutas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ticket extends AppCompatActivity {

    private TextView Fecha;
    private TextView Total;
    private ListView LVF1;
    private Button btnComprarF1;
    List<Contacto1> lst2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket);

        Fecha = (TextView) findViewById(R.id.Fecha);
        Total = (TextView) findViewById(R.id.Total);

        DateFormat FormatoF = new SimpleDateFormat("dd/MM/yyyy");
        Date datoF = new Date();
        String FechaActual = FormatoF.format(datoF);

        DateFormat FormatoH = new SimpleDateFormat("HH:mm:ss");
        Date datoH = new Date();
        String HoraActual = FormatoH.format(datoH);

        Fecha.setText("Hora: "+HoraActual+"      Fecha: "+FechaActual);


        LVF1 = (ListView) findViewById(R.id.LVF1);

        CustomAdapter1 adapter2 = new CustomAdapter1(this, GetData2());
        LVF1.setAdapter(adapter2);



        btnComprarF1 = (Button) findViewById(R.id.btnComprarF1);
        btnComprarF1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Compra Exitosa!", Toast.LENGTH_SHORT).show();
                Log.i("INFO:", "Ticket");
                restablecer();
                Intent intent = new Intent(ticket.this, MainActivity.class);
                startActivity(intent);
            }
        });




    }


    private List<Contacto1> GetData2() {
        lst2 = new ArrayList<>();

        SharedPreferences prfT = getSharedPreferences("Toronja1", Context.MODE_PRIVATE);
        String CantTo1 = prfT.getString("CantidadT", "0");
        int CantTo = Integer.parseInt(CantTo1);
        String PrecTo1 = prfT.getString("PrecioT", "0");
        float PrecTo = Float.parseFloat(PrecTo1);

        if (CantTo > 0) {
            lst2.add(new Contacto1(0, R.drawable.toronja, "Toronja", PrecTo1, CantTo1));
        }

        SharedPreferences prfM = getSharedPreferences("Manzana1", Context.MODE_PRIVATE);
        String CantMan1 = prfM.getString("CantidadM", "0");
        int CantMan = Integer.parseInt(CantMan1);
        String PrecMan1 = prfM.getString("PrecioM", "0");
        float PrecMan = Float.parseFloat(PrecMan1);

        if (CantMan > 0) {
            lst2.add(new Contacto1(1, R.drawable.manzana, "Manzana", PrecMan1, CantMan1));
        }

        SharedPreferences prfP = getSharedPreferences("Pera1", Context.MODE_PRIVATE);
        String CantPer1 = prfP.getString("CantidadP", "0");
        int CantPer = Integer.parseInt(CantPer1);
        String PrecPer1 = prfP.getString("PrecioP", "0");
        float PrecPer = Float.parseFloat(PrecPer1);

        if (CantPer > 0) {
            lst2.add(new Contacto1(2, R.drawable.pera, "Pera", PrecPer1, CantPer1));
        }

        SharedPreferences prfS = getSharedPreferences("Sandia1", Context.MODE_PRIVATE);
        String CantSan1 = prfS.getString("CantidadS", "0");
        int CantSan = Integer.parseInt(CantSan1);
        String PrecSan1 = prfS.getString("PrecioS", "0");
        float PrecSan = Float.parseFloat(PrecSan1);

        if (CantSan > 0) {
            lst2.add(new Contacto1(3, R.drawable.sandia, "Sandia", PrecSan1, CantSan1));
        }

        SharedPreferences prfPL = getSharedPreferences("Platano1", Context.MODE_PRIVATE);
        String CantPla1 = prfPL.getString("CantidadPL", "0");
        int CantPla = Integer.parseInt(CantPla1);
        String PrecPla1 = prfPL.getString("PrecioPL", "0");
        float PrecPla = Float.parseFloat(PrecPla1);

        if (CantPla > 0) {
            lst2.add(new Contacto1(4, R.drawable.platano, "Platano", PrecPla1, CantPla1));
        }

        SharedPreferences prfD = getSharedPreferences("Durazno1", Context.MODE_PRIVATE);
        String CantDur1 = prfD.getString("CantidadD", "0");
        int CantDur = Integer.parseInt(CantDur1);
        String PrecDur1 = prfD.getString("PrecioD", "0");
        float PrecDur = Float.parseFloat(PrecDur1);

        if (CantDur > 0) {
            lst2.add(new Contacto1(5, R.drawable.durazno, "Durazno", PrecDur1, CantDur1));
        }

        float PT = PrecTo + PrecMan + PrecPer + PrecSan + PrecPla + PrecDur;
        String PTF = String.valueOf(PT);

        Total.setText(PTF);

        return lst2;


    }

    private void restablecer () {
        SharedPreferences prfT = getSharedPreferences("Toronja1", Context.MODE_PRIVATE);
        SharedPreferences.Editor editToronja1 = prfT.edit();
        editToronja1.clear();
        editToronja1.apply();

        SharedPreferences prfM = getSharedPreferences("Manzana1", Context.MODE_PRIVATE);
        SharedPreferences.Editor editManzana1 = prfM.edit();
        editManzana1.clear();
        editManzana1.apply();

        SharedPreferences prfP = getSharedPreferences("Pera1", Context.MODE_PRIVATE);
        SharedPreferences.Editor editPera1 = prfP.edit();
        editPera1.clear();
        editPera1.apply();

        SharedPreferences prfS = getSharedPreferences("Sandia1", Context.MODE_PRIVATE);
        SharedPreferences.Editor editSandia1 = prfS.edit();
        editSandia1.clear();
        editSandia1.apply();

        SharedPreferences prfPL = getSharedPreferences("Platano1", Context.MODE_PRIVATE);
        SharedPreferences.Editor editPlatano1 = prfPL.edit();
        editPlatano1.clear();
        editPlatano1.apply();

        SharedPreferences prfD = getSharedPreferences("Durazno1", Context.MODE_PRIVATE);
        SharedPreferences.Editor editDurazno1 = prfD.edit();
        editDurazno1.clear();
        editDurazno1.apply();


    }


}