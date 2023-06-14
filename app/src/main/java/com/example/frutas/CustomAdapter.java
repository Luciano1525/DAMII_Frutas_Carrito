package com.example.frutas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends BaseAdapter {

    Context context;
    List<Contacto> lst;

    public CustomAdapter(Context context, List<Contacto> lst) {
        this.context = context;
        this.lst = lst;
    }

    @Override
    public int getCount(){
        return lst.size();
    }

    @Override
    public Object getItem(int i){
        return i;
    }

    @Override
    public long getItemId(int i){
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup){
        ImageView IVP;
        TextView TVP;
        TextView TVNP;
        Contacto c = lst.get(i);

        if(view==null){
            view = LayoutInflater.from(context).inflate(R.layout.listview_p, null);
            IVP = view.findViewById(R.id.IVP);
            TVP = view.findViewById(R.id.TVP);
            TVNP = view.findViewById(R.id.TVNP);

            IVP.setImageResource(c.IVP);
            TVP.setText(c.TVP);
            TVNP.setText(c.TVNP);
        }

        return view;
    }
}
