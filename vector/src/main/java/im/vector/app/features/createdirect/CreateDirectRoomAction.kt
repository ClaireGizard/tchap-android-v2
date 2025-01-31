/*
 * Copyright (c) 2020 New Vector Ltd
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

package im.vector.app.features.createdirect

import im.vector.app.core.platform.VectorViewModelAction
import im.vector.app.features.userdirectory.PendingSelection

sealed class CreateDirectRoomAction : VectorViewModelAction {
    data class CreateRoomAndInviteSelectedUsers(
            val selections: Set<PendingSelection>
    ) : CreateDirectRoomAction()
    data class InviteByEmail(val email: String) : CreateDirectRoomAction()
    data class CreateDirectMessageByUserId(val userId: String) : CreateDirectRoomAction()
}
