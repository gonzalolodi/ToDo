package co.mobilemakers.todo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * A placeholder fragment containing a simple view.
 */
public class AddTaskFragment extends Fragment {

    EditText mEditTextTitle;
    Button mButtonDone;

    public AddTaskFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_add_task, container, false);
        prepareEditText(rootView);
        mButtonDone = (Button) rootView.findViewById(R.id.button_done);
        mButtonDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent titleResult = new Intent();
                titleResult.putExtra(TasksFragment.TASK_TITLE, mEditTextTitle.getText().toString());
                getActivity().setResult(Activity.RESULT_OK, titleResult);
                getActivity().finish();
            }
        });
        return rootView;
    }

    private void prepareEditText(View rootView) {
        mEditTextTitle = (EditText) rootView.findViewById(R.id.edit_text_task_title);
        mEditTextTitle.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mButtonDone.setEnabled(!TextUtils.isEmpty(mEditTextTitle.getText()));
            }
        });
    }
}
