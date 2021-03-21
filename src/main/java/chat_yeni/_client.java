package chat_yeni;
import java.io.DataInputStream;  
import java.io.DataOutputStream;  
import java.net.Socket;  //ilk önce kütühphane 
/*Soket, iki makine arasındaki iletişim için bir uç noktadır*/

public class _client extends javax.swing.JFrame {
static Socket sckt;  //nesneler 
 static DataInputStream dtinpt;  
 static DataOutputStream dtotpt;  
    public _client() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        msg_text = new javax.swing.JTextField();
        msg_btn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        msg_area = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        msg_text.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N

        msg_btn.setBackground(new java.awt.Color(255, 102, 255));
        msg_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                msg_btnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 255));
        jLabel1.setText("CLIENT");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 255));
        jLabel2.setText("Mesajınız:  ");

        msg_area.setColumns(20);
        msg_area.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        msg_area.setRows(5);
        jScrollPane1.setViewportView(msg_area);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                            .addComponent(msg_text))
                        .addGap(30, 30, 30)
                        .addComponent(msg_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(msg_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(15, 15, 15)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(msg_text, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(94, 94, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void msg_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_msg_btnActionPerformed
        try {
            String msgout = "";
            msgout = msg_text.getText().trim();  //boşluklar vs. kontrol ediyor ve kaldırıyo
            dtotpt.writeUTF(msgout);  /*Veri çıkış akışı, bir uygulamanın ilkel Java veri türlerini taşınabilir
            bir şekilde bir çıktı akışına yazmasına izin verir.*/
        } catch (Exception e) {}
    }//GEN-LAST:event_msg_btnActionPerformed

    
    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new _client().setVisible(true);
            }
        });
        try {  
   sckt = new Socket("127.0.0.1", 1201);  
   dtinpt = new DataInputStream(sckt.getInputStream());  
   dtotpt = new DataOutputStream(sckt.getOutputStream());  
   String msgin = "";  
   while (!msgin.equals("Çıkış")) {  
    msgin = dtinpt.readUTF();  
    msg_area.setText(msg_area.getText().trim() + "\n Server:" + msgin);  
    //setText:okunacak geçerli metni ayarlamak için kullanılır. Bu yöntem, bir parametre olarak ayarlanacak metni alır
   }  
  } catch (Exception e) {}  
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTextArea msg_area;
    private javax.swing.JButton msg_btn;
    private javax.swing.JTextField msg_text;
    // End of variables declaration//GEN-END:variables
}
