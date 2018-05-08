package org.eurofurence.connavigator.util.extensions

import android.support.design.widget.FloatingActionButton
import android.support.v7.widget.RecyclerView
import android.view.ViewManager
import com.github.chrisbanes.photoview.PhotoView
import com.github.lzyzsd.circleprogress.ArcProgress
import com.joanzapata.iconify.widget.IconButton
import com.joanzapata.iconify.widget.IconTextView
import org.jetbrains.anko.custom.ankoView
import us.feras.mdv.MarkdownView

/**
 * Extensions to anko viewmanager
 */

inline fun ViewManager.arcProgress(init: ArcProgress.() -> Unit) = ankoView({ ArcProgress(it) }, 0, init)
inline fun ViewManager.recycler(init: RecyclerView.() -> Unit) = ankoView({ RecyclerView(it) }, 0, init)
inline fun ViewManager.photoView(init: PhotoView.() -> Unit) = ankoView({ PhotoView(it) }, 0, init)
inline fun ViewManager.markdownView(init: MarkdownView.() -> Unit) = ankoView({ MarkdownView(it) }, 0, init)
inline fun ViewManager.fontAwesomeView(init: IconTextView.() -> Unit) = ankoView({IconTextView(it)}, 0, init)
inline fun ViewManager.fontAwesomeButton(init: IconButton.() -> Unit) = ankoView({IconButton(it)}, 0, init)
inline fun ViewManager.floatingActionButton(init: FloatingActionButton.() -> Unit) = ankoView({FloatingActionButton(it)}, 0, init)