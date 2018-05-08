package org.eurofurence.connavigator.util.extensions

import android.text.method.DateTimeKeyListener
import net.danlew.android.joda.JodaTimeAndroid
import org.joda.time.DateTime
import org.ocpsoft.prettytime.PrettyTime
import java.util.*

/**
 * Created by requinard on 7/9/17.
 */
fun Date.jodatime() = DateTime(this.time)
fun Date.toRelative() = PrettyTime().format(this)

fun now() = DateTime.now()