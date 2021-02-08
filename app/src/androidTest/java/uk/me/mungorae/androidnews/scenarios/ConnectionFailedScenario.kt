package uk.me.mungorae.androidnews.scenarios

import uk.me.mungorae.androidnews.stages.ApiReturnsError
import uk.me.mungorae.androidnews.stages.MainScreenFinishedLoading
import uk.me.mungorae.androidnews.stages.MainScreenWillShowConnectionError
import uk.me.mungorae.androidnews.stages.Stage

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
