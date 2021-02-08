package uk.me.mungorae.androidnews.stages

import uk.me.mungorae.androidnews.actions.ApiActions

class ApiReturnsError : Stage {
    override fun begin() {
        ApiActions.returnsError()
    }
}