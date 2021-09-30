package com.example.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.idwise.sdk.IDWise

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        IDWise.startJourney(this,
            "Journey Definition ID",//provided by IDWise
            "Reference Number",
            { journeyId, submitted ->
                // Journey completed callback.
            },
            { journeyId ->
                // Journey cancelled callback.
            },
            "ar" // Locale (language) for UI, we are passing "ar" for Arabic in this example.
        )

    }

}
