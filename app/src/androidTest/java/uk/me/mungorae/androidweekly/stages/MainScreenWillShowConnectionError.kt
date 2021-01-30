package uk.me.mungorae.androidweekly.stages

import uk.me.mungorae.androidweekly.actions.MainScreenActions

class MainScreenWillShowConnectionError: Stage {
    override fun begin() {
        MainScreenActions.hasConnectionError()
    }
}