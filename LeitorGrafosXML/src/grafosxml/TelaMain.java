/*
Trabalho de Teoria dos Grafos
Equipe: Antonio Celestino, Nathan Manera e Pedro Ferreira
Professor: Daves Martins
4º Período BSI - IF Sudeste MG Juiz de Fora
 */
package grafosxml;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class TelaMain extends javax.swing.JFrame {
    
    List<No> listaNos = new ArrayList<No>();
    List<Aresta> listaArestas =  new ArrayList<Aresta>();
    String origemAresta;
    String destinoAresta;
    int numeroAresta=0;
    
    public TelaMain() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtVertices = new javax.swing.JTextField();
        jbSalvar = new javax.swing.JButton();
        jbMostrar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbNos = new javax.swing.JTable();
        jbCriarNos = new javax.swing.JButton();
        jtOrigem = new javax.swing.JTextField();
        jtDestino = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jbCriarAresta = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtbArestas = new javax.swing.JTable();
        jtFechar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Número de Vértices");

        jLabel2.setText("Criação de Arestas");

        jtVertices.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtVerticesActionPerformed(evt);
            }
        });

        jbSalvar.setText("Salvar Grafo");
        jbSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalvarActionPerformed(evt);
            }
        });

        jbMostrar.setText("Mostrar Grafo");
        jbMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbMostrarActionPerformed(evt);
            }
        });

        jLabel3.setText("Arestas Direcionadas?");

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("Sim");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Não");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jtbNos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome vértice"
            }
        ));
        jScrollPane1.setViewportView(jtbNos);

        jbCriarNos.setText("Criar Vértices");
        jbCriarNos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCriarNosActionPerformed(evt);
            }
        });

        jtOrigem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtOrigemActionPerformed(evt);
            }
        });

        jtDestino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtDestinoActionPerformed(evt);
            }
        });

        jLabel4.setText("Origem");

        jLabel5.setText("Destino");

        jbCriarAresta.setText("Criar");
        jbCriarAresta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCriarArestaActionPerformed(evt);
            }
        });

        jtbArestas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nº", "Vértice origem", "Vértice destino"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jtbArestas);

        jtFechar.setText("Fechar");
        jtFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtFecharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbSalvar)
                        .addGap(38, 38, 38)
                        .addComponent(jbMostrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtFechar)
                        .addGap(37, 37, 37))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jRadioButton1)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButton2))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jtVertices, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(82, 82, 82)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jbCriarNos)
                                        .addGap(43, 43, 43)
                                        .addComponent(jLabel4)
                                        .addGap(6, 6, 6)
                                        .addComponent(jtOrigem, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(20, 20, 20)
                                        .addComponent(jLabel5)
                                        .addGap(4, 4, 4)
                                        .addComponent(jtDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(20, 20, 20)
                                .addComponent(jbCriarAresta)))
                        .addGap(0, 14, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jtVertices, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbCriarNos)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jtOrigem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jtDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbCriarAresta))))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel3))
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbSalvar)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jbMostrar)
                        .addComponent(jtFechar))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtVerticesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtVerticesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtVerticesActionPerformed

    private void jbSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalvarActionPerformed
        XStream xstream = new XStream(new DomDriver());
        xstream.processAnnotations(Grafo.class);      
        
        Grafo g = new Grafo("G", "directed", listaNos, listaArestas);
        if(jRadioButton1.isSelected()){
            g.setTipo("directed");
        }
        if(jRadioButton2.isSelected()){
            g.setTipo("undirected");
        }
        //System.out.println(xstream.toXML(g));
        String xml = xstream.toXML(g);

            g = null;

            g = (Grafo) xstream.fromXML(xml);

            try{
                File xmlFile = new File("grafo.xml");
                xstream.toXML(g, new FileWriter(xmlFile));
            }catch(IOException ex){
                System.out.println("Erro ao Gravar Arquivo");
            }
        JOptionPane.showMessageDialog(null,"Dados Salvos com Sucesso");
    }//GEN-LAST:event_jbSalvarActionPerformed

    private void jbMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbMostrarActionPerformed
        XStream xstream = new XStream(new DomDriver());
        xstream.processAnnotations(Grafo.class); 
        
        File xmlFileLer = new File("grafo.xml");
        Grafo g = (Grafo) xstream.fromXML(xmlFileLer);
        String xml = xstream.toXML(g);
        System.out.println(xml);
    }//GEN-LAST:event_jbMostrarActionPerformed

    public static void buscarGrafo() {
        try {
            FileReader ler = new FileReader("grafo.xml");

            XStream xstream = new XStream(new DomDriver());

            xstream.alias("Grafo", Grafo.class);
            Grafo g = (Grafo) xstream.fromXML(ler);

            String id = g.getId();
            List<Aresta> aresta = g.getArestas();
            List<No> nos = g.getNos();
            String tipo = g.getTipo();

            /*System.out.println(id);
             System.out.println(aresta);
             System.out.println(nos);
             System.out.println(tipo);*/
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TelaMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jbCriarNosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCriarNosActionPerformed
        for (int i = 1; i <= parseInt(jtVertices.getText()); i++) {
            listaNos.add(new No("n"+i));
            DefaultTableModel linha = (DefaultTableModel) jtbNos.getModel();
            linha.addRow(new String[] {"n"+i});
        }
        jtVertices.setText("");
    }//GEN-LAST:event_jbCriarNosActionPerformed

    private void jtOrigemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtOrigemActionPerformed
        
    }//GEN-LAST:event_jtOrigemActionPerformed

    private void jtDestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtDestinoActionPerformed
        
    }//GEN-LAST:event_jtDestinoActionPerformed

    private void jbCriarArestaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCriarArestaActionPerformed
        origemAresta = jtOrigem.getText();
        destinoAresta = jtDestino.getText();
        listaArestas.add(new Aresta(origemAresta, destinoAresta));
        numeroAresta = numeroAresta+1;
        DefaultTableModel linha = (DefaultTableModel) jtbArestas.getModel();
            linha.addRow(new String[] {"Aresta"+numeroAresta, origemAresta, destinoAresta});
        jtOrigem.setText("");
        jtDestino.setText("");
    }//GEN-LAST:event_jbCriarArestaActionPerformed

    private void jtFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtFecharActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jtFecharActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbCriarAresta;
    private javax.swing.JButton jbCriarNos;
    private javax.swing.JButton jbMostrar;
    private javax.swing.JButton jbSalvar;
    private javax.swing.JTextField jtDestino;
    private javax.swing.JButton jtFechar;
    private javax.swing.JTextField jtOrigem;
    private javax.swing.JTextField jtVertices;
    private javax.swing.JTable jtbArestas;
    private javax.swing.JTable jtbNos;
    // End of variables declaration//GEN-END:variables
}
