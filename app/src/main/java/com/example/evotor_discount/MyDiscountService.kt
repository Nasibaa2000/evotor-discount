package com.example.evotor_discount

import android.content.Intent
import android.os.RemoteException
import android.widget.RemoteViews.RemoteView
import androidx.core.app.ActivityCompat.startActivityForResult
import org.json.JSONException
import org.json.JSONObject
import ru.evotor.framework.core.IntegrationService
import ru.evotor.framework.core.action.event.receipt.changes.position.IPositionChange
import ru.evotor.framework.core.action.event.receipt.changes.receipt.SetExtra
import ru.evotor.framework.core.action.event.receipt.discount.ReceiptDiscountEvent
import ru.evotor.framework.core.action.event.receipt.discount.ReceiptDiscountEvent.NAME_SELL_RECEIPT
import ru.evotor.framework.core.action.event.receipt.discount.ReceiptDiscountEventProcessor
import ru.evotor.framework.core.action.event.receipt.discount.ReceiptDiscountEventResult
import ru.evotor.framework.core.action.processor.ActionProcessor
import java.math.BigDecimal


/**
 * Применение скидки на весь чек продажи
 */
class MyDiscountService : IntegrationService() {
    override fun createProcessors(): Map<String, ActionProcessor>? {
        val intent = Intent(this, DiscountActivity::class.java)
        startActivity(intent)
        val map: MutableMap<String, ActionProcessor> = HashMap()
        map[ReceiptDiscountEvent.NAME_SELL_RECEIPT] = object : ReceiptDiscountEventProcessor() {
            override fun call(action: String, event: ReceiptDiscountEvent, callback: Callback) {
                try {
                    //Значение скидки на весь чек в рублях или иной валюте
                    val discount = BigDecimal(5)
                    val `object` = JSONObject()
                    `object`.put("someSuperKey", "AWESOME DISCOUNT")
                    val extra = SetExtra(`object`)
                    val listOfChanges: List<IPositionChange> = ArrayList()
                    callback.onResult(
                        ReceiptDiscountEventResult(
                            discount,
                            extra,
                            listOfChanges,
                            null
                        )
                    )
                } catch (e: JSONException) {
                    e.printStackTrace()
                } catch (e: RemoteException) {
                    e.printStackTrace()
                }
            }
        }
        return map
    }
}



//import android.app.Service
//import android.content.Intent
//import android.os.IBinder
//import android.os.RemoteException
//import org.json.JSONException
//import org.json.JSONObject
//import ru.evotor.framework.core.IntegrationManager
//import ru.evotor.framework.core.IntegrationService
//import ru.evotor.framework.core.action.event.receipt.changes.position.IPositionChange
//import ru.evotor.framework.core.action.event.receipt.changes.receipt.SetExtra
//import ru.evotor.framework.core.action.event.receipt.discount.ReceiptDiscountEvent
//import ru.evotor.framework.core.action.event.receipt.discount.ReceiptDiscountEventProcessor
//import ru.evotor.framework.core.action.event.receipt.discount.ReceiptDiscountEventResult
//import ru.evotor.framework.core.action.processor.ActionProcessor
//import java.math.BigDecimal
//import java.math.RoundingMode
//
//
//class MyDiscountService : IntegrationService() {
//    override fun createProcessors(): Map<String, ActionProcessor> {
//        val map = HashMap<String, ActionProcessor>()
//        map[ReceiptDiscountEvent.NAME_SELL_RECEIPT] = object : ReceiptDiscountEventProcessor() {
//            override fun call(action: String, event: ReceiptDiscountEvent, callback: Callback) {
//                try {
//                    val discount = BigDecimal("0.05%")
//                    val jsonObject = JSONObject()
//                    jsonObject.put("someSuperKey", "AWESOME DISCOUNT")
//                    val extra = SetExtra(jsonObject)
//                    val listOfChanges = ArrayList<IPositionChange>()
//                    callback.onResult(ReceiptDiscountEventResult(discount, extra, listOfChanges, null))
//
//                } catch (e: JSONException) {
//                    e.printStackTrace()
//                    println("fjfjjgjgg")
//                } catch (e: RemoteException) {
//                    e.printStackTrace()
//                    println("aaaaa")
//                }
//
//            }
//        }
//        return map
//    }
//
//}



