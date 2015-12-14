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
import java.util.ArrayList;
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

    public String getIncidenciaArestas(Grafo g) {
        String incidentes = "\n";
        for (Aresta are : arestas) {
            String origem = are.getOrigem();
            String destino = are.getDestino();
            String nome = are.getNomeAresta();
            incidentes += "Aresta: " + nome + " Incidentes: " + origem + " e " + destino + "\n";
        }
        return incidentes;
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
        String subArestAd = "";
        for (No vertice : nos) {
            int i = 0;
            for (Aresta ares : arestas) {
                if (vertice.getId().equals(ares.getOrigem()) || vertice.getId().equals(ares.getDestino())) {
                    subArestAd += ares.getNomeAresta() + ", ";
                    i++;
                }
            }
            if (i > 1) {
                arestasAd += "\n Pelo vértice " + vertice.getId() + ": " + subArestAd;
                subArestAd = "";
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

    public class ArestaIndependente {

        private Aresta aresta1;
        private Aresta aresta2;

        public ArestaIndependente(Aresta aresta1, Aresta aresta2) {
            this.aresta1 = aresta1;
            this.aresta2 = aresta2;
        }

        public Aresta getAresta1() {
            return aresta1;
        }

        public void setAresta1(Aresta aresta1) {
            this.aresta1 = aresta1;
        }

        public Aresta getAresta2() {
            return aresta2;
        }

        public void setAresta2(Aresta aresta2) {
            this.aresta2 = aresta2;
        }
    }

    public String getArestasIndependentes() {
        String arestasIndependentes = "\n";
        List<ArestaIndependente> verificaId = new ArrayList<ArestaIndependente>();
        for (Aresta are1 : arestas) {
            String id1 = are1.getNomeAresta();
            String origem1 = are1.getOrigem();
            String destino1 = are1.getDestino();
            for (Aresta are2 : arestas) {
                String id2 = are2.getNomeAresta();
                String origem2 = are2.getOrigem();
                String destino2 = are2.getDestino();
                if (origem1 != origem2 && destino1 != destino2 && origem1 != destino1 && origem2 != destino2 && origem1 != destino2 && origem2 != destino1) {
                    boolean b = true;
                    for (int i = 0; i < verificaId.size(); i++) {
                        if (verificaId.get(i).getAresta1() == are1 && verificaId.get(i).getAresta2() == are2) {
                            b = false;
                            break;
                        }
                    }
                    if (b == true) {
                        arestasIndependentes += "[" + id1 + "] " + "{" + origem1 + ", " + destino1 + "}" + " e " + "[" + id2 + "] " + "{" + origem2 + ", " + destino2 + "}" + "\n";
                        verificaId.add(new ArestaIndependente(are2, are1));
                    }
                }
            }
        }
        if (arestasIndependentes == "\n") {
            arestasIndependentes = "Não há arestas independentes !!";
        }
        return arestasIndependentes;
    }

    public String getVerticesIndependentes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getVerticesIsolados() {
        String isolados = "";
        for (No vertice : nos) {
            int i=0;
            for (Aresta ares : arestas) {
                if (vertice.getId().equals(ares.getOrigem()) || vertice.getId().equals(ares.getDestino())){
                    i++;
                }
            }
            if(i == 0){
                isolados += "\n vértice " + vertice.getId();
            }
        }
        return isolados;
    }

    public String getVerticesTerminais(Grafo g) {
        String estring = "\n";
        for (int i = 0; i < g.getNos().size(); i++) {
            if (g.getGrauVertice(g.getNos().get(i)) == 1) {
                estring += "Grau(" + g.getNos().get(i).getId() + ");\n";
            }
        }
        if (estring == "\n") {
            estring = "Não há vértices terminais !!";
        }
        return estring;
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
