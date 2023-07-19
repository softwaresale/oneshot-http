package com.github.softwaresale.oneshot

/**
 * Handles a connection handled by the server. This can optionally return a value from the handler, which is
 * returned back up to the user
 */
interface ConnectionHandler<ResultT : Any> {
    suspend fun handle(request: Any, response: Any): ResultT
}