package ifnoticias.com.br.ifnoticias;

/**
 * Created by Pedro on 26/03/2017.
 */

public class Noticia {
    private String nome;
    private String url;
    private String titulo;
    private String conteudo;
    private String htmlId;
    private String htmlClasse;
    private String data;

    public Noticia(String nome, String url, String titulo, String conteudo) {
        this.nome = nome;
        this.url = url;
        this.titulo = titulo;
        this.conteudo = conteudo;
    }

    public Noticia(String nome){
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getHtmlId() {
        return htmlId;
    }

    public void setHtmlId(String htmlId) {
        this.htmlId = htmlId;
    }

    public String getHtmlClasse() {
        return htmlClasse;
    }

    public void setHtmlClasse(String htmlClasse) {
        this.htmlClasse = htmlClasse;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return nome;
    }
}
