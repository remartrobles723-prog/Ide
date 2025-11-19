package com.itsaky.tom.rv2ide.handlers

// import com.itsaky.tom.rv2ide.lsp.clang.ClangLanguageServer || planned for v..03
import android.content.Context
import com.itsaky.tom.rv2ide.lsp.api.ILanguageClient
import com.itsaky.tom.rv2ide.lsp.api.ILanguageServerRegistry
import com.itsaky.tom.rv2ide.lsp.java.JavaLanguageServer
import com.itsaky.tom.rv2ide.lsp.kotlin.KotlinLanguageServer
import com.itsaky.tom.rv2ide.lsp.xml.XMLLanguageServer

/** @author Akash Yadav */
object LspHandler {

  fun registerLanguageServers(context: Context) {
    ILanguageServerRegistry.getDefault().apply {
      getServer(JavaLanguageServer.SERVER_ID) ?: register(JavaLanguageServer())
      getServer(KotlinLanguageServer.SERVER_ID) ?: register(KotlinLanguageServer(context))
      // getServer(ClangLanguageServer.SERVER_ID) ?: register(ClangLanguageServer(context)) ||
      // planned for v..03
      getServer(XMLLanguageServer.SERVER_ID) ?: register(XMLLanguageServer())
    }
  }

  fun connectClient(client: ILanguageClient) {
    ILanguageServerRegistry.getDefault().connectClient(client)
  }

  fun destroyLanguageServers(isConfigurationChange: Boolean) {
    if (isConfigurationChange) {
      return
    }
    ILanguageServerRegistry.getDefault().destroy()
  }
}
