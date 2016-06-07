package org.eurofurence.connavigator.ui.fragments

import android.os.Bundle
import android.support.annotation.Nullable
import android.support.v4.app.Fragment
import android.text.SpannableStringBuilder
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import org.eurofurence.connavigator.R
import org.eurofurence.connavigator.util.Note
import org.eurofurence.connavigator.util.delegators.view

/**
 * Created by David on 6/7/2016.
 */
class NoteFragment(val note: Note) : Fragment() {

    val noteContent by view(TextView::class.java)
    val noteEdit by view(EditText::class.java)

    override fun onCreateView(inflater: LayoutInflater, @Nullable container: ViewGroup?, @Nullable savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_note, container, false)

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        noteContent.text = note.text

        noteEdit.text = SpannableStringBuilder(note.text)

        // On clicking the note, it should go full screen and show the edit bar
        noteContent.setOnClickListener { toggleEditBar() }
    }

    private fun toggleEditBar() {
        if (noteContent.visibility == View.VISIBLE) {
            noteContent.visibility = View.GONE
            noteEdit.visibility = View.VISIBLE
        } else {
            noteContent.visibility = View.VISIBLE
            noteEdit.visibility = View.GONE
        }
    }
}