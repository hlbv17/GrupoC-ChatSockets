/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package visual;

import chatSocketsGrupoC.ClientSocket;
import chatSocketsGrupoC.MessageSocketClient;

import javax.swing.*;
/**
 * @author USER
 */
public class Frm_ChatClient extends javax.swing.JFrame {
    private ClientSocket clientSocket;

    /**
     * Creates new form Frm_ChatCliente
     */
    public Frm_ChatClient() {
        initComponents();
        txt_Chat.setEnabled(false);
        btn_Logout.setEnabled(false);
        txt_Mensaje.setEnabled(false);
        btn_Enviar.setEnabled(false);
        clientSocket = new ClientSocket();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_Enviar = new javax.swing.JButton();
        txt_Mensaje = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_Chat = new javax.swing.JTextArea();
        lbl_ChatCliente = new javax.swing.JLabel();
        btn_Login = new javax.swing.JButton();
        btn_Logout = new javax.swing.JButton();
        lbl_NombreCliente = new javax.swing.JLabel();
        txt_Username = new javax.swing.JTextField();
        lbl_Username = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chat Cliente");

        btn_Enviar.setText("Enviar");
        btn_Enviar.setToolTipText("");
        btn_Enviar.setName(""); // NOI18N
        btn_Enviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_EnviarActionPerformed(evt);
            }
        });

        txt_Chat.setEditable(false);
        txt_Chat.setColumns(20);
        txt_Chat.setRows(5);
        jScrollPane1.setViewportView(txt_Chat);

        lbl_ChatCliente.setText("Chat Cliente:");

        btn_Login.setText("Login");
        btn_Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LoginActionPerformed(evt);
            }
        });

        btn_Logout.setText("Logout");
        btn_Logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LogoutActionPerformed(evt);
            }
        });

        lbl_NombreCliente.setText("---");

        lbl_Username.setText("Username");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(lbl_ChatCliente)
                                                .addGap(18, 18, 18)
                                                .addComponent(lbl_NombreCliente)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(lbl_Username)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(txt_Username, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                                                        .addComponent(txt_Mensaje))
                                                .addGap(27, 27, 27)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btn_Enviar)
                                        .addComponent(btn_Logout)
                                        .addComponent(btn_Login))
                                .addGap(29, 29, 29))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txt_Username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbl_Username)
                                        .addComponent(btn_Login))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lbl_NombreCliente)
                                        .addComponent(lbl_ChatCliente))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(41, 41, 41)
                                                .addComponent(btn_Logout))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btn_Enviar)
                                        .addComponent(txt_Mensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Frm_ChatClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_ChatClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_ChatClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_ChatClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {

            new Frm_ChatClient().setVisible(true);

        });
    }

    private void btn_EnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EnviarActionPerformed
        // TODO add your handling code here:
        boolean isMensaje;
        String mensaje = txt_Mensaje.getText().trim();

        isMensaje = isString(mensaje);

        if (isMensaje) {
            // añadir código para enviar mensaje
            mensaje = "CHAT " + mensaje;
            clientSocket.sendMessageRoom(mensaje);
        }

        // Despues de enviar el mensaje, se borra el texo.
        txt_Mensaje.setText("");

    }//GEN-LAST:event_btn_EnviarActionPerformed

    private void btn_LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LoginActionPerformed
        // TODO add your handling code here:
        boolean isUsername;
        String username = txt_Username.getText().trim();

        isUsername = isString(username);
        try {
            clientSocket.connect();
            clientSocket.registerOnMessage(new MessageSocketClient() {
                @Override
                public void onMessage(String response) {
                    txt_Chat.append(response+ "\n");
                }

                @Override
                public void onServerClosed() {
                    JOptionPane.showMessageDialog(null, "El servidor está cerrado!");
                }

                @Override
                public void onLogout() {
                    JOptionPane.showMessageDialog(null, "Te has desconectado del servidor!");
                    clearFields();
                }
            });
        } catch (Throwable err) {
            JOptionPane.showMessageDialog(null, "No se pudo conectar al servidor");
            return;
        }
        if (isUsername) {
            txt_Username.setText("");
            txt_Username.setEnabled(false);
            btn_Login.setEnabled(false);
            lbl_NombreCliente.setText(username);
            txt_Chat.setEnabled(true);
            btn_Logout.setEnabled(true);
            txt_Mensaje.setEnabled(true);
            btn_Enviar.setEnabled(true);
            clientSocket.sendMessageRoom("LOGIN " + username);
            // añadir código para login

        }
    }//GEN-LAST:event_btn_LoginActionPerformed

    void clearFields(){
        lbl_NombreCliente.setText("---");
        txt_Username.setEnabled(true);
        btn_Login.setEnabled(true);
        txt_Chat.setEnabled(false);
        txt_Chat.setText("");
        btn_Logout.setEnabled(false);
        txt_Mensaje.setEnabled(false);
        btn_Enviar.setEnabled(false);
    }

    private void btn_LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LogoutActionPerformed
        // TODO add your handling code here:
        try {
            clientSocket.disconnect();
        } catch (Throwable t) {
        }
        lbl_NombreCliente.setText("---");
        txt_Username.setEnabled(true);
        btn_Login.setEnabled(true);
        txt_Chat.setEnabled(false);
        btn_Logout.setEnabled(false);
        txt_Mensaje.setEnabled(false);
        btn_Enviar.setEnabled(false);

        // añadir código para logout

    }//GEN-LAST:event_btn_LogoutActionPerformed

    //region Methods

    private boolean isString(String string) {
        boolean isUsername = false;
        if (!string.equals("")) {
            isUsername = true;
        }
        return isUsername;
    }

    //endregion 


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Enviar;
    private javax.swing.JButton btn_Login;
    private javax.swing.JButton btn_Logout;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_ChatCliente;
    private javax.swing.JLabel lbl_NombreCliente;
    private javax.swing.JLabel lbl_Username;
    private javax.swing.JTextArea txt_Chat;
    private javax.swing.JTextField txt_Mensaje;
    private javax.swing.JTextField txt_Username;
    // End of variables declaration//GEN-END:variables
}
