package guiproject11;
        
import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
/*
//    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 327, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(266, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
*/

public class showDetails extends JFrame {
    
    DefaultTableModel model = new DefaultTableModel();
    Container cnt = this.getContentPane();
    JTable jtbl = new JTable(model);
    public showDetails() {
        cnt.setLayout(new FlowLayout(FlowLayout.LEFT));
        model.addColumn("Id");
        model.addColumn("Name");
        model.addColumn("Aadhar No.");
        model.addColumn("Age");
        model.addColumn("Father Name");
        model.addColumn("Phone No.");
        model.addColumn("Family Income");
        model.addColumn("Degree");
        String id = searchid.id;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/credit_bank?autoReconnect=true&useSSL=false","root","root");
            PreparedStatement pst = con.prepareStatement("SELECT * FROM studentinformation where Id="+id);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                model.addRow(new Object[]{rs.getInt("Id"), rs.getString("Name"),rs.getString("AadharNo"),rs.getString("Age"),rs.getString("FatherName"),rs.getString("PhoneNo"),rs.getString("FamilyIncome"),rs.getString("degree")});
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        cnt.add(new JScrollPane(jtbl));
        this.pack();
    }
    //hello world is my main motive upto doing this now its my responsibility to take upfront 
    //utter responsbility of all the things where i don't give a shit to anyone who think i can't do anything.
    public static void main(String[] args) {
        JFrame frame = new showDetails();
        frame.setTitle("Student Records");
        frame.setSize(500, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}