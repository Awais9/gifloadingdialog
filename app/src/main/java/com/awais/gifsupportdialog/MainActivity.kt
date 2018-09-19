package com.awais.gifsupportdialog

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.awais.gifloadingdialog.LoadingDialog

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*create the instance for loading dialog which is singleton*/
        val loadingDialog = LoadingDialog.getInstance(this)
        /*show the dialog where you want*/
        loadingDialog.showDialog()
        /*hide the dialog when it is not needed*/
//        loadingDialog.hideDialog()
        /*you can change your local gif image*/
//        loadingDialog.currentDrawable = R.drawable.test
        /*you can change image by string url (link)*/
//        loadingDialog.gifURL = "https://media.giphy.com/media/BYyLhBtSVgl2w/giphy.gif"
    }
}
