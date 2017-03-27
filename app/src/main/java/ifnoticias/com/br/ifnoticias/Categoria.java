package ifnoticias.com.br.ifnoticias;

/**
 * Created by Pedro on 26/03/2017.
 */

public class Categoria {

    private String nome;
    private String url;
    private String htmlId;
    private String htmlClasse;

    public Categoria(String nome, String url, String htmlId, String htmlClasse) {
        this.nome = nome;
        this.url = url;
        this.htmlId = htmlId;
        this.htmlClasse = htmlClasse;
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

    @Override
    public String toString() {
        return "Categoria{" +
                "nome='" + nome + '\'' +
                ", url='" + url + '\'' +
                ", htmlId='" + htmlId + '\'' +
                ", htmlClasse='" + htmlClasse + '\'' +
                '}';
    }
}
