/*
 * LobPage.java
 *
 * Created on August 24, 2013, 4:19 PM
 */

package com.rameses.gov.etracs.bpls.views;

import com.rameses.rcp.ui.annotations.Template;
import com.rameses.seti2.views.CrudFormPage;

/**
 *
 * @author  Rameses
 */
@Template(CrudFormPage.class)
public class LobPage extends javax.swing.JPanel {
    
    /** Creates new form LobPage */
    public LobPage() {
        initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        formPanel1 = new com.rameses.rcp.util.FormPanel();
        xTextField1 = new com.rameses.rcp.control.XTextField();
        xLookupField1 = new com.rameses.rcp.control.XLookupField();
        xLookupField2 = new com.rameses.rcp.control.XLookupField();
        jPanel5 = new javax.swing.JPanel();
        xDataTable2 = new com.rameses.rcp.control.XDataTable();
        xButton1 = new com.rameses.rcp.control.XButton();
        xButton2 = new com.rameses.rcp.control.XButton();

        formPanel1.setCaptionVAlignment(com.rameses.rcp.constant.UIConstants.CENTER);
        formPanel1.setCaptionWidth(85);
        formPanel1.setPadding(new java.awt.Insets(0, 5, 5, 5));

        xTextField1.setCaption("Line of Business");
        xTextField1.setCaptionWidth(100);
        xTextField1.setName("entity.name"); // NOI18N
        xTextField1.setPreferredSize(new java.awt.Dimension(0, 20));
        xTextField1.setRequired(true);
        formPanel1.add(xTextField1);

        xLookupField1.setCaption("Classification");
        xLookupField1.setExpression("#{entity.classification.objid}");
        xLookupField1.setHandler("lobclassification:lookup");
        xLookupField1.setName("entity.classification"); // NOI18N
        xLookupField1.setCaptionWidth(100);
        xLookupField1.setPreferredSize(new java.awt.Dimension(0, 20));
        formPanel1.add(xLookupField1);

        xLookupField2.setCaption("PSIC");
        xLookupField2.setExpression("#{entity.psic.objid} #{entity.psic.title}");
        xLookupField2.setHandler("psic:lookup");
        xLookupField2.setName("entity.psic"); // NOI18N
        xLookupField2.setCaptionWidth(100);
        xLookupField2.setPreferredSize(new java.awt.Dimension(0, 20));
        formPanel1.add(xLookupField2);

        com.rameses.rcp.control.border.XTitledBorder xTitledBorder1 = new com.rameses.rcp.control.border.XTitledBorder();
        xTitledBorder1.setTitle("   Attributes   ");
        jPanel5.setBorder(xTitledBorder1);
        jPanel5.setLayout(new java.awt.BorderLayout());

        xDataTable2.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        xDataTable2.setColumns(new com.rameses.rcp.common.Column[]{
            new com.rameses.rcp.common.Column(new Object[]{
                new Object[]{"name", "lobattributeid"}
                , new Object[]{"caption", "Name"}
                , new Object[]{"width", 100}
                , new Object[]{"minWidth", 0}
                , new Object[]{"maxWidth", 0}
                , new Object[]{"required", false}
                , new Object[]{"resizable", true}
                , new Object[]{"nullWhenEmpty", true}
                , new Object[]{"editable", false}
                , new Object[]{"visible", true}
                , new Object[]{"visibleWhen", null}
                , new Object[]{"textCase", com.rameses.rcp.constant.TextCase.UPPER}
                , new Object[]{"typeHandler", new com.rameses.rcp.common.LabelColumnHandler()}
            })
        });
        xDataTable2.setHandler("listHandler");
        xDataTable2.setName("selectedItem"); // NOI18N
        jPanel5.add(xDataTable2, java.awt.BorderLayout.CENTER);

        xButton1.setCaption("Add");
        xButton1.setDepends(new String[] {"entity.*", "selectedItem"});
        xButton1.setDisableWhen("#{canAddAttribute == false}");
        xButton1.setName("addAttribute"); // NOI18N
        xButton1.setText("Add");

        xButton2.setCaption("Add");
        xButton2.setDepends(new String[] {"entity.*", "selectedItem"});
        xButton2.setDisableWhen("#{canRemoveAttribute == false}");
        xButton2.setName("removeAttribute"); // NOI18N
        xButton2.setText("Remove");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
                    .addComponent(formPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(xButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(xButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(formPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(xButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(xButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.rameses.rcp.util.FormPanel formPanel1;
    private javax.swing.JPanel jPanel5;
    private com.rameses.rcp.control.XButton xButton1;
    private com.rameses.rcp.control.XButton xButton2;
    private com.rameses.rcp.control.XDataTable xDataTable2;
    private com.rameses.rcp.control.XLookupField xLookupField1;
    private com.rameses.rcp.control.XLookupField xLookupField2;
    private com.rameses.rcp.control.XTextField xTextField1;
    // End of variables declaration//GEN-END:variables
    
}
