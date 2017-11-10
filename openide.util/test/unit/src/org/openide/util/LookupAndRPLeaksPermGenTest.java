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
package org.openide.util;

import java.net.URL;
import java.net.URLClassLoader;
import org.openide.util.Lookup;
import org.openide.util.RequestProcessor;
import org.openide.util.lookup.LookupPermGenLeakTest;

/**
 *
 * @author Jaroslav Tulach <jtulach@netbeans.org>
 */
public class LookupAndRPLeaksPermGenTest extends LookupPermGenLeakTest {
    static {
        System.setProperty("org.openide.util.RequestProcessor.inactiveTime", "600"); // NOI18N
    }
    
    public LookupAndRPLeaksPermGenTest(String name) {
        super(name);
    }

    @Override
    protected URLClassLoader createClassLoader() {
        URLClassLoader loader;
        URL lookup = Lookup.class.getProtectionDomain().getCodeSource().getLocation();
        URL rp = RequestProcessor.class.getProtectionDomain().getCodeSource().getLocation();
        URL tests = LookupPermGenLeakTest.class.getProtectionDomain().getCodeSource().getLocation();
        loader = new URLClassLoader(
            new URL[] { lookup, tests, rp },
            Lookup.class.getClassLoader().getParent()
        );
        return loader;
    }
}
