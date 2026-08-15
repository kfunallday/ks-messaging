package com.ksmessaging.headless.forums

import com.ksmessaging.api.forum.Forum
import com.ksmessaging.headless.json.JsonDict

internal fun Forum.output() = JsonDict(
    "name" to name,
    "id" to id.bytes
)

internal fun Collection<Forum>.output() = map { it.output() }
