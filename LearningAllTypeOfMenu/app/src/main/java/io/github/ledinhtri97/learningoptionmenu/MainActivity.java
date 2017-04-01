package io.github.ledinhtri97.learningoptionmenu;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * 1. Handling click events
 * 2. Creating an Options Menu
 * 3. Creating Contextual Menus
 *      a. Creating a floating context menu
 *      b. Using the contextual action mode
 * 4. Creating a Popup Menu
 * */

public class MainActivity extends AppCompatActivity  {

    TextView txtDemo;
    Button btnContextualMode;
    ListView lvSach1, lvSach2;
    ArrayList<String> dsSach;
    ArrayAdapter<String> adapterSach;

    ActionMode mActionMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvents();

    }

    private void addControls() {
        txtDemo = (TextView) findViewById(R.id.txtDemo);
        btnContextualMode = (Button) findViewById(R.id.btnContextualMode);
        lvSach1 = (ListView) findViewById(R.id.lvSach1);
        lvSach2 = (ListView) findViewById(R.id.lvSach2);
        dsSach = new ArrayList<>();
        adapterSach = new ArrayAdapter<String>(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                dsSach
        );
        lvSach1.setAdapter(adapterSach);
        lvSach2.setAdapter(adapterSach);

        dsSach.add("Harry Potter I");
        dsSach.add("Harry Potter II");
        dsSach.add("Harry Potter III");
        dsSach.add("Harry Potter IV");
        dsSach.add("Harry Potter V");

        adapterSach.notifyDataSetChanged();

    }

    private void addEvents() {
        //dang ky them list view vao danh sach the hien boi Context Menu;
        registerForContextMenu(lvSach1);

        //truyen Contextual Action Mode cho listview
        enableContextualActionOnListView(lvSach2);

        //truyen Contextual Action Mode cho button
        btnContextualMode.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (mActionMode != null) {
                    return false;
                }
                mActionMode = MainActivity.this.startActionMode(mActionModeCallback);
                v.setSelected(true);
                return true;
            }
        });
    }

    /**1. Handling click events*/
    private boolean eventItemsMenu(MenuItem item){
        switch (item.getItemId()){
            case R.id.mnuMauXanh:
                txtDemo.setText("Mau xanh ne!");
                txtDemo.setBackgroundColor(Color.BLUE);
                return true;
            case R.id.mnuMauDo:
                txtDemo.setText("Mau do ne!");
                txtDemo.setBackgroundColor(Color.RED);
                return true;
            case R.id.mnuMauVang:
                txtDemo.setText("Mau vang ne!");
                txtDemo.setBackgroundColor(Color.YELLOW);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /**2. Creating an Options Menu
     * xuat hien ngay tren thanh tabar*/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menumain, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return eventItemsMenu(item);
    }

    /*======================================================================================*/

    /** ListView 1
     * 3 - a. Creating a floating context menu
     * sau khi override can su dung ham registerForContextMenu(view) cho listview*/
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menumain, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        return eventItemsMenu(item);
    }

    /*======================================================================================*/

    /** Button
     * 3 - b. Using the contextual action mode and then enable Contextual mode on button images button
     * su ly them Contextual mode vao button duoc xu ly trong btn.setOnLongClickListener cua ham addEvents()*/
    private ActionMode.Callback mActionModeCallback = new ActionMode.Callback() {

        // Called when the action mode is created; startActionMode() was called
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            // Inflate a menu resource providing context menu items
            MenuInflater inflater = mode.getMenuInflater();
            inflater.inflate(R.menu.menumain, menu);
            return true;
        }

        // Called each time the action mode is shown. Always called after onCreateActionMode, but
        // may be called multiple times if the mode is invalidated.
        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false; // Return false if nothing is done
        }

        // Called when the user selects a contextual menu item
        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            return eventItemsMenu(item);
        }

        // Called when the user exits the action mode
        @Override
        public void onDestroyActionMode(ActionMode mode) {
            mActionMode = null;
        }
    };

    /** listView 2
     * 3 - b. Using the contextual action mode and then enable Contextual mode on listview or gridview*/
    private void enableContextualActionOnListView(ListView listView) {
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
        listView.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {

            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position,
                                                  long id, boolean checked) {
                // Here you can do something when items are selected/de-selected,
                // such as update the title in the CAB
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                // Respond to clicks on the actions in the CAB
                return eventItemsMenu(item);
            }

            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                // Inflate the menu for the CAB
                MenuInflater inflater = mode.getMenuInflater();
                inflater.inflate(R.menu.menumain, menu);
                return true;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {
                // Here you can make any necessary updates to the activity when
                // the CAB is removed. By default, selected items are deselected/unchecked.
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                // Here you can perform updates to the CAB due to
                // an invalidate() request
                return false;
            }
        });
    }

    /*======================================================================================*/

    /** button
     * 4. Creating a Popup Menu*/
    public void showPopup(View view) {
        PopupMenu popupMenu = new PopupMenu(this, view);

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                return eventItemsMenu(item);
            }
        });

        popupMenu.inflate(R.menu.menumain);
        popupMenu.show();
    }

    /*======================================================================================*/
}
