package com.itsaky.androidide.utils

import com.itsaky.androidide.app.BaseApplication
import com.itsaky.androidide.managers.PreferenceManager

/** * @Author Tom */
class IBuildSystemUtils {
  companion object {
    fun getNdkVersion(): String? {
      val prefManager: PreferenceManager = BaseApplication.getBaseInstance().prefManager
      return prefManager.getString("bs_native_kit_version", null)
    }

    fun setNdkVersion(version: String) {
      val prefManager = BaseApplication.getBaseInstance().prefManager
      prefManager.putString("bs_native_kit_version", version)
    }

    fun getCMakeVersion(): String? {
      val prefManager: PreferenceManager = BaseApplication.getBaseInstance().prefManager
      return prefManager.getString("bs_cmake_version", null)
    }

    fun setCMakeVersion(version: String) {
      val prefManager = BaseApplication.getBaseInstance().prefManager
      prefManager.putString("bs_cmake_version", version)
    }
  }
}
