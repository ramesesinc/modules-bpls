/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rameses.gov.etracs.bpls.views;

import com.rameses.osiris2.themes.OKCancelPage;
import com.rameses.rcp.ui.annotations.Template;

/**
 *
 * @author ramesesinc
 */
@Template(OKCancelPage.class)
public class BusinessApplicationOptionPage extends javax.swing.JPanel {

    /**
     * Creates new form BusinessApplicationOptionPage
     */
    public BusinessApplicationOptionPage() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        xFormPanel1 = new com.rameses.rcp.control.XFormPanel();
        xCheckBox1 = new com.rameses.rcp.control.XCheckBox();

        setPreferredSize(new java.awt.Dimension(373, 243));
        setLayout(new java.awt.BorderLayout());

        xFormPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 0, 0));
        xFormPanel1.setCaptionVAlignment(com.rameses.rcp.constant.UIConstants.CENTER);

        xCheckBox1.setCaption("Auto Issue Permit After EPayment");
        xCheckBox1.setName("data.autoissue"); // NOI18N
        xCheckBox1.setCaptionWidth(220);
        xFormPanel1.add(xCheckBox1);

        add(xFormPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.rameses.rcp.control.XCheckBox xCheckBox1;
    private com.rameses.rcp.control.XFormPanel xFormPanel1;
    // End of variables declaration//GEN-END:variables
}
