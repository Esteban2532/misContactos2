package com.esteban.miscontactos;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
/**
 * Created by Esteban on 16/10/2017.
 */

public class ContactoAdaptador  extends RecyclerView.Adapter<ContactoAdaptador.ContactoViewHolder>{


    ArrayList<contacto> contactos;
    Activity activity;

    public ContactoAdaptador(ArrayList<contacto> contactos, Activity activity){
        this.contactos = contactos;
        this.activity = activity;
    }
    @Override//Va a inflar el layout y lo pasara al viewholder para que el obtenga los view
    public ContactoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_contacto, parent, false);
        return new ContactoViewHolder(v);
    }

    //asocia cada elemento de la lista con cada view
    @Override
    public void onBindViewHolder(ContactoViewHolder contactoViewHolder, int position) {
        final contacto contacto = contactos.get(position);

        contactoViewHolder.imgFoto.setImageResource(contacto.getFoto());
        contactoViewHolder.tvNombreCV.setText(contacto.getNombre());
        contactoViewHolder.tvTelefonoCV.setText(contacto.getTelefono());

        contactoViewHolder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Diste like a " + contacto.getNombre(), Toast.LENGTH_SHORT).show();
            }
        });

        contactoViewHolder.imgFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, contacto.getNombre(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(activity,DetalleContacto.class);

                intent.putExtra("nombre", contacto.getNombre());
                intent.putExtra("telefono", contacto.getTelefono());
                intent.putExtra("email", contacto.getEmail());

                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {//cantidad de elementos que contiene mi lista
        return contactos.size();

    }

    public static class ContactoViewHolder extends RecyclerView.ViewHolder {

         private ImageView imgFoto;
         private TextView tvNombreCV;
         private TextView tvTelefonoCV;
         private ImageButton btnLike;


         public ContactoViewHolder(View itemView) {
             super(itemView);

             imgFoto        = (ImageView) itemView .findViewById(R.id.imgFoto);
             tvNombreCV     = (TextView) itemView.findViewById(R.id.tvnombreCV);
             tvTelefonoCV   = (TextView) itemView.findViewById(R.id.tvtelefonoCV);
             btnLike        = (ImageButton) itemView.findViewById(R.id.btnLike);




         }
     }

}
