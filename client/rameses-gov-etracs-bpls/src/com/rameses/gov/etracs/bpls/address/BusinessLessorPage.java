/*
 * BuildingPage.java
 *
 * Created on May 8, 2014, 4:51 AM
 */

package com.rameses.gov.etracs.bpls.address;

import com.rameses.osiris2.themes.OKCancelPage;
import com.rameses.rcp.ui.annotations.StyleSheet;
import com.rameses.rcp.ui.annotations.Template;

/**
 *
 * @author  Elmo
 */
@Template(OKCancelPage.class)
@StyleSheet
public class BusinessLessorPage extends javax.swing.JPanel {
    
    /** Creates new form BuildingPage */
    public BusinessLessorPage() {
        initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        xFormPanel1 = new com.rameses.rcp.control.XFormPanel();
        xTextField2 = new com.rameses.rcp.control.XTextField();
        xTextField4 = new com.rameses.rcp.control.XTextField();
        xTextField5 = new com.rameses.rcp.control.XTextField();
        xTextField7 = new com.rameses.rcp.control.XTextField();
        xLookupField1 = new com.rameses.rcp.control.XLookupField();
        xTextField9 = new com.rameses.rcp.control.XTextField();
        xPanel1 = new com.rameses.rcp.control.XPanel();
        xFormPanel2 = new com.rameses.rcp.control.XFormPanel();
        xComboBox1 = new com.rameses.rcp.control.XComboBox();
        xSuggest1 = new com.rameses.rcp.control.XSuggest();
        jScrollPane1 = new javax.swing.JScrollPane();
        xTextArea1 = new com.rameses.rcp.control.XTextArea();
        xButton1 = new com.rameses.rcp.control.XButton();
        jPanel1 = new javax.swing.JPanel();
        xButton5 = new com.rameses.rcp.control.XButton();

        xFormPanel1.setCaptionWidth(100);
        xFormPanel1.setPadding(new java.awt.Insets(0, 15, 5, 15));

        xTextField2.setCaption("House / Bldg No");
        xTextField2.setName("entity.bldgno"); // NOI18N
        xFormPanel1.add(xTextField2);

        xTextField4.setCaption("Bldg Name");
        xTextField4.setName("entity.bldgname"); // NOI18N
        xTextField4.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel1.add(xTextField4);

        xTextField5.setCaption("Street");
        xTextField5.setName("entity.street"); // NOI18N
        xTextField5.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel1.add(xTextField5);

        xTextField7.setCaption("Subdivision");
        xTextField7.setName("entity.subdivision"); // NOI18N
        xTextField7.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel1.add(xTextField7);

        xLookupField1.setCaption("Barangay");
        xLookupField1.setExpression("#{entity.barangay.name}");
        xLookupField1.setHandler("barangay:lookup");
        xLookupField1.setName("entity.barangay"); // NOI18N
        xLookupField1.setPreferredSize(new java.awt.Dimension(0, 20));
        xLookupField1.setRequired(true);
        xFormPanel1.add(xLookupField1);

        xTextField9.setCaption("PIN");
        xTextField9.setName("entity.pin"); // NOI18N
        xTextField9.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel1.add(xTextField9);

        com.rameses.rcp.control.border.XTitledBorder xTitledBorder1 = new com.rameses.rcp.control.border.XTitledBorder();
        xTitledBorder1.setTitle("Lessor Info");
        xPanel1.setBorder(xTitledBorder1);
        xPanel1.setVisibleWhen("#{entity.government==0 && businessowner==null}");

        xFormPanel2.setCaptionWidth(100);

        xComboBox1.setAllowNull(false);
        xComboBox1.setCaption("Org Type");
        xComboBox1.setExpression("#{item.value}");
        xComboBox1.setItemKey("key");
        xComboBox1.setItems("orgTypes");
        xComboBox1.setName("entity.lessor.orgtype"); // NOI18N
        xComboBox1.setPreferredSize(new java.awt.Dimension(250, 22));
        xComboBox1.setRequired(true);
        xFormPanel2.add(xComboBox1);

        xSuggest1.setCaption("Lessor");
        xSuggest1.setExpression("#{entity.lessor.name}");
        xSuggest1.setHandler("lessorModel");
        xSuggest1.setItemExpression("#{item.name}");
        xSuggest1.setName("entity.lessor.name"); // NOI18N
        xSuggest1.setPreferredSize(new java.awt.Dimension(0, 20));
        xSuggest1.setRequired(true);
        xFormPanel2.add(xSuggest1);

        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane1.setEnabled(false);
        jScrollPane1.setPreferredSize(new java.awt.Dimension(0, 50));

        xTextArea1.setCaption("Lessor Address");
        xTextArea1.setEnabled(false);
        xTextArea1.setName("entity.lessor.address.text"); // NOI18N
        xTextArea1.setNullWhenEmpty(false);
        xTextArea1.setRequired(true);
        jScrollPane1.setViewportView(xTextArea1);

        xFormPanel2.add(jScrollPane1);

        xButton1.setCaption("");
        xButton1.setName("reloadAddress"); // NOI18N
        xButton1.setText("Reload Address");
        xFormPanel2.add(xButton1);

        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(100, 22));
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        xButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/search.png"))); // NOI18N
        xButton5.setImmediate(true);
        xButton5.setMargin(new java.awt.Insets(2, 4, 2, 4));
        xButton5.setName("showLessor"); // NOI18N
        xButton5.setPreferredSize(new java.awt.Dimension(25, 22));
        jPanel1.add(xButton5);

        javax.swing.GroupLayout xPanel1Layout = new javax.swing.GroupLayout(xPanel1);
        xPanel1.setLayout(xPanel1Layout);
        xPanel1Layout.setHorizontalGroup(
            xPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(xPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(xFormPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        xPanel1Layout.setVerticalGroup(
            xPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(xPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(xPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(xFormPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(xPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(xFormPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(xFormPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(xPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private com.rameses.rcp.control.XButton xButton1;
    private com.rameses.rcp.control.XButton xButton5;
    private com.rameses.rcp.control.XComboBox xComboBox1;
    private com.rameses.rcp.control.XFormPanel xFormPanel1;
    private com.rameses.rcp.control.XFormPanel xFormPanel2;
    private com.rameses.rcp.control.XLookupField xLookupField1;
    private com.rameses.rcp.control.XPanel xPanel1;
    private com.rameses.rcp.control.XSuggest xSuggest1;
    private com.rameses.rcp.control.XTextArea xTextArea1;
    private com.rameses.rcp.control.XTextField xTextField2;
    private com.rameses.rcp.control.XTextField xTextField4;
    private com.rameses.rcp.control.XTextField xTextField5;
    private com.rameses.rcp.control.XTextField xTextField7;
    private com.rameses.rcp.control.XTextField xTextField9;
    // End of variables declaration//GEN-END:variables
    
}
