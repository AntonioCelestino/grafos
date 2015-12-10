/*
 Trabalho de Teoria dos Grafos
 Equipe: Antonio Celestino, Nathan Manera e Pedro Ferreira
 Professor: Daves Martins
 4º Período BSI - IF Sudeste MG Juiz de Fora
 */
package grafosxml;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@XStreamAlias("graph")
public class Grafo {

    @XStreamAlias("id")
    @XStreamAsAttribute
    private String id;
    @XStreamAlias("edgedefault")
    @XStreamAsAttribute
    private String tipo;
    @XStreamImplicit(itemFieldName = "node")
    private List<No> nos;
    @XStreamImplicit(itemFieldName = "edge")
    private List<Aresta> arestas;
    private int[][] matriz;
    String getConjVertices;

    public Grafo(String id, String tipo, List<No> nos, List<Aresta> arestas) {
        this.id = id;
        this.tipo = tipo;
        this.nos = nos;
        this.arestas = arestas;
        geraMatriz();
    }

    private void geraMatriz() {
        int Qtdenos = nos.size();
        matriz = new int[Qtdenos][Qtdenos];
        for (int i = 0; i < Qtdenos; i++) {
            for (int j = 0; j < Qtdenos; j++) {
                matriz[i][j] = 0;
            }
        }
        for (Aresta are : arestas) {
            int posO = nos.indexOf(new No(are.getOrigem()));
            int posD = nos.indexOf(new No(are.getDestino()));
            matriz[posO][posD] = 1;
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<No> getNos() {
        return nos;
    }

    public void setNos(List<No> nos) {
        this.nos = nos;
    }

    public List<Aresta> getArestas() {
        return arestas;
    }

    public void setArestas(List<Aresta> arestas) {
        this.arestas = arestas;
    }

    public int getOrdem() {
        return nos.size();
    }

    public String getConjuntoVertices() {
        String vertices = "V={";
        for (No ver : nos) {
            String id = ver.getId();
            vertices += id + ", ";
        }
        return vertices + "}";
    }

    public String getConjuntoArestas() {
        String conj = "A={";
        for (Aresta are : arestas) {
            String origem = are.getOrigem();
            String destino = are.getDestino();
            String nome = are.getNomeAresta();
            conj += nome + "(" + origem + "," + destino + "), ";
        }
        return conj + "}";
    }

    public String getIncidenciaArestas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getMensagemGrau(Grafo g, String s) {
        String estring = "\n";
        for (int i = 0; i < g.getNos().size(); i++) {
            if (s == "Vertice") {
                estring += "Grau(" + g.getNos().get(i).getId() + "): " + g.getGrauVertice(g.getNos().get(i)) + "; \n";
            }
            if (s == "Emissao") {
                estring += "Grau(" + g.getNos().get(i).getId() + "): " + g.getGrauEmissao(g.getNos().get(i)) + "; \n";
            }
            if (s == "Recepcao") {
                estring += "Grau(" + g.getNos().get(i).getId() + "): " + g.getGrauRecepcao(g.getNos().get(i)) + "; \n";
            }
        }
        return estring;
    }

    public int getGrauEmissao(No no) {
        int grau = 0;
        for (Aresta aresta : this.arestas) {
            if (aresta.getOrigem() == no.getId()) {
                grau++;
            }
        }
        return grau;
    }

    public int getGrauRecepcao(No no) {
        int grau = 0;
        for (Aresta aresta : this.arestas) {
            if (aresta.getDestino() == no.getId()) {
                grau++;
            }
        }
        return grau;
    }

    public int getGrauVertice(No no) {
        int grau = 0;
        for (Aresta aresta : this.arestas) {
            if (aresta.getDestino() == no.getId()) {
                grau++;
            }
            if (aresta.getOrigem() == no.getId()) {
                grau++;
            }
        }
        return grau;
    }
    
    public String getArestasAdjacentes() {
        String arestasAd = "";
        for (No vertice : nos) {
            arestasAd += "\n Pelo vértice "+vertice.getId()+": ";
            for (Aresta ares : arestas){
                if (vertice.getId().equals(ares.getOrigem()) || vertice.getId().equals(ares.getDestino())){
                    arestasAd += ares.getNomeAresta()+", ";
                }
            }
        }
        return arestasAd;
    }

    public String getVerticesAdjacentes() {
        String verticesAd = "\n";
        for (Aresta are : arestas) {
            String origem = are.getOrigem();
            String destino = are.getDestino();
            verticesAd += origem + " e " + destino + "\n";
        }
        return verticesAd;
    }

    public String getArestasIndependentes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getVerticesIndependentes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getVerticesFolhas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getVerticesTerminais() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getVerticesFontes(Grafo g) {
        String estring = "\n";
        for (int i = 0; i < g.getNos().size(); i++) {
            if (g.getGrauRecepcao(g.getNos().get(i)) == 0 && g.getGrauEmissao(g.getNos().get(i)) != 0) {
                estring += "Grau(" + g.getNos().get(i).getId() + ");\n";
            }
        }
        if (estring == "\n") {
            estring = "Não há vértices fontes!";
        }
        return estring;
    }

    public String getVerticesSumidouros(Grafo g) {
        String estring = "\n";
        for (int i = 0; i < g.getNos().size(); i++) {
            if (g.getGrauRecepcao(g.getNos().get(i)) != 0 && g.getGrauEmissao(g.getNos().get(i)) == 0) {
                estring += "Grau(" + g.getNos().get(i).getId() + ");\n";
            }
        }
        if (estring == "\n") {
            estring = "Não há vértices sumidouros!";
        }
        return estring;
    }

}
