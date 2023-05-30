package com.example.evotor_discount

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.tooling.preview.Preview
import com.example.evotor_discount.ui.theme.EvotordiscountTheme
import ru.evotor.framework.core.action.event.receipt.changes.position.IPositionChange
import ru.evotor.framework.core.action.event.receipt.changes.receipt.SetExtra
import java.math.BigDecimal

class DiscountActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_loyalty_card)

        val dialogView = layoutInflater.inflate(R.layout.dialog_loyalty_card, null)
        val cardNumEditText = dialogView.findViewById<EditText>(R.id.editText)

       val alertDialog = AlertDialog.Builder(this)
           .setView(R.layout.dialog_loyalty_card)
           .setTitle("Применение скидки")
           .setPositiveButton("применить") {dialog, _ ->
              val cardNumber = cardNumEditText.text.toString()

               if(cardNumber == "1111") {
                    intent = Intent(this, MyDiscountService::class.java)
                   startService(intent)
               } else{
                   Toast.makeText(this, "неверный номер", Toast.LENGTH_SHORT).show()
               }
               dialog.dismiss()
               finish()
           }
           .setNegativeButton("Отмена"){dialog, _ ->
               dialog.dismiss()
               finish()
           }
           .create()
        alertDialog.show()


    }
}
