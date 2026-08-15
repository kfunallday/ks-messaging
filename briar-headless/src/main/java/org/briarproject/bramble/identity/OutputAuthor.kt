package org.briarproject.bramble.identity

import org.briarproject.bramble.api.identity.Author
import com.ksmessaging.api.identity.AuthorInfo
import com.ksmessaging.headless.json.JsonDict
import java.util.Locale

fun Author.output() = JsonDict(
    "formatVersion" to formatVersion,
    "id" to id.bytes,
    "name" to name,
    "publicKey" to publicKey.encoded
)

fun AuthorInfo.Status.output() = name.lowercase(Locale.US)
