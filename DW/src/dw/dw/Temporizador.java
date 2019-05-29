/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dw;

import java.awt.Toolkit; // Para el pitido.
import java.awt.event.*;
import javax.swing.JOptionPane; 
import javax.swing.Timer; 
 
public class Temporizador extends javax.swing.JFrame {
     
    Timer Reloj; 
    int segundos; 
    int copiasegundos; 
    int delay = 1000; 
     
    public Temporizador() {
        initComponents();
        this.setLocationRelativeTo(null);

    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {
 
        Tiempo = new javax.swing.JLabel();
        Start = new javax.swing.JButton();
        Stop = new javax.swing.JButton();
        Restart = new javax.swing.JButton();
        Volver = new javax.swing.JButton();
 
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
 
        Tiempo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
 
        Start.setText("Iniciar");
        Start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StartActionPerformed(evt);
            }
        });
 
        Stop.setText("Detener");
        Stop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StopActionPerformed(evt);
            }
        });
 
        Restart.setText("Reiniciar");
        Restart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RestartActionPerformed(evt);
            }
        });
        
        Volver.setText("Volver");
        Volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VolverActionPerformed(evt);
            }
        });
 
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Tiempo, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Start)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Stop)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Restart)))
                        .addComponent(Volver)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Tiempo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Start)
                    .addComponent(Stop)
                    .addComponent(Restart))
                    .addComponent(Volver)
                .addContainerGap(30, Short.MAX_VALUE))
        );
 
        pack();
    }// </editor-fold>                        
 
private void StartActionPerformed(java.awt.event.ActionEvent evt) {                                      
        segundos = Integer.parseInt(JOptionPane.showInputDialog(null, "¿Con cuántos segundos?"));
        copiasegundos=segundos; 
         
        ActionListener taskPerformer = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                // Muestra en pantalla los segundos restantes:
                Tiempo.setText("Quedan " + String.valueOf(segundos) + " segundos..."); 
                // Comprueba si segundos es igual a cero para detener el Timer.
                if(segundos<=0) 
                {
                    Tiempo.setText("La cuenta regresiva ha terminado."); // Muestra mensaje.
                    Toolkit.getDefaultToolkit().beep(); // Emite sonido.
                    Reloj.stop(); 
                }
                segundos--; // Reduce la cantidad de segundos.
            }
        }; // Fin de la declaración del ActionListener.
         
        
        Reloj = new Timer(delay, taskPerformer);
        Reloj.start(); 
}                                     
 
private void StopActionPerformed(java.awt.event.ActionEvent evt) {                                     
Toolkit.getDefaultToolkit().beep(); // Emite sonido.
Reloj.stop(); // Detiene el timer y se deja de ejecutar ésto.
Tiempo.setText("La cuenta regresiva se ha detenido."); // Muestra mensaje.
}                                    
 
private void RestartActionPerformed(java.awt.event.ActionEvent evt) {                                        
Tiempo.setText("Cuenta regresiva reiniciada.");
segundos=copiasegundos; // Reinicializa el valor de segundos 
                        // para no introducirlos de nuevo.
Reloj.restart(); // Reinicia el timer.
}                                       
private void VolverActionPerformed(java.awt.event.ActionEvent evt) {                                     
Inicio a= new Inicio();
        a.setVisible(true);
        this.setVisible(false);
        this.setLocationRelativeTo(null);
}                 
 
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
            java.util.logging.Logger.getLogger(Temporizador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Temporizador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Temporizador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Temporizador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
 
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Temporizador().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify                     
    private javax.swing.JButton Restart;
    private javax.swing.JButton Start;
    private javax.swing.JButton Stop;
    private javax.swing.JLabel Tiempo;
    private javax.swing.JButton Volver;
    // End of variables declaration                   
}
