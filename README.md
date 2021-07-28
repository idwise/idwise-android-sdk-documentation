# IDWise Android SDK Documentation (V2 - Beta)
IDWise SDK allows you to integrate Digital Identity Verification technology inside your app, integration couldn't be simpler!


## Step 1: Adding IDWise References
In your `build.gradle` file, in the relavent sections, add the following:
1. Inside `android -> defaultConfig`, add the following: `multiDexEnabled true`:
2. Inside `android -> buildFeatures`, add the following: dataBinding true
As follows:

	    android {
	    .
	    .
	    
	        defaultConfig {
	    	.
	    	.
	            multiDexEnabled true
	    	}
	    	
	        buildFeatures {
	    	.
	    	.
	            dataBinding true
	    	}
	    }
3. Add the following repositories: 

        repositories {
    	       maven { url 'http://mobile-sdk.idwise.ai/releases/' }
    	       maven { url 'https://jitpack.io' }
		}
4. Add the following dependency inside your `dependencies` section:
    `implementation 'com.idwise:android-sdk:VERSION_NUMBER'`
    For example, if SDK version is 5.0.2, you need to use:
    
		dependencies {
	    .
	    .
			implementation 'com.idwise:android-sdk:5.0.2'
		}
5. Change `minSdkVersion` to 19 or higher
    
## Step 2: Calling IDWise to Start a Journey:
Make a call to **startJourney** method on **IDWise** object from **com.idwise.sdk** package.

You can find an example of the code here:
https://github.com/idwise/android-sdk-documentation/blob/8091facaa84fd59ede6d5972fe590ba013274346/example-activity.kt

This method takes two parameters and two call backs:

* **businessId** (also called Journey Definition ID): This is a unique identifier that identifies your journey definition. IDWise shares this with you when you register for using IDWise system
* **userId**: (Optional) A parameter that you can use to associate an arbitrary identifier (reference number) with the user making the current journey. This is helpful to link back the user or application related to the journey with the data in IDWise system   
* **completionCallback**: This callback has one parameter (journeyId), and called when the journey has been completed,
* **cancelCallback**: This callback has one parameter (journeyId) and is called when the customer cancels the journey (clicks back and confirms cancellation).

And that is all you need to get up and running with IDWise as part of your mobile app.

This invocation can happen at any point in your application when you want to take the user through a registration or on-boarding journey.
From this point onwards, IDWise SDK will guide the user through providing their documents and/or biometrics depending on the configuration of your journey in IDWise backend system.

## Step 3: Customising Prompts & Look and Feel:

The presentation you see on IDWise journey including the text prompts and images are all customisable by IDWise from the cloud, please reach out to the IDWise support team for any such customisations. 

The advantage here is that you do not need to publish a new version of your app to the store or get your users to update to apply any adjustments you need on the journey steps or user communication.

You can just edit the values of colours for both light and dark modes in "/res/values/themes.xml" and "/res/values-night/themes.xml" (file example of possible values is attached)

## Keep in touch!
Please get in touch if you want to make any adjustments or customisations to your users journey.
Please feel free to jump on a chat by visiting our website: www.idwise.com
