package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var globalNewNumber : String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun buNumberEvent(view:View){

        if (etShowNumber.text.toString().equals("0")){
            etShowNumber.setText("")
        }

        if(isNewOp)
            globalNewNumber="0"
        isNewOp=false
        val buSelect= view as Button
        var buClickValue:String=etShowNumber.text.toString()
        when (buSelect.id){
            bu0.id ->{
                buClickValue +="0"
                    globalNewNumber += "0"
            }
            bu1.id -> {
                buClickValue +="1"
                    globalNewNumber += "1"
            }
            bu2.id ->{
                buClickValue +="2"
                    globalNewNumber += "2"
            }
            bu3.id ->{
                buClickValue +="3"
                    globalNewNumber += "3"
            }
            bu4.id ->{
                buClickValue +="4"
                    globalNewNumber += "4"
            }
            bu5.id ->{
                buClickValue +="5"
                    globalNewNumber += "5"
            }
            bu6.id ->{
                buClickValue +="6"
                    globalNewNumber += "6"
            }
            bu7.id ->{
                buClickValue +="7"
                    globalNewNumber += "7"
            }
            bu8.id ->{
                buClickValue +="8"
                    globalNewNumber += "8"
            }
            bu9.id ->{
                    globalNewNumber += "9"
                buClickValue +="9"
            }
            buDot.id ->{
                 // TODO: Prvent Adding More Data
                buClickValue +="."
                    globalNewNumber += "."
            }
            buplusminus.id ->{
                buClickValue ="-"+ buClickValue
                globalNewNumber = "-"+ buClickValue
            }
        }
        etShowNumber.setText(buClickValue)

    }

    var op="*"
    var oldNumber=""
    var isNewOp=true
    fun buOpEvent(view: View){

        val buSelect= view as Button
        when (buSelect.id){
            buMul.id -> {
                op="*"
            }
            budiv.id -> {
                op="/"
            }
            buSub.id -> {
                op="-"
            }
            buAdd.id -> {
                op="+"
            }
        }
        oldNumber=etShowNumber.text.toString()
        isNewOp=true
        etShowNumber.setText(oldNumber+op)
    }
    fun buEqualEvent(view: View){
        val newNumber= globalNewNumber
        var finalNumber:Double?=null
        when(op){
            "*"->{
                finalNumber= oldNumber.toDouble()*newNumber.toDouble()
            }
            "/"->{
                finalNumber= oldNumber.toDouble()/newNumber.toDouble()
            }
            "+"->{
                finalNumber= oldNumber.toDouble()+newNumber.toDouble()
            }
            "-"->{
                finalNumber= oldNumber.toDouble()-newNumber.toDouble()
            }
        }
        etShowNumber.setText(finalNumber.toString())
        globalNewNumber=""
        isNewOp=true
    }
    fun buPercent(view: View){
        val number:Double=etShowNumber.text.toString().toDouble()/100

        etShowNumber.setText(number.toString())
        isNewOp=true
    }
    fun buClean(view: View){
        etShowNumber.setText("0")
        isNewOp=true
    }
}