package xtrange.apps.livedatasample

import android.os.Handler
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {
    private val _greetingLiveData = MutableLiveData<String>().apply {
        value = "Hello, World!"
    }

    val greetingLiveData: LiveData<String>
        get() = _greetingLiveData

    fun setUserNameLongRunning(name: String) {
        // Simulate a long running operation
        val handler = Handler()
        handler.postDelayed({
            _greetingLiveData.postValue("Hello, $name!")
        }, 3000)
    }

    fun setUserName(name: String) {
        _greetingLiveData.value = "Hello, $name!"
    }
}