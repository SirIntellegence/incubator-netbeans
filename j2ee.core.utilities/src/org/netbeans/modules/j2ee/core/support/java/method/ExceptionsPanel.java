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

package org.netbeans.modules.j2ee.core.support.java.method;

import java.awt.Component;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.lang.model.element.TypeElement;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.text.JTextComponent;
import org.netbeans.api.java.source.ClassIndex.NameKind;
import org.netbeans.api.java.source.ClassIndex.SearchScope;
import org.netbeans.api.java.source.ClasspathInfo;
import org.netbeans.api.java.source.ElementHandle;
import org.netbeans.api.java.source.ui.TypeElementFinder;
import org.openide.util.NbBundle;

/**
 *
 * @author  Martin Adamek
 */
public final class ExceptionsPanel extends javax.swing.JPanel {
    
    private final ExceptionsTableModel tableModel;
    private final ClasspathInfo cpInfo;
    
    public ExceptionsPanel(List<String> parameters, ClasspathInfo cpInfo) {
        initComponents();
        tableModel = new ExceptionsTableModel(parameters);
        this.cpInfo = cpInfo;
        table.setModel(tableModel);

        table.putClientProperty("terminateEditOnFocusLost", Boolean.TRUE); // NOI18N

//        ListSelectionListener listSelectionListener = new ListSelectionListenerImpl();
//        table.getSelectionModel().addListSelectionListener(listSelectionListener);
//        table.getColumnModel().getSelectionModel().addListSelectionListener(listSelectionListener);

        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                updateButtons();
            }
        });
        table.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                updateButtons();
            }
        });
        
        updateButtons();
    }
    
    public List<String> getExceptions() {
        return tableModel.getExceptions();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        addButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        upButton = new javax.swing.JButton();
        downButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(table);
        table.getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getMessage(ExceptionsPanel.class, "ACSN_ExceptionsTab")); // NOI18N
        table.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(ExceptionsPanel.class, "ACSD_ExceptionsTab")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(addButton, org.openide.util.NbBundle.getMessage(ExceptionsPanel.class, "ParametersPanel.addButton.text")); // NOI18N
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(removeButton, org.openide.util.NbBundle.getMessage(ExceptionsPanel.class, "ParametersPanel.removeButton.text")); // NOI18N
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(upButton, org.openide.util.NbBundle.getMessage(ExceptionsPanel.class, "ParametersPanel.upButton.text")); // NOI18N
        upButton.setEnabled(false);
        upButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(downButton, org.openide.util.NbBundle.getMessage(ExceptionsPanel.class, "ParametersPanel.downButton.text")); // NOI18N
        downButton.setEnabled(false);
        downButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                downButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(editButton, org.openide.util.NbBundle.getMessage(ExceptionsPanel.class, "ExceptionsPanel.editButton.text_1")); // NOI18N
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addButton)
                    .addComponent(removeButton)
                    .addComponent(editButton)
                    .addComponent(upButton)
                    .addComponent(downButton))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {addButton, downButton, editButton, removeButton, upButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removeButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editButton)
                        .addGap(18, 18, 18)
                        .addComponent(upButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(downButton))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE))
                .addContainerGap())
        );

        addButton.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(ExceptionsPanel.class, "ACSD_AddExceptionIntoTab")); // NOI18N
        removeButton.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(ExceptionsPanel.class, "ACSD_RemoveExceptionFromTab")); // NOI18N
        upButton.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(ExceptionsPanel.class, "ACSD_MoveUpInExcepTab")); // NOI18N
        downButton.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(ExceptionsPanel.class, "ACSD_MoveDownInExceptionTab")); // NOI18N
        editButton.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(ExceptionsPanel.class, "ACSD_editExceptionButton")); // NOI18N
    }// </editor-fold>//GEN-END:initComponents

private void downButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_downButtonActionPerformed
    int selIndex = table.getSelectedRow();
    int newIndex = selIndex + 1;
    if (newIndex < tableModel.getExceptions().size()) {
        tableModel.set(newIndex, tableModel.set(selIndex, tableModel.getException(newIndex)));
        table.setRowSelectionInterval(newIndex, newIndex);
        updateButtons();
    }
}//GEN-LAST:event_downButtonActionPerformed

private void upButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upButtonActionPerformed
    int selIndex = table.getSelectedRow();
    int newIndex = selIndex - 1;
    if (newIndex >= 0) {
        tableModel.set(newIndex, tableModel.set(selIndex, tableModel.getException(newIndex)));
        table.setRowSelectionInterval(newIndex, newIndex);
        updateButtons();
    }
}//GEN-LAST:event_upButtonActionPerformed
    
