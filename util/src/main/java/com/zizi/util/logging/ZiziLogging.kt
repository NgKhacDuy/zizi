package com.zizi.util.logging

import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.FormatStrategy
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy
import timber.log.Timber

object ZiziLogging {

  fun setupLogging() {
    val formatStrategy: FormatStrategy =
        PrettyFormatStrategy.newBuilder()
            .showThreadInfo(true)
            .methodCount(1)
            .methodOffset(5)
            .build()
    Logger.addLogAdapter(AndroidLogAdapter(formatStrategy))
    Timber.plant(
        object : Timber.DebugTree() {
          override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
            Logger.log(priority, tag, message, t)
          }
        }
    )
  }

  fun logError(message: String?, throwable: Throwable?) {
    Timber.e(throwable, message)
  }

  fun logInfo(message: String?, throwable: Throwable?) {
    Timber.i(throwable, message)
  }

  fun logDebug(message: String?, throwable: Throwable?) {
    Timber.d(throwable, message)
  }
}
