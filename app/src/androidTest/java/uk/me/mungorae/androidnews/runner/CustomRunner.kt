package uk.me.mungorae.androidnews.runner

import android.app.Application
import android.app.Instrumentation
import android.content.Context
import androidx.test.runner.AndroidJUnitRunner
import uk.me.mungorae.androidnews.TestApp

class CustomRunner: AndroidJUnitRunner() {

    override fun newApplication(
        cl: ClassLoader?,
        className: String?,
        context: Context?
    ): Application {
        return Instrumentation.newApplication(TestApp::class.java, context)
    }
}