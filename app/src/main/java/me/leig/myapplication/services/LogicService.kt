package me.leig.myapplication.services

import android.content.Intent
import android.os.Binder
import android.os.IBinder
import me.leig.myapplication.comm.BaseService

class LogicService : BaseService() {

    override fun onBind(intent: Intent): IBinder? {

        return LogicBinder()
    }

    class LogicBinder: Binder() {

    }
}
