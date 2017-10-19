package com.esteban.miscontactos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<contacto> contactos;
    private RecyclerView listaContactos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Toolbar miActionBar = (Toolbar)findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);*/

        listaContactos = (RecyclerView)findViewById(R.id.rvContactos);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaContactos.setLayoutManager(llm);

        /*GridLayoutManager glm = new GridLayoutManager(this,2);
        listaContactos.setLayoutManager(glm);*/
        inicializarListaContactos();
        inicializarAdaptador();
    }

    public void inicializarAdaptador(){
        ContactoAdaptador adaptador = new ContactoAdaptador(contactos,this);
        listaContactos.setAdapter(adaptador);
    }

    public void  inicializarListaContactos(){

        contactos = new ArrayList<contacto>();
        contactos.add(new contacto(R.drawable.uno,"Esteban Valencia", "3128553636", "esteban@hotmail.com"));
        contactos.add(new contacto(R.drawable.dos,"Erika Arias", "3136748616", "eriarias13@gmail.com"));
        contactos.add(new contacto(R.drawable.tres,"Teresa Cano", "2656576", "teresa@hotmail.com"));
        contactos.add(new contacto(R.drawable.cuatro,"Octavio Giraldo", "3154339835", "octaviogiraldoc@gmail.com"));
        contactos.add(new contacto(R.drawable.imagen,"Daniel Arias", "3135568897", "danieledu@gmail.com"));
    }


}
