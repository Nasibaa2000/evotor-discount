package com.example.evotor_discount

import android.app.AlertDialog
import android.content.BroadcastReceiver
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.tooling.preview.Preview
import com.example.evotor_discount.ui.theme.EvotordiscountTheme
import ru.evotor.framework.component.PaymentPerformer
import ru.evotor.framework.core.IntegrationAppCompatActivity
import ru.evotor.framework.core.IntegrationException
import ru.evotor.framework.core.IntegrationManagerCallback
import ru.evotor.framework.core.IntegrationManagerFuture
import ru.evotor.framework.core.IntegrationService
import ru.evotor.framework.core.action.command.print_receipt_command.PrintReceiptCommandResult
import ru.evotor.framework.core.action.command.print_receipt_command.PrintSellReceiptCommand
import ru.evotor.framework.core.action.event.receipt.receipt_edited.ReceiptPaymentPartsEditedEvent
import ru.evotor.framework.core.action.event.receipt.receipt_edited.ReceiptPrintGroupEditedEvent
import ru.evotor.framework.payment.PaymentSystem
import ru.evotor.framework.payment.PaymentType
import ru.evotor.framework.receipt.Measure
import ru.evotor.framework.receipt.Payment
import ru.evotor.framework.receipt.Position
import ru.evotor.framework.receipt.PrintGroup
import ru.evotor.framework.receipt.Receipt
import ru.evotor.framework.users.UserApi
import java.math.BigDecimal
import java.util.UUID
import java.util.Vector

class MainActivity : IntegrationAppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = applicationContext.packageName

        findViewById<View>(R.id.btnOpenReceipt).setOnClickListener {
            openReceipt()
        }
        findViewById<View>(R.id.btnOpenPayback).setOnClickListener {
            openPayback()
        }
    }
    private fun openPayback() {
        TODO("Not yet implemented")
    }

    private fun openReceipt() {
        TODO("Not yet implemented")
    }


}
//
//fun openReceiptAndEmail() {
//    //Создание списка товаров чека
//    val list: MutableList<Position> = mutableListOf(
//        Position.Builder.newInstance(
//            //UUID позиции
//            UUID.randomUUID().toString(),
//            //UUID товара
//            null,
//            //Наименование
//            "1234",
//            //Наименование единицы измерения
//            Measure("12", 0, 0),
//            //Цена без скидок
//            BigDecimal(1000),
//            //Количество
//            BigDecimal.TEN
//        ).build(),
//        Position.Builder.newInstance(
//            UUID.randomUUID().toString(),
//            null,
//            "1234",
//            Measure("12", 0, 0),
//            BigDecimal(500),
//            BigDecimal.ONE
//        ).setPriceWithDiscountPosition(BigDecimal(300)).build()
//    )





