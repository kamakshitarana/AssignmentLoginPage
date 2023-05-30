package com.example.checkboxactivity;

import android.location.Location;
import android.widget.TextView;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LocationUnitTest {

    @Test
    public void updateLocation_isCorrect() {
        double latitude = 37.7749;
        double longitude = -122.4194;

        Location location = new Location("");
        location.setLatitude(latitude);
        location.setLongitude(longitude);

        MainActivity mainActivity = new MainActivity();
        mainActivity.updateLocation(location);

        TextView latitudeTextView = mainActivity.getLatitudeTextView();
        TextView longitudeTextView = mainActivity.getLongitudeTextView();

        assertEquals(String.valueOf(latitude), latitudeTextView.getText().toString());
        assertEquals(String.valueOf(longitude), longitudeTextView.getText().toString());
    }
}
