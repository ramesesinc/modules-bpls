package com.rameses.gov.etracs.bpls.views;

import com.rameses.osiris2.themes.FormPage;
import com.rameses.rcp.control.XButton;
import com.rameses.rcp.control.XDateField;
import com.rameses.rcp.control.XFormPanel;
import com.rameses.rcp.control.XTextArea;
import com.rameses.rcp.control.layout.XLayout;
import com.rameses.rcp.control.layout.YLayout;
import com.rameses.rcp.ui.annotations.Template;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

@Template({FormPage.class})
public class ClosureCreatePage extends JPanel
{
  private JPanel jPanel1;
  private JScrollPane jScrollPane1;
  private XButton xButton2;
  private XButton xButton3;
  private XDateField xDateField1;
  private XFormPanel xFormPanel1;
  private XTextArea xTextArea1;

  public ClosureCreatePage()
  {
    initComponents();
  }

  private void initComponents()
  {
    this.xFormPanel1 = new XFormPanel();
    this.xDateField1 = new XDateField();
    this.jScrollPane1 = new JScrollPane();
    this.xTextArea1 = new XTextArea();
    this.jPanel1 = new JPanel();
    this.xButton2 = new XButton();
    this.xButton3 = new XButton();

    setBorder(BorderFactory.createEmptyBorder(40, 20, 20, 20));
    setLayout(new YLayout());

    this.xFormPanel1.setCaptionFont(new Font("Dialog", 0, 14));
    this.xFormPanel1.setCaptionVAlignment("CENTER");

    this.xDateField1.setCaption("Date Ceased");
    this.xDateField1.setName("info.dtceased");
    this.xDateField1.setCaptionFont(new Font("SansSerif", 0, 14));
    this.xDateField1.setCaptionFontStyle("font-size: 14;");
    this.xDateField1.setCaptionWidth(120);
    this.xDateField1.setFont(new Font("SansSerif", 0, 14));
    this.xDateField1.setFontStyle("font-size: 14;");
    this.xDateField1.setPreferredSize(new Dimension(300, 22));
    this.xDateField1.setRequired(true);
    this.xFormPanel1.add(this.xDateField1);

    this.jScrollPane1.setPreferredSize(new Dimension(300, 70));

    this.xTextArea1.setCaption("Remarks");
    this.xTextArea1.setName("info.remarks");
    this.xTextArea1.setCaptionFontStyle("font-size: 14;");
    this.xTextArea1.setCaptionWidth(120);
    this.xTextArea1.setFont(new Font("Dialog", 0, 14));
    this.xTextArea1.setFontStyle("font-size: 14;");
    this.xTextArea1.setMargin(new Insets(5, 5, 1, 2));
    this.jScrollPane1.setViewportView(this.xTextArea1);

    this.xFormPanel1.add(this.jScrollPane1);

    add(this.xFormPanel1);

    this.jPanel1.setBorder(BorderFactory.createEmptyBorder(10, 124, 0, 0));
    XLayout xLayout1 = new XLayout();
    xLayout1.setSpacing(10);
    this.jPanel1.setLayout(xLayout1);

    this.xButton2.setMnemonic('s');
    this.xButton2.setName("doSubmit");
    this.xButton2.setFontStyle("font-size:14;");
    this.xButton2.setText("Submit");
    this.jPanel1.add(this.xButton2);

    this.xButton3.setMnemonic('c');
    this.xButton3.setName("doCancel");
    this.xButton3.setFontStyle("font-size:14;");
    this.xButton3.setText("Cancel");
    this.jPanel1.add(this.xButton3);

    add(this.jPanel1);
  }
}