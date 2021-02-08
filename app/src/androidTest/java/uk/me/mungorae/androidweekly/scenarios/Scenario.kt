package uk.me.mungorae.androidweekly.scenarios

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import uk.me.mungorae.androidweekly.MainActivity
import uk.me.mungorae.androidweekly.stages.Stage

@RunWith(AndroidJUnit4::class)
abstract class Scenario {

    @get:Rule
    var activityRule: ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun run() {
        runScenario {
            given().forEach {
                it.begin()
            }
            when_().forEach {
                it.begin()
            }
            then().forEach {
                it.begin()
            }
        }
    }

    open fun runScenario(scenario: () -> Unit) {
        scenario.invoke()
    }

    open fun given(): List<Stage> = emptyList()
    abstract fun when_(): List<Stage>
    abstract fun then(): List<Stage>
}

// Pull to refresh
// pages
// click article
// search title and description
// filter by date
// local store