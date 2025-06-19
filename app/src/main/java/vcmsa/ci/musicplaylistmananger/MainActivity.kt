package vcmsa.ci.musicplaylistmananger

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val btnNextScreen = findViewById<Button>(R.id.btnNext)
        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val btnExit = findViewById<Button>(R.id.btnExit)
        val edtSongTitle = findViewById<EditText>(R.id.edtSongTitle)
        val edtArtistName = findViewById<EditText>(R.id.edtArtistName)
        val edtRating = findViewById<EditText>(R.id.edtRating)
        val edtComments = findViewById<EditText>(R.id.edtComments)
        val feedback = findViewById<TextView>(R.id.txtFeedback)

        val song = ArrayList<String>()
        val artist = ArrayList<String>()
        val comments = ArrayList<String>()
        val rating = ArrayList<Int>()

        var count = 0
        btnAdd.setOnClickListener {
            val ratingText = edtRating.text.toString()
            if (edtComments.text.toString().isNotBlank()) {
                song.add(count, edtSongTitle.text.toString())
                artist.add(count, edtArtistName.text.toString())
                comments.add(count, edtComments.text.toString())
                rating.add(count, ratingText.toIntOrNull() ?:0 )
                count++


                edtComments.text.clear()
                edtSongTitle.text.clear()
                edtArtistName.text.clear()
                edtRating.text.clear()
            }
            else {
                feedback.text = "Enter Details for Playlist"
            }
        }
        btnExit.setOnClickListener{
            finishAffinity()
        }
        btnNextScreen.setOnClickListener{
            val intent = Intent(this@MainActivity, MainActivity2 ::class.java)
            intent.putStringArrayListExtra("Song", song)
            intent.putStringArrayListExtra("Artist", artist)
            intent.putIntegerArrayListExtra("Rating", rating)
            intent.putStringArrayListExtra("Comments", comments)
            intent.putExtra("count",count)
            startActivity(intent)

        }





        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}