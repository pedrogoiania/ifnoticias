package ifnoticias.com.br.ifnoticias;

import android.app.Activity;
import android.content.Intent;
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

public class principaisNoticias extends Activity {

    private ListView listaCategorias;

    ArrayList<Noticia> noticias = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principais_noticias);
        listaCategorias = (ListView) findViewById(R.id.listViewId);
        new ParsePage().execute();
    }

    class ParsePage extends AsyncTask<String,Void,String> {

        Elements elements = new Elements();

        @Override
        protected String doInBackground(String... params) {
            Document doc;
            try{
                doc = Jsoup.connect("http://www.ifg.edu.br").get();
                //Capturando principais noticias
                elements = doc.getElementsByClass("contentpaneopen");
                for(Element e : elements){
                    String nome = e.getElementsByTag("h2").text();
                    String url = e.getElementsByTag("a").attr("href").toString();
                    Elements conteudoSpan = e.getElementsByTag("p");
                    String conteudo = "";
                    String titulo = "";

                    if(conteudoSpan.size() == 2){
                       titulo= conteudoSpan.get(0).text().toString();
                       conteudo=conteudoSpan.get(1).text().toString();
                    }

                    if(nome!="" && url!="" && titulo!=""){
                        Noticia noticia = new Noticia(nome,url,titulo,conteudo);
                        noticias.add(noticia);
                    }

                }
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