private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
    int selectedRow = table.getSelectedRow();
    if (selectedRow > -1) {
        tableModel.removeException(selectedRow);
    }
    if (selectedRow == table.getRowCount()) {
        selectedRow--;
    }
    table.getSelectionModel().setSelectionInterval(selectedRow, selectedRow);
    updateButtons();
}//GEN-LAST:event_removeButtonActionPerformed

private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
    ElementHandle<TypeElement> handle = browseExceptions();
    if (handle != null) {
        int index = tableModel.addException(handle.getQualifiedName());
        table.getSelectionModel().setSelectionInterval(index, index);
        table.getColumnModel().getSelectionModel().setSelectionInterval(0, 0);
        updateButtons();
    }
}//GEN-LAST:event_addButtonActionPerformed

private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
    final ElementHandle<TypeElement> handle = browseExceptions();
    if (handle != null) {
        int index = table.getSelectedRow();
        table.getSelectionModel().setSelectionInterval(index, index);
        table.getColumnModel().getSelectionModel().setSelectionInterval(0, 0);
        tableModel.setValueAt(handle.getQualifiedName(), index, 0);
    }
}//GEN-LAST:event_editButtonActionPerformed

    private ElementHandle<TypeElement> browseExceptions() {
        return TypeElementFinder.find(cpInfo, new TypeElementFinder.Customizer() {
            public Set<ElementHandle<TypeElement>> query(ClasspathInfo classpathInfo, String textForQuery, NameKind nameKind, Set<SearchScope> searchScopes) {                                            
                return classpathInfo.getClassIndex().getDeclaredTypes(textForQuery, nameKind, searchScopes);
            }

            public boolean accept(ElementHandle<TypeElement> typeHandle) {
                return true;
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton downButton;
    private javax.swing.JButton editButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton removeButton;
    private javax.swing.JTable table;
    private javax.swing.JButton upButton;
    // End of variables declaration//GEN-END:variables
    
    private void updateButtons() {
        int selIndex = table.getSelectedRow();
        boolean oneSelected = table.getSelectedRowCount() == 1;
        
        removeButton.setEnabled(oneSelected);
        editButton.setEnabled(oneSelected);
        upButton.setEnabled(oneSelected && (selIndex > 0));
        downButton.setEnabled(oneSelected && (selIndex < tableModel.getRowCount() - 1));
    }
    
    // accessible for test
    static class ExceptionsTableModel extends AbstractTableModel {
        
        private final List<String> exceptions;
        
        public ExceptionsTableModel(List<String> parameters) {
            this.exceptions = new ArrayList<String>(parameters);
        }
        
        public List<String> getExceptions() {
            return exceptions;
        }
        
        public int addException(String exceptionName) {
            int index = exceptions.size();
            exceptions.add(exceptionName);
            fireTableRowsInserted(index, index);
            return index;
        }
        
        public void removeException(int index) {
            exceptions.remove(index);
            fireTableRowsDeleted(index, index);
        }
        
        public String getException(int index) {
            return exceptions.get(index);
        }
        
        public String set(int index, String exception) {
            return exceptions.set(index, exception);
        }

        public int getRowCount() {
            return exceptions.size();
        }
        
        public int getColumnCount() {
            return 1;
        }
        
        public Object getValueAt(int row, int column) {
            Object result = null;
            if (row >= 0) {
                result = exceptions.get(row);
            }
            return result;
        }
        
        public String getColumnName(int column) {
            return NbBundle.getMessage(ParametersPanel.class, "ExceptionsPanel.LBL_Exception");
        }

        public boolean isCellEditable(int row, int column) {
            return true;
        }
        
        public void setValueAt(Object aValue, int row, int column) {
            exceptions.set(row, (String) aValue);
            fireTableCellUpdated(row, column);
        }
        
        // JTable uses this method to determine the default renderer/editor for each cell.
        // If we didn't implement this method, then the last column would contain
        // text ("true"/"false"), rather than a check box.
        public Class getColumnClass(int c) {
            return getValueAt(0, c).getClass();
        }
        
    }
    
    private class ListSelectionListenerImpl implements ListSelectionListener {

        public void valueChanged(ListSelectionEvent e) {
            table.editCellAt(table.getSelectedRow(), table.getSelectedColumn());
            Component editor = table.getEditorComponent();
            if (editor != null) {
                editor.requestFocus();
            }
            if (editor instanceof JTextComponent) {
                JTextComponent textComp = (JTextComponent) editor;
                textComp.selectAll();
            }
        }

    }

}
