/**
 * Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 * <p>
 * package com.example.android.justjava;
 */

package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.android.justjava.R;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;
import static com.example.android.justjava.R.id.checkbox;
import static com.example.android.justjava.R.id.chkWhippedCream;

// import static com.example.nikronus.justjave.R.string.price;


/**
 * These import statements are not working and are giving an error. In the lines that follow, I have been trying to repair them.
 * import static android.R.attr.button;
 * import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;
 * Gave up and deleted the import statement. Need to get help from mentor. Also, why strings do not save. Also, other errors,
 * including being unable to increment properly with + botton. Second quantity value is the only value that appears.
 * i.e. program does not increment. Debugger activity does not work as instructed. Oddly, when I moved from a
 * local variable to a global variable, this behavior appears to have fixed itself.
 */


/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 2;
    int price = 0;
    CheckBox whippedCreamCheckbox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        whippedCreamCheckbox = (CheckBox) findViewById(R.id.chkWhippedCream);
    }

    /**
     * Added this method to be called when the '+' button is clicked. -JL
     */

    public void increment(View view) {
        quantity = quantity + 1;
        display(quantity);
    }

    /**
     * Added this method to be called when the '-' button is clicked. -JL
     */

    public void decrement(View view) {
        quantity = quantity - 1;
        display(quantity);
    }

    /**
     * This method is called when the order button is clicked. This is the old code that Udacity wanted changed to what's in the next section.
     *public void submitOrder(View view) {
     *    display(quantity);
     *    displayPrice(quantity * 5);
     *}
     */

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        price = calculatePrice();
        String priceMessage = createOrderSummary();
        displayMessage(priceMessage);
    }

    /**
     * Calculates the price of the order.
     *
     * @return total price.
     */
    private int calculatePrice() {
        int price = quantity * 5;
        return price;
    }

    /**
     * Creates an order summary.
     */

    private String createOrderSummary() {
        String priceMessage = "Name: Nikronus Nikelby";
        priceMessage = priceMessage + "\nAdd Whipped Cream?" + String.valueOf(whippedCreamCheckbox.isChecked());
        priceMessage = priceMessage + "\nQuantity: " + quantity;
        priceMessage = priceMessage + "\nTotal: $" + price;
        priceMessage = priceMessage + "\nThank you!";
        return priceMessage;
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

}