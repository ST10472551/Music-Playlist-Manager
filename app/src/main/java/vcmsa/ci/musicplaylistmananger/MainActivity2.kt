package vcmsa.ci.musicplaylistmananger

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)


        val btnDisplay = findViewById<Button>(R.id.btnDisplay)
       val btnExit = findViewById<Button>(R.id.btnExit)
        val txtDisplay = findViewById<TextView>(R.id.txtDisplay)

        val song = intent.getStringArrayListExtra("Song")
        val artist = intent.getStringArrayListExtra( "artist")
        val rating = intent.getIntegerArrayListExtra( "rating")
        val comments = intent.getStringArrayListExtra( "comments")
        var count = intent.getIntExtra( "count",  8)

        btnDisplay.setOnClickListener {
            var result = "Songs Listed: $count\n\n"
            var i = 0
            while (i < count) {
                result += "${song?.get(i)}\n\n"
                i++
            }
            txtDisplay.text = result

        }
        btnExit.setOnClickListener{
            finishAffinity()


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}}