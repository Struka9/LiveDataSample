package xtrange.apps.livedatasample

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var etName: EditText
    private lateinit var btGreet: Button
    private lateinit var tvGreetings: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val viewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
        val liveData = viewModel.greetingLiveData
        liveData.observe(this /*The owner of the lifecycle to which the observer is bound*/,
            Observer {
                tvGreetings.text = it
            })

        etName = findViewById(R.id.et_name)
        tvGreetings = findViewById(R.id.tv_greetings)
        btGreet = findViewById(R.id.bt_greet)
        btGreet.setOnClickListener {
            val name = if (etName.text.isNullOrEmpty()) "World" else etName.text.toString()
            viewModel.setUserNameLongRunning(name)
        }
    }
}
