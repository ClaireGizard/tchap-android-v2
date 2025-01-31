/*
 * Copyright (c) 2021 New Vector Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package fr.gouv.tchap.android.sdk.api.session.room.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import timber.log.Timber

/**
 * Class representing the TchapEventType.STATE_ROOM_ACCESS_RULES state event content
 */
@JsonClass(generateAdapter = true)
data class RoomAccessRulesContent(
        @Json(name = "rule") val rule: String? = null
) {
    val accessRules: RoomAccessRules? = RoomAccessRules.values().firstOrNull { it.value == rule }
            ?: run {
                Timber.w("Invalid value for RoomAccessRules: `$rule`")
                null
            }
}
