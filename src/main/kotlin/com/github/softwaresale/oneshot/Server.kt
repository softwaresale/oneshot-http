package com.github.softwaresale.oneshot

import java.net.ServerSocket

class Server<ResultT : Any>(port: Int) {
    private val serverSocket: ServerSocket = ServerSocket(port)

    private suspend fun listen(): ResultT {
        // Get a single connection
        val connection = serverSocket.accept()
        // immediately close the server
        serverSocket.close()

        // Read a request from the connection
        // TODO

        // Set up a response to be sent back to the connection

        // Give the request and response to the handler, get a result
        // TODO

        // Clean up resources
        // TODO

        // Return the result
        TODO()
    }
}