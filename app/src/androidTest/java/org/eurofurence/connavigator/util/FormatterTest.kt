package org.eurofurence.connavigator.util

import android.test.AndroidTestCase
import com.pholser.junit.quickcheck.Property
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck
import io.swagger.client.model.EventEntry
import junit.framework.TestCase
import org.junit.runner.RunWith

/**
 * Created by David on 26-7-2016.
 */
@RunWith(JUnitQuickcheck::class)
class FormatterTest : AndroidTestCase() {
    @Property fun testEventToTimes(e: EventEntry) {
    }

    fun testShortTime() {

    }

    @Property fun testEventTitle(e: EventEntry) {
        assertNotNull(Formatter.eventTitle(e))
    }

    fun testDealerName() {

    }

    fun testRoomFull() {

    }

    fun testRoomName() {

    }

    fun testEventOwner() {

    }

    fun testShareEvent() {

    }

    fun testShareDealer() {

    }

    fun testShareInfo() {

    }

    fun testCreateUrl() {

    }

    fun testWikiToMarkdown() {

    }

}