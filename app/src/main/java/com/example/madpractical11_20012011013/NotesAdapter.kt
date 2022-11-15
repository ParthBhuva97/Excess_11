package com.example.madpractical11_20012011013

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.madpractical11_20012011013.databinding.NotesViewItemBinding
import java.io.Serializable


class NotesAdapter(private val array : List<Note>)  : RecyclerView.Adapter<NotesAdapter.NotesViewHolder>(){
    inner class NotesViewHolder(val binding: NotesViewItemBinding) : RecyclerView.ViewHolder(binding.root) {

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.notes_view_item,parent,false)
        val binding = NotesViewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NotesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        with(holder){
            with(array[position]){
                binding.noteTitle.text = this.title
                binding.noteSubtitle.text = this.subTitle
                binding.noteContent.text = this.Description
                binding.noteDate.text = this.modifiedTime
                val obj = this as Serializable
                this.calcReminder()
                if(this.isReminder){
                    binding.noteReminderDateTime.visibility = View.VISIBLE
                    binding.noteReminderDateTime.text = this.getReminderText()
                }
                else{
                    binding.noteReminderDateTime.visibility = View.GONE
                    binding.imgDelete.setOnClickListener{
                        (context as MainActivity).deleteNote(position)
                    }
                    binding.cardNote.setOnClickListener {
                        Intent(this@NotesAdapter.context,NotesViewActivity::class.java).apply {
                            putExtra("Object",obj)
                            this@NotesAdapter.context.startActivity(this)
                        }
                    }
                    binding.imgEdit.setOnClickListener{
                        (context as MainActivity).showAlertDialog(
                             MainActivity.NoteMode.edit,
                            "Edit Note",
                            this,
                             position,
                            this@NotesAdapter
                        )
                    }
                }
            }
        }

    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}