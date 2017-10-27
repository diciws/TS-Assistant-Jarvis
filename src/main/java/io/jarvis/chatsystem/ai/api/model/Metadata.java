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

import java.io.Serializable;

public class Metadata implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Name of the intent that produced this result
     */
    @SerializedName("intentName")
    private String intentName;

    /**
     * Id of the intent that produced this result
     */
    @SerializedName("intentId")
    private String intentId;

    /**
     * Indicates wheather webhook functionaly is enabled in the triggered intent.
     */
    @SerializedName("webhookUsed")
    private String webhookUsed;

    /**
     * Name of the intent that produced this result
     */
    public String getIntentName() {
        return intentName;
    }

    public void setIntentName(final String intentName) {
        this.intentName = intentName;
    }

    /**
     * Id of the intent that produced this result
     */
    public String getIntentId() {
        return intentId;
    }

    public void setIntentId(final String intentId) {
        this.intentId = intentId;
    }

    /**
     * Indicates wheather webhook functionaly is enabled in the triggered intent.
     */
    public boolean isWebhookUsed() {
        return webhookUsed != null ? Boolean.valueOf(webhookUsed) : false;
    }

    public void setWebhookUsed(boolean webhookUsed) {
        this.webhookUsed = Boolean.toString(webhookUsed);
    }
}
