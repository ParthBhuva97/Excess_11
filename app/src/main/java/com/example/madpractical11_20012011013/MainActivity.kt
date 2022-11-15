package com.example.madpractical11_20012011013

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.madpractical11_20012011013.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private val TAG = "MainActivity"

    private var listener : ((note:Note,baseListAdapter:NotesAdapter,mode:NoteMode,position:Int)->Unit)?=
        { note:Note,_:NotesAdapter,noteMode:NoteMode,pos:Int ->
            note.modifiedTime = Note.getCurrentDateTime()
            if(noteMode == NoteMode.add){
                if(!createNote(note)){
                    Toast.makeText(this,"Enter Valid Note",Toast.LENGTH_SHORT).show()
                }
            }else if(noteMode == NoteMode.edit){
                Log.i(TAG,"listener:Note:$note")
                if(!updateNote(note,pos)){
                    Toast.makeText(this,"Enter Valid Note",Toast.LENGTH_SHORT).show()
                }
            }
    }

    class NoteMode {

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun createNote(note:Note):Boolean{
        TODO("Insert New Note")
    }

    private fun updateNote(note:Note,position: Int):Boolean{
        TODO("Update Notes")
    }

    public fun deleteNote(position: Int){
        TODO("Delete Notes")
    }

    fun showAlertDialog(
        mode:NoteMode,
        dialogTitle:String,
        note:Note,
        position: Int,
        baseListAdapter: NotesAdapter
    ){
        val dialogView = LayoutInflater.from(this).inflate(R.layout.notes_form,null)
        val builder = AlertDialog.Builder(this)
            .setView(dialogView)
            .setTitle("Add/Edit Notes")
        val alertDialog = builder.show()

    }
}