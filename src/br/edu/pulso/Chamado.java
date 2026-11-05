package br.edu.pulso;

public class Chamado {
    private final int id;
    private final String titulo;
    private final String setor;
    private final String prioridade;
    private final String status;

    public Chamado(int id, String titulo, String setor, String prioridade, String status) {
        this.id = id;
        this.titulo = titulo;
        this.setor = setor;
        this.prioridade = prioridade;
        this.status = status;
    }

    public int getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getSetor() { return setor; }
    public String getPrioridade() { return prioridade; }
    public String getStatus() { return status; }

    public String toJson() {
        return "{\"id\":" + id + ",\"titulo\":\"" + jsonEscape(titulo) +
            "\",\"setor\":\"" + jsonEscape(setor) +
            "\",\"prioridade\":\"" + jsonEscape(prioridade) +
            "\",\"status\":\"" + jsonEscape(status) + "\"}";
    }

    private static String jsonEscape(String s) {
        return s.replace("\\", "\\\\").replace("\"", "\\\"").replace("\n", "\\n");
    }
}
