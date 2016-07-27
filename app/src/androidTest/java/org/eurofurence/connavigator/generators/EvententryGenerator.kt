package org.eurofurence.connavigator.generators

import com.pholser.junit.quickcheck.generator.GenerationStatus
import com.pholser.junit.quickcheck.generator.Generator
import com.pholser.junit.quickcheck.random.SourceOfRandomness
import io.swagger.client.model.EventEntry
import java.util.*

/**
 * Created by David on 26-7-2016.
 */

fun SourceOfRandomness.nextString(count: Int = 100): String {
    val builder = StringBuilder()

    for (i in IntRange(0, 100)) {
        builder.append(this.nextChar('A', 'a'))
    }

    return builder.toString()
}

class EventEntryGenerator() : Generator<EventEntry>(EventEntry::class.java) {
    override fun generate(random: SourceOfRandomness, status: GenerationStatus): EventEntry {
        val e: EventEntry = EventEntry()

        e.title = random.nextString()
        e.abstract = random.nextString(250)
        e.subTitle = random.nextString(50)
        e.panelHosts = random.nextString(20)
        e.id = UUID.randomUUID()

        return e
    }

}