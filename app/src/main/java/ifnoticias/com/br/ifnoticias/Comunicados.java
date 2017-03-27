package ifnoticias.com.br.ifnoticias;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Comunicados extends Activity {

//    Document doc;
//    doc = Jsoup.connect("http://ifg.edu.br").get();
//
//    //Capturando categorias
//    //Capturando categoria comunicados
//    Element element = doc.getElementById("Mod25");
//    String nomeCategoria = element.getElementsByClass("show").text().toString();
//                Log.d("Elements ", nomeCategoria);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comunicados);
    }
}
