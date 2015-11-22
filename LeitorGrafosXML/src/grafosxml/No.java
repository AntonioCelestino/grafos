/*
Trabalho de Teoria dos Grafos
Equipe: Antonio Celestino, Nathan Manera e Pedro Ferreira
Professor: Daves Martins
4º Período BSI - IF Sudeste MG Juiz de Fora
 */
package grafosxml;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import java.util.List;

@XStreamAlias("node")
public class No {
    @XStreamAlias("id")
    @XStreamAsAttribute
    private String id;

    public No(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public static No getNoById(String id, List<No> nos) {
        for (No no : nos) {
            if (no.getId().equals(id)) {
                return no;
            }
        }
        return null;
    }
    
}
