/*
 * Copyright (c) 2021 New Vector Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package fr.gouv.tchap.android.sdk.internal.services.threepidplatformdiscover

import fr.gouv.tchap.android.sdk.internal.services.threepidplatformdiscover.model.Platform
import retrofit2.http.GET
import retrofit2.http.Query

internal interface ThreePidPlatformDiscoverAPI {

    /**
     * Get the Tchap platform configuration from a medium. This can be used both for registration & login.
     *
     * @param address  the address.
     * @param medium   the medium.
     */
    @GET("_matrix/identity/api/v1/info")
    suspend fun info(@Query("address") address: String, @Query("medium") medium: String): Platform
}
