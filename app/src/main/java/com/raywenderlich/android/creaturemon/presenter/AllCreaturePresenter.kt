package com.raywenderlich.android.creaturemon.presenter

import androidx.lifecycle.LiveData
import com.raywenderlich.android.creaturemon.model.Creature
import com.raywenderlich.android.creaturemon.model.CreatureRepository
import com.raywenderlich.android.creaturemon.model.room.RoomRepository

class AllCreaturePresenter(private val roomRepository: CreatureRepository=RoomRepository() ) :BasePresenter<AllCreatureContract.View>(), AllCreatureContract.Presenter {
    private val allCreatures: LiveData<List<Creature>>

    init {
        allCreatures= roomRepository.getAllCreatures()
    }

    override fun getAllCreatures(): LiveData<List<Creature>> {
        return allCreatures
    }

    override fun clearAllCreatures() {
        roomRepository.clearAllCreatures()
        getView()?.showCreaturesCleared()
    }
}