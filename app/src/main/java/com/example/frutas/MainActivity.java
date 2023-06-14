package com.example.frutas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView LV;
    TextView TV, TVS;
    List<Contacto> lst;

    String infop[] = {
            " agregado al carrito.",
            " agregado al carrito.",
            " agregado al carrito.",
            " agregado al carrito.",
            " agregado al carrito. ",
            " agregado al carrito."
    };

    private ImageButton IBC;
    private String T, M, P, S, PL, D;
    //Precio sumado
    private float PT = 22, PM = 15, PP = 20, PS = 35, PPL = 25, PD = 21;
    private float SPT1 = 0, SPM1 = 0, SPP1 = 0, SPS1 = 0, SPPL1 = 0, SPD1 = 0;
    //Cantidad de Producto
    private int CT1 = 0, CM1 = 0, CP1 = 0, CS1 = 0, CPL1 = 0, CD1 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LV = (ListView) findViewById(R.id.LV);
        TV = (TextView) findViewById(R.id.TV);
        TVS = (TextView) findViewById(R.id.TVS);

        CustomAdapter adapter = new CustomAdapter(this, GetData());
        LV.setAdapter(adapter);

        LV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Contacto c = lst.get(position);
                TV.setText(c.TVP + infop[position]);
                TVS.setText(c.TVP);
                guardarPreference();


            }
        });

        IBC = (ImageButton) findViewById(R.id.IBC);
        IBC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,listado.class);
                startActivity(intent);
            }
        });

    }

    private List<Contacto> GetData(){
        lst = new ArrayList<>();


        lst.add(new Contacto(0, R.drawable.toronja, "Toronja","$ 22.00"));
        lst.add(new Contacto(1, R.drawable.manzana, "Manzana","$ 15.00"));
        lst.add(new Contacto(2, R.drawable.pera, "Pera","$ 20.00"));
        lst.add(new Contacto(3, R.drawable.sandia, "Sandia","$ 35.00"));
        lst.add(new Contacto(4, R.drawable.platano, "Platano","$ 25.00"));
        lst.add(new Contacto(5, R.drawable.durazno, "Durazno","$ 21.00"));

        return lst;
    }

    private void guardarPreference() {
        String fs = TVS.getText().toString();
        if (fs.equals("Toronja")){
            SharedPreferences prfT = getSharedPreferences("Toronja1", Context.MODE_PRIVATE);
            CT1 = CT1 + 1;
            SPT1 = SPT1 + PT;
            T = fs;
            String CT = String.valueOf(CT1);
            String SPT = String.valueOf(SPT1);

            SharedPreferences.Editor editToronja = prfT.edit();
            editToronja.putString("Toronjas", T.toString());
            editToronja.putString("CantidadT", CT.toString());
            editToronja.putString("PrecioT", SPT.toString());
            editToronja.commit();
            Toast.makeText(getApplicationContext(), "Cantidad Agregada ", Toast.LENGTH_SHORT).show();

        } else if(fs.equals("Manzana")) {
            SharedPreferences prfM = getSharedPreferences("Manzana1", Context.MODE_PRIVATE);
            CM1 = CM1 + 1;
            SPM1 = SPM1 + PM;
            M = fs;
            String CM = String.valueOf(CM1);
            String SPM = String.valueOf(SPM1);

            SharedPreferences.Editor editManzana = prfM.edit();
            editManzana.putString("Manzanas", M.toString());
            editManzana.putString("CantidadM", CM.toString());
            editManzana.putString("PrecioM", SPM.toString());
            editManzana.commit();
            Toast.makeText(getApplicationContext(), "Cantidad Agregada ", Toast.LENGTH_SHORT).show();

        } else if(fs.equals("Pera")) {
            SharedPreferences prfP = getSharedPreferences("Pera1", Context.MODE_PRIVATE);
            CP1 = CP1 + 1;
            SPP1 = SPP1 + PP;
            P = fs;
            String CP = String.valueOf(CP1);
            String SPP = String.valueOf(SPP1);

            SharedPreferences.Editor editPera = prfP.edit();
            editPera.putString("Peras", P.toString());
            editPera.putString("CantidadP", CP.toString());
            editPera.putString("PrecioP", SPP.toString());
            editPera.commit();
            Toast.makeText(getApplicationContext(), "Cantidad Agregada ", Toast.LENGTH_SHORT).show();

        } else if(fs.equals("Sandia")) {
            SharedPreferences prfS = getSharedPreferences("Sandia1", Context.MODE_PRIVATE);
            CS1 = CS1 + 1;
            SPS1 = SPS1 + PS;
            S = fs;
            String CS = String.valueOf(CS1);
            String SPS = String.valueOf(SPS1);

            SharedPreferences.Editor editSandia = prfS.edit();
            editSandia.putString("Sandias", S.toString());
            editSandia.putString("CantidadS", CS.toString());
            editSandia.putString("PrecioS", SPS.toString());
            editSandia.commit();
            Toast.makeText(getApplicationContext(), "Cantidad Agregada ", Toast.LENGTH_SHORT).show();

        } else if(fs.equals("Platano")) {
            SharedPreferences prfPL = getSharedPreferences("Platano1", Context.MODE_PRIVATE);
            CPL1 = CPL1 + 1;
            SPPL1 = SPPL1 + PPL;
            PL = fs;
            String CPL = String.valueOf(CPL1);
            String SPPL = String.valueOf(SPPL1);

            SharedPreferences.Editor editPlatano = prfPL.edit();
            editPlatano.putString("Platanos", PL.toString());
            editPlatano.putString("CantidadPL", CPL.toString());
            editPlatano.putString("PrecioPL", SPPL.toString());
            editPlatano.commit();
            Toast.makeText(getApplicationContext(), "Cantidad Agregada ", Toast.LENGTH_SHORT).show();

        } else if(fs.equals("Durazno")) {
            SharedPreferences prfD = getSharedPreferences("Durazno1", Context.MODE_PRIVATE);
            CD1 = CD1 + 1;
            SPD1 = SPD1 + PD;
            D = fs;
            String CD = String.valueOf(CD1);
            String SPD = String.valueOf(SPD1);

            SharedPreferences.Editor editDurazno = prfD.edit();
            editDurazno.putString("Duraznos", D.toString());
            editDurazno.putString("CantidadD", CD.toString());
            editDurazno.putString("PrecioD", SPD.toString());
            editDurazno.commit();
            Toast.makeText(getApplicationContext(), "Cantidad Agregada ", Toast.LENGTH_SHORT).show();

        }

    }

}