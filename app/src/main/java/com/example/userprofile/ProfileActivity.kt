package com.example.userprofile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        initViews()
    }

    private fun initViews() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.profile_title)

        val profile = intent.getParcelableExtra<Profile>(PROFILE_EXTRA)

        if (profile != null) {
            textName.text = getString(R.string.name, profile.firstName, profile.lastName)
            textDescription.text = profile.description
            if (profile.imageUri != null) profileImage.setImageURI(profile.imageUri)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item?.itemId){
            android.R.id.home -> {
                finish()
                true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    companion object{
        const val PROFILE_EXTRA = "PROFILE_EXTRA"
    }

}
