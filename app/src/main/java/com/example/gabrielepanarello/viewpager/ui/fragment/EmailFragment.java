package com.example.gabrielepanarello.viewpager.ui.fragment;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.gabrielepanarello.viewpager.R;

/**
 * Created by Gabriele Panarello on 14/03/2018.
 */

public class EmailFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.email_layout, container, false);


        final EditText receiverText = (EditText) rootView.findViewById(R.id.receiverText);
        final EditText subjectText = (EditText) rootView.findViewById(R.id.subjectText);
        final EditText messageText = (EditText) rootView.findViewById(R.id.messageText);
        Button sendButton = (Button) rootView.findViewById(R.id.sendButton);

        final String receiver = String.valueOf(receiverText.getText());
        final String subject = String.valueOf(subjectText.getText());
        final String bodyText = String.valueOf(messageText.getText());


        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (receiver != null && subject != null && bodyText != null) {
                    String mailto = "mailto:" + Uri.encode(receiver) +
                            "?subject=" + Uri.encode(subject) +
                            "&body=" + Uri.encode(bodyText);

                    Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
                    emailIntent.setData(Uri.parse(mailto));
                    try {
                        receiverText.setText("");
                        subjectText.setText("");
                        messageText.setText("");

                        startActivity(emailIntent);
                    } catch (ActivityNotFoundException e) {
                        //TODO: Handle case where no email app is available
                    }
                }
            }
        });

        return rootView;
    }
}
