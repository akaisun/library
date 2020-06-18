package com.akaisun.library.util

import android.content.Context
import android.net.Uri
import androidx.core.content.FileProvider
import java.io.File


object FileProviderUtil {

    fun getUriByProvider(context: Context, file: File): Uri {
        return FileProvider.getUriForFile(context, context.applicationInfo.packageName + ".provider", file)
    }
}
