package com.example.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var added=false;
        var replaced=false;
        val frag1=Fragment1()
        val frag2=Fragment2()
        val add:Button=findViewById<Button>(R.id.button)
        val remove:Button=findViewById<Button>(R.id.button2)
        val replace:Button=findViewById<Button>(R.id.button3)
        add.setOnClickListener {
            if(!added) {
                val fragTransaction=supportFragmentManager.beginTransaction()
                fragTransaction.add(R.id.fragContainer, frag1)
                added = true;
                fragTransaction.commit()
            }
        }
        remove.setOnClickListener {
            if(added) {
                val fragTransaction=supportFragmentManager.beginTransaction()
                if (!replaced)
                    fragTransaction.remove(frag1)
                else fragTransaction.remove(frag2)
                added = false
                replaced = false
                fragTransaction.commit()
            }
        }
        replace.setOnClickListener {
            if (added) {
                val fragTransaction=supportFragmentManager.beginTransaction()
                if (replaced)
                    {
                        fragTransaction.replace(R.id.fragContainer, frag1)
                        replaced = false
                    }
                else
                {
                    fragTransaction.replace(R.id.fragContainer, frag2)
                    replaced = true
                }
                fragTransaction.commit()
            }
        }
    }
}