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
package io.micronaut.ignite.configuration;

import io.micronaut.context.annotation.EachProperty;
import io.micronaut.context.annotation.Parameter;
import io.micronaut.core.naming.Named;
import org.apache.ignite.cache.QueryEntity;
import org.apache.ignite.configuration.CacheConfiguration;
import org.jetbrains.annotations.NotNull;

/**
 * Ignite cache configuration.
 *
 * @param <K> the cache key
 * @param <V> the cache value
 */
@EachProperty(value = DefaultIgniteConfiguration.PREFIX + "." + DefaultCacheConfiguration.PREFIX)
public class DefaultCacheConfiguration<K, V> extends CacheConfiguration<K, V> implements Named {
    public static final String PREFIX = "cacheConfigurations";
    private final String name;

    /**
     * Construct a new instance.
     * @param name the name to use.
     */
    public DefaultCacheConfiguration(@Parameter String name) {
        super();
        this.name = name;
        super.setName(name);
    }

    @NotNull
    @Override
    public String getName() {
        return name;
    }

    /**
     * The Query Entities.
     */
    @EachProperty(value = "queryEntities", list = true)
    public static class DefaultQueryEntities extends QueryEntity {
    }
}
