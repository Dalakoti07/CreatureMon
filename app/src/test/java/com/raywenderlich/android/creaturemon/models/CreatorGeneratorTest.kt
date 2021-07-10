package com.raywenderlich.android.creaturemon.models

import com.raywenderlich.android.creaturemon.model.Creature
import com.raywenderlich.android.creaturemon.model.CreatureAttributes
import com.raywenderlich.android.creaturemon.model.CreatureGenerator
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class CreatorGeneratorTest {

    private lateinit var creatureGenerator: CreatureGenerator

    @Before
    fun setUp(){
        creatureGenerator = CreatureGenerator()
    }

    @Test
    fun testGeneratedHitPoint(){
        val attributes= CreatureAttributes(
            intelligence = 7,
            strength = 3,
            endurance = 10
        )
        val name= "Rikachu"
        val expectedCreature = Creature(attributes,84,name)

        assertEquals(expectedCreature,creatureGenerator.generateCreature(attributes,name))
    }
}