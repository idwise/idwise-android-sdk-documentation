# IDWise Android SDK Documentation (v2 - Beta)
This SDK allows you to integrate the IDWise Digital Identity Verification technology inside your app with minimal fuss. Whenever your app wants to verify a user, it simply calls a single function in our SDK (`startJourney`) which will start an ID verification journey for that user. This will present a highly customisable UI that guides the user through a series of steps that prompts them for their ID documents and/or biometrics depending on how you have configured your journey in our backend systems. At the end of this process your app will receive a `journeyId` (via callback functions) which your backend code can use to securely get the result of this verification process. It's that simple!

## Step 1: Integrating with your build scripts
- In your `build.gradle` file, add `multiDexEnabled true` and `dataBinding true` in these sections:
```
android {
	...
	defaultConfig {
		...
		multiDexEnabled true
	}

	buildFeatures {
		...
		dataBinding true
	}
}
```
- Add the following repositories:
```
repositories {
	maven { url 'http://mobile-sdk.idwise.ai/releases/' }
	maven { url 'https://jitpack.io' }
}
```
- Add the following dependency inside your `dependencies` section: `implementation 'com.idwise:android-sdk:VERSION_NUMBER'`
  For example, to use **v5.0.2** of our SDK, you would do the following:
```
dependencies {
	...
	implementation 'com.idwise:android-sdk:5.0.2'
}
```
- Change your `minSdkVersion` to **19** or higher

## Step 2: Starting an ID verification journey:
You can find an example of how to start an ID verification process in the file [`example-activity.kt`](example-activity.kt).

Your app can start an ID verification process by making a call to the `startJourney` method which takes the following parameters:

* **businessId** (also called Journey Definition ID): This is a unique identifier that identifies your journey definition. IDWise shares this with you when you register for using IDWise system
* **userId**: (Optional) A parameter that you can use to associate an arbitrary identifier (reference number) with the user making the current journey. This is helpful to link the journey back to the user and/or application that started the journey
* **completionCallback**: This callback has one parameter (journeyId), and is called when the journey has been completed
* **cancelCallback**: This callback has one parameter (journeyId) and is called when the customer cancels the journey (clicks back and confirms cancellation)

The `journeyId` can then be used by your backend code to securely get the result of the ID verification.

## Step 3: Customising the UI for the ID verification journey:

The text prompts, images, and colours for both the light and dark modes within an ID verification journey are all customisable. This customisation is performed in our cloud which has the following advantages:

* You do not need to publish a new version of your app to the store each time you customise the journey,
* Your users do not need to do anything in order to pickup any customisations that you apply,

It almost works like magic!

Please see the files in [`res/values`](res/values) folder for an example of what the colour customisations look like, you can edit the following files `/res/values/themes.xml` and `/res/values-night/themes.xml`

Please reach out to our IDWise support team for details on how to customise the UI for the ID verification journey.

## Keep in touch!
Please get in touch if you want to make any adjustments or customisations to your users journey.
Please feel free to jump on a chat by visiting our website: www.idwise.com
