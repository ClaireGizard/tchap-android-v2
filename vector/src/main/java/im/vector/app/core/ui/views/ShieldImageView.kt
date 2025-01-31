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

package im.vector.app.core.ui.views

import android.content.Context
import android.util.AttributeSet
import androidx.annotation.DrawableRes
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.view.isVisible
import im.vector.app.R
import org.matrix.android.sdk.api.crypto.RoomEncryptionTrustLevel

class ShieldImageView @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0
) : AppCompatImageView(context, attrs, defStyleAttr) {

    init {
        if (isInEditMode) {
            render(RoomEncryptionTrustLevel.Trusted)
        }
        // Tchap: Hide the shield
        isVisible = false
    }

    fun render(roomEncryptionTrustLevel: RoomEncryptionTrustLevel?) {
        // Tchap: Hide the shield
        isVisible = false

        when (roomEncryptionTrustLevel) {
            RoomEncryptionTrustLevel.Default -> {
                contentDescription = context.getString(R.string.a11y_trust_level_default)
                setImageResource(R.drawable.ic_shield_black)
            }
            RoomEncryptionTrustLevel.Warning -> {
                contentDescription = context.getString(R.string.a11y_trust_level_warning)
                setImageResource(R.drawable.ic_shield_warning)
            }
            RoomEncryptionTrustLevel.Trusted -> {
                contentDescription = context.getString(R.string.a11y_trust_level_trusted)
                setImageResource(R.drawable.ic_shield_trusted)
            }
        }
    }
}

@DrawableRes
fun RoomEncryptionTrustLevel.toDrawableRes(): Int {
    return when (this) {
        RoomEncryptionTrustLevel.Default -> R.drawable.ic_shield_black
        RoomEncryptionTrustLevel.Warning -> R.drawable.ic_shield_warning
        RoomEncryptionTrustLevel.Trusted -> R.drawable.ic_shield_trusted
    }
}
