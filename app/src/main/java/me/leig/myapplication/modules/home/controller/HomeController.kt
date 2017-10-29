package me.leig.myapplication.modules.home.controller

import me.leig.myapplication.comm.BaseController
import me.leig.myapplication.modules.home.data.ModuleBean

/**
 *
 *
 * @author leig.
 * @version 29/10/2017.
 */
class HomeController: BaseController() {

    var list: ArrayList<ModuleBean>? = null

    fun initData() {
        list = ArrayList()
        var i: Int = 0
        while (i < 10) {
            i += 1
            val mb: ModuleBean = ModuleBean(i, "http://i1.bbs.fd.zol-img.com.cn/t_s1200x5000/g5/M00/0A/0D/ChMkJlnyggKITkMhAAYw9xhORIAAAhmEwFsly4ABjEP537.jpg", "第" + i + "个标题")
            list!!.add(mb)
        }
    }

}