package ryanestes.medilert;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

import static ryanestes.medilert.R.id.help_btn;
import static ryanestes.medilert.R.id.progressBar;


public class UserActivity extends AppCompatActivity {

        @BindView(R.id.med_details)TextView mMedText;
        @BindView(R.id.phoneNumber) TextView mPhoneNum;
        @BindView(R.id.email) TextView mEmail;
    @BindView(R.id.address) TextView mAddress;
    @BindView(help_btn) Button mHelpBtn;

    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_user);
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            ButterKnife.bind(this);

        mHelpBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(UserActivity.this,HelpActivity.class));
            }
        });


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mAddress.setClickable(true);
                    mAddress.setFocusable(true);
                    mAddress.setFocusableInTouchMode(true);
                    mAddress.setCursorVisible(true);
                    mPhoneNum.setClickable(true);
                    mPhoneNum.setFocusable(true);
                    mPhoneNum.setFocusableInTouchMode(true);
                    mPhoneNum.setCursorVisible(true);
                    mEmail.setClickable(true);
                    mEmail.setFocusable(true);
                    mEmail.setFocusableInTouchMode(true);
                    mEmail.setCursorVisible(true);
                    mMedText.setClickable(true);
                    mMedText.setFocusable(true);
                    mMedText.setFocusableInTouchMode(true);
                    mMedText.setCursorVisible(true);
                    Snackbar.make(view, "Categories can now be edited!", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            });
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_main, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            int id = item.getItemId();

            //noinspection SimplifiableIfStatement
            if (id == R.id.action_settings) {
                return true;
            }

            return super.onOptionsItemSelected(item);
        }

    }
