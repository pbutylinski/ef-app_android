package org.eurofurence.connavigator.ui.widgets

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.widget.RemoteViews
import org.eurofurence.connavigator.R

/**
 * Created by David on 6/4/2016.
 */
class UpcomingEventsWidget: AppWidgetProvider() {
    override fun onUpdate(context: Context, appWidgetManager: AppWidgetManager, appWidgetIds: IntArray) {
        super.onUpdate(context, appWidgetManager, appWidgetIds)

        val remoteView = RemoteViews(context.packageName, R.layout.widget_current)

        remoteView.setTextViewText(R.layout.widget_current, "wololo")

        appWidgetManager.updateAppWidget(appWidgetIds, remoteView)
    }
}