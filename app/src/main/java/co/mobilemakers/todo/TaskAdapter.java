package co.mobilemakers.todo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

/**
 * Created by gonzalo.lodi on 04/02/2015.
 */
public class TaskAdapter extends ArrayAdapter<Task>{

    List<Task> mTasks;
    Context mContext;

    public TaskAdapter(Context context, List<Task> objects) {
        super(context, R.layout.list_task_entry, objects);
        this.mTasks =objects;
        mContext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView;
        rowView = reuseOrGenerateRowView(convertView, parent);
        displayContentInView(position,rowView);

        return super.getView(position, convertView, parent);
    }

    private View reuseOrGenerateRowView(View convertView, ViewGroup parent) {
        View rowView;
        if (convertView != null) {
            rowView = convertView;
        } else {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(R.layout.list_task_entry, parent, false);
        }
        return rowView;
    }

    private void displayContentInView(int position, View rowView) {
        if (rowView != null) {
            CheckBox mCheckBoxTask = (CheckBox)rowView.findViewById(R.id.check_box_task);
            mCheckBoxTask.setText(mTasks.get(position).getName());
            mCheckBoxTask.setChecked(mTasks.get(position).getDone());

        }
    }
}
