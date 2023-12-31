package com.faisal.staff.presenter

import com.faisal.staff.modell.DataItem

interface CrudView {
    // get data
    fun onSuccessGet(data: List<DataItem>?)
    fun onFailedGet(msg: String)

    // add data
    fun onSuccessAdd(msg: String)
    fun onErrorAdd(msg: String)

    // update data
    fun onSuccessUpdate(msg: String)
    fun onErrorUpdate(msg: String)

    // delete data
    fun onSuccessDelete(msg: String)
    fun onErrorDelete(msg: String)
}
