package me.leig.myapplication.modules.home.page

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.content_home.*
import me.leig.myapplication.R
import me.leig.myapplication.R.id
import me.leig.myapplication.R.layout
import me.leig.myapplication.comm.BaseActivity
import me.leig.myapplication.modules.home.controller.ModuleListAdapter
import me.leig.myapplication.modules.home.data.ModuleBean

class HomeActivity : BaseActivity() {

    var list: ArrayList<ModuleBean>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_home)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show()
        }

        // Example of a call to a native method
//        sample_text.text = stringFromJNI()

        initData()
        rv_home.layoutManager = LinearLayoutManager(this)
        rv_home.adapter = ModuleListAdapter(this, this!!.list!!) {
            Toast.makeText(this, "点击了" + it.title, Toast.LENGTH_SHORT).show()
        }

    }

    fun initData() {
        list = ArrayList()
        var i: Int = 0
        while (i < 10) {
            i += 1
            val mb: ModuleBean = ModuleBean(i, "http://i1.bbs.fd.zol-img.com.cn/t_s1200x5000/g5/M00/0A/0D/ChMkJlnyggKITkMhAAYw9xhORIAAAhmEwFsly4ABjEP537.jpg", "第" + i + "个标题")
            list!!.add(mb)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_home, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String

    companion object {

        // Used to load the 'native-lib' library on application startup.
        init {
            System.loadLibrary("native-lib")
        }
    }
}
