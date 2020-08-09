/*
 * Copyright 2017-2020 original authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.micronaut.ignite.config;

import edu.umd.cs.findbugs.annotations.NonNull;
import io.micronaut.context.annotation.EachProperty;
import io.micronaut.context.annotation.Parameter;
import io.micronaut.core.naming.Named;
import io.micronaut.data.runtime.config.SchemaGenerate;
import io.micronaut.ignite.configuration.IgniteClientConfiguration;

import java.util.ArrayList;
import java.util.List;

@EachProperty(value = IgniteDataConfiguration.PREFIX, primary = "default")
public class IgniteDataConfiguration implements Named {
    public static final String PREFIX = IgniteClientConfiguration.PREFIX + ".datasources";

    private final String name;
    private SchemaGenerate schemaGenerate = SchemaGenerate.NONE;
    private String client = "default";
    private List<String> packages = new ArrayList<>(3);
    private String cache;
    private boolean batchGenerate = false;

    /**
     * The configuration
     * @param name The configuration name
     */
    public IgniteDataConfiguration(@Parameter String name) {
        this.name = name;
    }

    public void setBatchGenerate(boolean batchGenerate) {
        this.batchGenerate = batchGenerate;
    }

    public boolean isBatchGenerate() {
        return batchGenerate;
    }

    /**
     * @param client
     */
    public void setClient(String client) {
        this.client = client;
    }

    /**
     *
     * @return
     */
    public String getClient() {
        return client;
    }

    /**
     *
     * @param schemaGenerate
     */
    public void setSchemaGenerate(SchemaGenerate schemaGenerate) {
        this.schemaGenerate = schemaGenerate;
    }

    /**
     *
     * @return
     */
    public SchemaGenerate getSchemaGenerate() {
        return schemaGenerate;
    }

    /**
     *
     * @param packages
     */
    public void setPackages(List<String> packages) {
        this.packages = packages;
    }

    /**
     *
     * @return
     */
    public List<String> getPackages() {
        return packages;
    }

    /**
     * @param cache the cache name to use
     */
    public void setCache(String cache) {
        this.cache = cache;
    }

    /**
     * @return the cache name
     */
    public String getCache() {
        return cache;
    }

    @NonNull
    @Override
    public String getName() {
        return this.name;
    }
}
