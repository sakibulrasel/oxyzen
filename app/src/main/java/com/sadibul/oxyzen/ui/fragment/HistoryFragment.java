package com.sadibul.oxyzen.ui.fragment;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.sadibul.oxyzen.R;
import com.sadibul.oxyzen.adapters.DataAdapter;
import com.sadibul.oxyzen.databinding.FragmentHistoryBinding;
import com.sadibul.oxyzen.model.ScannedData;
import com.sadibul.oxyzen.viewmodel.HomeViewModel;

import java.util.ArrayList;
import java.util.List;

import dagger.hilt.android.AndroidEntryPoint;

import static android.content.Context.MODE_PRIVATE;

@AndroidEntryPoint
public class HistoryFragment extends Fragment {

    private FragmentHistoryBinding binding;
    private final String MY_PREFS_NAME ="fragment";
    private SharedPreferences mySPrefs;
    private SharedPreferences.Editor editor;

    private HomeViewModel viewModel;
    private DataAdapter adapter;
    private ArrayList<ScannedData> scannedDataList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHistoryBinding.inflate(inflater,container,false);
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        initRecyclerView();
        observeData();
        setUpItemTouchHelper();
        mySPrefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
        mySPrefs = getActivity().getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        editor = mySPrefs.edit();
        editor.remove("name");
        editor.putString("name","HISTORY");
        editor.apply();
    }

    private void setUpItemTouchHelper()
    {
        ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int swipedPosition = viewHolder.getAdapterPosition();
                ScannedData scannedData = adapter.getDataAt(swipedPosition);
                viewModel.deleteData(scannedData.getData());
                Toast.makeText(getContext(),"Data Removed from List", Toast.LENGTH_LONG).show();
            }
        };
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(binding.dataRecyclerView);
    }

    private void observeData()
    {
        viewModel.getDataList().observe(getViewLifecycleOwner(), new Observer<List<ScannedData>>() {
            @Override
            public void onChanged(List<ScannedData> data) {
                if(data==null || data.size()==0){
                    binding.nodataText.setVisibility(View.VISIBLE);
                }else {
                    ArrayList<ScannedData> list = new ArrayList<>(data);
                    adapter.updateList(list);
                }
            }
        });
    }

    private void initRecyclerView()
    {
        binding.dataRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new DataAdapter(getContext(),scannedDataList);
        binding.dataRecyclerView.setAdapter(adapter);
    }
}