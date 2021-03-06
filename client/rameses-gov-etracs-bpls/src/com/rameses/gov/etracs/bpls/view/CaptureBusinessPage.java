/*
 * NewBPApplicationInitPage.java
 *
 * Created on October 3, 2013, 7:41 PM
 */

package com.rameses.gov.etracs.bpls.view;

import com.rameses.osiris2.themes.FormPage;
import com.rameses.rcp.ui.annotations.StyleSheet;
import com.rameses.rcp.ui.annotations.Template;



/**
 *
 * @author  Elmo
 */
@Template(FormPage.class)
@StyleSheet
public class CaptureBusinessPage extends javax.swing.JPanel {
    
    /** Creates new form NewBPApplicationInitPage */
    public CaptureBusinessPage() {
        initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        xFormPanel2 = new com.rameses.rcp.control.XFormPanel();
        xTextField3 = new com.rameses.rcp.control.XTextField();
        xTextField2 = new com.rameses.rcp.control.XTextField();
        xComboBox2 = new com.rameses.rcp.control.XComboBox();
        xComboBox1 = new com.rameses.rcp.control.XComboBox();
        xLabel1 = new com.rameses.rcp.control.XLabel();
        xIntegerField2 = new com.rameses.rcp.control.XIntegerField();
        xDateField1 = new com.rameses.rcp.control.XDateField();
        xButton2 = new com.rameses.rcp.control.XButton();
        jLabel1 = new javax.swing.JLabel();

        xFormPanel2.setCaptionWidth(150);
        xFormPanel2.setPadding(new java.awt.Insets(0, 5, 5, 0));

        xTextField3.setCaption("Business Name");
        xTextField3.setDepends(new String[] {"entity.businessname"});
        xTextField3.setIndex(2);
        xTextField3.setName("entity.business.businessname"); // NOI18N
        xTextField3.setPreferredSize(new java.awt.Dimension(0, 22));
        xTextField3.setRequired(true);
        xFormPanel2.add(xTextField3);

        xTextField2.setCaption("Registered Name");
        xTextField2.setIndex(4);
        xTextField2.setName("entity.business.tradename"); // NOI18N
        xTextField2.setPreferredSize(new java.awt.Dimension(0, 22));
        xTextField2.setRequired(true);
        xFormPanel2.add(xTextField2);

        xComboBox2.setAllowNull(false);
        xComboBox2.setCaption("Permit Type");
        xComboBox2.setEmptyText("- Select a Permit Type -");
        xComboBox2.setExpression("#{item.title}");
        xComboBox2.setItems("application.permitTypes");
        xComboBox2.setName("application.permitType"); // NOI18N
        xComboBox2.setPreferredSize(new java.awt.Dimension(0, 22));
        xComboBox2.setRequired(true);
        xFormPanel2.add(xComboBox2);

        xComboBox1.setAllowNull(false);
        xComboBox1.setCaption("Office Type");
        xComboBox1.setDepends(new String[] {"application.permitType"});
        xComboBox1.setItems("application.officeTypes");
        xComboBox1.setName("entity.business.officetype"); // NOI18N
        xComboBox1.setPreferredSize(new java.awt.Dimension(150, 22));
        xComboBox1.setRequired(true);
        xFormPanel2.add(xComboBox1);

        xLabel1.setCaption("App Type");
        xLabel1.setExpression("#{entity.apptype} ( #{entity.activeyear} )\n");
        xLabel1.setFontStyle("font-size:18;font-weight:bold;");
        xLabel1.setPreferredSize(new java.awt.Dimension(0, 24));
        xFormPanel2.add(xLabel1);

        xIntegerField2.setCaption("Year Started");
        xIntegerField2.setDisableWhen("#{entity.apptype == 'NEW'}");
        xIntegerField2.setName("entity.yearstarted"); // NOI18N
        xIntegerField2.setPreferredSize(new java.awt.Dimension(100, 22));
        xIntegerField2.setRequired(true);
        xFormPanel2.add(xIntegerField2);

        xDateField1.setCaption("Date Applied");
        xDateField1.setName("entity.dtfiled"); // NOI18N
        xDateField1.setPreferredSize(new java.awt.Dimension(100, 22));
        xFormPanel2.add(xDateField1);

        xButton2.setMnemonic('c');
        xButton2.setImmediate(true);
        xButton2.setIndex(3);
        xButton2.setName("application.copyName"); // NOI18N
        xButton2.setText("Copy");

        jLabel1.setText("<html> <b>Note</b><br> <u>Business Name</u> - unique name identifier of business, include branch name if necessary<br> <u>Registered Name</u> - official registration name  (DTI or SEC)<br> </html>");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel1)
                    .addComponent(xFormPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(xButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(xFormPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(xButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(144, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private com.rameses.rcp.control.XButton xButton2;
    private com.rameses.rcp.control.XComboBox xComboBox1;
    private com.rameses.rcp.control.XComboBox xComboBox2;
    private com.rameses.rcp.control.XDateField xDateField1;
    private com.rameses.rcp.control.XFormPanel xFormPanel2;
    private com.rameses.rcp.control.XIntegerField xIntegerField2;
    private com.rameses.rcp.control.XLabel xLabel1;
    private com.rameses.rcp.control.XTextField xTextField2;
    private com.rameses.rcp.control.XTextField xTextField3;
    // End of variables declaration//GEN-END:variables
    
}
