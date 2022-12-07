/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Main;
import Function.GUIFunc;
import Function.UserFunc;
import javax.swing.JLabel;
 /*
 *
 * @author Atthoriq
 */
public class Logins extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    GUIFunc GUI = new GUIFunc();
    UserFunc usf = new UserFunc();
    int id;
    public Logins() {
        initComponents();
        
        passwordValid.setVisible(false);
        usernameValid.setVisible(false);
        GUI.showPanel(jPanel2, LoginPanel);
        jLabel7.setHorizontalAlignment(JLabel.CENTER);
        sqPanel.setVisible(false);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        SecurityQuestion = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        sqPanel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        question1 = new javax.swing.JLabel();
        answer1 = new javax.swing.JTextField();
        answer2 = new javax.swing.JTextField();
        question2 = new javax.swing.JLabel();
        answer3 = new javax.swing.JTextField();
        question3 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        sqUsername = new javax.swing.JTextField();
        showSq = new javax.swing.JButton();
        ResetPassword = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        username1 = new javax.swing.JLabel();
        us1 = new javax.swing.JTextField();
        password1 = new javax.swing.JLabel();
        newPw = new javax.swing.JPasswordField();
        reset = new javax.swing.JButton();
        password2 = new javax.swing.JLabel();
        newPw1 = new javax.swing.JPasswordField();
        LoginPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        us = new javax.swing.JTextField();
        pw = new javax.swing.JPasswordField();
        usernameValid = new javax.swing.JLabel();
        passwordValid = new javax.swing.JLabel();
        username = new javax.swing.JLabel();
        password = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Kedai Kopi Garasi 23");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(98, 220, 220, 29);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 450));

        jPanel2.setBackground(new java.awt.Color(153, 255, 255));
        jPanel2.setLayout(new java.awt.CardLayout());

        SecurityQuestion.setBackground(new java.awt.Color(255, 255, 255));
        SecurityQuestion.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel3.setText("Lupa Password");
        SecurityQuestion.add(jLabel3);
        jLabel3.setBounds(110, 50, 133, 25);

        sqPanel.setBackground(new java.awt.Color(255, 255, 255));
        sqPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(238, 233, 233)));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Jawab Pertanyaan keamanan Anda");

        question1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        question1.setText("Pertanyaan1");

        answer1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        answer1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                answer1ActionPerformed(evt);
            }
        });

        answer2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        answer2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                answer2ActionPerformed(evt);
            }
        });

        question2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        question2.setText("Pertanyaan2");

        answer3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        answer3.setMinimumSize(new java.awt.Dimension(7, 16));
        answer3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                answer3ActionPerformed(evt);
            }
        });

        question3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        question3.setText("Pertanyaan3");

        jButton3.setText("Reset Password");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout sqPanelLayout = new javax.swing.GroupLayout(sqPanel);
        sqPanel.setLayout(sqPanelLayout);
        sqPanelLayout.setHorizontalGroup(
            sqPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sqPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sqPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sqPanelLayout.createSequentialGroup()
                        .addGroup(sqPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(answer1)
                            .addGroup(sqPanelLayout.createSequentialGroup()
                                .addGroup(sqPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(question1)
                                    .addComponent(question2)
                                    .addComponent(question3))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(answer2)
                            .addComponent(answer3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sqPanelLayout.createSequentialGroup()
                        .addGap(0, 59, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addGap(67, 67, 67))))
            .addGroup(sqPanelLayout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addComponent(jButton3)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        sqPanelLayout.setVerticalGroup(
            sqPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sqPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(question1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(answer1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(question2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(answer2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(question3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(answer3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        SecurityQuestion.add(sqPanel);
        sqPanel.setBounds(0, 170, 350, 280);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Masukan Username Anda");
        SecurityQuestion.add(jLabel4);
        jLabel4.setBounds(10, 105, 153, 17);

        sqUsername.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sqUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sqUsernameActionPerformed(evt);
            }
        });
        SecurityQuestion.add(sqUsername);
        sqUsername.setBounds(10, 128, 257, 23);

        showSq.setText("Lanjut");
        showSq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showSqActionPerformed(evt);
            }
        });
        SecurityQuestion.add(showSq);
        showSq.setBounds(277, 128, 63, 23);

        jPanel2.add(SecurityQuestion, "card3");

        ResetPassword.setBackground(new java.awt.Color(255, 255, 255));
        ResetPassword.setLayout(null);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Atur Ulang Password");
        ResetPassword.add(jLabel6);
        jLabel6.setBounds(100, 60, 170, 29);

        username1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        username1.setText("Username");
        ResetPassword.add(username1);
        username1.setBounds(30, 130, 71, 20);

        us1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                us1ActionPerformed(evt);
            }
        });
        ResetPassword.add(us1);
        us1.setBounds(28, 156, 299, 28);

        password1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        password1.setText("Masukan Password Baru");
        ResetPassword.add(password1);
        password1.setBounds(30, 210, 180, 20);

        newPw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newPwActionPerformed(evt);
            }
        });
        ResetPassword.add(newPw);
        newPw.setBounds(30, 230, 299, 28);

        reset.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        reset.setText("Reset  Password");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });
        ResetPassword.add(reset);
        reset.setBounds(30, 380, 299, 32);

        password2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        password2.setText("Ulangi Password");
        ResetPassword.add(password2);
        password2.setBounds(30, 280, 130, 20);

        newPw1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newPw1ActionPerformed(evt);
            }
        });
        ResetPassword.add(newPw1);
        newPw1.setBounds(30, 300, 299, 28);

        jPanel2.add(ResetPassword, "card4");

        LoginPanel.setBackground(new java.awt.Color(255, 255, 255));
        LoginPanel.setPreferredSize(new java.awt.Dimension(350, 440));
        LoginPanel.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("Login");
        LoginPanel.add(jLabel2);
        jLabel2.setBounds(141, 53, 56, 29);

        us.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usActionPerformed(evt);
            }
        });
        LoginPanel.add(us);
        us.setBounds(28, 156, 299, 28);

        pw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pwActionPerformed(evt);
            }
        });
        LoginPanel.add(pw);
        pw.setBounds(28, 248, 299, 28);

        usernameValid.setBackground(new java.awt.Color(255, 255, 255));
        usernameValid.setForeground(new java.awt.Color(204, 0, 0));
        usernameValid.setText("jLabel2");
        LoginPanel.add(usernameValid);
        usernameValid.setBounds(28, 190, 299, 14);

        passwordValid.setForeground(new java.awt.Color(204, 0, 0));
        passwordValid.setText("jLabel2");
        LoginPanel.add(passwordValid);
        passwordValid.setBounds(28, 282, 299, 14);

        username.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        username.setText("Username");
        LoginPanel.add(username);
        username.setBounds(28, 130, 71, 20);

        password.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        password.setText("Password");
        LoginPanel.add(password);
        password.setBounds(28, 222, 67, 20);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setText("Login");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        LoginPanel.add(jButton1);
        jButton1.setBounds(28, 345, 299, 32);

        jLabel7.setText("Lupa Password?");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        LoginPanel.add(jLabel7);
        jLabel7.setBounds(30, 380, 300, 14);

        jPanel2.add(LoginPanel, "card3");

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, 350, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void usActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usActionPerformed

    private void pwActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pwActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pwActionPerformed

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
       GUI.switchPanel(jPanel2,SecurityQuestion);
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Main a = new Main();
        usf.login(us.getText(), pw.getText(), a, this, usernameValid, passwordValid);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void sqUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sqUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sqUsernameActionPerformed

    private void answer1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_answer1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_answer1ActionPerformed

    private void answer2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_answer2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_answer2ActionPerformed

    private void answer3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_answer3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_answer3ActionPerformed

    private void showSqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showSqActionPerformed
        usf.securityQuestion(sqUsername.getText(), sqPanel, question1, question2, question3);
    }//GEN-LAST:event_showSqActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
        usf.CheckAnswer(answer1.getText(), answer2.getText(), answer3.getText(), sqUsername.getText(),us1,jPanel2,ResetPassword);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void us1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_us1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_us1ActionPerformed

    private void newPwActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newPwActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newPwActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        usf.ResetPassword(newPw.getText(),newPw1.getText(), us1.getText(),jPanel2,LoginPanel);
    }//GEN-LAST:event_resetActionPerformed

    private void newPw1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newPw1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newPw1ActionPerformed

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
            java.util.logging.Logger.getLogger(Logins.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Logins.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Logins.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Logins.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Logins().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel LoginPanel;
    private javax.swing.JPanel ResetPassword;
    private javax.swing.JPanel SecurityQuestion;
    private javax.swing.JTextField answer1;
    private javax.swing.JTextField answer2;
    private javax.swing.JTextField answer3;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField newPw;
    private javax.swing.JPasswordField newPw1;
    private javax.swing.JLabel password;
    private javax.swing.JLabel password1;
    private javax.swing.JLabel password2;
    private javax.swing.JLabel passwordValid;
    private javax.swing.JPasswordField pw;
    private javax.swing.JLabel question1;
    private javax.swing.JLabel question2;
    private javax.swing.JLabel question3;
    private javax.swing.JButton reset;
    private javax.swing.JButton showSq;
    private javax.swing.JPanel sqPanel;
    private javax.swing.JTextField sqUsername;
    private javax.swing.JTextField us;
    private javax.swing.JTextField us1;
    private javax.swing.JLabel username;
    private javax.swing.JLabel username1;
    private javax.swing.JLabel usernameValid;
    // End of variables declaration//GEN-END:variables
}
