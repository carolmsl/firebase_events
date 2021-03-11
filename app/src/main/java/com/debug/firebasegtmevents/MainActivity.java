package com.debug.firebasegtmevents;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.analytics.FirebaseAnalytics.Event;
import com.google.firebase.analytics.FirebaseAnalytics.Param;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private FirebaseAnalytics mFirebaseAnalytics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

        viewPromotion();
        clickPromotion();
        //viewItem();
    }

    private void viewItem() {
        // Define product with relevant parameters

        Bundle product1 = new Bundle();
        product1.putString( Param.ITEM_ID, "sku1234"); // ITEM_ID or ITEM_NAME is required
        product1.putString( Param.ITEM_NAME, "Donut Friday Scented T-Shirt");
        product1.putString( Param.ITEM_CATEGORY, "Apparel/Men/Shirts");
        product1.putString( Param.ITEM_VARIANT, "Blue");
        product1.putString( Param.ITEM_BRAND, "Google");
        product1.putDouble( Param.PRICE, 29.99 );
        product1.putString( Param.CURRENCY, "USD" ); // Item-level currency unused today

        Bundle ecommerceBundle = new Bundle();
        ecommerceBundle.putBundle( "items", product1 );

        mFirebaseAnalytics.logEvent( Event.VIEW_ITEM, ecommerceBundle );
    }

    private void viewPromotion() {

        Bundle promotion = new Bundle();
        promotion.putString( Param.ITEM_ID, "PROMO_1234" ); // promotion ID; either ITEM_ID or ITEM_NAME is required
        promotion.putString( Param.ITEM_NAME, "Summer Sale" ); // promotion name
        promotion.putString( Param.CREATIVE_NAME, "summer_banner2" );
        promotion.putString( Param.CREATIVE_SLOT, "banner_slot1" );

        ArrayList promotions = new ArrayList();
        promotions.add(promotion);

        Bundle ecommerceBundle = new Bundle();
        ecommerceBundle.putParcelableArrayList("promotions", promotions );

        mFirebaseAnalytics.logEvent(Event.VIEW_ITEM_LIST, ecommerceBundle );
    }

    private void clickPromotion() {
        // Define promotion with relevant parameters

        Bundle promotion = new Bundle();
        promotion.putString( Param.ITEM_ID, "PROMO_1234"); // promotion ID; either ITEM_ID or ITEM_NAME is required
        promotion.putString( Param.ITEM_NAME, "Summer Sale"); // promotion name
        promotion.putString( Param.CREATIVE_NAME, "summer_banner2");
        promotion.putString( Param.CREATIVE_SLOT, "banner_slot1");


        ArrayList promotions = new ArrayList();
        promotions.add(promotion);

        Bundle ecommerceBundle = new Bundle();
        ecommerceBundle.putParcelableArrayList("promotions", promotions );

        mFirebaseAnalytics.logEvent( Event.SELECT_CONTENT, ecommerceBundle );
    }
}