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

package org.netbeans.modules.bugtracking.vcs;

import java.awt.Image;
import java.util.Arrays;
import java.util.Collection;
import org.netbeans.modules.bugtracking.TestIssue;
import org.netbeans.modules.bugtracking.TestRepository;
import org.netbeans.modules.bugtracking.spi.*;

/**
 *
 * @author Tomas Stupka
 */
public class HookRepository extends TestRepository {
    private final RepositoryInfo info = new RepositoryInfo("HookRepository", "HookRepository", "http://url", "HookRepository", "HookRepository", null, null, null, null);

    @Override
    public RepositoryInfo getInfo() {
        return info;
    }

    @Override
    public Image getIcon() {
        return null;
    }

    @Override
    public Collection<TestIssue> getIssues(String[] id) {
        return Arrays.asList(new TestIssue[] {HookIssue.instance});
    }

    @Override
    public Collection<TestIssue> simpleSearch(String criteria) {
        return Arrays.asList(new TestIssue[] {HookIssue.instance});
    }
}
