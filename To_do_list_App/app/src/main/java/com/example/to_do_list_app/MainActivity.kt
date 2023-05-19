package com.example.to_do_list_app

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.to_do_list_app.databinding.ActivityMainBinding
import com.example.to_do_list_app.databinding.PopupExampleBinding
import com.google.firebase.firestore.DocumentChange
import com.google.firebase.firestore.FirebaseFirestore
import kotlin.random.Random

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    private var userList = arrayListOf<User>()
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val adapter by lazy {
        MyAdapter(
            ::setOnclickDelete,
            ::setOnClickEdit
        )
    }

    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.add.setOnClickListener {
            setOnClickAdd()
        }
        getUser()
    }

    private fun getUser() {
        db.collection("user")
            .get()
            .addOnSuccessListener {
                if (!it.isEmpty) {
                    for (data in it) {
                        var user: User? = data.toObject(User::class.java)
                        if (user != null) {
                            user.id = data.id
                            Log.e("tag", data.id)
                            userList.add(user)
                        }
                    }
                    adapter.setList(userList)
                    binding.recyclerview.adapter = adapter
                } else {
                    Toast.makeText(this, "no data", Toast.LENGTH_LONG).show()
                }

            }
            .addOnFailureListener {
                Toast.makeText(this, it.toString(), Toast.LENGTH_LONG).show()
            }
    }

    private fun setOnClickEdit(item: User, position: Int) {
        showPopup("Update") { user ->
            user.id = item.id
            setUser(user, position)
            userList[position] = user
            adapter.setList(userList)
            Log.e(TAG, "setOnClickEdit: ${user.toString()}")
            Toast.makeText(this, "Sửa thành công", Toast.LENGTH_LONG).show()
        }
    }

    private fun setOnClickAdd() {
        showPopup("Add") { user ->
            addUser(user)
            adapter.setList(userList)
            Log.e(TAG, "setOnClickAdd: ${user.toString()}")
        }
    }


    private fun showPopup(nameOfButton: String, onAdd: (User) -> Unit) {
        val dialog = Dialog(this)
        val binding1 = PopupExampleBinding.inflate(layoutInflater)
        binding1.addd.text = nameOfButton
        dialog.setContentView(binding1.root)
        dialog.window?.apply {
            setLayout(
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT

            )
            setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        }
        binding1.addd.setOnClickListener {
            var user = User(
                null,
                binding1.editTextTextEmailAddress3.text.toString(),
                binding1.numberSigned.text.toString().toInt(),
                binding1.editTextTextPassword.text.toString(),
                binding1.textPersonName.text.toString()
            )
            onAdd(user)
            dialog.dismiss()
        }
        binding1.close.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
    }

    private fun setOnclickDelete(item: User, list: ArrayList<User>) {
        deleteUser(item.id.toString())
        list.remove(item)
        adapter.setList(list)
    }

    private fun addUser(item: User) {
        db.collection("user")
            .add(item)
            .addOnSuccessListener {
                item.id = it.id
                userList.add(item)
                setUser(item, userList.size - 1)
                adapter.setList(userList)
                Toast.makeText(this, "Thêm thành công", Toast.LENGTH_LONG).show()
            }
            .addOnFailureListener {
                Toast.makeText(this, "Thêm không thành công", Toast.LENGTH_LONG).show()
            }

    }

    private fun setUser(item: User, position: Int) {
        db.collection("user")
            .document(item.id.toString())
            .set(item)
            .addOnSuccessListener {
                userList[position] = item
            }
            .addOnFailureListener {
                Toast.makeText(this, "Sửa không thành công", Toast.LENGTH_LONG).show()
            }

    }


    private fun deleteUser(id: String) {
        db.collection("user")
            .document(id)
            .delete()
            .addOnSuccessListener {
                Log.e("id", id)
                Toast.makeText(this, "Xóa thành công", Toast.LENGTH_LONG).show()
            }
            .addOnFailureListener {
                Toast.makeText(this, "Xóa không thành công", Toast.LENGTH_LONG).show()
            }
    }

}

