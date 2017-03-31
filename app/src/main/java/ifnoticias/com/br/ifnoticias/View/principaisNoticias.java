package ifnoticias.com.br.ifnoticias.View;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Paint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;

import ifnoticias.com.br.ifnoticias.Controller.CapturaNoticia;
import ifnoticias.com.br.ifnoticias.Model.Noticia;
import ifnoticias.com.br.ifnoticias.R;

public class principaisNoticias extends Activity {

    private ListView listaCategorias;
    private ArrayList<Noticia> noticias = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principais_noticias);
        listaCategorias = (ListView) findViewById(R.id.listViewId);
        new ParsePage().execute();
    }

    class ParsePage extends AsyncTask<String,Void,String> {

        CapturaNoticia capturaNoticia = new CapturaNoticia();

        @Override
        protected String doInBackground(String... params) {
            Document doc;
            try{
                doc = Jsoup.connect("http://www.ifg.edu.br").get();
                Elements div = doc.select("div");

                capturaNoticia.capturaTitulo(div);
            }catch (IOException e){
                e.printStackTrace();
            }
            return "rodou";
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            Log.d("POST EXECUTE: ", "onPostExecute: rodou no seleciona categoria");

            ArrayAdapter<Noticia> adaptador = new ArrayAdapter<Noticia>(
                    getApplicationContext(),
                    android.R.layout.simple_list_item_1,
                    android.R.id.text1 ,
                    noticias
            );

            listaCategorias.setAdapter(adaptador);

            listaCategorias.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    int codigoPosicao = position;
                    Noticia noticia = (Noticia) listaCategorias.getItemAtPosition(codigoPosicao);
                    Intent intent = new Intent(principaisNoticias.this, visualizaNoticia.class);
                    intent.putExtra("titulo", noticia.getTitulo());
                    intent.putExtra("conteudo", noticia.getConteudo());
                    intent.putExtra("url", noticia.getUrl());

                    startActivity(intent);
                }
            });
        }
    }

}
