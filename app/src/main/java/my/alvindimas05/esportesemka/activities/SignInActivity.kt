package my.alvindimas05.esportesemka.activities

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import my.alvindimas05.esportesemka.Api
import my.alvindimas05.esportesemka.databinding.ActivitySignInBinding
import org.json.JSONObject

class SignInActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignInBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSignIn.setOnClickListener { onSignIn() }
    }

    private fun onSignIn(){
        val data = SignInData(binding.inputUsername.text.toString(), binding.inputPassword.text.toString())
        val queue = Volley.newRequestQueue(this)
        val request = JsonObjectRequest(Request.Method.POST, Api.baseUrl + "api/sign-in",
            JSONObject(Gson().toJson(data)), {
            Toast.makeText(this, "Sign In berhasil!", Toast.LENGTH_SHORT).show()
        }, {
            Toast.makeText(this, "User tidak ditemukan!", Toast.LENGTH_SHORT).show()
        })
        queue.add(request)
    }
    data class SignInData(val usernameOrEmail: String, val password: String)
}