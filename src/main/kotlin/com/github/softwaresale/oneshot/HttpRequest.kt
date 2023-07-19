package com.github.softwaresale.oneshot

import java.net.URI

data class HttpHeaders(
    val headers: Map<String, HeaderValue>
) {
    sealed interface HeaderValue {
        data class Single(val value: String) : HeaderValue
        data class Multi(val values: List<String>) : HeaderValue
    }
}

class HttpRequest internal constructor (
    /// The http method of this request
    private val verb: HttpMethod,
    /// The requested path
    private val uri: URI,
    /// Any headers associated with this request
    private val headers: HttpHeaders,
    /// The raw body of the request
    private val rawBody: ByteArray,
)