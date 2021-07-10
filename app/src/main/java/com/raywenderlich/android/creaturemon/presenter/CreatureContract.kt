package com.raywenderlich.android.creaturemon.presenter

import androidx.annotation.DrawableRes
import com.raywenderlich.android.creaturemon.model.AttributeType


class CreatureContract {

    //to be implemented by presenter, and view can call these methods on presenter
    interface Presenter{
        fun updateName(name :String)

        fun attributesSelected(attributesType: AttributeType, position :Int)

        fun drawableSelected(drawable:Int)

        fun isDrawableSelected(): Boolean
    }

    interface View{
        fun showHitPoints(hitPoints:String)

        fun showAvatarDrawable(@DrawableRes resourceId: Int)
    }

}