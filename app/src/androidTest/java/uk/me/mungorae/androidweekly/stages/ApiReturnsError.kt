package uk.me.mungorae.androidweekly.stages

import uk.me.mungorae.androidweekly.actions.ApiActions

class ApiReturnsError : Stage {
    override fun begin() {
        ApiActions.returnsError()
    }
}