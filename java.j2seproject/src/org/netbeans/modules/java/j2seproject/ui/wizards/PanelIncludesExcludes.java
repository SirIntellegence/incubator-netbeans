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

package org.netbeans.modules.java.j2seproject.ui.wizards;

import java.awt.Component;
import java.io.File;
import javax.swing.event.ChangeListener;
import org.netbeans.modules.java.api.common.project.ProjectProperties;
import org.netbeans.spi.java.project.support.ui.IncludeExcludeVisualizer;
import org.openide.WizardDescriptor;
import org.openide.util.HelpCtx;

/**
 * New project from existing sources panel to configure includes and excludes.
 */
class PanelIncludesExcludes implements WizardDescriptor.FinishablePanel {

    private final IncludeExcludeVisualizer viz;

    public PanelIncludesExcludes() {
        viz = new IncludeExcludeVisualizer();
    }

    public boolean isFinishPanel() {
        return true;
    }

    public Component getComponent() {
        return viz.getVisualizerPanel();
    }

    public void addChangeListener(ChangeListener l) {}

    public void removeChangeListener(ChangeListener l) {}

    public boolean isValid() {
        return true;
    }

    public void storeSettings(Object wiz) {
        WizardDescriptor w = (WizardDescriptor) wiz;
        w.putProperty(ProjectProperties.INCLUDES, viz.getIncludePattern());
        w.putProperty(ProjectProperties.EXCLUDES, viz.getExcludePattern());
    }

    public void readSettings(Object wiz) {
        WizardDescriptor w = (WizardDescriptor) wiz;
        String includes = (String) w.getProperty(ProjectProperties.INCLUDES);
        if (includes == null) {
            includes = "**"; // NOI18N
        }
        viz.setIncludePattern(includes);
        String excludes = (String) w.getProperty(ProjectProperties.EXCLUDES);
        if (excludes == null) {
            excludes = ""; // NOI18N
        }
        viz.setExcludePattern(excludes);
        File[] sourceRoots = (File[]) w.getProperty("sourceRoot");
        File[] testRoots = (File[]) w.getProperty("testRoot");
        File[] roots = new File[sourceRoots.length + testRoots.length];
        System.arraycopy(sourceRoots, 0, roots, 0, sourceRoots.length);
        System.arraycopy(testRoots, 0, roots, sourceRoots.length, testRoots.length);
        viz.setRoots(roots);
    }

    public HelpCtx getHelp() {
        return new HelpCtx(PanelIncludesExcludes.class);
    }

}
