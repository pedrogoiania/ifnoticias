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

    private ArrayList<Noticia> noticias = new ArrayList<>();

    public CapturaNoticia(ArrayList<Noticia> noticias) {
        this.noticias = noticias;
    }

    public void capturaNoticias(Elements div){
        Elements manchete = div.select(".row-fluid");

        Elements p = new Elements();
        Elements h1 = new Elements();
        Elements h2 = new Elements();
        Elements a = new Elements();



        for(Element e : manchete.select(".span4")){
            p = e.select("p");
            h1 = e.select("h1");
            h2 = e.select("h2");
            a = e.getElementsByTag("a");

            if(p.size() > 1){
                String categoria = p.get(0).text();
                String titulo = "";
                if(h1.size() > 0){
                   titulo =  h1.get(0).text();
                }else{
                   titulo =  h2.get(0).text();
                }
                String conteudo =  p.get(2).text();
                String url = a.attr("href").toString();

                Noticia noticia = new Noticia(categoria,url,titulo,conteudo);

                this.noticias.add(noticia);
            }
        }
    }

    public void capturaComunicado(Elements div){
        Elements rowFluid = div.select(".row-fluid");

        Elements lista = rowFluid.select(".lista");

        System.out.println(lista.size());

        Elements h4 = new Elements();
        Elements a = new Elements();

        for(Element e : lista.get(1).select(".span12")){
            h4 = e.select("h4");
            a = e.getElementsByTag("a");
            System.out.println(h4.text().toString());
            System.out.println(a.text().toString());


            if(h4.size() == 1){
                String categoria =h4.text();;
                String titulo = "";
                titulo =  h4.text();
                String conteudo =  h4.text();
                String url = a.attr("href").toString();
                System.out.println(a.attr("href").toString());
                Noticia noticia = new Noticia(categoria,url,titulo,conteudo);

                this.noticias.add(noticia);
            }
        }
    }

    public void capturaEventos(Elements div){
        Elements rowFluid = div.select(".row-fluid");

        Elements lista = rowFluid.select(".lista");

        System.out.println(lista.size());

        Elements h4 = new Elements();
        Elements a = new Elements();

        for(Element e : lista.get(0).select(".span12")){
            h4 = e.select("h4");
            a = e.getElementsByTag("a");
            System.out.println(h4.text().toString());
            System.out.println(a.text().toString());


            if(h4.size() == 1){
                String categoria =h4.text();;
                String titulo = "";
                titulo =  h4.text();
                String conteudo =  h4.text();
                String url = a.attr("href").toString();
                System.out.println(a.attr("href").toString());
                Noticia noticia = new Noticia(categoria,url,titulo,conteudo);

                this.noticias.add(noticia);
            }
        }
    }

    public ArrayList<Noticia> getNoticias() {
        return noticias;
    }

    public void setNoticias(ArrayList<Noticia> noticias) {
        this.noticias = noticias;
    }
}
