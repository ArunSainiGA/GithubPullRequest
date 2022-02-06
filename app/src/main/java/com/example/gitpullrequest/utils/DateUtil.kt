package com.example.gitpullrequest.utils

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.gitpullrequest.utils.DateConstants.SYSTEM_FORMAT
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

/**
 * Considering response time to be ISO
 */
object DateConstants{
    const val ISO_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSZ"
    const val SYSTEM_FORMAT = "dd-MM-yyyy HH:mm"
}

@RequiresApi(Build.VERSION_CODES.O)
fun fromISOToSystem(isoFormat: String): String? {
    return try {
        ZonedDateTime.parse(isoFormat)
            .withZoneSameInstant(ZoneId.of("Asia/Kolkata"))
            .format(DateTimeFormatter.ofPattern(SYSTEM_FORMAT))
    } catch (ex: Exception) {
        null
    }
}