package org.eurofurence.connavigator.ui.filters

import com.google.firebase.perf.metrics.AddTrace
import io.swagger.client.model.EventRecord
import org.eurofurence.connavigator.database.Db
import org.eurofurence.connavigator.database.HasDb
import org.eurofurence.connavigator.database.eventIsHappening
import org.eurofurence.connavigator.database.eventIsUpcoming
import org.eurofurence.connavigator.util.extensions.fullTitle
import java.util.*
import kotlin.collections.HashMap
import kotlin.collections.set

/**
 * Wraps event entries and provides sorting for these. Filters are async
 */
class EventList(override val db: Db) : HasDb {
    val filters = HashMap<FilterType, Any>()
    val UPCOMING_TIME_IN_MINUTES = 30

    @AddTrace(name = "EventList:applyEventFilters", enabled = true)
    fun applyFilters(): List<EventRecord> {
        var events = events.items

        this.filters.keys.forEach { key ->
            when (key) {
                FilterType.ON_DAY -> events = events.filter { it.conferenceDayId == filters[key] }
                FilterType.ON_TRACK -> events = events.filter { it.conferenceTrackId == filters[key] }
                FilterType.IN_ROOM -> events = events.filter { it.conferenceRoomId == filters[key] }
                FilterType.BY_TITLE -> events = events.filter { it.title.contains(filters[key] as String, true) }
                FilterType.IS_UPCOMING -> events = events.filter {
                    eventIsUpcoming(it, org.joda.time.DateTime.now()
                            , UPCOMING_TIME_IN_MINUTES)
                }
                FilterType.IS_FAVORITED -> events = events.filter { it.id in faves }
                FilterType.IS_CURRENT -> events = events.filter {
                    eventIsHappening(it, org.joda.time.DateTime.now())
                }
                FilterType.ORDER_START_TIME -> events = events.sortedBy { it.startDateTimeUtc }
                FilterType.ORDER_DAY_AND_TIME -> events = events.sortedBy { db.toDay(it)?.date }
                        .groupBy { it.id }
                        .map { it.value.sortedBy { it.startDateTimeUtc } }
                        .flatten()
                FilterType.ORDER_DAY -> events = events.sortedBy { db.toDay(it)!!.date }
                FilterType.ORDER_NAME -> events = events.sortedBy { it.fullTitle() }
            }
        }

        return events.toList()
    }

    /**
     * Filter by a date
     */
    fun onDay(dayID: UUID) =
            this.apply { filters[FilterType.ON_DAY] = dayID }

    /**
     * Filter by room
     */
    fun inRoom(roomID: UUID) =
            this.apply { filters[FilterType.IN_ROOM] = roomID }

    /**
     * Filter by track
     */
    fun onTrack(trackId: UUID) =
            this.apply { filters[FilterType.ON_TRACK] = trackId }

    /**
     * Search by title
     */
    fun byTitle(title: String) =
            this.apply { filters[FilterType.BY_TITLE] = title }

    /**
     * Filter by favourites
     */
    fun isFavorited() =
            this.apply { filters[FilterType.IS_FAVORITED] = "" }

    /**
     * Filter on current events
     */
    fun isCurrent() =
            this.apply { filters[FilterType.IS_CURRENT] = "" }

    /**
     * Filter to upcoming events
     */
    fun isUpcoming() =
            this.apply { filters[FilterType.IS_UPCOMING] = "" }

    /**
     * Sort events by date
     */
    fun sortByStartTime() =
            this.apply { filters[FilterType.ORDER_START_TIME] = "" }

    fun sortByDateAndTime() = this.apply { filters[FilterType.ORDER_DAY_AND_TIME] = "" }

    fun sortByDate() =
            this.apply { filters[org.eurofurence.connavigator.ui.filters.FilterType.ORDER_DAY] = "" }

    fun sortByName() =
            this.apply { filters[org.eurofurence.connavigator.ui.filters.FilterType.ORDER_NAME] = "" }
}

enum class FilterType {
    BY_TITLE,
    ON_DAY,
    ON_TRACK,
    ORDER_START_TIME,
    ORDER_DAY,
    ORDER_NAME,
    ORDER_DAY_AND_TIME,
    IN_ROOM,
    IS_UPCOMING,
    IS_FAVORITED,
    IS_CURRENT,
}