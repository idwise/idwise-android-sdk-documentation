package com.example.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.idwise.sdk.IDWise

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        IDWise.startJourney(this,
            "Journey Template ID",//provided by IDWise
            "Customer Specific Reference Number",
            { journeyId, submitted ->
                // Journey completed callback.
            },
            { journeyId ->
                // Journey cancelled callback.
            },
            { journeyInfo ->
                // Journey started callback (You can get journey id from journeyInfo?.journeyId
            },
            "en" // Locale (language) for UI, we are passing "ar" for Arabic in this example, for supported languages, please contact IDWise.
                 // Adding more languages (if not supported out of the box) is very simple.
        )
    }

}
