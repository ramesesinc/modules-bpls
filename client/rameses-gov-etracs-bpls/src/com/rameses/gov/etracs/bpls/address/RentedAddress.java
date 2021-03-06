/*
 * RentedAddress.java
 *
 * Created on May 7, 2014, 1:03 PM
 */

package com.rameses.gov.etracs.bpls.address;

import com.rameses.rcp.ui.annotations.StyleSheet;

/**
 *
 * @author  Elmo
 */
@StyleSheet
public class RentedAddress extends javax.swing.JPanel {
    
    /** Creates new form RentedAddress */
    public RentedAddress() {
        initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        xFormPanel3 = new com.rameses.rcp.control.XFormPanel();
        xSuggest2 = new com.rameses.rcp.control.XSuggest();
        xFormPanel1 = new com.rameses.rcp.control.XFormPanel();
        xTextField6 = new com.rameses.rcp.control.XTextField();
        xTextField1 = new com.rameses.rcp.control.XTextField();
        xTextField3 = new com.rameses.rcp.control.XTextField();
        xTextField2 = new com.rameses.rcp.control.XTextField();
        xTextField7 = new com.rameses.rcp.control.XTextField();
        xTextField4 = new com.rameses.rcp.control.XTextField();
        xTextField8 = new com.rameses.rcp.control.XTextField();
        xDecimalField1 = new com.rameses.rcp.control.XDecimalField();
        xFormPanel2 = new com.rameses.rcp.control.XFormPanel();
        xLabel1 = new com.rameses.rcp.control.XLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        xTextArea1 = new com.rameses.rcp.control.XTextArea();

        xFormPanel3.setCaptionVAlignment(com.rameses.rcp.constant.UIConstants.CENTER);
        xFormPanel3.setPadding(new java.awt.Insets(0, 15, 0, 0));

        xSuggest2.setCaption("Building");
        xSuggest2.setCaptionWidth(100);
        xSuggest2.setExpression("#{entity.bldgname}");
        xSuggest2.setHandler("bldgModel");
        xSuggest2.setItemExpression("#{item.bldgname} #{item.street? ', '+item.street: ''} #{item.lessor.objid? 'lessor:  ' + item.lessor.name : '' }");
        xSuggest2.setPreferredSize(new java.awt.Dimension(0, 22));
        xFormPanel3.add(xSuggest2);

        com.rameses.rcp.control.border.XTitledBorder xTitledBorder1 = new com.rameses.rcp.control.border.XTitledBorder();
        xTitledBorder1.setPadding(new java.awt.Insets(25, 10, 0, 10));
        xTitledBorder1.setTitle("  Business Address   ");
        xFormPanel1.setBorder(xTitledBorder1);
        xFormPanel1.setCaptionPadding(new java.awt.Insets(0, 1, 0, 0));
        xFormPanel1.setCaptionVAlignment(com.rameses.rcp.constant.UIConstants.CENTER);
        xFormPanel1.setCaptionWidth(100);

        xTextField6.setCaption("Unit No");
        xTextField6.setName("entity.unitno"); // NOI18N
        xTextField6.setRequired(true);
        xFormPanel1.add(xTextField6);

        xTextField1.setCaption("House / Bldg No");
        xTextField1.setEnabled(false);
        xTextField1.setName("entity.bldgno"); // NOI18N
        xFormPanel1.add(xTextField1);

        xTextField3.setCaption("Bldg Name");
        xTextField3.setEnabled(false);
        xTextField3.setName("entity.bldgname"); // NOI18N
        xTextField3.setPreferredSize(new java.awt.Dimension(298, 20));
        xFormPanel1.add(xTextField3);

        xTextField2.setCaption("Street");
        xTextField2.setName("entity.street"); // NOI18N
        xTextField2.setPreferredSize(new java.awt.Dimension(298, 20));
        xFormPanel1.add(xTextField2);

        xTextField7.setCaption("Subdivision");
        xTextField7.setName("entity.subdivision"); // NOI18N
        xTextField7.setPreferredSize(new java.awt.Dimension(298, 20));
        xFormPanel1.add(xTextField7);

        xTextField4.setCaption("Barangay");
        xTextField4.setEnabled(false);
        xTextField4.setName("entity.barangay.name"); // NOI18N
        xTextField4.setPreferredSize(new java.awt.Dimension(298, 20));
        xFormPanel1.add(xTextField4);

        xTextField8.setCaption("PIN");
        xTextField8.setName("entity.pin"); // NOI18N
        xTextField8.setPreferredSize(new java.awt.Dimension(298, 20));
        xFormPanel1.add(xTextField8);

        xDecimalField1.setCaption("Monthly Rent");
        xDecimalField1.setName("entity.monthlyrent"); // NOI18N
        xDecimalField1.setRequired(true);
        xFormPanel1.add(xDecimalField1);

        com.rameses.rcp.control.border.XTitledBorder xTitledBorder2 = new com.rameses.rcp.control.border.XTitledBorder();
        xTitledBorder2.setPadding(new java.awt.Insets(25, 10, 0, 10));
        xTitledBorder2.setTitle("Lessor Info");
        xFormPanel2.setBorder(xTitledBorder2);
        xFormPanel2.setCaptionWidth(100);
        xFormPanel2.setVisibleWhen("#{entity.government==0}");

        xLabel1.setCaption("Lessor Name");
        xLabel1.setExpression("#{entity.lessor.name}");
        xLabel1.setName("entity.lessor.name"); // NOI18N
        xLabel1.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel2.add(xLabel1);

        jScrollPane1.setPreferredSize(new java.awt.Dimension(298, 63));

        xTextArea1.setText("entity.lessor.address.text");
        xTextArea1.setCaption("Lessor Address");
        xTextArea1.setEnabled(false);
        xTextArea1.setName("entity.lessor.address.text"); // NOI18N
        jScrollPane1.setViewportView(xTextArea1);

        xFormPanel2.add(jScrollPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(xFormPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)
                    .addComponent(xFormPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(xFormPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(xFormPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(xFormPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(xFormPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private com.rameses.rcp.control.XDecimalField xDecimalField1;
    private com.rameses.rcp.control.XFormPanel xFormPanel1;
    private com.rameses.rcp.control.XFormPanel xFormPanel2;
    private com.rameses.rcp.control.XFormPanel xFormPanel3;
    private com.rameses.rcp.control.XLabel xLabel1;
    private com.rameses.rcp.control.XSuggest xSuggest2;
    private com.rameses.rcp.control.XTextArea xTextArea1;
    private com.rameses.rcp.control.XTextField xTextField1;
    private com.rameses.rcp.control.XTextField xTextField2;
    private com.rameses.rcp.control.XTextField xTextField3;
    private com.rameses.rcp.control.XTextField xTextField4;
    private com.rameses.rcp.control.XTextField xTextField6;
    private com.rameses.rcp.control.XTextField xTextField7;
    private com.rameses.rcp.control.XTextField xTextField8;
    // End of variables declaration//GEN-END:variables
    
}
