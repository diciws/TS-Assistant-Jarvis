/**
 * Copyright 2017 Google Inc. All Rights Reserved.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.jarvis.chatsystem.ai.api;

import io.jarvis.chatsystem.ai.api.model.AIContext;
import io.jarvis.chatsystem.ai.api.model.AIRequest;
import io.jarvis.chatsystem.ai.api.model.Entity;
import io.jarvis.chatsystem.ai.api.model.Location;

import java.util.List;
import java.util.Map;

/**
 * Extra data for request
 */
public class RequestExtras {
    private List<AIContext> contexts;
    private List<Entity> entities;

    private Boolean resetContexts;

    private Map<String, String> additionalHeaders;

    private Location location;

    public RequestExtras() {
        contexts = null;
        entities = null;
    }

    public RequestExtras(final List<AIContext> contexts, final List<Entity> entities) {
        this.contexts = contexts;
        this.entities = entities;
    }

    public List<AIContext> getContexts() {
        return contexts;
    }

    public void setContexts(final List<AIContext> contexts) {
        this.contexts = contexts;
    }

    public List<Entity> getEntities() {
        return entities;
    }

    public void setEntities(final List<Entity> entities) {
        this.entities = entities;
    }

    public Boolean getResetContexts() {
        return resetContexts;
    }

    public void setResetContexts(final boolean resetContexts) {
        this.resetContexts = resetContexts;
    }

    public Map<String, String> getAdditionalHeaders() {
        return additionalHeaders;
    }

    /**
     * Additional headers to be passed to API.AI service. Must not be used in normal cases.
     * @param additionalHeaders map with headers
     */
    public void setAdditionalHeaders(final Map<String, String> additionalHeaders) {
        this.additionalHeaders = additionalHeaders;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(final Location location) {
        this.location = location;
    }

    public boolean hasContexts() {
        if (contexts != null && !contexts.isEmpty()) {
            return true;
        }
        return false;
    }

    public boolean hasEntities() {
        if (entities != null && !entities.isEmpty()) {
            return true;
        }
        return false;
    }

    public boolean hasAdditionalHeaders() {
        if (additionalHeaders != null && !additionalHeaders.isEmpty()) {
            return true;
        }
        return false;
    }

    public void copyTo(final AIRequest request) {
        if (hasContexts()) {
            request.setContexts(getContexts());
        }

        if (hasEntities()) {
            request.setEntities(getEntities());
        }

        if (getResetContexts() != null) {
            request.setResetContexts(getResetContexts());
        }

    }


}
