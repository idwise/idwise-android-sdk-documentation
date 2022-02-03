package com.example.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.idwise.sdk.IDWise

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        /** 
        * Initialaize the SDK by replacing the "<CLIENT_KEY>" with
        * your own key provided by IDWIse. error callback will be 
        * triggered if there is any error in initialization of the SDK
        */
        
        IDWise.initialize("<CLIENT_KEY>") { error: IDWiseSDKError? ->
            error?.printStackTrace()
        }
        
        btnStartVerification?.setOnClickListener {
         
            IDWise.startJourney(
			context,
			"<YOUR_JOURNEY_TEMPLATE_ID>", //Provided by IDWise
			"<REFERENCE_NUMBER>", 
			"en",
			object : IDWiseSDKCallback {
                
			/** 
			* This event triggers when the Journey is started by
			* the user, by clicking on the Start Journey Button
			*/
			    override fun onJourneyStarted(journeyInfo: JourneyInfo) {
				    Log.d("IDWiseSDKCallback", "onJourneyStarted")
			    }

			/** 
			* This event triggers when the Journey is completed by
			* the user.
			*/
                
			    override fun onJourneyCompleted(
				    journeyInfo: JourneyInfo,
				    isSucceeded: Boolean
			    ) {
				    Log.d("IDWiseSDKCallback", "onJourneyCompleted")
			    }

			 /** 
			* This event triggers when the Journey is cancelled by
			* the user at any stage
			*/
			    override fun onJourneyCancelled(journeyInfo: JourneyInfo?) {
				    Log.d("IDWiseSDKCallback", "onJourneyCancelled")
			    }

                
			 /** 
			* This event triggers when an Error occured during the 
			* verification process
			*/
			    override fun onError(error: IDWiseSDKError) {
				    Log.d("IDWiseSDKCallback", "onError ${error.message}")
			    }
			})
            
        }
    }

}
