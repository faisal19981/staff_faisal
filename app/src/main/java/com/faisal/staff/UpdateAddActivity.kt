package com.faisal.staff

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.faisal.staff.modell.DataItem
import com.faisal.staff.presenter.CrudView
import com.faisal.staff.presenter.Presenter2
import kotlinx.android.synthetic.main.activity_update_add.*

class UpdateAddActivity : AppCompatActivity(), CrudView {
    private lateinit var presenter2: Presenter2
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_add)

        presenter2 = Presenter2(this)
        val itemDataItem = intent.getSerializableExtra("dataItem")

        if (itemDataItem == null) {
            btnAction.text = "Tambah"
            btnAction.setOnClickListener() {
                presenter2.addData(
                    etName.text.toString(),
                    etPhone.text.toString(),
                    etAddress.text.toString()
                )
            }
        } else if (itemDataItem != null) {
            btnAction.text = "Update"
            val item = itemDataItem as DataItem?
            etName.setText(item?.staffName.toString())
            etPhone.setText(item?.staffHp.toString())
            etAddress.setText(item?.staffAlamat.toString())
            btnAction.setOnClickListener() {
                presenter2.updateData(
                    item?.staffId ?:"",
                    etName.text.toString(),
                    etPhone.text.toString(),
                    etAddress.text.toString()
                )
                finish()
            }
        }
    }

    override fun onSuccessGet(data: List<DataItem>?) {
    }

    override fun onFailedGet(msg: String) {
    }

    override fun onSuccessAdd(msg: String) {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    override fun onErrorAdd(msg: String) {
    }

    override fun onSuccessUpdate(msg: String) {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    override fun onErrorUpdate(msg: String) {
    }

    override fun onSuccessDelete(msg: String) {
    }

    override fun onErrorDelete(msg: String) {
    }
}