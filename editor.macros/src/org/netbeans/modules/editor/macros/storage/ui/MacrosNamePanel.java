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

/*
 * MacrosNamePanel.java
 *
 * Created on 05.05.2009, 16:37:12
 */

package org.netbeans.modules.editor.macros.storage.ui;

import java.awt.Color;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


/**
 *
 * @author sp153251
 */
class MacrosNamePanel extends javax.swing.JPanel {

    private transient ChangeListener parent;

    private final Color regularColor;
    private final Color errColor;
    
    /** Creates new form MacrosNamePanel */
    public MacrosNamePanel() {
        initComponents();
        regularColor = nameField.getForeground();
        errColor = (Color)UIManager.getDefaults().getColor("nb.errorForeground"); // NOI18N
        setErrorMessage(null);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        errorLabel = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setMinimumSize(new java.awt.Dimension(100, 50));
        setPreferredSize(new java.awt.Dimension(340, 82));

        label.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        label.setLabelFor(nameField);
        org.openide.awt.Mnemonics.setLocalizedText(label, org.openide.util.NbBundle.getMessage(MacrosNamePanel.class, "CTL_Enter_macro_name")); // NOI18N

        nameField.setMinimumSize(new java.awt.Dimension(44, 24));
        nameField.setPreferredSize(new java.awt.Dimension(120, 24));
        nameField.selectAll();

        errorLabel.setForeground(new java.awt.Color(255, 0, 0));
        errorLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(errorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(5, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(errorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        nameField.getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getMessage(MacrosNamePanel.class, "AN_Enter_macro_name")); // NOI18N
        nameField.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(MacrosNamePanel.class, "AD_Enter_macro_name")); // NOI18N
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel errorLabel;
    private javax.swing.JLabel label;
    private javax.swing.JTextField nameField;
    // End of variables declaration//GEN-END:variables

    public String getNameValue() {
        return nameField.getText();
    }

    public void setChangeListener(ChangeListener textListener)
    {
        parent=textListener;
        nameField.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent event) {
                MacrosNamePanel.this.parent.stateChanged(null);
            }
            public void insertUpdate(DocumentEvent event) {
                MacrosNamePanel.this.parent.stateChanged(null);
            }
            public void removeUpdate(DocumentEvent event) {
                MacrosNamePanel.this.parent.stateChanged(null);
            }
        });
        parent.stateChanged(null);
    }

    private void setTextColor(Color color)
    {
        nameField.setForeground(color);
    }

    public void setErrorMessage(String text)
    {
        if(text!=null && text.length()>0)
        {
            errorLabel.setText(text);
            errorLabel.setFocusable(true);
            setTextColor(errColor);
        }
        else
        {
            errorLabel.setText(" ");//NOI18N, set not empty to avoid relayout
            errorLabel.setFocusable(false);
            setTextColor(regularColor);
        }
    }

}
