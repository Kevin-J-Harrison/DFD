package me.tnsi.dfd;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.Toast;

public class MapActivity2 extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(

                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        ImageButton button1 = (ImageButton) this.findViewById(R.id.mandrakes);
        button1.setOnClickListener(this);

        ImageButton button2 = (ImageButton) this.findViewById(R.id.provisions);
        button2.setOnClickListener(this);

        ImageButton button3 = (ImageButton) this.findViewById(R.id.fresh);
        button3.setOnClickListener(this);

        ImageButton button4 = (ImageButton) this.findViewById(R.id.einstein);
        button4.setOnClickListener(this);


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.button) {
            // Handle the camera action
        } else if (id == R.id.nav_sign_out) {
            Intent intent = new Intent(MapActivity2.this, LoginActivity.class);
            MapActivity2.this.startActivity(intent);
        } else if (id == R.id.nav_about) {
            Intent intent = new Intent(MapActivity2.this, AboutActivity.class);
            MapActivity2.this.startActivity(intent);
        } else if (id == R.id.nav_filters) {
            Intent intent = new Intent(MapActivity2.this, FiltersActivity.class);
            MapActivity2.this.startActivity(intent);
        } else if (id == R.id.nav_settings) {
            Intent intent = new Intent(MapActivity2.this, SettingsActivity.class);
            MapActivity2.this.startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        if (id == R.id.mandrakes){
            Intent intent = new Intent(MapActivity2.this, MandrakesActivity.class);
            MapActivity2.this.startActivity(intent);
        } else if (id == R.id.provisions){
            Intent intent = new Intent(MapActivity2.this, RestaurantDetailsActivity.class);
            intent.putExtra("Name", "Provisions on Demand");
            MapActivity2.this.startActivity(intent);
        } else if (id == R.id.einstein){
            Intent intent = new Intent(MapActivity2.this, RestaurantDetailsActivity.class);
            intent.putExtra("Name", "Einstein Bros");
            MapActivity2.this.startActivity(intent);
        } else if (id == R.id.fresh) {
            Intent intent = new Intent(MapActivity2.this, RestaurantDetailsActivity.class);
            intent.putExtra("Name", "Fresh");
            MapActivity2.this.startActivity(intent);
        }
    }
}
