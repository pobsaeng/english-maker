package com.web.english.classes

import java.io.UnsupportedEncodingException
import jdk.nashorn.internal.runtime.ScriptingFunctions.readLine
import java.io.FileReader
import java.io.BufferedReader
import java.util.*


class Utility {
    private var CODE = ("abcdefghijklmnopqrstuvwxyz"
            + "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
            + "1234567890")

    fun isNumber(text: String): Boolean {
        try {
            Integer.parseInt(text)

            return true
        } catch (ex: NumberFormatException) {
            return false
        }

    }

    fun randomText(length: Int): String {
        CODE += UUID.randomUUID().toString()

        val text = StringBuilder()

        for (i in 0 until length) {

            val pos = (Math.random() * CODE.length).toInt()
            val c = CODE[pos]

            text.append(c)
        }

        return text.toString()
    }

    @Throws(Exception::class)
    fun readTextToMap(path: String, keyword: String?): Map<String, String> {
        val map = HashMap<String, String>()
        val reader = BufferedReader(FileReader(path))

        for (text in reader.lines()) {
            if (text != null){
                if (text.trim().length === 0) continue
                if (text.trim() == "#") continue

                val delimiterOut = text.indexOf(",")
                if(delimiterOut != -1){
                    val delimiterIn = text.indexOf("=")
                    //Make the substring in order to get only real data
                    val key = text.substring(0, delimiterOut).trim().substring(delimiterIn + 1, delimiterOut)
                    val value = text.substring(delimiterOut + 1).trim().substring(delimiterOut + 1)
                    map[key] = value


//                    val k = text.substring(0, delimiterOut).trim()//0-7
//                    val v = text.substring(delimiterOut + 1).trim()//8 up to
//                    map[k] =  v
//                    println("$k $v")
                }
            }
        }
        reader.close()
        return map
    }
}