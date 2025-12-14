package com.khacduy.zizi.base

import android.app.Application
import com.zizi.util.ZiziUtil

class ZiziApplication : Application() {
  override fun onCreate() {
    super.onCreate()
    ZiziUtil.init()
  }
}
