/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.netbeans.modules.xml.wizard.impl;

import org.netbeans.modules.xml.wizard.*;
import org.netbeans.modules.xml.util.Util;

/**
 *
 * @author  Petr Kuzel
 */
public class DocumentPanel extends AbstractPanel {
    /** Serial Version UID */
    private static final long serialVersionUID = 3793605846188902177L;


    /** Creates new form DocumentPanel */
    public DocumentPanel() {
        initComponents();
        initAccessibility();

        // switch off extensibity point - not implemented
        otherRadioButton.setVisible(false);
        otherComboBox.setVisible(false);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        buttonGroup = new javax.swing.ButtonGroup();
        descTextArea = new javax.swing.JTextArea();
        wellformedRadioButton = new javax.swing.JRadioButton();
        dtdConstrainedRadioButton = new javax.swing.JRadioButton();
        schemaConstrainedRadioButton = new javax.swing.JRadioButton();
        otherRadioButton = new javax.swing.JRadioButton();
        otherComboBox = new javax.swing.JComboBox();
        fillPanel = new javax.swing.JPanel();

        setName(Util.THIS.getString(DocumentPanel.class, "PROP_doc_panel_name")); // NOI18N
        setLayout(new java.awt.GridBagLayout());

        descTextArea.setEditable(false);
        descTextArea.setLineWrap(true);
        descTextArea.setText(Util.THIS.getString(DocumentPanel.class, "MSG_document_panel_desc")); // NOI18N
        descTextArea.setWrapStyleWord(true);
        descTextArea.setDisabledTextColor(descTextArea.getForeground());
        descTextArea.setEnabled(false);
        descTextArea.setOpaque(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 12, 0);
        add(descTextArea, gridBagConstraints);

        buttonGroup.add(wellformedRadioButton);
        wellformedRadioButton.setText(Util.THIS.getString(DocumentPanel.class, "PROP_wellformed_name")); // NOI18N
        wellformedRadioButton.setToolTipText("null");
        wellformedRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wellformedRadioButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 12, 12, 0);
        add(wellformedRadioButton, gridBagConstraints);

        buttonGroup.add(dtdConstrainedRadioButton);
        dtdConstrainedRadioButton.setText(Util.THIS.getString(DocumentPanel.class, "PROP_dtd_doc_name")); // NOI18N
        dtdConstrainedRadioButton.setToolTipText("null");
        dtdConstrainedRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dtdConstrainedRadioButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 12, 12, 0);
        add(dtdConstrainedRadioButton, gridBagConstraints);

        buttonGroup.add(schemaConstrainedRadioButton);
        schemaConstrainedRadioButton.setText(Util.THIS.getString(DocumentPanel.class, "PROP_schema_doc_name")); // NOI18N
        schemaConstrainedRadioButton.setToolTipText("null");
        schemaConstrainedRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                schemaConstrainedRadioButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 12, 12, 0);
        add(schemaConstrainedRadioButton, gridBagConstraints);

        buttonGroup.add(otherRadioButton);
        otherRadioButton.setText(Util.THIS.getString(DocumentPanel.class, "PROP_other_doc_name")); // NOI18N
        otherRadioButton.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 12, 0, 12);
        add(otherRadioButton, gridBagConstraints);

        otherComboBox.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        add(otherComboBox, gridBagConstraints);

        fillPanel.setLayout(null);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(fillPanel, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void initAccessibility() {

        Util util = Util.THIS;
        wellformedRadioButton.setMnemonic(util.getChar(
                DocumentPanel.class, "PROP_doc_wellformedRadioButton_mne"));
        schemaConstrainedRadioButton.setMnemonic(util.getChar(
                DocumentPanel.class, "PROP_doc_schemaConstrainedRadioButton_mne"));
        dtdConstrainedRadioButton.setMnemonic(util.getChar(
                DocumentPanel.class, "PROP_doc_dtdConstrainedRadioButton_mne"));        
        getAccessibleContext().setAccessibleDescription(descTextArea.getText());        
    }
    
    private void schemaConstrainedRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_schemaConstrainedRadioButtonActionPerformed
        updateModel();
    }//GEN-LAST:event_schemaConstrainedRadioButtonActionPerformed

    private void dtdConstrainedRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dtdConstrainedRadioButtonActionPerformed
        updateModel();
    }//GEN-LAST:event_dtdConstrainedRadioButtonActionPerformed

    private void wellformedRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wellformedRadioButtonActionPerformed
        updateModel();
    }//GEN-LAST:event_wellformedRadioButtonActionPerformed

    /** User just entered the panel, init view by model values
     */
    protected void initView() {
        int type = model.getType();
        switch (type) {
            case DocumentModel.NONE:
                wellformedRadioButton.setSelected(true);
                break;
            case DocumentModel.DTD:
                dtdConstrainedRadioButton.setSelected(true);
                break;
            case DocumentModel.SCHEMA:
                schemaConstrainedRadioButton.setSelected(true);
                break;
            case DocumentModel.OTHER:
                otherRadioButton.setSelected(true);
                break;
            default:
                throw new IllegalStateException();
        }
    }    
    
    /** User just leaved the panel, update model
     */
    protected void updateModel() {
        if (wellformedRadioButton.isSelected()) {
            model.setType(model.NONE);
        } else if (dtdConstrainedRadioButton.isSelected()) {
            model.setType(model.DTD);
        } else if (schemaConstrainedRadioButton.isSelected()) {
            model.setType(model.SCHEMA);
        } else {
            model.setType(model.OTHER);
        }
    }    
    
    /** User just reentered the panel.
     */
    protected void updateView() {
        // no dynamic update needed
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JTextArea descTextArea;
    private javax.swing.JRadioButton dtdConstrainedRadioButton;
    private javax.swing.JPanel fillPanel;
    private javax.swing.JComboBox otherComboBox;
    private javax.swing.JRadioButton otherRadioButton;
    private javax.swing.JRadioButton schemaConstrainedRadioButton;
    private javax.swing.JRadioButton wellformedRadioButton;
    // End of variables declaration//GEN-END:variables

}
