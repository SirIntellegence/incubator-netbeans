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
package org.netbeans.modules.form;

import java.util.*;
import javax.swing.*;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import org.openide.util.Utilities;

/**
 * Component that allows you to select (reordered) sublist from given list of items.
 *
 * @author Jan Stola
 */
public class ListSelector extends javax.swing.JPanel {
    
    public ListSelector() {
        initComponents();
        ListDataListener listener = new ListDataListener() {
            @Override
            public void contentsChanged(ListDataEvent e) {
                if (e.getSource() == availableList.getModel()) {
                    addAllButton.setEnabled(availableList.getModel().getSize() != 0);
                } else if (e.getSource() == selectedList.getModel()) {
                    removeAllButton.setEnabled(selectedList.getModel().getSize() != 0);
                }
            }
            @Override
            public void intervalAdded(ListDataEvent e) {
                contentsChanged(e);
            }
            @Override
            public void intervalRemoved(ListDataEvent e) {
                contentsChanged(e);
            }
        };
        availableList.getModel().addListDataListener(listener);
        selectedList.getModel().addListDataListener(listener);
    }

    public void setItems(List available, List selected) {
        DefaultListModel model = (DefaultListModel)availableList.getModel();
        model.clear();
        for (Object item : available) {
            model.addElement(item);
        }
        model = (DefaultListModel)selectedList.getModel();
        model.clear();
        for (Object item : selected) {
            model.addElement(item);
        }
    }

