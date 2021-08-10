package com.example.myapplication.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.customlistView.CustomListAdapter;
import com.example.myapplication.customlistView.Facture;
import com.example.myapplication.databinding.FragmentSlideshowBinding;

import java.util.ArrayList;
import java.util.List;

public class SlideshowFragment extends Fragment {

    private SlideshowViewModel slideshowViewModel;
    private FragmentSlideshowBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                new ViewModelProvider(this).get(SlideshowViewModel.class);

        binding = FragmentSlideshowBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        List<Facture> image_details = getListData();
        final ListView listView = (ListView) binding.listView;
        listView.setAdapter(new CustomListAdapter(container.getContext(), image_details));

        // When the user clicks on the ListItem
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Object o = listView.getItemAtPosition(position);
                Facture facture = (Facture) o;
               /* Toast.makeText(SlideshowFragment.this,
                        "Selected :" + " " + facture,
                        Toast.LENGTH_LONG).show();*/
            }
        });

        /*final TextView textView = binding.textSlideshow;
        slideshowViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
    private  List<Facture> getListData() {
        List<Facture> list = new ArrayList<Facture>();
        Facture vietnam = new Facture("Vietnam", "np", 98000000);
        Facture usa = new Facture("United States", "np", 320000000);
        Facture russia = new Facture("Russia", "np", 142000000);


        list.add(vietnam);
        list.add(usa);
        list.add(russia);

        return list;
    }
}