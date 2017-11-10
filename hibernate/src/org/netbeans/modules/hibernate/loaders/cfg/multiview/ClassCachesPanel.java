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

package org.netbeans.modules.hibernate.loaders.cfg.multiview;

import org.netbeans.modules.hibernate.loaders.cfg.*;
import org.netbeans.modules.xml.multiview.ui.SectionInnerPanel;
import org.netbeans.modules.xml.multiview.ui.SectionView;

/**
 * Panel for displaying and editing class cache element
 * 
 * @author  Dongmei Cao
 */
public class ClassCachesPanel extends SectionInnerPanel {

    public ClassCachesPanel(SectionView view, final HibernateCfgDataObject dObj) {
        super(view);
        initComponents();
        // Error Pages
        ClassCachesTableModel model = new ClassCachesTableModel(dObj.getHibernateConfiguration().getSessionFactory());
        ClassCachesTablePanel panel = new ClassCachesTablePanel(dObj, model);
        //panel.setModel(dObj.getWebApp(),dObj.getWebApp().getContextParam());
        java.awt.GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        //gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 0, 0);
        gridBagConstraints.weightx = 1.0;
        //gridBagConstraints.weighty = 5.0;
        add(panel, gridBagConstraints);
    }

    public javax.swing.JComponent getErrorComponent(String errorId) {
        return null;
    }

    public void setValue(javax.swing.JComponent source, Object value) {
    }

    public void linkButtonPressed(Object obj, String id) {
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        filler = new javax.swing.JPanel();

        setLayout(new java.awt.GridBagLayout());

        filler.setOpaque(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        add(filler, gridBagConstraints);
    }// </editor-fold>
    // Variables declaration - do not modify
    private javax.swing.JPanel filler;
    // End of variables declaration
}
