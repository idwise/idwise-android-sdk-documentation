package com.example.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.idwise.sdk.IDWise

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        IDWise.startJourney(this,
            "Journey Definition ID",
            "Reference Number",
            { journeyId, submitted ->
                // Journey completed callback.
            },
            { journeyId ->
                // Journey cancelled callback.
            }
        )

    }

}
