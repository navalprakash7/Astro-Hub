package com.example.astrohub

import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2

class GalaxyActivity : AppCompatActivity() {

    var currentImage = 0
    lateinit var image:ImageView
    var names = arrayOf("Milky Way", "Andromeda", "Triangulum", "Sombrero", "Whirlpool")
    var paragraphs = arrayOf(
        "The Milky Way Galaxy is our home galaxy, a vast spiral galaxy containing billions of stars, planets, and other celestial objects. It spans about 100,000 light-years and features a supermassive black hole at its center called Sagittarius A*. The galaxy is composed of various arms filled with star-forming regions, nebulae, and clusters. The Milky Way is part of the Local Group, a cluster of galaxies that includes Andromeda and Triangulum. Observing its structure has provided insights into the formation and evolution of galaxies. With its dynamic nature and ongoing star formation, the Milky Way continues to be a subject of astronomical research and exploration.",
        "Andromeda Galaxy (M31), the closest spiral galaxy to the Milky Way, is approximately 2.5 million light-years away. It is the largest galaxy in the Local Group, containing about one trillion stars. Andromeda’s structure features a bright central bulge, extensive spiral arms, and numerous satellite galaxies. Astronomers predict that Andromeda and the Milky Way will collide in about 4.5 billion years, forming a new galaxy. Observations of Andromeda help scientists understand galactic dynamics, star formation, and dark matter distribution. Its immense size and beauty make it a favorite target for both amateur and professional astronomers.",
        "The Triangulum Galaxy (M33) is a smaller spiral galaxy in the Local Group, located approximately 3 million light-years away. It has a prominent spiral structure with numerous bright star-forming regions. Unlike the Milky Way and Andromeda, Triangulum lacks a significant central bulge, giving it a more open appearance. The galaxy is an important target for studying star formation and the interstellar medium. Its proximity and orientation make it an excellent subject for telescopic observations and astrophotography. Triangulum’s role in the Local Group provides insights into the interactions and evolution of nearby galaxies.",
        "The Sombrero Galaxy (M104) is a unique spiral galaxy located about 31 million light-years away in the constellation Virgo. Its distinctive appearance, featuring a bright nucleus and a prominent dust lane, resembles a sombrero hat. The galaxy’s structure includes a massive central bulge surrounded by an extensive halo of stars and globular clusters. Sombrero’s luminous core suggests the presence of a supermassive black hole. Its striking appearance and intriguing properties make it a popular target for astronomers and astrophotographers. The Sombrero Galaxy exemplifies the diversity and beauty of spiral galaxies.",
        "The Whirlpool Galaxy (M51) is a classic spiral galaxy located about 31 million light-years away in the constellation Canes Venatici. Known for its well-defined spiral arms, the galaxy is interacting with a smaller companion galaxy, NGC 5195. This interaction triggers intense star formation in the Whirlpool Galaxy’s arms, creating bright star-forming regions. The galaxy’s structure and dynamics make it a key subject for studying galactic interactions and star formation. Its stunning appearance has earned it a reputation as one of the most photogenic galaxies in the night sky, captivating both scientists and stargazers alike."
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_galaxy)

        supportActionBar?.hide()
        val imgPrev = findViewById<ImageButton>(R.id.imgPrev)
        val imgNext = findViewById<ImageButton>(R.id.imgNext)
        val textView = findViewById<TextView>(R.id.textView)
        val textView2 = findViewById<TextView>(R.id.textView2)

        imgPrev.setOnClickListener{
            val idCurrentImageString = "picg$currentImage"
            val idCurrentImageInt = this.resources.getIdentifier(idCurrentImageString,"id",packageName)
            image = findViewById(idCurrentImageInt)
            image.alpha = 0f
            currentImage = (5+currentImage-1)%5

            val idImageShowString = "picg$currentImage"
            val idImageShowInt = this.resources.getIdentifier(idImageShowString,"id",packageName)
            image = findViewById(idImageShowInt)
            image.alpha = 1f
            textView.text = names[currentImage]
            textView2.text = paragraphs[currentImage]
        }
        imgNext.setOnClickListener{
            val idCurrentImageString = "picg$currentImage"
            val idCurrentImageInt = this.resources.getIdentifier(idCurrentImageString,"id",packageName)
            image = findViewById(idCurrentImageInt)
            image.alpha = 0f
            currentImage = (5+currentImage+1)%5

            val idImageShowString = "picg$currentImage"
            val idImageShowInt = this.resources.getIdentifier(idImageShowString,"id",packageName)
            image = findViewById(idImageShowInt)
            image.alpha = 1f
            textView.text = names[currentImage]
            textView2.text = paragraphs[currentImage]
        }
    }
}