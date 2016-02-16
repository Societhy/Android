package com.example.jordan.societhy_android.Activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

import com.example.jordan.societhy_android.Activity.R;
import com.example.jordan.societhy_android.Fragments.DashboardFragment;
import com.example.jordan.societhy_android.Fragments.OrganisationProfileFragment;

public class HomeActivity extends AppCompatActivity implements
            DashboardFragment.OnFragmentInteractionListener,
            OrganisationProfileFragment.OnFragmentInteractionListener {

        private DrawerLayout mDrawer;
        private NavigationView nvDrawer;
        private Toolbar toolbar;
        private int currentFragment;
        private NavigationView navView;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_home);

            // Set a Toolbar to replace the ActionBar.
            toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);

            // Find our drawer view
            nvDrawer = (NavigationView) findViewById(R.id.nav_view);
            mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            navView = (NavigationView) findViewById(R.id.nav_view);

            Menu m = navView.getMenu();
            SubMenu topChannelMenu = m.addSubMenu("Organisations");
            // TODO REMOVE CETTE MERDE
            topChannelMenu.add("Foo").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                                                                     @Override
                                                                     public boolean onMenuItemClick(MenuItem item) {
                                                                         Log.v("onMenuItemClick", "CLICK TA MERE");
                                                                         Intent intent = new Intent(getBaseContext(), OrganisationAdministrationActivity.class);
                                                                         intent.putExtra("name", item.getTitle());
                                                                         startActivity(intent);
                                                                         return false;
                                                                     }
                                                                 });
            topChannelMenu.add("Bar").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    Log.v("onMenuItemClick", "CLICK TA MERE");
                    Intent intent = new Intent(getBaseContext(), OrganisationAdministrationActivity.class);
                    intent.putExtra("name", item.getTitle());
                    startActivity(intent);
                    return false;
                }
            });
            topChannelMenu.add("Baz").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    Log.v("onMenuItemClick", "CLICK TA MERE");
                    Intent intent = new Intent(getBaseContext(), OrganisationAdministrationActivity.class);
                    intent.putExtra("name", item.getTitle());
                    startActivity(intent);
                    return false;
                }
            });
            topChannelMenu.add("Foo").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    Log.v("onMenuItemClick", "CLICK TA MERE");
                    Intent intent = new Intent(getBaseContext(), OrganisationAdministrationActivity.class);
                    intent.putExtra("name", item.getTitle());
                    startActivity(intent);
                    return false;
                }
            });
            topChannelMenu.add("Bar").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    Log.v("onMenuItemClick", "CLICK TA MERE");
                    Intent intent = new Intent(getBaseContext(), OrganisationAdministrationActivity.class);
                    intent.putExtra("name", item.getTitle());
                    startActivity(intent);
                    return false;
                }
            });
            topChannelMenu.add("Baz").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    Log.v("onMenuItemClick", "CLICK TA MERE");
                    Intent intent = new Intent(getBaseContext(), OrganisationAdministrationActivity.class);
                    intent.putExtra("name", item.getTitle());
                    startActivity(intent);
                    return false;
                }
            });
           /* topChannelMenu.getItem().setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    Log.v("onMenuItemClick", "CLICK TA MERE");
                    Intent intent = new Intent(getBaseContext(), OrganisationAdministrationActivity.class);
                    intent.putExtra("name", item.getTitle());
                    startActivity(intent);
                    return false;
                }
            );*/


            setupDrawerContent(nvDrawer);

            Class FragmentClass = DashboardFragment.class;
            Fragment fragment = null;
            try {
                fragment = (Fragment) FragmentClass.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.fragment_layout, fragment).commit();
            setTitle("Dashboard");
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            // The action bar home/up action should open or close the drawer.
            switch (item.getItemId()) {
                case android.R.id.home:
                    mDrawer.openDrawer(GravityCompat.START);
                    return true;
            }

            return super.onOptionsItemSelected(item);
        }

        // Make sure this is the method with just `Bundle` as the signature
        @Override
        protected void onPostCreate(Bundle savedInstanceState) {
            super.onPostCreate(savedInstanceState);
        }

        private void setupDrawerContent(NavigationView navigationView) {
            navigationView.setNavigationItemSelectedListener(
                    new NavigationView.OnNavigationItemSelectedListener() {
                        @Override
                        public boolean onNavigationItemSelected(MenuItem menuItem) {
                            selectDrawerItem(menuItem);
                            return true;
                        }
                    });
        }

        public void selectDrawerItem(MenuItem menuItem) {
            // Create a new fragment and specify the planet to show based on
            // position
            Fragment fragment = null;
            int newFragmentId;
            Class fragmentClass;

            newFragmentId = menuItem.getItemId();
            if (newFragmentId != currentFragment) {
                switch (menuItem.getItemId()) {
                    case R.id.nav_dashboard:
                        Log.v("DashBoard", "dashboard selected fragment");
                        fragmentClass = DashboardFragment.class;
                        break;
                    case R.id.nav_modules:
                        fragmentClass = OrganisationProfileFragment.class;
                        break;
                    default:
                        fragmentClass = DashboardFragment.class;
                }
                currentFragment = menuItem.getItemId();

                try {
                    fragment = (Fragment) fragmentClass.newInstance();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                // Insert the fragment by replacing any existing fragment
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.fragment_layout, fragment).commit();

                // Highlight the selected item, update the title, and close the drawer
                menuItem.setChecked(true);
                setTitle(menuItem.getTitle());
                mDrawer.closeDrawers();
            }
        }

        @Override
        public void onBackPressed() {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("êtes vous sûr de vouloir quitter ?")
                    .setCancelable(false)
                    .setPositiveButton("Oui", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            HomeActivity.this.finish();
                        }
                    })
                    .setNegativeButton("Non", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();
        }

        @Override
        public void onFragmentInteraction(Uri uri) {
            Log.v("onFragmentInteraction", "mainactivity");
        }
    }
