package org.eurofurence.connavigator.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.eurofurence.connavigator.R
import org.eurofurence.connavigator.database.Database
import org.eurofurence.connavigator.util.extensions.letRoot

/**
 * Created by David on 6/5/2016.
 */
class FragmentViewNotes : Fragment() {
    val database: Database get() = letRoot { it.database }!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
            inflater.inflate(R.layout.abc_screen_simple_overlay_action_mode, container, false)

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //stuff is made
    }
}