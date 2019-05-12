package hu.bme.mobilszoftver.money_exchange.ui.main

import android.content.Context
import android.support.design.widget.FloatingActionButton
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageButton
import android.widget.TextView
import hu.bme.mobilszoftver.money_exchange.R
import hu.bme.mobilszoftver.money_exchange.model.Currency

class CurrencyAdapter(private val context: Context,
                      private val dataSource: ArrayList<Currency>,
                      private val inputPrice: Int) : BaseAdapter() {

    private val inflater: LayoutInflater
            = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return dataSource.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val rowView = inflater.inflate(R.layout.list_item_currency, parent, false)

        val countryTextView = rowView.findViewById(R.id.currency_list_country) as TextView

        val nameTextView = rowView.findViewById(R.id.currency_list_name) as TextView

        val favouriteStarOn = rowView.findViewById(R.id.favourite_star_on) as ImageButton

        val favouriteStarOff = rowView.findViewById(R.id.favourite_star_off) as ImageButton

        val actualPriceTextView = rowView.findViewById(R.id.currency_list_actual_price) as TextView

        val currency = getItem(position) as Currency

        nameTextView.text = currency.name
        countryTextView.text = currency.country
        favouriteStarOff.isFocusable = false
        favouriteStarOn.isFocusable = false
        favouriteStarOff.isClickable = false
        favouriteStarOn.isClickable = false
        if (currency.isFavourite) {
            favouriteStarOff.visibility = View.INVISIBLE
            favouriteStarOn.visibility = View.VISIBLE
        } else {
            favouriteStarOff.visibility = View.VISIBLE
            favouriteStarOn.visibility = View.INVISIBLE
        }
        actualPriceTextView.text = "0"
        if (inputPrice == -1) {
            actualPriceTextView.text = currency.price.toString()
            nameTextView.text = "HUF"

        } else if (inputPrice != 0) {
            actualPriceTextView.text = (inputPrice / currency.price).toString()
        }

        return rowView
    }
}