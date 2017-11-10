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


package org.netbeans.modules.i18n;


import java.util.ResourceBundle;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.StyledDocument;
import org.openide.awt.Mnemonics;


/**
 * Former part of ResourceBundlePanel (now <code>I18nPanel</code>). Helper base class for showing information
 * about found hard coded in java sources (java & form objects).
 *
 * @author  Peter Zavadsky
 */

public abstract class InfoPanel extends JPanel {

    /** Helper bundle in which are internationalized string from this source. */
    private ResourceBundle bundle;

    
    /** Creates new form InfoPanel */
    public InfoPanel(HardCodedString hcString, StyledDocument document) {
        if(bundle == null)
            bundle = I18nUtil.getBundle();

        initComponents ();   
        initAccessibility ();
        
        setHardCodedString(hcString, document);
    }

    /** Sets <code>HardCodedString</code> to inform about. 
     * @param hcString hard coded string to inform about
     * @param document document contaning hard coded string */
    protected abstract void setHardCodedString(HardCodedString hcString, StyledDocument document);

    /** String text field accessor. */
    protected JTextField getStringText() {
        return stringText;
    }
    
    /** Found in text fiedl accessor. */
    protected JTextField getFoundInText() {
        return foundInText;
    }
    
    /** Component text field accessor. */
    protected JTextField getComponentText() {
        return componentText;
    }
    
    /** Property text field accessor. */
    protected JTextField getPropertyText() {
        return propertyText;
    }
    
    /** Componenet label accessor. */
    protected JLabel getComponentLabel() {
        return componentLabel;
    }
    
    /** Property label accessor. */
    protected JLabel getPropertyLabel() {
        return propertyLabel;
    }
    
    private void initAccessibility() {
        this.getAccessibleContext().setAccessibleDescription(bundle.getString("ACS_InfoPanel"));
        stringText.getAccessibleContext().setAccessibleDescription(bundle.getString("ACS_stringText"));
        propertyText.getAccessibleContext().setAccessibleDescription(bundle.getString("ACS_propertyText"));
        componentText.getAccessibleContext().setAccessibleDescription(bundle.getString("ACS_componentText"));
        foundInText.getAccessibleContext().setAccessibleDescription(bundle.getString("ACS_foundInText"));
    }     
    
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the FormEditor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        java.awt.GridBagConstraints gridBagConstraints;

        stringLabel = new javax.swing.JLabel();
        stringText = new javax.swing.JTextField();
        foundInLabel = new javax.swing.JLabel();
        foundInText = new javax.swing.JTextField();
        componentLabel = new javax.swing.JLabel();
        componentText = new javax.swing.JTextField();
        propertyLabel = new javax.swing.JLabel();
        propertyText = new javax.swing.JTextField();

        setLayout(new java.awt.GridBagLayout());

        stringLabel.setLabelFor(stringText);
        Mnemonics.setLocalizedText(stringLabel, bundle.getString("CTL_StringLabel")); // NOI18N 
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 12, 0, 0);
        add(stringLabel, gridBagConstraints);

        stringText.setEditable(false);
        stringText.selectAll();
        stringText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                stringTextFocusGained(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(12, 11, 0, 11);
        add(stringText, gridBagConstraints);

        foundInLabel.setLabelFor(foundInText);
        Mnemonics.setLocalizedText(foundInLabel, bundle.getString("CTL_FoundInLabel")); // NOI18N 
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 12, 0, 0);
        add(foundInLabel, gridBagConstraints);

        foundInText.setEditable(false);
        foundInText.selectAll();
        foundInText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                foundInTextFocusGained(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(11, 11, 0, 11);
        add(foundInText, gridBagConstraints);

        componentLabel.setLabelFor(componentText);
        Mnemonics.setLocalizedText(componentLabel, bundle.getString("CTL_ComponentLabel")); // NOI18N 
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 12, 0, 0);
        add(componentLabel, gridBagConstraints);

        componentText.setEditable(false);
        componentText.selectAll();
        componentText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                componentTextFocusGained(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(11, 11, 0, 11);
        add(componentText, gridBagConstraints);

        propertyLabel.setLabelFor(propertyText);
        Mnemonics.setLocalizedText(propertyLabel, bundle.getString("CTL_PropertyLabel")); // NOI18N 
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 12, 11, 0);
        add(propertyLabel, gridBagConstraints);

        propertyText.setEditable(false);
        propertyText.selectAll();
        propertyText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                propertyTextFocusGained(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(11, 11, 11, 11);
        add(propertyText, gridBagConstraints);

    }//GEN-END:initComponents

    private void propertyTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_propertyTextFocusGained
        // Accessibility
        propertyText.selectAll();
    }//GEN-LAST:event_propertyTextFocusGained

    private void componentTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_componentTextFocusGained
        // Accessibility
        componentText.selectAll();
    }//GEN-LAST:event_componentTextFocusGained

    private void foundInTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_foundInTextFocusGained
        // Accessibility
        foundInText.selectAll();
    }//GEN-LAST:event_foundInTextFocusGained

    private void stringTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_stringTextFocusGained
        // Accessibility
        stringText.selectAll();
    }//GEN-LAST:event_stringTextFocusGained


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel propertyLabel;
    private javax.swing.JLabel stringLabel;
    private javax.swing.JTextField stringText;
    private javax.swing.JTextField propertyText;
    private javax.swing.JLabel foundInLabel;
    private javax.swing.JLabel componentLabel;
    private javax.swing.JTextField componentText;
    private javax.swing.JTextField foundInText;
    // End of variables declaration//GEN-END:variables

}
