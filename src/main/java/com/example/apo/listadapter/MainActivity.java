package com.example.apo.listadapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.apo.listadapter.fragments.FirstFragment;
import com.example.apo.listadapter.fragments.SecondFragment;
import com.example.apo.listadapter.fragments.ThirdFragment;


public class MainActivity extends AppCompatActivity {


    FragmentPagerAdapter adapterViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // afairesa to mhnumataki katw de3ia gia ananewsh ths listas-den uparxei kan h setAdapter edw outws h allws
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                setAdapter();
//
//                Snackbar.make(view, "New list is created", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });


        ViewPager vpPager = (ViewPager) findViewById(R.id.vpPager);
        //gia na travijeis to fragment manager sto sigkekrimenou  activity ,kaneis getSupportFragmentManager()
        adapterViewPager = new MyPagerAdapter(getSupportFragmentManager());
        vpPager.setAdapter(adapterViewPager);


        // afora tis katastaseis tou view pager, ka8e allagh selidas
        // thn akouei o listener kai sou dinei position (event listener)
        vpPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            // This method will be invoked when a new page becomes selected.
            @Override
            public void onPageSelected(int position) {
                Toast.makeText(MainActivity.this,
                        "Selected page position: " + (position+1), Toast.LENGTH_SHORT).show();
            }

            // This method will be invoked when the current page is scrolled
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                // Code goes here
            }

            // Called when the scroll state changes:
            // SCROLL_STATE_IDLE, SCROLL_STATE_DRAGGING, SCROLL_STATE_SETTLING
            @Override
            public void onPageScrollStateChanged(int state) {
                // Code goes here
            }
        });

    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }


    public static class MyPagerAdapter extends FragmentPagerAdapter {
        private static int NUM_ITEMS = 3;

        public MyPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        // Returns total number of pages
        @Override
        public int getCount() {
            return NUM_ITEMS;
        }

        // Returns the fragment to display for that page
        @Override
        public Fragment getItem(int position) {
//            FirstFragment fFrag = new FirstFragment();

            switch (position) {
                case 0: // Fragment # 0 - This will show FirstFragment
                        // to string pou dinw sto constructor tupou firstFragment einai olh auth h akoulou8ia xarakthrwn "Page # " + position + '1' + "12"
//                    return FirstFragment.newInstance(position, "Page # " + position + '1' + "12");
                    return ThirdFragment.newInstance();
//                    return fFrag.newInstance(0, "Page # 1");
                case 1: // Fragment # 0 - This will show SecondFragment different title
                    return SecondFragment.newInstance();
                case 2: // Fragment # 1 - This will show FirstFragment
                    return FirstFragment.newInstance(position, "Page " + (position + 1));
                default:
                    return null;
            }

        }

        // Returns the page title for the top indicator
        //an den uphrxe den 8a fainotan o ari8mos panw pshla sthn selida kai kapws sundeetai me to PageStrip tou xml
        @Override
        public CharSequence getPageTitle(int position) {
            return ("Page " + (position+1));
        }

    }


}


