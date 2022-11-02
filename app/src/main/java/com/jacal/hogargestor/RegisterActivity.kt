package com.jacal.hogargestor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.core.util.PatternsCompat
import java.util.regex.Pattern

class RegisterActivity : AppCompatActivity() {
    private var editName: EditText?=null
    private var editLastName: EditText?=null
    private var editNit:EditText?=null
    private var editPhone:EditText?=null
    private var editEmail: EditText?=null
    private var editPassword: EditText?=null
    private var checkBoxPolicies: CheckBox?=null
    private val nameAndLast_Pattern: Pattern= Pattern.compile(
        "[a-zA-Z]*"
    )
    private val password_Pattern:Pattern= Pattern.compile(
        "^"+
                "(?=.*[0-9])"+
                "(?=.*[a-z])"+
                "(?=.*[A-Z])"+
                "(?=.*[(@#\$%^&+=.])"+
                ".{8,}"+
                "$"
    )
    private val email_Pattern:Pattern= Patterns.EMAIL_ADDRESS

    private val phone_Pattern:Pattern= Patterns.PHONE

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        editName=findViewById(R.id.editName)
        editLastName=findViewById(R.id.editLastName)
        editNit=findViewById(R.id.editNit)
        editPhone=findViewById(R.id.editPhone)
        editEmail=findViewById(R.id.editEmail)
        editPassword=findViewById(R.id.editPassword)
        checkBoxPolicies=findViewById(R.id.CheckboxPolicies)
    }

    fun onRegisterSave(view: View) {
        if(validateForm()){
            Toast.makeText(this,"Correcto",Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(this,"Error", Toast.LENGTH_LONG).show()
        }
    }

    private fun validateForm():Boolean{
        var validate=true
        var name:String=editName!!.text.toString()
        var lastname:String=editLastName!!.text.toString()
        var nit:String=editLastName!!.text.toString()
        var phone:String=editPhone!!.text.toString()
        var telefono:String=editLastName!!.text.toString()
        var email:String=editEmail!!.text.toString()
        var password:String=editPassword!!.text.toString()
        //Inicio Name
        if (TextUtils.isEmpty(name)){
            editName!!.error="Campo Requerido"
            validate=false
        }else if(!nameAndLast_Pattern.matcher(name.replace(" ","")).matches()){
            editName!!.error="Nombre no válido"
            validate=false
        }else editName!!.error=null
        //Fin Name
        //Inicio Password
        if (TextUtils.isEmpty(password)){
            editPassword!!.error="Campo Requerido"
            validate=false
        }else if(!password_Pattern.matcher(password).matches()){
            editPassword!!.error="Contraseña no válida"
            validate=false
        }else editPassword!!.error=null
        //Fin Passord

        //Apellido
        if (TextUtils.isEmpty(lastname)){
            editLastName!!.error="Campo Requerido"
            validate=false
        }else if(!nameAndLast_Pattern.matcher(lastname.replace(" ","")).matches()){
            editLastName!!.error="Apellido no válido"
            validate=false
        }else editLastName!!.error=null
        //Nit
        if (TextUtils.isEmpty(nit)){
            editNit!!.error="Campo Requerido"
            validate=false
        }else editNit!!.error=null
        //Telefono
        if (TextUtils.isEmpty(telefono)){
            editPhone!!.error="Campo Requerido"
            validate=false
        }else editPhone!!.error=null
        //Email
        if (TextUtils.isEmpty(email)){
            editEmail!!.error="Campo Requerido"
            validate=false
        }else if(!email_Pattern.matcher(email).matches()){
            editEmail!!.error="Contraseña no válida"
            validate=false
        }else editEmail!!.error=null

        //Phone
        if (TextUtils.isEmpty(phone)){
            editPhone!!.error="Campo Requerido"
            validate=false
        }else if(!phone_Pattern.matcher(phone).matches()){
            editPhone!!.error="Telefono no válido"
            validate=false
        }else editPhone!!.error=null
        /*if(PatternsCompat.EMAIL_ADDRESS.matcher(email).matches()){
            editEmail!!.error="Email Invalido"
            validate=false
        }else editEmail!!.error=null*/

        if(!checkBoxPolicies!!.isChecked){
            validate=false
        }

        return validate
    }
}