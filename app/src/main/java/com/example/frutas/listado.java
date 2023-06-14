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
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class listado extends AppCompatActivity {
    ListView LVF;
    List<Contacto1> lst1;
    private Button btnComprarF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);
        LVF = (ListView) findViewById(R.id.LVF);

        CustomAdapter1 adapter1 = new CustomAdapter1(this, GetData1());
        LVF.setAdapter(adapter1);


        btnComprarF = (Button) findViewById(R.id.btnComprarF);
        btnComprarF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Compra Exitosa!", Toast.LENGTH_SHORT).show();
                Log.i("INFO:", "Ticket");
                Intent intent = new Intent(listado.this, ticket.class);
                startActivity(intent);
            }
        });

    }

    private List<Contacto1> GetData1(){
        lst1 = new ArrayList<>();

        SharedPreferences prfT = getSharedPreferences("Toronja1", Context.MODE_PRIVATE);
        String CantTo1 = prfT.getString("CantidadT", "0");
        int CantTo = Integer.parseInt(CantTo1);

        if (CantTo>0){
            String PrecTo1 = prfT.getString("PrecioT", "0");
            lst1.add(new Contacto1(0, R.drawable.toronja, "Toronja", PrecTo1, CantTo1));
        }

        SharedPreferences prfM = getSharedPreferences("Manzana1", Context.MODE_PRIVATE);
        String CantMan1 = prfM.getString("CantidadM", "0");
        int CantMan = Integer.parseInt(CantMan1);

        if (CantMan>0){
            String PrecMan1 = prfM.getString("PrecioM", "0");
            lst1.add(new Contacto1(1, R.drawable.manzana, "Manzana", PrecMan1, CantMan1));
        }

        SharedPreferences prfP = getSharedPreferences("Pera1", Context.MODE_PRIVATE);
        String CantPer1 = prfP.getString("CantidadP", "0");
        int CantPer = Integer.parseInt(CantPer1);

        if (CantPer>0){
            String PrecPer1 = prfP.getString("PrecioP", "0");
            lst1.add(new Contacto1(2, R.drawable.pera, "Pera", PrecPer1, CantPer1));
        }

        SharedPreferences prfS = getSharedPreferences("Sandia1", Context.MODE_PRIVATE);
        String CantSan1 = prfS.getString("CantidadS", "0");
        int CantSan = Integer.parseInt(CantSan1);

        if (CantSan>0){
            String PrecSan1 = prfS.getString("PrecioS", "0");
            lst1.add(new Contacto1(3, R.drawable.sandia, "Sandia", PrecSan1, CantSan1));
        }

        SharedPreferences prfPL = getSharedPreferences("Platano1", Context.MODE_PRIVATE);
        String CantPla1 = prfPL.getString("CantidadPL", "0");
        int CantPla = Integer.parseInt(CantPla1);

        if (CantPla>0){
            String PrecPla1 = prfPL.getString("PrecioPL", "0");
            lst1.add(new Contacto1(4, R.drawable.platano, "Platano", PrecPla1, CantPla1));
        }

        SharedPreferences prfD = getSharedPreferences("Durazno1", Context.MODE_PRIVATE);
        String CantDur1 = prfD.getString("CantidadD", "0");
        int CantDur = Integer.parseInt(CantDur1);

        if (CantDur>0){
            String PrecDur1 = prfD.getString("PrecioD", "0");
            lst1.add(new Contacto1(5, R.drawable.durazno, "Durazno", PrecDur1, CantDur1));
        }

        return lst1;
    }
}