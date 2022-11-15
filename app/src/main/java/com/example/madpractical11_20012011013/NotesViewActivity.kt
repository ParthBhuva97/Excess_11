package com.example.madpractical11_20012011013

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.WindowCompat
import com.example.madpractical11_20012011013.databinding.ActivityNotesViewBinding
import com.example.madpractical11_20012011013.databinding.NotesViewItemBinding

class NotesViewActivity : AppCompatActivity() {
    private lateinit var note : Note
    private lateinit var binding : NotesViewItemBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)
        note = intent.getSerializableExtra("Object") as Note
        binding = NotesViewItemBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        setSupportActionBar(binding.toolbar)
        with(note){
            binding.noteTitle.text = this.title
            binding.noteSubtitle.text = this.subTitle
            binding.noteContent.text = this.Description
            binding.noteDate.text = this.modifiedTime
            this.calcReminder()
            if(this.isReminder){
                binding.noteReminderDateTime.visibility = View.VISIBLE
                binding.noteReminderDateTime.text = this.getReminderText()
            }
            else{
                binding.noteReminderDateTime.visibility = View.GONE
            }
            binding.cardNote.setOnClickListener{
                Intent(this@NotesAdapter.context,NotesViewActivity::class.java).apply{
                    putExtra("Object",obj)
                    this@NotesAdapter.context.startActivity(this)
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