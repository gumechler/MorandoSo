package morandoso.android.com;

public class alimentacao_feed {
    private String titulo;
    private String descricao;
    private String url;
    private String imagem;

    public alimentacao_feed(String titulo, String descricao, String url, String imagem) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.url = url;
        this.imagem = imagem;
    }

    public alimentacao_feed(){

    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
}
