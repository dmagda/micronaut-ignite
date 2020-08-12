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
package io.micronaut.ignite.annotation;

import io.micronaut.context.annotation.AliasFor;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.annotation.RepositoryConfiguration;
import io.micronaut.data.annotation.sql.SqlMembers;
import io.micronaut.ignite.IgniteRepositoryOperations;
import io.micronaut.ignite.IgniteSqlQueryBuilder;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@RepositoryConfiguration(
    queryBuilder = IgniteSqlQueryBuilder.class,
    operations = IgniteRepositoryOperations.class,
    implicitQueries = false,
    namedParameters = false
)
@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE})
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Repository
public @interface IgniteRepository {
    @AliasFor(annotation = Repository.class, member = "value")
    String value() default "default";

    @AliasFor(annotation = MappedEntity.class, member = SqlMembers.SCHEMA)
    String schema();
}
