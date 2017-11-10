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
package org.netbeans.modules.profiler.spi;

import org.netbeans.lib.profiler.common.ProfilingSettings;
import org.openide.util.Lookup;

/**
 * A helper SPI interface for plugging in to the profiling session lifecycle
 * 
 * @author Jaroslav Bachorik
 */
public interface SessionListener {
    /**
     * Default No-op implementation of {@linkplain SessionListener}
     */
    public static abstract class Adapter implements SessionListener {

        @Override
        public void onShutdown() {
        }

        @Override
        public void onStartup(ProfilingSettings ps, Lookup.Provider p) {
        }
    }

    /**
     * Called on the profiling session startup
     * @param ps The {@linkplain ProfilingSettings} used to start the session
     * @param p The associated project
     */
    void onStartup(ProfilingSettings ps, Lookup.Provider p);

    /**
     * Called on the profiling session shutdown
     */
    void onShutdown();
}
