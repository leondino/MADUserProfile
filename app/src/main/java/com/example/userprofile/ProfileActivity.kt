package com.example.userprofile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        initViews()
    }

    private fun initViews() {
        val profile = intent.getParcelableExtra<Profile>(PROFILE_EXTRA)

        if (profile != null) {
            textName.text = getString(R.string.name, profile.firstName, profile.lastName)
            textDescription.text = profile.description
            if (profile.imageUri != null) profileImage.setImageURI(profile.imageUri)
        }
    }

    companion object{
        const val PROFILE_EXTRA = "PROFILE_EXTRA"
    }

}
