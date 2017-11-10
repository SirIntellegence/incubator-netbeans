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
package org.netbeans.modules.csl.api;

import javax.swing.Action;
import javax.swing.text.BadLocationException;
import javax.swing.text.JTextComponent;

/** @author Sandip V. Chitale (Sandip.Chitale@Sun.Com)
 * @deprecated use {@link CslActions#createDeleteCamelCasePositionAction(javax.swing.Action, boolean) } instead.
 */
public final class DeleteToNextCamelCasePosition extends SelectNextCamelCasePosition {
    public static final String deleteNextCamelCasePosition = "delete-next-camel-case-position"; //NOI18N

    public DeleteToNextCamelCasePosition(Action originalAction) {
        super(deleteNextCamelCasePosition, originalAction);
    }

    protected @Override void moveToNewOffset(JTextComponent textComponent, int offset) throws BadLocationException {
        textComponent.getDocument().remove(textComponent.getCaretPosition(), offset - textComponent.getCaretPosition());
    }
}
