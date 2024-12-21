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

class NebulaActivity : AppCompatActivity() {

    var currentImage = 0
    lateinit var image:ImageView
    var names = arrayOf("Orion Nebula", "Eagle Nebula", "Ring Nebula", "Crab Nebula", "Helix Nebula")
    var paragraphs = arrayOf(
        "The Orion Nebula (M42) is one of the brightest and most studied nebulae, located approximately 1,344 light-years away in the constellation Orion. It is a massive star-forming region, home to young stars, stellar nurseries, and intricate clouds of gas and dust. The nebula's glowing appearance is due to ultraviolet radiation from hot, young stars ionizing the surrounding hydrogen gas. The Orion Nebula is a key target for studying star formation and the early stages of stellar evolution, captivating astronomers and stargazers alike.",
        "The Eagle Nebula (M16), located about 7,000 light-years away in the constellation Serpens, is famous for the 'Pillars of Creation,' towering columns of gas and dust captured in iconic images by the Hubble Space Telescope. This stellar nursery is a region of active star formation, with young, hot stars illuminating the surrounding gas. The Eagle Nebula is part of a larger star cluster, and its intricate structures provide a unique glimpse into the dynamic processes of star birth and interstellar material shaping.",
        "The Ring Nebula (M57), situated about 2,300 light-years away in the constellation Lyra, is a planetary nebula formed from the remnants of a dying star. Its donut-like appearance results from glowing gas expelled by the star in its final stages. The central star, now a white dwarf, emits ultraviolet radiation that ionizes the gas, creating the nebula’s characteristic glow. The Ring Nebula’s structure and composition provide insights into the life cycle of stars and the chemical enrichment of the interstellar medium.",
        "The Crab Nebula (M1), located approximately 6,500 light-years away in the constellation Taurus, is the remnant of a supernova explosion observed in 1054 AD. This expanding cloud of gas and dust is powered by a rapidly spinning neutron star, or pulsar, at its center. The Crab Nebula emits radiation across the electromagnetic spectrum, from radio waves to gamma rays, making it a key target for studying high-energy astrophysics and supernova remnants. Its dynamic and intricate structure continues to fascinate scientists and observers.",
        "The Helix Nebula (NGC 7293), often called the 'Eye of God,' is a planetary nebula located about 650 light-years away in the constellation Aquarius. It is one of the closest and most well-known examples of a dying star shedding its outer layers. The nebula’s intricate structure consists of rings of glowing gas and dust, illuminated by the ultraviolet radiation of the central white dwarf. The Helix Nebula provides valuable information about the late stages of stellar evolution and the fate of Sun-like stars."
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nebula)

        supportActionBar?.hide()
        val imgPrev = findViewById<ImageButton>(R.id.imgPrev)
        val imgNext = findViewById<ImageButton>(R.id.imgNext)
        val textView = findViewById<TextView>(R.id.textView)
        val textView2 = findViewById<TextView>(R.id.textView2)

        imgPrev.setOnClickListener{
            val idCurrentImageString = "picn$currentImage"
            val idCurrentImageInt = this.resources.getIdentifier(idCurrentImageString,"id",packageName)
            image = findViewById(idCurrentImageInt)
            image.alpha = 0f
            currentImage = (5+currentImage-1)%5

            val idImageShowString = "picn$currentImage"
            val idImageShowInt = this.resources.getIdentifier(idImageShowString,"id",packageName)
            image = findViewById(idImageShowInt)
            image.alpha = 1f
            textView.text = names[currentImage]
            textView2.text = paragraphs[currentImage]
        }
        imgNext.setOnClickListener{
            val idCurrentImageString = "picn$currentImage"
            val idCurrentImageInt = this.resources.getIdentifier(idCurrentImageString,"id",packageName)
            image = findViewById(idCurrentImageInt)
            image.alpha = 0f
            currentImage = (5+currentImage+1)%5

            val idImageShowString = "picn$currentImage"
            val idImageShowInt = this.resources.getIdentifier(idImageShowString,"id",packageName)
            image = findViewById(idImageShowInt)
            image.alpha = 1f
            textView.text = names[currentImage]
            textView2.text = paragraphs[currentImage]
        }
    }
}