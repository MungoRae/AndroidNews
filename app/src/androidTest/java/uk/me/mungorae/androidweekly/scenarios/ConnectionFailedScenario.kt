package uk.me.mungorae.androidweekly.scenarios

import uk.me.mungorae.androidweekly.stages.ApiReturnsError
import uk.me.mungorae.androidweekly.stages.MainScreenFinishedLoading
import uk.me.mungorae.androidweekly.stages.MainScreenWillShowConnectionError
import uk.me.mungorae.androidweekly.stages.Stage

class ConnectionFailedScenario: Scenario() {
    override fun given(): List<Stage> {
        return listOf(
            ApiReturnsError()
        )
    }

    override fun when_(): List<Stage> {
        return listOf(
            MainScreenFinishedLoading()
        )
    }

    override fun then(): List<Stage> {
        return listOf(
            MainScreenWillShowConnectionError()
        )
    }
}
