/*
Trabalho de Teoria dos Grafos
Equipe: Antonio Celestino, Nathan Manera, Pedro Ferreira e Rafael Paiva
Professor: Daves Martins
4º Período BSI - IF Sudeste MG Juiz de Fora
 */
package grafosxml;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;


@XStreamAlias("edge")
public class Aresta {
    @XStreamAlias("source")
    @XStreamAsAttribute
    private String origem;
    @XStreamAlias("target")
    @XStreamAsAttribute
    private String destino;
    @XStreamAlias("name")
    @XStreamAsAttribute
    private String nomeAresta;
    private String valorAresta;

    public Aresta( String nomeAresta, String valorAresta, String origem, String destino) {
        this.nomeAresta = nomeAresta+":"+valorAresta;
        this.valorAresta = valorAresta;
        this.origem = origem;
        this.destino = destino;
    }

    public String getValorAresta() {
        return valorAresta;
    }

    public void setValorAresta(String valorAresta) {
        this.valorAresta = valorAresta;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getNomeAresta() {
        return nomeAresta;
    }

    public void setNomeAresta(String nomeAresta) {
        this.nomeAresta = nomeAresta;
    }
    
    
}
