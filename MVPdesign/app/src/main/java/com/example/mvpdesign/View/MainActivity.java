package com.example.mvpdesign.View;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.mvpdesign.Model.GetQuoteInteractorImpl;
import com.example.mvpdesign.Presenter.MainPresenter;
import com.example.mvpdesign.Presenter.MainPresenterImpl;
import com.example.mvpdesign.R;

import static android.view.View.GONE;

public class MainActivity extends AppCompatActivity implements MainView {
    private TextView textView;
    private ProgressBar progressBar;
    private Button button;

    MainPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView= findViewById(R.id.textView);
        progressBar= findViewById(R.id.progressBar);
        button= findViewById(R.id.button);

        presenter= new MainPresenterImpl(this, new GetQuoteInteractorImpl());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onButtonClick();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
        textView.setVisibility(View.INVISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(GONE);
        textView.setVisibility(View.VISIBLE);
    }

    @Override
    public void setQuote(String string) {
        textView.setText(string);
    }
}
