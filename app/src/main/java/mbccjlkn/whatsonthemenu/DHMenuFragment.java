package mbccjlkn.whatsonthemenu;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


public class DHMenuFragment extends Fragment {

    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_dhmenu, container, false);

        Toast.makeText(view.getContext(), "No Favorites To Display", Toast.LENGTH_LONG).show();

        return view;
    }

}
