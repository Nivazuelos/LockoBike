package com.genesys.tauhackathon

import org.json.JSONObject

class FakeAPI2 {

    private val json = """
    {
        "places": [
        {
                "uuid": "c2c0b47d-9db5-4fa0-82d3-9e25d5480ebb",
                "title": "sportek Tel Aviv",
                "subtitle": "sportek in Tel Aviv",
                "latitude":32.0988,
                "longitude": 34.7850
            }
        
        ]
    }
""".trimIndent()

    fun fetchPlaces(): ArrayList<Place> {

        val jsonObject = JSONObject(json)
        val placesArray = jsonObject.getJSONArray("places")

        val places = ArrayList<Place>()

        for (i in 0 until placesArray.length()) {

            val placeObj = placesArray.getJSONObject(i)
            val place = Place(
                placeObj.getString("uuid"),
                placeObj.getString("title"),
                placeObj.getString("subtitle"),
                placeObj.getDouble("latitude"),
                placeObj.getDouble("longitude")
            )
            places.add(place)
        }

        return places
    }
}