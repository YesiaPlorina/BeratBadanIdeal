package com.example.beratbadanidealabhimata

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    lateinit var gender : Spinner



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        gender = findViewById(R.id.spinner_gender) as Spinner
        var tinggi: String
        var berat: String

        val genders = arrayOf("P - Pria", "W - Wanita")
        var pilGender: String = ""

        gender.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, genders)

        gender.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                pilGender = genders.get(p2)
            }
        }

            edt_tinggi.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(p0: Editable?) {
                    tinggi = edt_tinggi.text.toString()
                    if(tinggi.isEmpty()){
                        toast("Input Tinggi Badan")
                    }else{
                        val finalTinggi: Int = tinggi.toInt()
                        edt_berat.addTextChangedListener(object : TextWatcher{
                            override fun afterTextChanged(p0: Editable?) {
                                berat = edt_berat.text.toString()
                                if(berat.isEmpty()){
                                    toast("Input Berat Badan")
                                }else{
                                    val finalBerat: Int = berat.toInt()
                                    btn_check.onClick {
                                        if(pilGender == "P - Pria") {
                                            if(edt_tinggi.text.toString().isEmpty()){
                                                edt_tinggi.error = "Tinggi Harus di Isi"
                                            }else if(edt_berat.text.toString().isEmpty()){
                                                edt_berat.error = "Berat Badan Harus di Isi"
                                            }else {
//                                    startActivity<Result>()

                                                val ideal = (finalTinggi - 100) - ((finalTinggi - 100) * 0.1)
                                                val hasil = ideal / finalBerat
                                                val hasilFinal: Int = hasil.toInt()
                                                tv_test.text = hasilFinal.toString()
                                                if (hasilFinal.equals(1)) {
                                                    toast("ideal")
                                                    val intent = Intent(this@MainActivity, Result::class.java)
                                                    intent.putExtra("Ideal", "Ideal")
                                                    startActivity(intent)
                                                } else {
                                                    toast("tidak ideal")
                                                    val intent = Intent(this@MainActivity, resultWanita::class.java)
                                                    intent.putExtra("Ideal", "Tidak Ideal")
                                                    startActivity(intent)
                                                }
                                            }
                                        }
                                        if (pilGender == "W - Wanita"){
                                            tv_test.text = pilGender
                                            val ideal = (finalTinggi - 100) - ((finalTinggi - 100)* 0.15)
                                            val hasil = ideal / finalBerat
                                            val hasilFinal: Int = hasil.toInt()
                                            tv_test.text = hasilFinal.toString()
                                            if(hasilFinal.equals(1)){
                                                toast("ideal")
                                                val intent = Intent(this@MainActivity,Result::class.java)
                                                intent.putExtra("Ideal","Ideal")
                                                startActivity(intent)
                                            }else{
                                                toast("tidak ideal")
                                                val intent = Intent(this@MainActivity,resultWanita::class.java)
                                                intent.putExtra("Ideal","Tidak Ideal")
                                                startActivity(intent)
                                            }
                                        }
                                    }

                                }


                            }
//                                val finalBerat: Int = berat.toInt()
//                        tv_test.text = (finalTinggi + finalBerat).toString()


                            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                            }

                            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                            }
                        })
                    }
                    }


                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                }
            })



//        }

            btn_check.onClick {
                toast("Tinggi and Berat must be requred")
            }



    }

}






