package com.example.listview;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView lista;
    private TextView texto;
    private RadioButton radioButton_pulsado;

    public class Encapsulador {
        private int imagen;
        private String titulo;
        private String texto;
        private boolean dato1;

        public Encapsulador(int idImagen, String textoTitulo, String textoContenido, boolean favorito) {
            this.imagen = idImagen;
            this.titulo = textoTitulo;
            this.texto = textoContenido;
            this.dato1 = favorito;
        }

        public String get_textoTitulo() {
            return titulo;
        }

        public String get_textoContenido() {
            return texto;
        }

        public int get_idImagen() {
            return imagen;
        }

        public boolean get_checkBox1() {
            return dato1;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = findViewById(R.id.listView);
        texto = findViewById(R.id.textFooter);

        ArrayList<Encapsulador> datos = new ArrayList<>();
        datos.add(new Encapsulador(R.drawable.softgrey, "Soft Grey and Harbor Blue", "\n" + "Air Force 1 Low x Stash", false));
        datos.add(new Encapsulador(R.drawable.darkmocha, "Black and Dark Mocha", "\n" + "CJ1 T-Rexx", false));
        datos.add(new Encapsulador(R.drawable.varsitykobe, "Varsity Maize and Varsity Purple", "\n" + "Air Force 1 Low x Kobe", false));
        datos.add(new Encapsulador(R.drawable.moonlight, "Moonlight", "\n" + "\n" + "Nike Air Max Plus", false));
        datos.add(new Encapsulador(R.drawable.wyws, "W.Y.W.S.", "\n" + "\n" + "Air Force 1 '07 x A Ma Maniére", false));
        datos.add(new Encapsulador(R.drawable.blackcement, "Black Cement", "\n" + "\n" + "Air Jordan 3", false));
        datos.add(new Encapsulador(R.drawable.whitemidnight, "White and Midnight Navy", "\n" + "\n" + "Nike Us Force 1", false));
        datos.add(new Encapsulador(R.drawable.russetsunset, "Russet and Sunset", "\n" + "\n" + "Air Force 1 '07 LV8", false));
        datos.add(new Encapsulador(R.drawable.gameroyal, "Game Royal", "\n" + "\n" + "Air Jordan 1 Low", false));
        datos.add(new Encapsulador(R.drawable.firfirered, "Fir and Fire Red", "\n" + "\n" + "Nike SB Dunk Low", false));

        lista.setAdapter(new Adaptador(this, R.layout.entrada, datos) {
            @Override
            public void onEntrada(Object entrada, View view) {
                if (entrada != null) {
                    TextView texto_superior_entrada = view.findViewById(R.id.texto_titulo);
                    TextView texto_inferior_entrada = view.findViewById(R.id.texto_datos);
                    ImageView imagen_entrada = view.findViewById(R.id.imagen);
                    RadioButton miRadio = view.findViewById(R.id.boton);

                    Encapsulador encapsulador = (Encapsulador) entrada;
                    texto_superior_entrada.setText(encapsulador.get_textoTitulo());
                    texto_inferior_entrada.setText(encapsulador.get_textoContenido());
                    imagen_entrada.setImageResource(encapsulador.get_idImagen());

                    miRadio.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (radioButton_pulsado != null) {
                                radioButton_pulsado.setChecked(false);
                            }
                            radioButton_pulsado = (RadioButton) v;
                            texto.setText("MARCADA UNA OPCIÓN");
                        }
                    });
                }
            }
        });
    }
}