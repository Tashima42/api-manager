/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.tashima42.apimanager.views.netbeansgui;

import com.tashima42.apimanager.entities.Api;
import com.tashima42.apimanager.entities.Team;
import com.tashima42.apimanager.entities.Employee;
import com.tashima42.apimanager.views.Main;
import java.util.ArrayList;

/**
 *
 * @author tashima
 */
public class MainView extends javax.swing.JFrame {

    private final Main main;

    /**
     * Creates new form InitialView
     */
    public MainView() {
        main = new Main();
        initComponents();
        setApisTable();
        setTeamsTable();
        setEmployeesTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        tabs = new javax.swing.JTabbedPane();
        apiPanel = new javax.swing.JPanel();
        apiScrollPanel = new javax.swing.JScrollPane();
        apiTable = new javax.swing.JTable();
        apiEditButton = new javax.swing.JButton();
        apiAddButton = new javax.swing.JButton();
        teamsPanel = new javax.swing.JPanel();
        teamsScrollPanel = new javax.swing.JScrollPane();
        teamsTable = new javax.swing.JTable();
        teamsEditButton = new javax.swing.JButton();
        teamsAddButton = new javax.swing.JButton();
        employeesPanel = new javax.swing.JPanel();
        employeesScrollPanel = new javax.swing.JScrollPane();
        employeesTable = new javax.swing.JTable();
        employeesEditButton = new javax.swing.JButton();
        employeeAddButton = new javax.swing.JButton();
        mainMenuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        apiMenu = new javax.swing.JMenu();
        apiAddItem = new javax.swing.JMenuItem();
        editApiItem = new javax.swing.JMenuItem();
        removeApiItem = new javax.swing.JMenuItem();
        teamsMenu = new javax.swing.JMenu();
        teamAddItem = new javax.swing.JMenuItem();
        teamEditItem = new javax.swing.JMenuItem();
        teamRemoveItem = new javax.swing.JMenuItem();
        employeesMenu = new javax.swing.JMenu();
        employeeAddItem = new javax.swing.JMenuItem();
        employeeEditItem = new javax.swing.JMenuItem();
        employeeRemoveItem = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        apiTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        apiScrollPanel.setViewportView(apiTable);

        apiEditButton.setText("Edit");
        apiEditButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                apiEditButtonMouseClicked(evt);
            }
        });
        apiEditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apiEditButtonActionPerformed(evt);
            }
        });

        apiAddButton.setText("Add");
        apiAddButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                apiAddButtonMouseClicked(evt);
            }
        });
        apiAddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apiAddButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout apiPanelLayout = new javax.swing.GroupLayout(apiPanel);
        apiPanel.setLayout(apiPanelLayout);
        apiPanelLayout.setHorizontalGroup(
            apiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, apiPanelLayout.createSequentialGroup()
                .addComponent(apiScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(apiPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(apiEditButton)
                .addGap(41, 41, 41)
                .addComponent(apiAddButton)
                .addGap(181, 181, 181))
        );
        apiPanelLayout.setVerticalGroup(
            apiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, apiPanelLayout.createSequentialGroup()
                .addComponent(apiScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(apiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(apiEditButton)
                    .addComponent(apiAddButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabs.addTab("APIs", apiPanel);

        teamsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        teamsScrollPanel.setViewportView(teamsTable);

        teamsEditButton.setText("Edit");
        teamsEditButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                teamsEditButtonMouseClicked(evt);
            }
        });
        teamsEditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                teamsEditButtonActionPerformed(evt);
            }
        });

        teamsAddButton.setText("Add");
        teamsAddButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                teamsAddButtonMouseClicked(evt);
            }
        });
        teamsAddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                teamsAddButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout teamsPanelLayout = new javax.swing.GroupLayout(teamsPanel);
        teamsPanel.setLayout(teamsPanelLayout);
        teamsPanelLayout.setHorizontalGroup(
            teamsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(teamsPanelLayout.createSequentialGroup()
                .addComponent(teamsScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(teamsPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(teamsEditButton)
                .addGap(41, 41, 41)
                .addComponent(teamsAddButton)
                .addGap(181, 181, 181))
        );
        teamsPanelLayout.setVerticalGroup(
            teamsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, teamsPanelLayout.createSequentialGroup()
                .addComponent(teamsScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(teamsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(teamsEditButton)
                    .addComponent(teamsAddButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabs.addTab("Teams", teamsPanel);

        employeesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        employeesScrollPanel.setViewportView(employeesTable);

        employeesEditButton.setText("Edit");
        employeesEditButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                employeesEditButtonMouseClicked(evt);
            }
        });
        employeesEditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeesEditButtonActionPerformed(evt);
            }
        });

        employeeAddButton.setText("Add");
        employeeAddButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                employeeAddButtonMouseClicked(evt);
            }
        });
        employeeAddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeAddButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout employeesPanelLayout = new javax.swing.GroupLayout(employeesPanel);
        employeesPanel.setLayout(employeesPanelLayout);
        employeesPanelLayout.setHorizontalGroup(
            employeesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(employeesPanelLayout.createSequentialGroup()
                .addComponent(employeesScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(employeesPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(employeesEditButton)
                .addGap(41, 41, 41)
                .addComponent(employeeAddButton)
                .addGap(181, 181, 181))
        );
        employeesPanelLayout.setVerticalGroup(
            employeesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, employeesPanelLayout.createSequentialGroup()
                .addComponent(employeesScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(employeesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(employeesEditButton)
                    .addComponent(employeeAddButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabs.addTab("Employees", employeesPanel);

        fileMenu.setText("File");

        apiMenu.setText("APIs");

        apiAddItem.setText("Add API");
        apiMenu.add(apiAddItem);

        editApiItem.setText("Edit API");
        apiMenu.add(editApiItem);

        removeApiItem.setText("Remove API");
        apiMenu.add(removeApiItem);

        fileMenu.add(apiMenu);

        teamsMenu.setText("Teams");

        teamAddItem.setText("Add Team");
        teamsMenu.add(teamAddItem);

        teamEditItem.setText("Edit Team");
        teamsMenu.add(teamEditItem);

        teamRemoveItem.setText("Remove Team");
        teamsMenu.add(teamRemoveItem);

        fileMenu.add(teamsMenu);

        employeesMenu.setText("Employees");

        employeeAddItem.setText("Add Employee");
        employeesMenu.add(employeeAddItem);

        employeeEditItem.setText("Edit Employee");
        employeesMenu.add(employeeEditItem);

        employeeRemoveItem.setText("Remove Employee");
        employeesMenu.add(employeeRemoveItem);

        fileMenu.add(employeesMenu);

        mainMenuBar.add(fileMenu);

        setJMenuBar(mainMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabs, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabs, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void apiAddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apiAddButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_apiAddButtonActionPerformed

    private void apiAddButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_apiAddButtonMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_apiAddButtonMouseClicked

    private void apiEditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apiEditButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_apiEditButtonActionPerformed

    private void apiEditButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_apiEditButtonMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_apiEditButtonMouseClicked

    private void teamsEditButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_teamsEditButtonMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_teamsEditButtonMouseClicked

    private void teamsEditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_teamsEditButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_teamsEditButtonActionPerformed

    private void teamsAddButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_teamsAddButtonMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_teamsAddButtonMouseClicked

    private void teamsAddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_teamsAddButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_teamsAddButtonActionPerformed

    private void employeesEditButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_employeesEditButtonMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_employeesEditButtonMouseClicked

    private void employeesEditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeesEditButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_employeesEditButtonActionPerformed

    private void employeeAddButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_employeeAddButtonMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_employeeAddButtonMouseClicked

    private void employeeAddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeAddButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_employeeAddButtonActionPerformed

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
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainView().setVisible(true);
            }
        });
    }

    private void setApisTable() {
        Object[][] apis = this.main.getApisInfo();
        apiTable.setModel(new javax.swing.table.DefaultTableModel(
                apis,
                new String[]{"Name", "Description", "Team", "Owner"}) {
            Class[] types = new Class[]{
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean[]{
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
    }

    ;
    
        private void setTeamsTable() {
        Object[][] teams = this.main.getTeamsInfo();
        teamsTable.setModel(new javax.swing.table.DefaultTableModel(
                teams,
                new String[]{"Name", "Description", "Manager"}) {
            Class[] types = new Class[]{
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean[]{
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
    }

    ;
        
     private void setEmployeesTable() {
        Object[][] employees = this.main.getEmployeesInfo();
        employeesTable.setModel(new javax.swing.table.DefaultTableModel(
                employees,
                new String[]{"Name", "Description", "Role"}) {
            Class[] types = new Class[]{
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean[]{
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
    }
    ;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton apiAddButton;
    private javax.swing.JMenuItem apiAddItem;
    private javax.swing.JButton apiEditButton;
    private javax.swing.JMenu apiMenu;
    private javax.swing.JPanel apiPanel;
    private javax.swing.JScrollPane apiScrollPanel;
    private javax.swing.JTable apiTable;
    private javax.swing.JMenuItem editApiItem;
    private javax.swing.JButton employeeAddButton;
    private javax.swing.JMenuItem employeeAddItem;
    private javax.swing.JMenuItem employeeEditItem;
    private javax.swing.JMenuItem employeeRemoveItem;
    private javax.swing.JButton employeesEditButton;
    private javax.swing.JMenu employeesMenu;
    private javax.swing.JPanel employeesPanel;
    private javax.swing.JScrollPane employeesScrollPanel;
    private javax.swing.JTable employeesTable;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuBar mainMenuBar;
    private javax.swing.JMenuItem removeApiItem;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JMenuItem teamAddItem;
    private javax.swing.JMenuItem teamEditItem;
    private javax.swing.JMenuItem teamRemoveItem;
    private javax.swing.JButton teamsAddButton;
    private javax.swing.JButton teamsEditButton;
    private javax.swing.JMenu teamsMenu;
    private javax.swing.JPanel teamsPanel;
    private javax.swing.JScrollPane teamsScrollPanel;
    private javax.swing.JTable teamsTable;
    // End of variables declaration//GEN-END:variables
}
