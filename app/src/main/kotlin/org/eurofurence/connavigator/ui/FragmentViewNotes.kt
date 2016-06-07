package org.eurofurence.connavigator.ui

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.eurofurence.connavigator.R
import org.eurofurence.connavigator.database.Database
import org.eurofurence.connavigator.ui.fragments.NoteFragment
import org.eurofurence.connavigator.util.Note
import org.eurofurence.connavigator.util.delegators.view
import org.eurofurence.connavigator.util.extensions.applyOnRoot
import org.eurofurence.connavigator.util.extensions.letRoot
import java.util.*

/**
 * Created by David on 6/5/2016.
 */
class FragmentViewNotes : Fragment() {
    val database: Database get() = letRoot { it.database }!!
    val notesFab by view(FloatingActionButton::class.java)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
            inflater.inflate(R.layout.fview_notes, container, false)

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        applyOnRoot { changeTitle("Notes") }

        val transaction = childFragmentManager.beginTransaction()

        for (note in database.noteDb.items)
            transaction.add(R.id.notesContent, NoteFragment(note))

        transaction.commitAllowingStateLoss()

        notesFab.setOnClickListener { createNewNote() }
    }

    private fun createNewNote() {
        val note = Note("")

        val newNotes = LinkedList<Note>()

        newNotes.addAll(database.noteDb.items)
        newNotes.add(note)

        database.noteDb.items = newNotes

        childFragmentManager.beginTransaction()
                .add(R.id.notesContent, NoteFragment(note))
                .commitAllowingStateLoss()

    }
}