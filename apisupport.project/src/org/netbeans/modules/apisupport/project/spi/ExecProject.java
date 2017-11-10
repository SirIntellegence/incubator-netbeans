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
package org.netbeans.modules.apisupport.project.spi;

import java.io.IOException;
import org.openide.util.Task;

/** Abstraction over executing a project.
 *
 * @author Jaroslav Tulach <jtulach@netbeans.org>
 * @since 1.49
 */
public interface ExecProject {
    /** Asks the project to execute itself given provided arguments.
     * 
     * @param args arguments for the execution
     * @return task that will finish as soon as execution is over
     * @throws IOException if the launch fails
     */
    public Task execute(String... args) throws IOException;
}
