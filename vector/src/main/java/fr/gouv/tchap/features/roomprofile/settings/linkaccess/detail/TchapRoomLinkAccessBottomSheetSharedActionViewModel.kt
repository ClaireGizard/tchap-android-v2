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

package fr.gouv.tchap.features.roomprofile.settings.linkaccess.detail

import im.vector.app.core.platform.VectorSharedActionViewModel
import javax.inject.Inject

/**
 * Activity shared view model to handle room link access quick actions
 */
class TchapRoomLinkAccessBottomSheetSharedActionViewModel @Inject constructor() : VectorSharedActionViewModel<TchapRoomLinkAccessBottomSheetSharedAction>()
