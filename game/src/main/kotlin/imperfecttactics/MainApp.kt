package imperfecttactics

import com.almasb.fxgl.app.GameApplication
import com.almasb.fxgl.settings.GameSettings

class MainApp : GameApplication() {

    override fun initSettings(settings: GameSettings) {
        settings.apply {
            isIntroEnabled = false
            isMenuEnabled = false
            isProfilingEnabled = false
            isCloseConfirmation = false
            width = 800
            height = 600
        }
    }

    companion object {
        fun main(args:Array<String>) {
            launch(MainApp::class.java, *args)
        }
    }
}