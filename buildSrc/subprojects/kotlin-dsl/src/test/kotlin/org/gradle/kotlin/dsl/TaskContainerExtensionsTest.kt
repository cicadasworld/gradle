/*
 * Copyright 2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.gradle.kotlin.dsl

import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify

import org.gradle.api.tasks.TaskContainer
import org.gradle.api.tasks.Upload

import org.junit.Test


class TaskContainerExtensionsTest {

    @Test
    fun `can configure by name and type using getByName`() {

        val task = mock<Upload>()
        val tasks = mock<TaskContainer>() {
            on { getByName("uploadArchives") } doReturn task
        }

        tasks.getByName<Upload>("uploadArchives") {
            isUploadDescriptor = true
        }

        verify(task).isUploadDescriptor = true
    }
}
