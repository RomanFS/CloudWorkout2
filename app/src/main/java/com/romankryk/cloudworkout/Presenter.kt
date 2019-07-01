package com.romankryk.cloudworkout


class Presenter (val router: RouterSample) {

    private fun authError() {
        router.newRootScreenWithMessage("LoginScreen", null, "")
    }
}

