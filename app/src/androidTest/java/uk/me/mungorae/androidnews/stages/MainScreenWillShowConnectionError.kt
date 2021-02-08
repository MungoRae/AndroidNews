package uk.me.mungorae.androidnews.stages

import uk.me.mungorae.androidnews.actions.MainScreenActions

class MainScreenWillShowConnectionError: Stage {
    override fun begin() {
        MainScreenActions.hasConnectionError()
    }
}