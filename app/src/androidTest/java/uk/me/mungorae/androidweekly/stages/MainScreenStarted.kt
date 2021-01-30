package uk.me.mungorae.androidweekly.stages

import androidx.test.core.app.ActivityScenario
import uk.me.mungorae.androidweekly.MainActivity

class MainScreenStarted: Stage {
    override fun begin() {
        ActivityScenario.launch(MainActivity::class.java)
    }
}