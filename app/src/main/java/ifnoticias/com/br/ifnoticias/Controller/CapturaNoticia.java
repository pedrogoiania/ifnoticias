package ifnoticias.com.br.ifnoticias.Controller;

import android.widget.ListView;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

import ifnoticias.com.br.ifnoticias.Model.Noticia;

/**
 * Created by Pedro on 31/03/2017.
 */

public class CapturaNoticia {

    private ListView listaCategorias;
    private ArrayList<Noticia> noticias = new ArrayList<>();

    public CapturaNoticia() {
    }

    public CapturaNoticia(ListView listaCategorias, ArrayList<Noticia> noticias) {
        this.listaCategorias = listaCategorias;
        this.noticias = noticias;
    }

    public String capturaTitulo(Elements div){
        String titulo = "";

        Elements manchete = div.select(".row-fluid");

        Elements p = new Elements();
        Elements h1 = new Elements();
        Elements h2 = new Elements();
        Elements href = new Elements();

        for(Element e : manchete.select(".span4")){
            p = e.select("p");
            h1 = e.select("h1");
            h2 = e.select("h2");
            href = e.select("a[href]");

            if(p.size() > 1){
                System.out.println("Categoria: " + p.get(0).text());
                if(h1.size() > 0){
                    System.out.println("Titulo: " + h1.get(0).text());
                }else{
                    System.out.println("Titulo: " + h2.get(0).text());
                }
                System.out.println("Conteudo: " + p.get(2).text());
                System.out.println("URL: " + href.text());
            }
        }
        return titulo;
    }

    public ListView getListaCategorias() {
        return listaCategorias;
    }

    public void setListaCategorias(ListView listaCategorias) {
        this.listaCategorias = listaCategorias;
    }

    public ArrayList<Noticia> getNoticias() {
        return noticias;
    }

    public void setNoticias(ArrayList<Noticia> noticias) {
        this.noticias = noticias;
    }
}
