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

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.annotations.SerializedName;
import io.jarvis.chatsystem.ai.api.util.ParametersConverter;
import io.jarvis.chatsystem.ai.api.util.StringUtils;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Result implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final String DATE_FORMAT_ERROR_MESSAGE = "'%s' parameter has value '%s' and can't be parsed as a Date or Time";

    @SerializedName("action")
    private String action;

    @SerializedName("score")
    private float score;

    @SerializedName("source")
    private String source;

    /**
     * This field will be deserialized as hashMap container with all parameters and it's values
     */
    @SerializedName("parameters")
    private HashMap<String, JsonElement> parameters;

    /**
     * Currently active contexts
     */
    @SerializedName("contexts")
    private List<AIOutputContext> contexts;


    @SerializedName("metadata")
    private Metadata metadata;

    /**
     * The query that was used to produce this result
     */
    @SerializedName("resolvedQuery")
    private String resolvedQuery;

    /**
     * Fulfillment of the response
     */
    @SerializedName("fulfillment")
    private Fulfillment fulfillment;

    @SerializedName("actionIncomplete")
    private boolean actionIncomplete;

    public String getAction() {
        if (action == null) {
            return "";
        }
        return action;
    }

    public void setAction(final String action) {
        this.action = action;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public String getSource() {
        return source;
    }

    public void setSource(final String source) {
        this.source = source;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(final Metadata metadata) {
        this.metadata = metadata;
    }

    public HashMap<String, JsonElement> getParameters() {
        return parameters;
    }

    public String getStringParameter(final String name) {
        return getStringParameter(name, "");
    }

    public String getStringParameter(final String name, final String defaultValue) {
        if (parameters.containsKey(name)) {
            final String parameterValue = parameters.get(name).getAsString();
            return parameterValue;
        }
        return defaultValue;
    }

    public Date getDateParameter(final String name) throws IllegalArgumentException {
        return getDateParameter(name, null);
    }

    public Date getDateParameter(final String name, final Date defaultValue) throws IllegalArgumentException {
        if (parameters.containsKey(name)) {
            final String parameterStringValue = parameters.get(name).getAsString();

            if (StringUtils.isEmpty(parameterStringValue)) {
                return defaultValue;
            }

            try {
                return ParametersConverter.parseDate(parameterStringValue);
            } catch (final ParseException pe) {
                throw new IllegalArgumentException(String.format(DATE_FORMAT_ERROR_MESSAGE, name, parameterStringValue), pe);
            }

        }
        return defaultValue;
    }

    public Date getDateTimeParameter(final String name) throws IllegalArgumentException {
        return getDateTimeParameter(name, null);
    }

    public Date getDateTimeParameter(final String name, final Date defaultValue) throws IllegalArgumentException {
        if (parameters.containsKey(name)) {
            final String parameterStringValue = parameters.get(name).getAsString();

            if (StringUtils.isEmpty(parameterStringValue)) {
                return defaultValue;
            }

            try {
                return ParametersConverter.parseDateTime(parameterStringValue);
            } catch (final ParseException pe) {
                throw new IllegalArgumentException(String.format(DATE_FORMAT_ERROR_MESSAGE, name, parameterStringValue), pe);
            }

        }
        return defaultValue;
    }

    public Date getTimeParameter(final String name) throws IllegalArgumentException {
        return getTimeParameter(name, null);
    }

    public Date getTimeParameter(final String name, final Date defaultValue) throws IllegalArgumentException {
        if (parameters.containsKey(name)) {
            final String parameterStringValue = parameters.get(name).getAsString();

            if (StringUtils.isEmpty(parameterStringValue)) {
                return defaultValue;
            }

            try {
                return ParametersConverter.parseTime(parameterStringValue);
            } catch (final ParseException pe) {
                throw new IllegalArgumentException(String.format(DATE_FORMAT_ERROR_MESSAGE, name, parameterStringValue), pe);
            }

        }
        return defaultValue;
    }

    public int getIntParameter(final String name) {
        return getIntParameter(name, 0);
    }

    public int getIntParameter(final String name, final int defaultValue) {
        if (parameters.containsKey(name)) {
            final String parameterStringValue = parameters.get(name).getAsString();

            if (StringUtils.isEmpty(parameterStringValue)) {
                return defaultValue;
            }

            return ParametersConverter.parseInteger(parameterStringValue);
        }
        return defaultValue;
    }

    public float getFloatParameter(final String name) {
        return getFloatParameter(name, 0);
    }

    public float getFloatParameter(final String name, final float defaultValue) {
        if (parameters.containsKey(name)) {
            final String parameterStringValue = parameters.get(name).getAsString();

            if (StringUtils.isEmpty(parameterStringValue)) {
                return defaultValue;
            }

            return ParametersConverter.parseFloat(parameterStringValue);
        }
        return defaultValue;
    }

    public JsonObject getComplexParameter(final String name, final JsonObject defaultValue) {
        if (parameters.containsKey(name)) {
            final JsonObject jsonObject = parameters.get(name).getAsJsonObject();

            if (jsonObject == null) {
                return defaultValue;
            }

            return jsonObject;
        }
        return defaultValue;
    }

    public JsonObject getComplexParameter(final String name) {
        return getComplexParameter(name, null);
    }

    public List<AIOutputContext> getContexts() {
        return contexts;
    }

    public AIOutputContext getContext(final String name) {
        if (StringUtils.isEmpty(name)) {
            throw new IllegalArgumentException("name argument must be not empty");
        }

        if (contexts == null) {
            return null;
        }

        for (final AIOutputContext c : contexts) {
            if (name.equalsIgnoreCase(c.getName())) {
                return c;
            }
        }

        return null;
    }

    /**
     * The query that was used to produce this result
     */
    public String getResolvedQuery() {
        return resolvedQuery;
    }

    public void setResolvedQuery(final String resolvedQuery) {
        this.resolvedQuery = resolvedQuery;
    }

    public Fulfillment getFulfillment() {
        return fulfillment;
    }

    public void setFulfillment(final Fulfillment fulfillment) {
        this.fulfillment = fulfillment;
    }

    public boolean isActionIncomplete() {
        return actionIncomplete;
    }

    public void setActionIncomplete(final boolean actionIncomplete) {
        this.actionIncomplete = actionIncomplete;
    }

    void trimParameters() {
        if (parameters != null) {
            final List<String> parametersToTrim = new LinkedList<String>();
            for (final String key : parameters.keySet()) {
                final JsonElement jsonElement = parameters.get(key);
                if (jsonElement != null && jsonElement.isJsonPrimitive()) {
                    if (((JsonPrimitive) jsonElement).isString() && StringUtils.isEmpty(jsonElement.getAsString())) {
                        parametersToTrim.add(key);
                    }
                }
            }
            for (final String key : parametersToTrim) {
                parameters.remove(key);
            }
        }
    }

    @Override
    public String toString() {
        return String.format("Result {action='%s', resolvedQuery='%s'}",
                action,
                resolvedQuery);
    }
}
