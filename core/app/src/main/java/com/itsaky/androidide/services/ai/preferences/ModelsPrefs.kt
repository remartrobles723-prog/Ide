package com.itsaky.androidide.services.ai.preferences

import com.itsaky.androidide.app.BaseApplication
import com.itsaky.androidide.managers.PreferenceManager

fun getAgentName(): String? {
  val prefManager: PreferenceManager = BaseApplication.getBaseInstance().prefManager
  return prefManager.getString("ai_agent_name", null)
}
