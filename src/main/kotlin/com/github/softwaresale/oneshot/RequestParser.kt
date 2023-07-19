package com.github.softwaresale.oneshot

import java.io.InputStream
import java.io.InputStreamReader
import java.net.URI
import java.nio.CharBuffer

internal class RequestParser(inputStream: InputStream) {
    private val inputStreamReader = InputStreamReader(inputStream)

    fun parse(): HttpRequest {
        // read the request line
        val (httpMethod, uri) = parseHttpRequestLine()

        // Read the headers
    }

    private fun parseHttpHeaders(): HttpHeaders {
        val parser = Regex("""^(\S+):(?:\s*)(.+)$""")
        while
    }

    private fun parseHttpRequestLine(): Pair<HttpMethod, URI> {
        val line = readRequestLine()
        val parser = Regex("""^(\w+) (\S+) HTTP(.+)$""")

        return parser.matchEntire(line)?.let {
            val method = it.groupValues[1].let(HttpMethod::valueOf)
            val uri = URI(it.groupValues[2])

            method to uri
        } ?: throw Exception("Invalid request line")
    }

    private fun readRequestLine(): String {
        val lineBuilder = StringBuilder()
        var lastRead: Char? = null
        while (true) {
            val nextByte = inputStreamReader.read()
            if (nextByte == -1 || (lastRead == '\r' && nextByte == '\n'.code)) {
                // EOF -> we're done
                break
            } else {
                val nextChar = nextByte.toChar()
                lineBuilder.append(nextChar)
                lastRead = nextChar
            }
        }

        return lineBuilder.toString()
    }
}