    public List getSelectedItems() {
        DefaultListModel model = (DefaultListModel)selectedList.getModel();
        return Arrays.asList(model.toArray());
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        availableLabel = new javax.swing.JLabel();
        availableScrollPane = new javax.swing.JScrollPane();
        availableList = new javax.swing.JList();
        addButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        addAllButton = new javax.swing.JButton();
        removeAllButton = new javax.swing.JButton();
        selectedScrollPane = new javax.swing.JScrollPane();
        selectedList = new javax.swing.JList();
        upButton = new javax.swing.JButton();
        downButton = new javax.swing.JButton();
        selectedLabel = new javax.swing.JLabel();

        availableLabel.setLabelFor(availableList);
        org.openide.awt.Mnemonics.setLocalizedText(availableLabel, org.openide.util.NbBundle.getMessage(ListSelector.class, "MSG_ListSelector_Available")); // NOI18N

        availableList.setModel(new DefaultListModel());
        availableList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                availableListValueChanged(evt);
            }
        });
        availableScrollPane.setViewportView(availableList);
        availableList.getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getMessage(ListSelector.class, "MSG_ListSelector_Available_ACSN")); // NOI18N
        availableList.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(ListSelector.class, "MSG_ListSelector_Available_ACSD")); // NOI18N

        addButton.setText(org.openide.util.NbBundle.getMessage(ListSelector.class, "MSG_ListSelector_Add")); // NOI18N
        addButton.setEnabled(false);
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        removeButton.setText(org.openide.util.NbBundle.getMessage(ListSelector.class, "MSG_ListSelector_Remove")); // NOI18N
        removeButton.setEnabled(false);
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        addAllButton.setText(org.openide.util.NbBundle.getMessage(ListSelector.class, "MSG_ListSelector_AddAll")); // NOI18N
        addAllButton.setEnabled(false);
        addAllButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAllButtonActionPerformed(evt);
            }
        });

        removeAllButton.setText(org.openide.util.NbBundle.getMessage(ListSelector.class, "MSG_ListSelector_RemoveAll")); // NOI18N
        removeAllButton.setEnabled(false);
        removeAllButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeAllButtonActionPerformed(evt);
            }
        });

        selectedList.setModel(new DefaultListModel());
        selectedList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                selectedListValueChanged(evt);
            }
        });
        selectedScrollPane.setViewportView(selectedList);
        selectedList.getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getMessage(ListSelector.class, "MSG_ListSelector_Selected_ACSN")); // NOI18N
        selectedList.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(ListSelector.class, "MSG_ListSelector_Selected_ACSD")); // NOI18N

        upButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/netbeans/modules/form/resources/up.gif"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(upButton, org.openide.util.NbBundle.getMessage(ListSelector.class, "MSG_ListSelector_Up")); // NOI18N
        upButton.setEnabled(false);
        upButton.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        if (!Utilities.isMac()) {
            upButton.setMargin(new java.awt.Insets(2, 6, 2, 6));
        }
        upButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upButtonActionPerformed(evt);
            }
        });

        downButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/netbeans/modules/form/resources/down.gif"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(downButton, org.openide.util.NbBundle.getMessage(ListSelector.class, "MSG_ListSelector_Down")); // NOI18N
        downButton.setEnabled(false);
        downButton.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        if (!Utilities.isMac()) {
            downButton.setMargin(new java.awt.Insets(2, 6, 2, 6));
        }
        downButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                downButtonActionPerformed(evt);
            }
        });

        selectedLabel.setLabelFor(selectedList);
        org.openide.awt.Mnemonics.setLocalizedText(selectedLabel, org.openide.util.NbBundle.getMessage(ListSelector.class, "MSG_ListSelector_Selected")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(availableLabel)
                    .addComponent(availableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(addButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(removeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addAllButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(removeAllButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(selectedScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                    .addComponent(selectedLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(downButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(upButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(availableLabel)
                    .addComponent(selectedLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                        .addComponent(upButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(downButton)
                        .addContainerGap(46, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                        .addComponent(addButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addAllButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removeButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removeAllButton)
                        .addContainerGap(17, Short.MAX_VALUE))
                    .addComponent(availableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                    .addComponent(selectedScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)))
        );

        addButton.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(ListSelector.class, "MSG_ListSelector_Add_ACSD")); // NOI18N
        removeButton.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(ListSelector.class, "MSG_ListSelector_Remove_ACSD")); // NOI18N
        addAllButton.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(ListSelector.class, "MSG_ListSelector_AddAll_ACSD")); // NOI18N
        removeAllButton.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(ListSelector.class, "MSG_ListSelector_RemoveAll_ACSD")); // NOI18N
        upButton.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(ListSelector.class, "MSG_ListSelector_Up_ACSD")); // NOI18N
        downButton.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(ListSelector.class, "MSG_ListSelector_Down_ACSD")); // NOI18N
    }// </editor-fold>//GEN-END:initComponents

    private void downButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_downButtonActionPerformed
        DefaultListModel model = (DefaultListModel)selectedList.getModel();
        int index = selectedList.getSelectedIndex();
        Object item = model.remove(index);
        model.add(index+1, item);
        selectedList.setSelectedIndex(index+1);
        selectedList.ensureIndexIsVisible(index+1);
    }//GEN-LAST:event_downButtonActionPerformed

    private void upButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upButtonActionPerformed
        DefaultListModel model = (DefaultListModel)selectedList.getModel();
        int index = selectedList.getSelectedIndex();
        Object item = model.remove(index);
        model.add(index-1, item);
        selectedList.setSelectedIndex(index-1);
        selectedList.ensureIndexIsVisible(index-1);
    }//GEN-LAST:event_upButtonActionPerformed

    private void removeAllButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeAllButtonActionPerformed
        moveListItems(selectedList, availableList, false);
    }//GEN-LAST:event_removeAllButtonActionPerformed

    private void addAllButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAllButtonActionPerformed
        moveListItems(availableList, selectedList, false);
    }//GEN-LAST:event_addAllButtonActionPerformed

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        moveListItems(selectedList, availableList, true);
    }//GEN-LAST:event_removeButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        moveListItems(availableList, selectedList, true);
    }//GEN-LAST:event_addButtonActionPerformed

    private void selectedListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_selectedListValueChanged
        removeButton.setEnabled(selectedList.getSelectedIndex() != -1);
        int[] index = selectedList.getSelectedIndices();
        upButton.setEnabled((index.length == 1) && (index[0] != 0));
        downButton.setEnabled((index.length == 1) && (index[0] != selectedList.getModel().getSize()-1));
    }//GEN-LAST:event_selectedListValueChanged

    private void availableListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_availableListValueChanged
        addButton.setEnabled(availableList.getSelectedIndex() != -1);
    }//GEN-LAST:event_availableListValueChanged
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addAllButton;
    private javax.swing.JButton addButton;
    private javax.swing.JLabel availableLabel;
    private javax.swing.JList availableList;
    private javax.swing.JScrollPane availableScrollPane;
    private javax.swing.JButton downButton;
    private javax.swing.JButton removeAllButton;
    private javax.swing.JButton removeButton;
    private javax.swing.JLabel selectedLabel;
    private javax.swing.JList selectedList;
    private javax.swing.JScrollPane selectedScrollPane;
    private javax.swing.JButton upButton;
    // End of variables declaration//GEN-END:variables

    /**
     * Moves items of <code>fromList</code> into <code>toList</code>.
     *
     * @param fromList list to move the items from.
     * @param toList list to move the items to.
     * @param selected determines whether to move all items or just the selected ones.
     */
    private static void moveListItems(JList fromList, JList toList, boolean selected) {
        DefaultListModel fromModel = (DefaultListModel)fromList.getModel();
        DefaultListModel toModel = (DefaultListModel)toList.getModel();
        if (selected) {
            int[] index = fromList.getSelectedIndices();
            for (int i=0; i<index.length; i++) {
                Object item = fromModel.getElementAt(index[i]);
                toModel.addElement(item);
            }
            for (int i=index.length-1; i>=0; i--) {
                fromModel.removeElementAt(index[i]);
            }
        } else {
            Enumeration items = fromModel.elements();
            while (items.hasMoreElements()) {
                toModel.addElement(items.nextElement());
            }
            fromModel.clear();
        }
    }
    
}
