package org.eurofurence.connavigator.util

import org.joda.time.DateTime
import java.io.Serializable
import java.util.*

/**
 * Created by David on 6/5/2016.
 */
class Note(var text: String) : Serializable {
    val dateCreated = DateTime.now()
    val id = UUID.randomUUID()
}