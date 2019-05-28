/*
 * BusinessInfoPage.java
 *
 * Created on October 3, 2013, 8:34 PM
 */

package com.rameses.gov.etracs.bpls.view;

import com.rameses.osiris2.themes.FormPage;
import com.rameses.rcp.ui.annotations.Template;


/**
 *
 * @author  Elmo
 */
@Template(FormPage.class)
public class ApplicationFormGeneralInfo extends javax.swing.JPanel {
    
    /** Creates new form BusinessInfoPage */
    public ApplicationFormGeneralInfo() {
        initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        xFormPanel3 = new com.rameses.rcp.control.XFormPanel();
        xTextField1 = new com.rameses.rcp.control.XTextField();
        xLabel3 = new com.rameses.rcp.control.XLabel();
        xLabel11 = new com.rameses.rcp.control.XLabel();
        xLabel5 = new com.rameses.rcp.control.XLabel();
        xLabel12 = new com.rameses.rcp.control.XLabel();
        xLabel13 = new com.rameses.rcp.control.XLabel();
        xLabel9 = new com.rameses.rcp.control.XLabel();
        xLabel6 = new com.rameses.rcp.control.XLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        xTextArea2 = new com.rameses.rcp.control.XTextArea();
        xFormPanel5 = new com.rameses.rcp.control.XFormPanel();
        xLabel4 = new com.rameses.rcp.control.XLabel();
        xLabel16 = new com.rameses.rcp.control.XLabel();
        xLabel20 = new com.rameses.rcp.control.XLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        xTextArea1 = new com.rameses.rcp.control.XTextArea();
        xLabel14 = new com.rameses.rcp.control.XLabel();
        xLabel17 = new com.rameses.rcp.control.XLabel();
        xLabel18 = new com.rameses.rcp.control.XLabel();
        xLabel25 = new com.rameses.rcp.control.XLabel();
        xLabel24 = new com.rameses.rcp.control.XLabel();
        xLabel26 = new com.rameses.rcp.control.XLabel();
        xLabel23 = new com.rameses.rcp.control.XLabel();
        xFormPanel4 = new com.rameses.rcp.control.XFormPanel();
        xDataTable1 = new com.rameses.rcp.control.XDataTable();

        xFormPanel3.setCaptionWidth(100);
        xFormPanel3.setShowCaption(false);

        xTextField1.setEditable(false);
        xTextField1.setCaption("App No");
        xTextField1.setFontStyle("font-weight:bold");
        xTextField1.setForeground(new java.awt.Color(102, 0, 0));
        xTextField1.setName("entity.appno"); // NOI18N
        xTextField1.setOpaque(false);
        xTextField1.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel3.add(xTextField1);

        com.rameses.rcp.control.border.XLineBorder xLineBorder1 = new com.rameses.rcp.control.border.XLineBorder();
        xLineBorder1.setLineColor(new java.awt.Color(204, 204, 204));
        xLabel3.setBorder(xLineBorder1);
        xLabel3.setCaption("App Type");
        xLabel3.setExpression("#{entity.apptype}");
        xLabel3.setPreferredSize(new java.awt.Dimension(0, 18));
        xFormPanel3.add(xLabel3);

        com.rameses.rcp.control.border.XLineBorder xLineBorder2 = new com.rameses.rcp.control.border.XLineBorder();
        xLineBorder2.setLineColor(new java.awt.Color(204, 204, 204));
        xLabel11.setBorder(xLineBorder2);
        xLabel11.setCaption("Applicable Year");
        xLabel11.setExpression("#{entity.appyear}");
        xLabel11.setName("application.year"); // NOI18N
        xLabel11.setPreferredSize(new java.awt.Dimension(0, 18));
        xFormPanel3.add(xLabel11);

        com.rameses.rcp.control.border.XLineBorder xLineBorder3 = new com.rameses.rcp.control.border.XLineBorder();
        xLineBorder3.setLineColor(new java.awt.Color(204, 204, 204));
        xLabel5.setBorder(xLineBorder3);
        xLabel5.setCaption("Status");
        xLabel5.setExpression("#{entity.state}");
        xLabel5.setPreferredSize(new java.awt.Dimension(0, 18));
        xFormPanel3.add(xLabel5);

        com.rameses.rcp.control.border.XLineBorder xLineBorder4 = new com.rameses.rcp.control.border.XLineBorder();
        xLineBorder4.setLineColor(new java.awt.Color(204, 204, 204));
        xLabel12.setBorder(xLineBorder4);
        xLabel12.setCaption("Date Filed");
        xLabel12.setExpression("#{entity.dtfiled}");
        xLabel12.setPreferredSize(new java.awt.Dimension(0, 18));
        xFormPanel3.add(xLabel12);

        com.rameses.rcp.control.border.XLineBorder xLineBorder5 = new com.rameses.rcp.control.border.XLineBorder();
        xLineBorder5.setLineColor(new java.awt.Color(204, 204, 204));
        xLabel13.setBorder(xLineBorder5);
        xLabel13.setCaption("Year Started");
        xLabel13.setExpression("#{entity.business.yearstarted}");
        xLabel13.setName("application.year"); // NOI18N
        xLabel13.setPreferredSize(new java.awt.Dimension(0, 18));
        xFormPanel3.add(xLabel13);

        com.rameses.rcp.control.border.XLineBorder xLineBorder6 = new com.rameses.rcp.control.border.XLineBorder();
        xLineBorder6.setLineColor(new java.awt.Color(204, 204, 204));
        xLabel9.setBorder(xLineBorder6);
        xLabel9.setCaption("Org Type");
        xLabel9.setExpression("#{entity.business.orgtypename}");
        xLabel9.setPreferredSize(new java.awt.Dimension(0, 18));
        xFormPanel3.add(xLabel9);

        com.rameses.rcp.control.border.XLineBorder xLineBorder7 = new com.rameses.rcp.control.border.XLineBorder();
        xLineBorder7.setLineColor(new java.awt.Color(204, 204, 204));
        xLabel6.setBorder(xLineBorder7);
        xLabel6.setCaption("Owner");
        xLabel6.setExpression("#{entity.business.owner.name}");
        xLabel6.setPreferredSize(new java.awt.Dimension(0, 18));
        xFormPanel3.add(xLabel6);

        jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane2.setEnabled(false);
        jScrollPane2.setName("entity.businessaddress.text"); // NOI18N
        jScrollPane2.setPreferredSize(new java.awt.Dimension(0, 50));

        xTextArea2.setCaption("Owner Address");
        xTextArea2.setEnabled(false);
        xTextArea2.setName("entity.business.owner.address.text"); // NOI18N
        jScrollPane2.setViewportView(xTextArea2);

        xFormPanel3.add(jScrollPane2);

        xFormPanel5.setCaptionWidth(120);
        xFormPanel5.setShowCaption(false);

        xLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        xLabel4.setCaption("BIN");
        xLabel4.setExpression("#{ entity.business.bin  }");
        xLabel4.setFontStyle("font-weight:bold;");
        xLabel4.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel5.add(xLabel4);

        com.rameses.rcp.control.border.XLineBorder xLineBorder8 = new com.rameses.rcp.control.border.XLineBorder();
        xLineBorder8.setLineColor(new java.awt.Color(204, 204, 204));
        xLabel16.setBorder(xLineBorder8);
        xLabel16.setCaption("Business Name");
        xLabel16.setExpression("#{entity.business.businessname}");
        xLabel16.setPreferredSize(new java.awt.Dimension(0, 18));
        xFormPanel5.add(xLabel16);

        com.rameses.rcp.control.border.XLineBorder xLineBorder9 = new com.rameses.rcp.control.border.XLineBorder();
        xLineBorder9.setLineColor(new java.awt.Color(204, 204, 204));
        xLabel20.setBorder(xLineBorder9);
        xLabel20.setCaption("Reg. Trade Name");
        xLabel20.setExpression("#{entity.tradename}");
        xLabel20.setPreferredSize(new java.awt.Dimension(0, 18));
        xFormPanel5.add(xLabel20);

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane1.setEnabled(false);
        jScrollPane1.setName("entity.businessaddress.text"); // NOI18N
        jScrollPane1.setPreferredSize(new java.awt.Dimension(0, 50));

        xTextArea1.setCaption("Address");
        xTextArea1.setEnabled(false);
        xTextArea1.setName("entity.business.address.text"); // NOI18N
        jScrollPane1.setViewportView(xTextArea1);

        xFormPanel5.add(jScrollPane1);

        com.rameses.rcp.control.border.XLineBorder xLineBorder10 = new com.rameses.rcp.control.border.XLineBorder();
        xLineBorder10.setLineColor(new java.awt.Color(204, 204, 204));
        xLabel14.setBorder(xLineBorder10);
        xLabel14.setCaption("Mobile No");
        xLabel14.setExpression("#{entity.business.mobileno}");
        xLabel14.setName("entity.business.phoneno"); // NOI18N
        xLabel14.setPreferredSize(new java.awt.Dimension(0, 18));
        xFormPanel5.add(xLabel14);

        com.rameses.rcp.control.border.XLineBorder xLineBorder11 = new com.rameses.rcp.control.border.XLineBorder();
        xLineBorder11.setLineColor(new java.awt.Color(204, 204, 204));
        xLabel17.setBorder(xLineBorder11);
        xLabel17.setCaption("Phone No");
        xLabel17.setExpression("#{entity.business.phoneno}");
        xLabel17.setName("entity.branchname"); // NOI18N
        xLabel17.setPreferredSize(new java.awt.Dimension(0, 18));
        xFormPanel5.add(xLabel17);

        com.rameses.rcp.control.border.XLineBorder xLineBorder12 = new com.rameses.rcp.control.border.XLineBorder();
        xLineBorder12.setLineColor(new java.awt.Color(204, 204, 204));
        xLabel18.setBorder(xLineBorder12);
        xLabel18.setCaption("Email");
        xLabel18.setExpression("#{entity.business.email}");
        xLabel18.setName("entity.branchname"); // NOI18N
        xLabel18.setPreferredSize(new java.awt.Dimension(0, 20));
        xFormPanel5.add(xLabel18);

        com.rameses.rcp.control.border.XLineBorder xLineBorder13 = new com.rameses.rcp.control.border.XLineBorder();
        xLineBorder13.setLineColor(new java.awt.Color(204, 204, 204));
        xLabel25.setBorder(xLineBorder13);
        xLabel25.setCaption("Created By");
        xLabel25.setExpression("#{entity.createdby.name}");
        xLabel25.setName("entity.branchname"); // NOI18N
        xLabel25.setPreferredSize(new java.awt.Dimension(0, 18));
        xFormPanel5.add(xLabel25);

        com.rameses.rcp.control.border.XLineBorder xLineBorder14 = new com.rameses.rcp.control.border.XLineBorder();
        xLineBorder14.setLineColor(new java.awt.Color(204, 204, 204));
        xLabel24.setBorder(xLineBorder14);
        xLabel24.setCaption("Current Task");
        xLabel24.setExpression("#{task.state}");
        xLabel24.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        xLabel24.setName("entity.branchname"); // NOI18N
        xLabel24.setPreferredSize(new java.awt.Dimension(0, 18));
        xFormPanel5.add(xLabel24);

        com.rameses.rcp.control.border.XLineBorder xLineBorder15 = new com.rameses.rcp.control.border.XLineBorder();
        xLineBorder15.setLineColor(new java.awt.Color(204, 204, 204));
        xLabel26.setBorder(xLineBorder15);
        xLabel26.setCaption("Assessor");
        xLabel26.setExpression("#{entity.assessor.name}");
        xLabel26.setName("entity.branchname"); // NOI18N
        xLabel26.setPreferredSize(new java.awt.Dimension(0, 18));
        xFormPanel5.add(xLabel26);

        com.rameses.rcp.control.border.XLineBorder xLineBorder16 = new com.rameses.rcp.control.border.XLineBorder();
        xLineBorder16.setLineColor(new java.awt.Color(204, 204, 204));
        xLabel23.setBorder(xLineBorder16);
        xLabel23.setCaption("Approver");
        xLabel23.setExpression("#{entity.approver.name}");
        xLabel23.setName("entity.branchname"); // NOI18N
        xLabel23.setPreferredSize(new java.awt.Dimension(0, 18));
        xFormPanel5.add(xLabel23);

        xFormPanel4.setCaptionWidth(120);

        xDataTable1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        xDataTable1.setColumns(new com.rameses.rcp.common.Column[]{
            new com.rameses.rcp.common.Column(new Object[]{
                new Object[]{"name", "name"}
                , new Object[]{"caption", "Line of Business"}
                , new Object[]{"width", 100}
                , new Object[]{"minWidth", 0}
                , new Object[]{"maxWidth", 0}
                , new Object[]{"required", false}
                , new Object[]{"resizable", true}
                , new Object[]{"nullWhenEmpty", true}
                , new Object[]{"editable", false}
                , new Object[]{"textCase", com.rameses.rcp.constant.TextCase.UPPER}
                , new Object[]{"typeHandler", new com.rameses.rcp.common.TextColumnHandler()}
            }),
            new com.rameses.rcp.common.Column(new Object[]{
                new Object[]{"name", "assessmenttype"}
                , new Object[]{"caption", "Assessment Type"}
                , new Object[]{"width", 120}
                , new Object[]{"minWidth", 120}
                , new Object[]{"maxWidth", 120}
                , new Object[]{"required", false}
                , new Object[]{"resizable", true}
                , new Object[]{"nullWhenEmpty", true}
                , new Object[]{"editable", true}
                , new Object[]{"editableWhen", null}
                , new Object[]{"textCase", com.rameses.rcp.constant.TextCase.UPPER}
                , new Object[]{"typeHandler", new com.rameses.rcp.common.ComboBoxColumnHandler("lobAssessmentTypes", null, null)}
            })
        });
        xDataTable1.setHandler("lob.listModel");
        xDataTable1.setName("lob.selectedItem"); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(xFormPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(xFormPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE))
                    .addComponent(xDataTable1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(29, 29, 29)
                .addComponent(xFormPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                .addGap(708, 708, 708))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(xFormPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(xFormPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(xFormPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(xDataTable1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(103, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private com.rameses.rcp.control.XDataTable xDataTable1;
    private com.rameses.rcp.control.XFormPanel xFormPanel3;
    private com.rameses.rcp.control.XFormPanel xFormPanel4;
    private com.rameses.rcp.control.XFormPanel xFormPanel5;
    private com.rameses.rcp.control.XLabel xLabel11;
    private com.rameses.rcp.control.XLabel xLabel12;
    private com.rameses.rcp.control.XLabel xLabel13;
    private com.rameses.rcp.control.XLabel xLabel14;
    private com.rameses.rcp.control.XLabel xLabel16;
    private com.rameses.rcp.control.XLabel xLabel17;
    private com.rameses.rcp.control.XLabel xLabel18;
    private com.rameses.rcp.control.XLabel xLabel20;
    private com.rameses.rcp.control.XLabel xLabel23;
    private com.rameses.rcp.control.XLabel xLabel24;
    private com.rameses.rcp.control.XLabel xLabel25;
    private com.rameses.rcp.control.XLabel xLabel26;
    private com.rameses.rcp.control.XLabel xLabel3;
    private com.rameses.rcp.control.XLabel xLabel4;
    private com.rameses.rcp.control.XLabel xLabel5;
    private com.rameses.rcp.control.XLabel xLabel6;
    private com.rameses.rcp.control.XLabel xLabel9;
    private com.rameses.rcp.control.XTextArea xTextArea1;
    private com.rameses.rcp.control.XTextArea xTextArea2;
    private com.rameses.rcp.control.XTextField xTextField1;
    // End of variables declaration//GEN-END:variables
    
}