/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin;

import java.io.*;
import java.util.*;
import java.awt.Point;
import javax.swing.*;
import javax.swing.JTable;
/**
 *
 * @author Justin
 */
public class ErrorLogInterface extends JFrame {

    /**
     * Creates new form ErrorLogInterface
     */
    public ErrorLogInterface() {
        initComponents();
        
        //initialize status selection categories
        errorLogStatus.addItem("New");
        errorLogStatus.addItem("Updated");
        errorLogStatus.addItem("Reviewing");
        errorLogStatus.addItem("Solved");
        
        //populate gui field with info from the database
        getErrorData(20);   
    }

    private void getErrorData(int max_rows){
        //TODO replace with real database info
        Scanner testIn = null;
        
        try{
            File testfile = new File("errorTest.txt");
            testIn = new Scanner(testfile);
        }
        catch(FileNotFoundException e){
            System.out.print("File Not Found...");
        }
        
        //initialize column counter
        int rows = 0;
        
        //initial table data
        Object tableData[][] = new Object[5][4];
        
        while(testIn.hasNext()){
            //store data
            String testLine[] = testIn.nextLine().split(",");
            //populate the row with error data
            tableData[rows][0] = testLine[0];
            tableData[rows][1] = testLine[1];
            tableData[rows][2] = testLine[2];
            tableData[rows][3] = "New";
            //set a status combobox in every row
            
            rows++;
        }
        
        //create table
        ErrorLog = new JTable(rows, 4);
        //set Table font
        ErrorLog.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        
        //set Table Model
        ErrorLog.setModel(new javax.swing.table.DefaultTableModel(
            tableData,
            new String [] {
                "ID", "Description", "Date", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        //setRowHeight
        ErrorLog.setRowHeight(50);
        //add Component to GUI
        ErrorLog_ScrollPanel.setViewportView(ErrorLog);
        
        //set a 
        errorLogStatus.setSelectedIndex(2);
        ErrorLog.getColumnModel().getColumn(3).setCellEditor(new DefaultCellEditor(errorLogStatus));
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        ErrorLog_Title = new javax.swing.JLabel();
        ErrorLog_ScrollPanel = new javax.swing.JScrollPane();
        ScrollContainer_Panel = new javax.swing.JPanel();
        ErrorLog_SubmitButton = new javax.swing.JToggleButton();

        jLabel4.setText("jLabel4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ErrorLog_Title.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        ErrorLog_Title.setText("Error Log");

        javax.swing.GroupLayout ScrollContainer_PanelLayout = new javax.swing.GroupLayout(ScrollContainer_Panel);
        ScrollContainer_Panel.setLayout(ScrollContainer_PanelLayout);
        ScrollContainer_PanelLayout.setHorizontalGroup(
            ScrollContainer_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );
        ScrollContainer_PanelLayout.setVerticalGroup(
            ScrollContainer_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 375, Short.MAX_VALUE)
        );

        ErrorLog_ScrollPanel.setViewportView(ScrollContainer_Panel);

        ErrorLog_SubmitButton.setText("Submit");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(ErrorLog_ScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(ErrorLog_Title)
                        .addGap(494, 494, 494))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(ErrorLog_SubmitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(98, 98, 98))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(ErrorLog_Title)
                .addGap(18, 18, 18)
                .addComponent(ErrorLog_ScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 633, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ErrorLog_SubmitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(154, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86))
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
            java.util.logging.Logger.getLogger(ErrorLogInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ErrorLogInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ErrorLogInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ErrorLogInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ErrorLogInterface().setVisible(true);
            }
        });
    }

    private javax.swing.JTable ErrorLog;
    private JComboBox errorLogStatus = new JComboBox();
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane ErrorLog_ScrollPanel;
    private javax.swing.JToggleButton ErrorLog_SubmitButton;
    private javax.swing.JLabel ErrorLog_Title;
    private javax.swing.JPanel ScrollContainer_Panel;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}