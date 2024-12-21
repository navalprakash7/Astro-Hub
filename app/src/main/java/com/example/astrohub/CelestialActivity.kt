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

class CelestialActivity : AppCompatActivity() {

    var currentImage = 0
    lateinit var image:ImageView
    val names = arrayOf("Neutron Star", "Supernova", "Black Hole", "Quasar", "Pulsar")
    val paragraphs = arrayOf(
        "The Neutron Star (M42) is one of the brightest and most studied stellar remnants, located approximately 1,344 light-years away in the constellation Orion. This enigmatic object is the dense core left behind after a massive star has exhausted its nuclear fuel and undergone a supernova explosion. The Neutron Star’s gravity is so intense that it compresses the remaining matter into a state where neutrons are packed closely together. These stellar remnants are often only about 20 kilometers in diameter but contain the mass of several suns. The Neutron Star’s glowing appearance is due to ultraviolet radiation from hot, young stars ionizing the surrounding hydrogen gas. Its high magnetic field and rapid rotation make it a fascinating object for scientific study, as it allows astronomers to investigate the extreme physics of matter under high pressure and density. The Neutron Star continues to intrigue researchers and is considered a vital target for studying stellar evolution and the life cycle of massive stars.",
        "The Supernova (M16), located about 7,000 light-years away in the constellation Serpens, is an event that marks the explosive death of a massive star. The most famous feature of the Supernova is the 'Pillars of Creation,' towering columns of gas and dust that have been captured in stunning detail by the Hubble Space Telescope. These columns are a region of active star formation, where new stars are born from the surrounding gas and dust. The Supernova itself, an enormous release of energy, can briefly outshine an entire galaxy, creating intense radiation that illuminates the surrounding nebula. The Supernova explosion is a crucial stage in the life cycle of massive stars, and the remnants of such explosions, often rich in heavy elements, play a key role in the chemical enrichment of the universe. Supernovae are also essential for understanding stellar nucleosynthesis and the dynamics of star formation in the cosmos.",
        "The Black Hole (M57), situated about 2,300 light-years away in the constellation Lyra, is a fascinating and mysterious celestial object. Formed from the collapse of a massive star, the Black Hole has an intense gravitational field that is so strong that not even light can escape its pull. This phenomenon leads to what is called the event horizon, the point beyond which nothing can return. As matter and radiation spiral into the Black Hole, they form an accretion disk, heating up to extremely high temperatures. The presence of a Black Hole distorts space-time around it, which can be observed through gravitational lensing and the behavior of nearby objects. Black Holes are central to modern astrophysics, as they challenge our understanding of physics, particularly in extreme conditions. Their study offers insights into general relativity, quantum mechanics, and the behavior of matter and energy under the most extreme environments in the universe.",
        "The Quasar (M1), located approximately 6,500 light-years away in the constellation Taurus, is an extremely energetic and distant active galactic nucleus. Powered by a supermassive Black Hole at its center, the Quasar emits vast amounts of radiation across the entire electromagnetic spectrum, from radio waves to gamma rays. The energy is produced as matter is drawn into the Black Hole, forming an accretion disk that accelerates to nearly the speed of light. The Quasar’s brightness can surpass that of entire galaxies, making them detectable from billions of light-years away. These objects were among the first to be discovered in the early 20th century and have been key to understanding the behavior of Black Holes and the formation of galaxies. They are important in studying cosmic evolution and the relationship between Black Holes, galaxies, and the large-scale structure of the universe, offering vital clues about the formation and growth of supermassive Black Holes.",
        "The Pulsar (NGC 7293), often called the 'Eye of God,' is a rapidly rotating neutron star located about 650 light-years away in the constellation Aquarius. It is a remnant of a massive star that has exploded in a supernova, leaving behind a highly magnetized neutron star. The Pulsar emits periodic beams of radiation, which can be detected as regular pulses of energy, typically in the form of radio waves, but some Pulsars emit across the electromagnetic spectrum. These regular pulses occur because the neutron star’s rotation is highly stable, and the beams sweep across space like a lighthouse beam. The Pulsar’s intense magnetic field and rapid rotation make it an important tool for studying fundamental physics, particularly in the areas of quantum mechanics and general relativity. Pulsars are also valuable for testing theories about matter under extreme conditions, as their properties help scientists understand the behavior of dense matter and the dynamics of compact objects in space."
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_celestial)

        supportActionBar?.hide()
        val imgPrev = findViewById<ImageButton>(R.id.imgPrev)
        val imgNext = findViewById<ImageButton>(R.id.imgNext)
        val textView = findViewById<TextView>(R.id.textView)
        val textView2 = findViewById<TextView>(R.id.textView2)

        imgPrev.setOnClickListener{
            val idCurrentImageString = "picc$currentImage"
            val idCurrentImageInt = this.resources.getIdentifier(idCurrentImageString,"id",packageName)
            image = findViewById(idCurrentImageInt)
            image.alpha = 0f
            currentImage = (5+currentImage-1)%5

            val idImageShowString = "picc$currentImage"
            val idImageShowInt = this.resources.getIdentifier(idImageShowString,"id",packageName)
            image = findViewById(idImageShowInt)
            image.alpha = 1f
            textView.text = names[currentImage]
            textView2.text = paragraphs[currentImage]
        }
        imgNext.setOnClickListener{
            val idCurrentImageString = "picc$currentImage"
            val idCurrentImageInt = this.resources.getIdentifier(idCurrentImageString,"id",packageName)
            image = findViewById(idCurrentImageInt)
            image.alpha = 0f
            currentImage = (5+currentImage+1)%5

            val idImageShowString = "picc$currentImage"
            val idImageShowInt = this.resources.getIdentifier(idImageShowString,"id",packageName)
            image = findViewById(idImageShowInt)
            image.alpha = 1f
            textView.text = names[currentImage]
            textView2.text = paragraphs[currentImage]
        }
    }
}