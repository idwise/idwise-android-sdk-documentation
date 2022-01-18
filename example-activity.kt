package com.example.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.idwise.sdk.IDWise

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

       IDWise.initialize(
            "<YOUR_API_KEY>", //Provided by IDWise
            "<YOUR_API_SECRET>" //Provided by IDWise
        ) { isSuccess: Boolean, error: IDWiseSDKError? ->
    
	    if (isSuccess) {
		    IDWise.startJourney(
			context,
			"<YOUR_JOURNEY_TEMPLATE_ID>", //Provided by IDWise
			"<REFERENCE_NUMBER>", 
			"en",
			object : IDWiseSDKCallback {
			    override fun onJourneyStarted(journeyInfo: JourneyInfo) {
				Log.d("IDWiseSDKCallback", "onJourneyStarted")
			    }

			    override fun onJourneyCompleted(
				journeyInfo: JourneyInfo,
				isSucceeded: Boolean
			    ) {
				Log.d("IDWiseSDKCallback", "onJourneyCompleted")
			    }

			    override fun onJourneyCancelled(journeyInfo: JourneyInfo?) {
				Log.d("IDWiseSDKCallback", "onJourneyCancelled")
			    }

			    override fun onError(error: IDWiseSDKError) {

				Log.d("IDWiseSDKCallback", "onError ${error.message}")
			    }
			})
		}
        }
    }

}
