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
 * DefaultVisitor.java
 *
 * Created on March 10, 2006, 12:08 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.netbeans.modules.xml.axi.visitor;

import org.netbeans.modules.xml.axi.AXIDocument;
import org.netbeans.modules.xml.axi.AnyAttribute;
import org.netbeans.modules.xml.axi.AnyElement;
import org.netbeans.modules.xml.axi.Attribute;
import org.netbeans.modules.xml.axi.Compositor;
import org.netbeans.modules.xml.axi.Element;
import org.netbeans.modules.xml.axi.ContentModel;
import org.netbeans.modules.xml.axi.SchemaReference;
import org.netbeans.modules.xml.axi.datatype.Datatype;

/**
 *
 * @author Samaresh (Samaresh.Panda@Sun.Com)
 */
public abstract class DefaultVisitor implements AXIVisitor2 {
        
    /**
     * Creates a new instance of DefaultVisitor
     */
    public DefaultVisitor() {
    }
    
    public void visit(AXIDocument root) {        
    }
    
    public void visit(Element element) {        
    }
    
    public void visit(AnyElement element) {
    }
    
    public void visit(Attribute attribute) {        
    }
        
    public void visit(AnyAttribute attribute) {        
    }
    
    public void visit(Compositor compositor) {
    }
    
    public void visit(ContentModel contentModel) {      
    }
    
    public void visit(Datatype datatype) {      
    }	

    @Override
    public void visit(SchemaReference ref) {
    }
}
