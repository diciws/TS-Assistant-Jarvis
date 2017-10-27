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

package io.jarvis.chatsystem.ai.api.model;

import com.google.gson.annotations.SerializedName;
import io.jarvis.chatsystem.ai.api.util.StringUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class QuestionMetadata implements Serializable {

    private static final long serialVersionUID = 1L;

    @SerializedName("timezone")
    private String timezone;

    @SerializedName("lang")
    private String language;

    @SerializedName("sessionId")
    private String sessionId;

    @SerializedName("entities")
    private List<Entity> entities;

    @SerializedName("location")
    private Location location;

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(final String timezone) {
        this.timezone = timezone;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(final String language) {
        if (StringUtils.isEmpty(language)) {
            throw new IllegalArgumentException("language must not be null");
        }

        this.language = language;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(final String sessionId) {
        this.sessionId = sessionId;
    }

    public List<Entity> getEntities() {
        return entities;
    }

    public void setEntities(final List<Entity> entities) {
        this.entities = entities;
    }

    public void addEntity(final Entity entity) {
        if (entities == null) {
            entities = new ArrayList<>();
        }
        entities.add(entity);
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(final Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return String.format("QuestionMetadata{language='%s', timezone='%s'}", language, timezone);
    }
}
