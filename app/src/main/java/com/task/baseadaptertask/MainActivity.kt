package com.task.baseadaptertask

import android.app.Dialog
import android.os.Bundle
import android.view.ViewGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.task.baseadaptertask.databinding.ActivityMainBinding
import com.task.baseadaptertask.databinding.CustomdialogBinding

class MainActivity : AppCompatActivity() {
    var binding:ActivityMainBinding?=null
    var list= arrayListOf("c","c++","Java","Python")
    var listAdapter=ListAdapter(list)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding?.listView?.adapter=listAdapter
        binding?.btnAdd?.setOnClickListener {
            var dialogBinding= CustomdialogBinding.inflate(layoutInflater)
            var dialog= Dialog(this).apply{
                setContentView(dialogBinding.root)
                show()
            }
            dialog.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            dialogBinding.btnSubmit.setOnClickListener {
                if (dialogBinding.etName.text?.toString()?.trim().isNullOrEmpty()){
                    dialogBinding.etName.error="Enter Anything"
                }else{
                    list.add(dialogBinding.etName.text.toString().trim())
                    dialog.dismiss()
                }
            }
            dialog.show()
        }
    }
}